package com.YukiSato.GhostArmorMod.regi;

import com.YukiSato.GhostArmorMod.item.GhostIngot;
import com.YukiSato.GhostArmorMod.main.GhostArmorMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GhostArmorModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GhostArmorMod.MOD_ID);
    public static final RegistryObject<Item> GHOST_INGOT = ITEMS.register("ghost_ingot", GhostIngot::new);
}
