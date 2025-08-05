package com.YukiSato.GhostArmorMod.item.armor;

import com.YukiSato.GhostArmorMod.main.GhostArmorMod;
import com.YukiSato.GhostArmorMod.main.GhostKeyBind;
import com.YukiSato.GhostArmorMod.regi.GhostArmorModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GhostChestPlate extends ArmorItem {
    public GhostChestPlate() {
        super(GhostArmorMaterials.GHOST, Type.CHESTPLATE, new Properties().fireResistant());
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level world, Player player, int slotIndex, int selectedIndex) {
        super.onInventoryTick(stack, world, player, slotIndex, selectedIndex);
        flyMode(stack, player);
        Vec3 vec3 = player.getLookAngle();
        if (world.isClientSide && getModeNum(stack) == 1) {
            if (GhostKeyBind.ghostKey[0].consumeClick()) {
                player.lerpMotion(vec3.x * 7, vec3.y * 7, vec3.z * 7);
            }
        }
    }

    private void flyMode(ItemStack stack, Player player) {
        if (stack.getTag() == null) {
            stack.setTag(new CompoundTag());
        }
        stack.getTag().putInt("canFly", fullArmor(player) ? 1 : 0);
    }
    public static int getModeNum(ItemStack stack) {
        if (stack.getTag() == null) {
            return 0;
        }
        return stack.getTag().getInt("canFly");
    }

    private String modeName (ItemStack stack) {
        return switch (getModeNum(stack)) {
            case 0 -> "Disable";
            case 1 -> "Enable";
            default -> "Unknown";
        };
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(Component.literal("Fly : " + modeName(stack)).withStyle(ChatFormatting.AQUA));
    }
    @Override
    public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
        if (getModeNum(stack) == 1) {
            return true;
        }
        return false;
    }
    @Override
    public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
        if (!entity.level().isClientSide) {
            int nextFlightTick = flightTicks + 1;
            if (nextFlightTick % 10 == 0) {
                entity.gameEvent(net.minecraft.world.level.gameevent.GameEvent.ELYTRA_GLIDE);
            }
        }
        return true;
    }

    private boolean fullArmor(Player player) {
        if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == GhostArmorModItems.GHOST_HELMET.get()
        && player.getItemBySlot(EquipmentSlot.CHEST).getItem() == GhostArmorModItems.GHOST_CHEST_PLATE.get()
        && player.getItemBySlot(EquipmentSlot.LEGS).getItem() == GhostArmorModItems.GHOST_LEGGINGS.get()
        && player.getItemBySlot(EquipmentSlot.FEET).getItem() == GhostArmorModItems.GHOST_BOOTS.get()) {
            return true;
        }
        return false;
    }

    @Mod.EventBusSubscriber(modid = GhostArmorMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public class DamageAmount {
        @SubscribeEvent
        public static void setDamage(LivingHurtEvent event) {
            ResourceKey[] damages = {
                    DamageTypes.FALL,
                    DamageTypes.FLY_INTO_WALL
            };
            Player player = Minecraft.getInstance().player;
            ItemStack stack = player.getItemBySlot(EquipmentSlot.CHEST);
            for (ResourceKey<DamageType> type : damages) {
                if (event.getSource().is(type) && GhostChestPlate.getModeNum(stack) == 1) {
                    event.setAmount(0.0F);
                }
            }
        }
    }
    
}
