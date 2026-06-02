package me.otterboy.goremagala.client.model;

import me.otterboy.goremagala.entity.GoreMagalaEntity;
import me.otterboy.goremagala.GoreMagala;
import net.minecraft.resources.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class GoreMagalaPreviewModel extends GeoModel<GoreMagalaEntity> {
    @Override
    public Identifier getModelResource(GeoRenderState state) {
        return Identifier.fromNamespaceAndPath(GoreMagala.MOD_ID, "entity/gore_magala");
    }

    @Override
    public Identifier getTextureResource(GeoRenderState state) {
        return Identifier.fromNamespaceAndPath(GoreMagala.MOD_ID, "textures/entity/gore_magala.png");
    }

    @Override
    public Identifier getAnimationResource(GoreMagalaEntity animatable) {
        return Identifier.fromNamespaceAndPath(GoreMagala.MOD_ID, "entity/gore_magala_preview");
    }
}
