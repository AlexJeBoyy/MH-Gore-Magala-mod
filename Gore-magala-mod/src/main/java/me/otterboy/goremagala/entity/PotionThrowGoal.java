package me.otterboy.goremagala.entity;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import me.otterboy.goremagala.frenzy.FrenzyEffects;

import java.util.List;

/**
 * Periodically applies the Frenzy Virus splash effect to a random nearby player.
 */
public class PotionThrowGoal extends Goal {

    private final GoreMagalaEntity gore;
    private final double detectionRange = 24.0D;
    private int cooldown = 0;
    private final int cooldownMax = 60;  // 3 seconds

    public PotionThrowGoal(GoreMagalaEntity gore) {
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
        if (this.gore.getRandom().nextFloat() < 0.15f) {
            List<Player> nearbyPlayers = this.gore.level().getEntitiesOfClass(Player.class, this.detectionBox());
            if (!nearbyPlayers.isEmpty()) {
                Player target = nearbyPlayers.get(this.gore.getRandom().nextInt(nearbyPlayers.size()));
                target.addEffect(new MobEffectInstance(FrenzyEffects.FRENZY_VIRUS, 100, 0, false, true));
                this.cooldown = this.cooldownMax;
            }
        }
    }

    private AABB detectionBox() {
        return new AABB(
            this.gore.getX() - detectionRange, this.gore.getY() - 4, this.gore.getZ() - detectionRange,
            this.gore.getX() + detectionRange, this.gore.getY() + 4, this.gore.getZ() + detectionRange
        );
    }
}
