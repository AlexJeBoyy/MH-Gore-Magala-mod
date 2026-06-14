package me.otterboy.goremagala.entity;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import me.otterboy.goremagala.frenzy.FrenzyEffects;

import java.util.List;

/**
 * Gore Magala creates a ring of Frenzy area-effect clouds around itself,
 * applying the Frenzy Virus to all nearby players.
 */
public class FrenzyBurstGoal extends Goal {

    private final GoreMagalaEntity gore;
    private final double detectionRange = 20.0D;
    private int cooldown = 0;
    private final int cooldownMax = 200;  // 10 seconds

    public FrenzyBurstGoal(GoreMagalaEntity gore) {
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
            return;
        }
        if (this.gore.canUseSpecialAttack() && this.gore.getRandom().nextFloat() < 0.03f) {
            this.performFrenzyBurst();
            this.cooldown = this.cooldownMax;
            this.gore.triggerSpecialAttackCooldown(70);
        }
    }

    private void performFrenzyBurst() {
        if (this.gore.level().isClientSide()) return;

        List<Player> nearbyPlayers = this.gore.level().getEntitiesOfClass(Player.class, this.detectionBox());
        if (nearbyPlayers.isEmpty()) return;

        // Spawn a cloud at the center and four compass points around Gore
        spawnCloud(this.gore.getX(), this.gore.getY() + 1, this.gore.getZ());
        for (int angle = 0; angle < 360; angle += 90) {
            double rad = Math.toRadians(angle);
            spawnCloud(
                this.gore.getX() + Math.cos(rad) * 3,
                this.gore.getY() + 1,
                this.gore.getZ() + Math.sin(rad) * 3
            );
        }

        // Also hit all players immediately
        MobEffectInstance effect = new MobEffectInstance(FrenzyEffects.FRENZY_VIRUS, 200, 0, false, true);
        for (Player player : nearbyPlayers) {
            player.addEffect(effect);
        }
    }

    private void spawnCloud(double x, double y, double z) {
        AreaEffectCloud cloud = new AreaEffectCloud(this.gore.level(), x, y, z);
        cloud.setRadius(2.0F);
        cloud.setRadiusOnUse(-0.1F);
        cloud.setDuration(200);
        cloud.setWaitTime(10);
        cloud.addEffect(new MobEffectInstance(FrenzyEffects.FRENZY_VIRUS, 100, 0));
        this.gore.level().addFreshEntity(cloud);
    }

    private AABB detectionBox() {
        return new AABB(
            this.gore.getX() - detectionRange, this.gore.getY() - 4, this.gore.getZ() - detectionRange,
            this.gore.getX() + detectionRange, this.gore.getY() + 4, this.gore.getZ() + detectionRange
        );
    }
}