package me.otterboy.goremagala.armor;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public class GoreArmorMaterial {
    public static final int BASE_DURABILITY = 15;
    public static final ResourceKey<EquipmentAsset> GORE_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath("goremagala", "gore_armor_material"));
    public static final TagKey<Item> REPAIRS_GORE_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath("goremagala", "repairs_gore_armor"));

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 4,
                    ArmorType.CHESTPLATE, 10,
                    ArmorType.LEGGINGS, 8,
                    ArmorType.BOOTS, 4
            ),
            5,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            3.0f,
            0.2f,
            REPAIRS_GORE_ARMOR,
            GORE_ARMOR_MATERIAL_KEY
    );
}
