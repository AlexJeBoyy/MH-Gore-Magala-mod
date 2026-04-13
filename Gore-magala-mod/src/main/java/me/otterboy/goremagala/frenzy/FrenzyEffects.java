package me.otterboy.goremagala.frenzy;

import me.otterboy.goremagala.GoreMagala;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;

public final class FrenzyEffects {
    public static final Holder<MobEffect> FRENZY_VIRUS = Registry.registerForHolder(
            BuiltInRegistries.MOB_EFFECT,
            Identifier.fromNamespaceAndPath(GoreMagala.MOD_ID, "frenzy_virus"),
            new FrenzyVirusEffect()
    );

    private FrenzyEffects() {
    }

    public static void register() {
        GoreMagala.LOGGER.info("Registered frenzy effects for {}", GoreMagala.MOD_ID);
    }
}

