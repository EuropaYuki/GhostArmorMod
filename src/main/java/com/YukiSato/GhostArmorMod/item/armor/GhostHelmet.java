package com.YukiSato.GhostArmorMod.item.armor;

import net.minecraft.world.item.ArmorItem;

public class GhostHelmet extends ArmorItem {
    public GhostHelmet() {
        super(GhostArmorMaterials.GHOST, Type.HELMET, new Properties().fireResistant());
    }

}
