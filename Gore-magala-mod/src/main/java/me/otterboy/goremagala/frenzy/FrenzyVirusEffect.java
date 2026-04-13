package me.otterboy.goremagala.frenzy;

import me.otterboy.goremagala.GoreMagala;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class FrenzyVirusEffect extends MobEffect {
    private static final Identifier FRENZY_MOVEMENT_ID = Identifier.fromNamespaceAndPath(GoreMagala.MOD_ID, "frenzy_movement_penalty");
    private static final Identifier FRENZY_ATTACK_ID = Identifier.fromNamespaceAndPath(GoreMagala.MOD_ID, "frenzy_attack_penalty");

    public FrenzyVirusEffect() {
        super(MobEffectCategory.HARMFUL, 0x5A1E73);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, FRENZY_MOVEMENT_ID, -0.15D, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        this.addAttributeModifier(Attributes.ATTACK_SPEED, FRENZY_ATTACK_ID, -0.10D, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }
}
