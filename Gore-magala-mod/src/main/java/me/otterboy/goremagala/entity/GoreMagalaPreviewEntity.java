package me.otterboy.goremagala.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class GoreMagalaPreviewEntity extends PathfinderMob implements GeoEntity {
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public GoreMagalaPreviewEntity(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
        this.setNoAi(true);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 100.0)
                .add(Attributes.MOVEMENT_SPEED, 0.0);
    }

    @Override
    protected void registerGoals() {
        // Intentionally empty: this preview entity should stay static for scale testing.
    }

    @Override
    public void tick() {
        super.tick();
        // Freeze horizontal movement while keeping normal vertical collision/grounding.
        this.setDeltaMovement(0, this.getDeltaMovement().y, 0);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }
}
