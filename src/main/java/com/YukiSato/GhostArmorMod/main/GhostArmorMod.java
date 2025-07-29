package com.YukiSato.GhostArmorMod.main;

import com.YukiSato.GhostArmorMod.regi.GhostArmorModItems;
import com.YukiSato.GhostArmorMod.regi.tab.GhostArmorModTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("ghostarmormod")
public class GhostArmorMod {
    public static final String MOD_ID = "ghostarmormod";

    public GhostArmorMod () {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        GhostArmorModItems.ITEMS.register(bus);
        GhostArmorModTabs.MOD_TABS.register(bus);
    }
}
