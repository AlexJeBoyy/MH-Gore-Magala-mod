package me.otterboy.goremagala.client.renderer;

import me.otterboy.goremagala.client.model.GoreMagalaPreviewModel;
import me.otterboy.goremagala.entity.GoreMagalaPreviewEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import org.jspecify.annotations.NonNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

@SuppressWarnings("rawtypes")
public class GoreMagalaPreviewRenderer<R extends @NonNull LivingEntityRenderState & @NonNull GeoRenderState> extends GeoEntityRenderer<GoreMagalaPreviewEntity, R> {
    public GoreMagalaPreviewRenderer(EntityRendererProvider.Context context) {
        super(context, new GoreMagalaPreviewModel());
        this.withScale(1.0f);
    }
}

