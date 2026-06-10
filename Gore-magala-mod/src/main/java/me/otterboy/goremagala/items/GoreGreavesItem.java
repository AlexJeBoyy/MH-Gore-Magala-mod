package me.otterboy.goremagala.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

public class GoreGreavesItem extends Item {

    public GoreGreavesItem(ArmorMaterial material, ArmorType type, Item.Properties properties) {
        super(properties.humanoidArmor(material, type).durability(type.getDurability(15)));
    }
}

