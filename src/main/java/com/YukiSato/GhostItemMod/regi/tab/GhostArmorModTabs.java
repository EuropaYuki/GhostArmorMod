package com.YukiSato.GhostItemMod.regi.tab;

import com.YukiSato.GhostItemMod.main.GhostItemMod;
import com.YukiSato.GhostItemMod.regi.GhostArmorModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class GhostArmorModTabs {
    public static final DeferredRegister<CreativeModeTab> MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GhostItemMod.MOD_ID);
    public static final RegistryObject<CreativeModeTab> GHOST_ARMOR_MAIN = MOD_TABS.register("ghost_armor_main",
            ()->{return CreativeModeTab.builder()
                    .icon(()-> new ItemStack(GhostArmorModItems.GHOST_INGOT.get()))
                    .title(Component.translatable("itemGroup.ghost_armor_main"))
                    .displayItems((param, output)-> {
                        for (Item item:GhostArmorMain.items) {
                            output.accept(item);
                        }
                    })
                    .build();
    });
}
