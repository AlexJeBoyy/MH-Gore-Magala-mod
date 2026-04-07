package me.otterboy.goremagala;

import me.otterboy.goremagala.items.GoreHelmetItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoreMagala implements ModInitializer {
	public static final String MOD_ID = "goremagala";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Item GORE_HELMET = register("gore_helmet",
			new Item.Properties()
					.humanoidArmor(net.minecraft.world.item.equipment.ArmorMaterials.DIAMOND, ArmorType.HELMET)
					.durability(ArmorType.HELMET.getDurability(15))
	);

	private static Item register(String name, Item.Properties properties) {
		System.out.println("GoreMagala: Registering item: " + name);
		ResourceKey<Item> itemKey = ResourceKey.create(BuiltInRegistries.ITEM.key(),
				Identifier.fromNamespaceAndPath(MOD_ID, name));

		properties.setId(itemKey);

		Item item = name.equals("gore_helmet") ? 
			new GoreHelmetItem(net.minecraft.world.item.equipment.ArmorMaterials.DIAMOND, ArmorType.HELMET, properties) : 
			new Item(properties);
		System.out.println("GoreMagala: Created " + item.getClass().getSimpleName() + " instance");

		Item registered = Registry.register(BuiltInRegistries.ITEM, itemKey, item);
		System.out.println("GoreMagala: Registered item with ID: " + itemKey);
		return registered;
	}

	@Override
	public void onInitialize() {
		System.out.println("=== GoreMagala Mod Initializing ===");
		LOGGER.info("Hello Fabric world!");

		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT)
				.register((itemGroup) -> {
					itemGroup.accept(GORE_HELMET);
				});
		System.out.println("=== GoreMagala Mod Initialized ===");
	}
}
