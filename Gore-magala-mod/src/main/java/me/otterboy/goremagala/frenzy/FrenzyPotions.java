package me.otterboy.goremagala.frenzy;

import me.otterboy.goremagala.GoreMagala;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;

public final class FrenzyPotions {
    public static final Holder<Potion> FRENZY_VIRUS = Registry.registerForHolder(
            BuiltInRegistries.POTION,
            Identifier.fromNamespaceAndPath(GoreMagala.MOD_ID, "frenzy_virus"),
            new Potion(
                    "frenzy_virus",
                    new MobEffectInstance(FrenzyEffects.FRENZY_VIRUS, 20 * 45, 0)
            )
    );

    private FrenzyPotions() {
    }

    public static void register() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder ->
                builder.addMix(Potions.AWKWARD, GoreMagala.GORE_MAGALA_SCALE, FRENZY_VIRUS)
        );
        GoreMagala.LOGGER.info("Registered frenzy potions for {}", GoreMagala.MOD_ID);
    }
}
