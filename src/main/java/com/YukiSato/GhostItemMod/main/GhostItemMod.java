package com.YukiSato.GhostItemMod.main;

import com.YukiSato.GhostItemMod.regi.GhostArmorModItems;
import com.YukiSato.GhostItemMod.regi.tab.GhostArmorModTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("ghostitemmod")
public class GhostItemMod {
    public static final String MOD_ID = "ghostitemmod";

    public GhostItemMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        GhostArmorModItems.ITEMS.register(bus);
        GhostArmorModTabs.MOD_TABS.register(bus);
    }
}
