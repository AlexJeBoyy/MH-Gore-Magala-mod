package me.otterboy.goremagala.entity;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import me.otterboy.goremagala.frenzy.FrenzyEffects;

import java.util.List;

/**
 * Custom goal voor Gore Magala: Frenzy Attack (spuwen)
 * Infecteert spelers in de buurt met Frenzy-virus
 */
public class FrenzyAttackGoal extends Goal {
    
    private final GoreMagalaEntity gore;
    private final double detectionRange = 16.0D;  // 16 blokken bereik
    private int cooldown = 0;
    private final int cooldownMax = 60;  // 3 seconden cooldown (20 ticks/sec * 3 sec / (1 tick cadence))
    
    public FrenzyAttackGoal(GoreMagalaEntity gore) {
        this.gore = gore;
    }
    
    @Override
    public boolean canUse() {
        // Check of er spelers in range zijn
        if (this.cooldown > 0) {
            return false;
        }
        
        List<Player> nearbyPlayers = this.gore.level().getEntitiesOfClass(
            Player.class,
            new AABB(
                this.gore.getX() - detectionRange,
                this.gore.getY() - 4,
                this.gore.getZ() - detectionRange,
                this.gore.getX() + detectionRange,
                this.gore.getY() + 4,
                this.gore.getZ() + detectionRange
            )
        );
        
        return !nearbyPlayers.isEmpty();
    }
    
    @Override
    public void tick() {
        // Cooldown decrementieren
        if (this.cooldown > 0) {
            this.cooldown--;
            return;
        }
        
        // Infecteer alle spelers in range
        List<Player> nearbyPlayers = this.gore.level().getEntitiesOfClass(
            Player.class,
            new AABB(
                this.gore.getX() - detectionRange,
                this.gore.getY() - 4,
                this.gore.getZ() - detectionRange,
                this.gore.getX() + detectionRange,
                this.gore.getY() + 4,
                this.gore.getZ() + detectionRange
            )
        );
        
        for (Player player : nearbyPlayers) {
            // Voeg Frenzy effect toe (100 ticks = 5 seconden, level 0)
            player.addEffect(new MobEffectInstance(FrenzyEffects.FRENZY_VIRUS, 100, 0, false, true));
            
            System.out.println("[GOREMAGALA-FRENZY] Gore Magala spuuwt frenzy! Player " + player.getName().getString() + " infected!");
        }
        
        // Zet cooldown
        this.cooldown = this.cooldownMax;
    }
    
    @Override
    public void stop() {
        // Cleanup als nodig
    }
}
