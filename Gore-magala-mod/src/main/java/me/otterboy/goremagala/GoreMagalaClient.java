package me.otterboy.goremagala;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;

public class GoreMagalaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("=== GoreMagalaClient: Initializing ===");

        // Register resource reload listener to debug texture loading
        ResourceManagerHelper.get(PackType.CLIENT_RESOURCES).registerReloadListener(new SimpleSynchronousResourceReloadListener() {
            @Override
            public Identifier getFabricId() {
                return Identifier.fromNamespaceAndPath("goremagala", "texture_debug");
            }

            @Override
            public void onResourceManagerReload(ResourceManager resourceManager) {
                System.out.println("=== TEXTURE DEBUG: Checking for gore_helmet resources ===");

                // Check item model
                Identifier modelId = Identifier.fromNamespaceAndPath("goremagala", "models/item/gore_helmet.json");
                boolean modelExists = resourceManager.getResource(modelId).isPresent();
                System.out.println("Item model exists: " + modelExists + " at " + modelId);

                if (modelExists) {
                    try {
                        var resource = resourceManager.getResource(modelId);
                        if (resource.isPresent()) {
                            try (var stream = resource.get().open()) {
                                String content = new String(stream.readAllBytes());
                                System.out.println("Model content: " + content);
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("Failed to read model: " + e.getMessage());
                    }
                }

                // Check texture
                Identifier textureId = Identifier.fromNamespaceAndPath("goremagala", "textures/item/gore_helmet.png");
                boolean textureExists = resourceManager.getResource(textureId).isPresent();
                System.out.println("Texture exists: " + textureExists + " at " + textureId);

                if (textureExists) {
                    try {
                        var resource = resourceManager.getResource(textureId);
                        if (resource.isPresent()) {
                            try (var stream = resource.get().open()) {
                                byte[] imageData = stream.readAllBytes();
                                System.out.println("Texture loaded successfully! Size: " + imageData.length + " bytes");

                                // Try to verify it's a valid PNG
                                if (imageData.length >= 8) {
                                    boolean isPNG = imageData[0] == (byte)0x89 &&
                                                   imageData[1] == 'P' &&
                                                   imageData[2] == 'N' &&
                                                   imageData[3] == 'G';
                                    System.out.println("Is valid PNG: " + isPNG);
                                }
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("Failed to read texture: " + e.getMessage());
                        e.printStackTrace();
                    }
                }

                // List all goremagala resources
                System.out.println("=== Listing ALL goremagala resources: ===");
                resourceManager.listResources("", loc -> loc.getNamespace().equals("goremagala"))
                    .forEach((id, res) -> System.out.println("  Found: " + id));
                System.out.println("=== END TEXTURE DEBUG ===");
            }
        });

        System.out.println("=== GoreMagalaClient: Initialized ===");
    }
}
