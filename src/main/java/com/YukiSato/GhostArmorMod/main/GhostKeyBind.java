package com.YukiSato.GhostArmorMod.main;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.event.KeyEvent;

@Mod.EventBusSubscriber(modid = GhostArmorMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GhostKeyBind {
    public static KeyMapping[] ghostKey = new KeyMapping[1];

    @SubscribeEvent
    public static void keyRegister(final RegisterKeyMappingsEvent event) {
        ghostKey[0] = create("rocketJump", KeyEvent.VK_Z);
        for (KeyMapping key : ghostKey) {
            event.register(key);
        }
    }
    private static KeyMapping create (String name, int key) {
        return new KeyMapping("key.ghostarmormod." + name, key, "key.categories.ghostarmormod");
    }
}
