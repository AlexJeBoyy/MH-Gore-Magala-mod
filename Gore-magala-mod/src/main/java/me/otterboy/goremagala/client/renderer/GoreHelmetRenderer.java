package me.otterboy.goremagala.client.renderer;

import me.otterboy.goremagala.client.model.GoreHelmetModel;
import me.otterboy.goremagala.items.GoreHelmetItem;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import org.jspecify.annotations.NonNull;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

@SuppressWarnings("rawtypes")
public class GoreHelmetRenderer<R extends @NonNull HumanoidRenderState & @NonNull GeoRenderState> extends GeoArmorRenderer<GoreHelmetItem, R> {
    public GoreHelmetRenderer() {
        super(new GoreHelmetModel());
        this.withScale(0.94f);
    }

    @Override
    public @NonNull String getBoneNameForSegment(@NonNull R renderState, @NonNull ArmorSegment segment) {
        return "head";
    }
}
