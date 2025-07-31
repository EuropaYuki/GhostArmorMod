package com.YukiSato.GhostArmorMod.regi.tab;

import com.YukiSato.GhostArmorMod.regi.GhostArmorModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class GhostArmorMain {
    public static final Item[] items = {
            Items.DIAMOND,
            GhostArmorModItems.GHOST_INGOT.get(),
            GhostArmorModItems.GHOST_HELMET.get(),
            GhostArmorModItems.GHOST_CHEST_PLATE.get(),
            GhostArmorModItems.GHOST_LEGGINGS.get(),
            GhostArmorModItems.GHOST_BOOTS.get()
    };
}
