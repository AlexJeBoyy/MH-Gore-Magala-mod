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

@Mixin(Mob.class)
public class GoreMagalaLootTableMixin {

    @Inject(method = "getLootTable", at = @At("HEAD"), cancellable = true)
    private void goremagala$getLootTable(CallbackInfoReturnable<Optional<ResourceKey<LootTable>>> cir) {
        // DEBUG: Trace all getLootTable calls
        Mob self = (Mob) (Object) this;
        String className = self.getClass().getSimpleName();
        String fullClassName = self.getClass().getName();

        System.out.println("[GOREMAGALA-DEBUG] getLootTable() called on entity: " + className + " (Full: " + fullClassName + ")");

        // DEBUG: Check if it's our entity
        if ("GoreMagalaEntity".equals(className)) {
            System.out.println("[GOREMAGALA-DEBUG] ✓ Matched GoreMagalaEntity! Setting loot table.");
            ResourceKey<LootTable> lootTableKey = ResourceKey.create(
                    Registries.LOOT_TABLE,
                    Identifier.fromNamespaceAndPath("goremagala", "entities/gore_magala")
            );
            System.out.println("[GOREMAGALA-DEBUG] ✓ Loot table key created: " + lootTableKey);
            cir.setReturnValue(Optional.of(lootTableKey));
            System.out.println("[GOREMAGALA-DEBUG] ✓ Callback return value set (wrapped in Optional)!");
        } else {
            System.out.println("[GOREMAGALA-DEBUG] ✗ Not a GoreMagalaEntity, skipping");
        }
    }
}







