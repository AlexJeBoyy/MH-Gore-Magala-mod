package me.otterboy.goremagala;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;

public class GoreMagalaDeathHandler {

    public static void register() {
        ServerLivingEntityEvents.ALLOW_DEATH.register((entity, damageSource, damageAmount) -> {
            // DEBUG: Log all entity deaths
            System.out.println("[GOREMAGALA-DEBUG-DEATH] Entity died: " + entity.getClass().getSimpleName());
            System.out.println("[GOREMAGALA-DEBUG-DEATH] Damage source: " + damageSource.type().msgId());

            if ("GoreMagalaEntity".equals(entity.getClass().getSimpleName())) {
                System.out.println("[GOREMAGALA-DEBUG-DEATH] ✓ GoreMagalaEntity is DYING! getLootTable() will be called next...");
            }

            return true; // Allow death
        });
    }
}


