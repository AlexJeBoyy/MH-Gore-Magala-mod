package me.otterboy.goremagala.client.model;

import me.otterboy.goremagala.GoreMagala;
import me.otterboy.goremagala.items.GoreHelmetItem;
import net.minecraft.resources.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class GoreHelmetModel extends GeoModel<GoreHelmetItem> {
    // GeckoLib 5.x scans assets/<ns>/geckolib/models/*.geo.json
    // PREFIX_STRIPPER removes "geckolib/models/" → cache key = "<ns>:gore_helmet"
    // SUFFIX_STRIPPER removes ".geo.json" → return path WITHOUT extension AND without geckolib/models/ prefix

    @Override
    public Identifier getModelResource(GeoRenderState state) {
        return Identifier.fromNamespaceAndPath(GoreMagala.MOD_ID, "gore_helmet");
    }

    @Override
    public Identifier getTextureResource(GeoRenderState state) {
        return Identifier.fromNamespaceAndPath(GoreMagala.MOD_ID, "textures/armor/gore_helmet.png");
    }

    @Override
    public Identifier getAnimationResource(GoreHelmetItem animatable) {
        // GeckoLib 5.x scans assets/<ns>/geckolib/animations/*.animation.json
        // PREFIX_STRIPPER removes "geckolib/animations/" → cache key = "<ns>:gore_helmet"
        return Identifier.fromNamespaceAndPath(GoreMagala.MOD_ID, "gore_helmet");
    }
}
