package me.otterboy.goremagala.entity;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;

import java.util.List;

/**
 * Gore Magala leaps toward the nearest player, dealing damage and knockback on landing.
 */
public class LeapAttackGoal extends Goal {

    private final GoreMagalaEntity gore;
    private final double detectionRange = 24.0D;
    private int cooldown = 0;
    private final int cooldownMax = 120;  // 6 seconds
    private Player targetPlayer = null;

    public LeapAttackGoal(GoreMagalaEntity gore) {
        this.gore = gore;
    }

    @Override
    public boolean canUse() {
        // Cooldown is handled entirely in tick() so the goal stays running and counts down
        return !this.gore.level().getEntitiesOfClass(Player.class, this.detectionBox()).isEmpty();
    }

    @Override
    public void tick() {
        if (this.cooldown > 0) {
            this.cooldown--;
        }

        // Attempt a leap at 8% chance per tick when off cooldown
        if (this.cooldown <= 0 && this.gore.getRandom().nextFloat() < 0.08f) {
            List<Player> nearbyPlayers = this.gore.level().getEntitiesOfClass(Player.class, this.detectionBox());
            if (!nearbyPlayers.isEmpty()) {
                targetPlayer = nearbyPlayers.get(this.gore.getRandom().nextInt(nearbyPlayers.size()));
                this.performLeap(targetPlayer);
                this.cooldown = this.cooldownMax;
            }
        }

        // Deal impact damage when Gore lands near the target
        if (targetPlayer != null && this.gore.onGround()) {
            if (this.gore.distanceTo(targetPlayer) < 3.0D) {
                targetPlayer.hurt(this.gore.damageSources().mobAttack(this.gore), 6.0F);
                double dx = targetPlayer.getX() - this.gore.getX();
                double dz = targetPlayer.getZ() - this.gore.getZ();
                double dist = Math.sqrt(dx * dx + dz * dz);
                if (dist > 0) {
                    targetPlayer.setDeltaMovement(dx / dist, 0.5, dz / dist);
                }
                // Spawn impact particles
                for (int i = 0; i < 10; i++) {
                    this.gore.level().addParticle(ParticleTypes.EXPLOSION,
                        this.gore.getX() + (this.gore.getRandom().nextDouble() - 0.5) * 2,
                        this.gore.getY() + 0.5,
                        this.gore.getZ() + (this.gore.getRandom().nextDouble() - 0.5) * 2,
                        0, 0.1, 0);
                }
                targetPlayer = null;
            }
        }
    }

    private void performLeap(Player target) {
        double dx = target.getX() - this.gore.getX();
        double dz = target.getZ() - this.gore.getZ();
        double distance = Math.sqrt(dx * dx + dz * dz);
        if (distance > 0) {
            double power = Math.min(distance / 10.0, 1.5);
            this.gore.setDeltaMovement(dx / distance * 0.7 * power, 0.8 + power * 0.5, dz / distance * 0.7 * power);
        }
    }

    @Override
    public void stop() {
        targetPlayer = null;
    }

    private AABB detectionBox() {
        return new AABB(
            this.gore.getX() - detectionRange, this.gore.getY() - 8, this.gore.getZ() - detectionRange,
            this.gore.getX() + detectionRange, this.gore.getY() + 8, this.gore.getZ() + detectionRange
        );
    }
}
