package me.otterboy.goremagala.client.model;

import me.otterboy.goremagala.GoreMagala;
import me.otterboy.goremagala.items.GoreHelmItem;
import net.minecraft.resources.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class GoreHelmModel extends GeoModel<GoreHelmItem> {
    @Override
    public Identifier getModelResource(GeoRenderState state) {
        return Identifier.fromNamespaceAndPath(GoreMagala.MOD_ID, "armor/gore_helm");
    }

    @Override
    public Identifier getTextureResource(GeoRenderState state) {
        return Identifier.fromNamespaceAndPath(GoreMagala.MOD_ID, "textures/armor/gore_helm.png");
    }

    @Override
    public Identifier getAnimationResource(GoreHelmItem animatable) {
        return Identifier.fromNamespaceAndPath(GoreMagala.MOD_ID, "armor/gore_helmet");
    }
}
