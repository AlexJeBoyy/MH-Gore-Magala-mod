package me.otterboy.goremagala.client.renderer;

import me.otterboy.goremagala.client.model.GoreHelmModel;
import me.otterboy.goremagala.items.GoreHelmItem;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import org.jspecify.annotations.NonNull;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

@SuppressWarnings("rawtypes")
public class GoreHelmRenderer<R extends @NonNull HumanoidRenderState & @NonNull GeoRenderState> extends GeoArmorRenderer<GoreHelmItem, R> {
    public GoreHelmRenderer() {
        super(new GoreHelmModel());
        this.withScale(0.94f);
    }

    @Override
    public @NonNull String getBoneNameForSegment(@NonNull R renderState, @NonNull ArmorSegment segment) {
        return "head";
    }
}

