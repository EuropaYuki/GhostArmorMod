package com.YukiSato.GhostArmorMod.item.armor;

import com.YukiSato.GhostArmorMod.regi.GhostArmorModItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;

public class GhostChestPlate extends ArmorItem {
    public GhostChestPlate() {
        super(GhostArmorMaterials.GHOST, Type.CHESTPLATE, new Properties().fireResistant());
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
