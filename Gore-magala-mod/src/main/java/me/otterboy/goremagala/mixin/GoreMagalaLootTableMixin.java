package me.otterboy.goremagala.mixin;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.storage.loot.LootTable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

/**
 * Injects the Gore Magala loot table into the entity on death.
 */
@Mixin(Mob.class)
public class GoreMagalaLootTableMixin {

    @Inject(method = "getLootTable", at = @At("HEAD"), cancellable = true)
    private void goremagala$getLootTable(CallbackInfoReturnable<Optional<ResourceKey<LootTable>>> cir) {
        Mob self = (Mob) (Object) this;
        if ("GoreMagalaEntity".equals(self.getClass().getSimpleName())) {
            cir.setReturnValue(Optional.of(ResourceKey.create(
                    Registries.LOOT_TABLE,
                    Identifier.fromNamespaceAndPath("goremagala", "entities/gore_magala")
            )));
        }
    }
}
