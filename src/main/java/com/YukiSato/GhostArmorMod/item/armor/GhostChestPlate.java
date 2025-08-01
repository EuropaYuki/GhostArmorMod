package com.YukiSato.GhostArmorMod.item.armor;

import com.YukiSato.GhostArmorMod.regi.GhostArmorModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GhostChestPlate extends ArmorItem {
    public GhostChestPlate() {
        super(GhostArmorMaterials.GHOST, Type.CHESTPLATE, new Properties().fireResistant());
    }

    private void flyMode(ItemStack stack, Player player) {
        if (stack.getTag() == null) {
            stack.setTag(new CompoundTag());
        }
        stack.getTag().putInt("canFly", fullArmor(player) ? 1 : 0);
    }
    public int getModeNum(ItemStack stack) {
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

    private boolean fullArmor(Player player) {
        if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == GhostArmorModItems.GHOST_HELMET.get()
        && player.getItemBySlot(EquipmentSlot.CHEST).getItem() == GhostArmorModItems.GHOST_CHEST_PLATE.get()
        && player.getItemBySlot(EquipmentSlot.LEGS).getItem() == GhostArmorModItems.GHOST_LEGGINGS.get()
        && player.getItemBySlot(EquipmentSlot.FEET).getItem() == GhostArmorModItems.GHOST_BOOTS.get()) {
            return true;
        }
        return false;
    }
    
}
