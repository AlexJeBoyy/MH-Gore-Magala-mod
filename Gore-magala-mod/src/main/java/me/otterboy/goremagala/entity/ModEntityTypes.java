package me.otterboy.goremagala.entity;

import me.otterboy.goremagala.GoreMagala;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public final class ModEntityTypes {
    public static final EntityType<GoreMagalaPreviewEntity> GORE_MAGALA_PREVIEW = register(
            "gore_magala_preview",
            EntityType.Builder.<GoreMagalaPreviewEntity>of(GoreMagalaPreviewEntity::new, MobCategory.CREATURE)
                    .sized(2.4f, 2.8f)
    );

    private ModEntityTypes() {
    }

    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE,
                Identifier.fromNamespaceAndPath(GoreMagala.MOD_ID, name));

        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }

    public static void registerModEntityTypes() {
        GoreMagala.LOGGER.info("Registering EntityTypes for {}", GoreMagala.MOD_ID);
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(GORE_MAGALA_PREVIEW, GoreMagalaPreviewEntity.createAttributes());
    }
}

