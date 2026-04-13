package me.otterboy.goremagala;

import me.otterboy.goremagala.client.renderer.GoreMagalaPreviewRenderer;
import me.otterboy.goremagala.entity.ModEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class GoreMagalaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntityTypes.GORE_MAGALA_PREVIEW, GoreMagalaPreviewRenderer::new);
        System.out.println("=== GoreMagalaClient: Initialized ===");
    }
}
