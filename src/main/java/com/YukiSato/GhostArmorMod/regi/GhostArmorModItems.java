package com.YukiSato.GhostArmorMod.regi;

import com.YukiSato.GhostArmorMod.item.GhostIngot;
import com.YukiSato.GhostArmorMod.item.armor.GhostBoots;
import com.YukiSato.GhostArmorMod.item.armor.GhostChestPlate;
import com.YukiSato.GhostArmorMod.item.armor.GhostHelmet;
import com.YukiSato.GhostArmorMod.item.armor.GhostLeggings;
import com.YukiSato.GhostArmorMod.main.GhostArmorMod;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GhostArmorModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GhostArmorMod.MOD_ID);
    public static final RegistryObject<Item> GHOST_INGOT = ITEMS.register("ghost_ingot", GhostIngot::new);
    public static final RegistryObject<ArmorItem> GHOST_HELMET = ITEMS.register("ghost_helmet", GhostHelmet::new);
    public static final RegistryObject<ArmorItem> GHOST_CHEST_PLATE = ITEMS.register("ghost_chest_plate", GhostChestPlate::new);
    public static final RegistryObject<ArmorItem> GHOST_LEGGINGS = ITEMS.register("ghost_leggings", GhostLeggings::new);
    public static final RegistryObject<ArmorItem> GHOST_BOOTS = ITEMS.register("ghost_boots", GhostBoots::new);
}
