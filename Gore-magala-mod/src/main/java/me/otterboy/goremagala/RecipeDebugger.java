package me.otterboy.goremagala;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecipeDebugger {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoreMagala.MOD_ID);

    public static void register() {
        ServerLifecycleEvents.SERVER_STARTED.register(RecipeDebugger::onServerStart);
    }

    private static void onServerStart(MinecraftServer server) {
        LOGGER.info("=== Gore Magala Recipe Debug ===");
        var recipeManager = server.getRecipeManager();
        var allRecipes = recipeManager.getRecipes();

        LOGGER.info("Total recipes loaded: {}", allRecipes.size());

        int goreRecipes = 0;
        for (var recipe : allRecipes) {
            String id = recipe.id().toString();
            if (id.contains("gore")) {
                LOGGER.info("  ✓ Found Gore Recipe: {}", id);
                goreRecipes++;
            }
        }

        LOGGER.info("Gore Magala recipes found: {}", goreRecipes);
        if (goreRecipes == 0) {
            LOGGER.warn("⚠️  NO GORE MAGALA RECIPES FOUND! Check recipe JSON files.");
        }
        LOGGER.info("=== End Debug ===");
    }
}

