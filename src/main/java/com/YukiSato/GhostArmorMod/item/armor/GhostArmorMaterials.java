package com.YukiSato.GhostArmorMod.item.armor;

import com.YukiSato.GhostArmorMod.regi.GhostArmorModItems;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;

public class GhostArmorMaterials {
    public static final ModArmorMaterial GHOST = new ModArmorMaterial("ghost", 50,
            Util.make(new EnumMap<>(ArmorItem.Type.class),
                    (type)-> {
                type.put(ArmorItem.Type.HELMET, 5);
                type.put(ArmorItem.Type.CHESTPLATE, 10);
                type.put(ArmorItem.Type.LEGGINGS, 8);
                type.put(ArmorItem.Type.BOOTS, 5);
                    }), 50, SoundEvents.ARMOR_EQUIP_LEATHER, 5.0F, 0.001F,
            ()->{return Ingredient.of(GhostArmorModItems.GHOST_INGOT.get());
            }
            );
}
