package me.otterboy.goremagala.entity;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import me.otterboy.goremagala.frenzy.FrenzyEffects;

/**
 * Applies Frenzy Virus to nearby players periodically.
 */
public class FrenzyAttackGoal extends Goal {

    private final GoreMagalaEntity gore;
    private final double detectionRange = 16.0D;
    private int cooldown = 0;
    private final int cooldownMax = 100;  // 5 seconds

    public FrenzyAttackGoal(GoreMagalaEntity gore) {
        this.gore = gore;
    }

    @Override
    public boolean canUse() {
        return !this.gore.level().getEntitiesOfClass(Player.class, this.detectionBox()).isEmpty();
    }

    @Override
    public void tick() {
        if (this.cooldown > 0) {
            this.cooldown--;
            return;
        }

        if (!this.gore.canUseSpecialAttack() || this.gore.getRandom().nextFloat() >= 0.10f) {
            return;
        }

        for (Player player : this.gore.level().getEntitiesOfClass(Player.class, this.detectionBox())) {
            player.addEffect(new MobEffectInstance(FrenzyEffects.FRENZY_VIRUS, 100, 0, false, true));
        }
        this.cooldown = this.cooldownMax;
        this.gore.triggerSpecialAttackCooldown(40);
    }

    private AABB detectionBox() {
        return new AABB(
            this.gore.getX() - detectionRange, this.gore.getY() - 4, this.gore.getZ() - detectionRange,
            this.gore.getX() + detectionRange, this.gore.getY() + 4, this.gore.getZ() + detectionRange
        );
    }
}