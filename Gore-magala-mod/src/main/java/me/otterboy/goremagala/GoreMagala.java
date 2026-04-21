package me.otterboy.goremagala;

import me.otterboy.goremagala.armor.GoreArmorMaterial;
import me.otterboy.goremagala.entity.ModEntityTypes;
import me.otterboy.goremagala.frenzy.FrenzyEffects;
import me.otterboy.goremagala.frenzy.FrenzyPotions;
import me.otterboy.goremagala.items.GoreCoilItem;
import me.otterboy.goremagala.items.GoreGreavesItem;
import me.otterboy.goremagala.items.GoreHelmItem;
import me.otterboy.goremagala.items.GoreMailItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.equipment.ArmorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoreMagala implements ModInitializer {
	public static final String MOD_ID = "goremagala";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// Armor items.
	public static final Item GORE_HELM = registerGoreHelm(new Item.Properties());
	public static final Item GORE_MAIL = registerGoreMail(new Item.Properties());
	public static final Item GORE_COIL = registerGoreCoil(new Item.Properties());
	public static final Item GORE_GREAVES = registerGoreGreaves(new Item.Properties());

	// Crafting and alchemy materials.
	public static final Item GORE_MAGALA_SCALE = registerSimpleItem("gore_magala_scale", new Item.Properties());
	public static final Item GORE_MAGALA_WING = registerSimpleItem("gore_magala_wing", new Item.Properties());
	public static final Item GORE_MAGALA_GEM = registerSimpleItem("gore_magala_gem", new Item.Properties());
	public static final Item GORE_MAGALA_TAIL = registerSimpleItem("gore_magala_tail", new Item.Properties());

	// Preview spawn egg for size checks before boss AI is implemented.
	public static final Item GORE_MAGALA_PREVIEW_SPAWN_EGG = registerSpawnEgg(
			"gore_magala_preview_spawn_egg",
			ModEntityTypes.GORE_MAGALA_PREVIEW
	);

	private static Item registerSimpleItem(String name, Item.Properties properties) {
		ResourceKey<Item> itemKey = ResourceKey.create(BuiltInRegistries.ITEM.key(),
				Identifier.fromNamespaceAndPath(MOD_ID, name));
		properties.setId(itemKey);
		return Registry.register(BuiltInRegistries.ITEM, itemKey, new Item(properties));
	}

	private static Item registerSpawnEgg(String name, EntityType<? extends Mob> entityType) {
		ResourceKey<Item> itemKey = ResourceKey.create(BuiltInRegistries.ITEM.key(),
				Identifier.fromNamespaceAndPath(MOD_ID, name));
		Item.Properties properties = new Item.Properties().spawnEgg(entityType);
		properties.setId(itemKey);
		return Registry.register(BuiltInRegistries.ITEM, itemKey, new SpawnEggItem(properties));
	}

	private static Item registerGoreHelm(Item.Properties properties) {
		ResourceKey<Item> itemKey = ResourceKey.create(BuiltInRegistries.ITEM.key(),
				Identifier.fromNamespaceAndPath(MOD_ID, "gore_helm"));

		properties.setId(itemKey);

		Item item = new GoreHelmItem(
				GoreArmorMaterial.INSTANCE,
				ArmorType.HELMET,
				properties
		);

		return Registry.register(BuiltInRegistries.ITEM, itemKey, item);
	}

	private static Item registerGoreMail(Item.Properties properties) {
		ResourceKey<Item> itemKey = ResourceKey.create(BuiltInRegistries.ITEM.key(),
				Identifier.fromNamespaceAndPath(MOD_ID, "gore_mail"));

		properties.setId(itemKey);

		Item item = new GoreMailItem(
				GoreArmorMaterial.INSTANCE,
				ArmorType.CHESTPLATE,
				properties
		);

		return Registry.register(BuiltInRegistries.ITEM, itemKey, item);
	}

	private static Item registerGoreCoil(Item.Properties properties) {
		ResourceKey<Item> itemKey = ResourceKey.create(BuiltInRegistries.ITEM.key(),
				Identifier.fromNamespaceAndPath(MOD_ID, "gore_coil"));

		properties.setId(itemKey);

		Item item = new GoreCoilItem(
				GoreArmorMaterial.INSTANCE,
				ArmorType.LEGGINGS,
				properties
		);

		return Registry.register(BuiltInRegistries.ITEM, itemKey, item);
	}

	private static Item registerGoreGreaves(Item.Properties properties) {
		ResourceKey<Item> itemKey = ResourceKey.create(BuiltInRegistries.ITEM.key(),
				Identifier.fromNamespaceAndPath(MOD_ID, "gore_greaves"));

		properties.setId(itemKey);

		Item item = new GoreGreavesItem(
				GoreArmorMaterial.INSTANCE,
				ArmorType.BOOTS,
				properties
		);

		return Registry.register(BuiltInRegistries.ITEM, itemKey, item);
	}

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing {}", MOD_ID);

		ModEntityTypes.registerModEntityTypes();
		ModEntityTypes.registerAttributes();

		FrenzyEffects.register();
		FrenzyPotions.register();

		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT)
				.register(itemGroup -> {
					itemGroup.accept(GORE_HELM);
					itemGroup.accept(GORE_MAIL);
					itemGroup.accept(GORE_COIL);
					itemGroup.accept(GORE_GREAVES);
				});

		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS)
				.register(itemGroup -> {
					itemGroup.accept(GORE_MAGALA_SCALE);
					itemGroup.accept(GORE_MAGALA_WING);
					itemGroup.accept(GORE_MAGALA_GEM);
					itemGroup.accept(GORE_MAGALA_TAIL);
				});

		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS)
				.register(itemGroup -> itemGroup.accept(GORE_MAGALA_PREVIEW_SPAWN_EGG));
	}
}
