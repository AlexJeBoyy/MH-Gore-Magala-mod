package me.otterboy.goremagala.items;

import net.minecraft.world.item.Item;

/**
 * Gore Magala Helmet - Basic helmet item
 * Uses standard Item with equipment properties for armor functionality
 */
public class GoreHelmetItem extends Item {
    public GoreHelmetItem(Item.Properties properties) {
        super(properties);
        System.out.println("GoreHelmetItem: Registered!");
    }
}
