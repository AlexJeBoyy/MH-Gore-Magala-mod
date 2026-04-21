package me.otterboy.goremagala.client.model;

import me.otterboy.goremagala.GoreMagala;
import me.otterboy.goremagala.entity.GoreMagalaPreviewEntity;
import net.minecraft.resources.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class GoreMagalaPreviewModel extends GeoModel<GoreMagalaPreviewEntity> {
    @Override
    public Identifier getModelResource(GeoRenderState state) {
        return Identifier.fromNamespaceAndPath(GoreMagala.MOD_ID, "entity/gore_magala_preview");
    }

    @Override
    public Identifier getTextureResource(GeoRenderState state) {
        return Identifier.fromNamespaceAndPath(GoreMagala.MOD_ID, "textures/entity/gore_magala_preview.png");
    }

    @Override
    public Identifier getAnimationResource(GoreMagalaPreviewEntity animatable) {
        return Identifier.fromNamespaceAndPath(GoreMagala.MOD_ID, "entity/gore_magala_preview");
    }
}
