package me.otterboy.goremagala;

import net.fabricmc.api.ClientModInitializer;

public class GoreMagalaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("=== GoreMagalaClient: Initializing ===");
        System.out.println("=== GoreMagalaClient: Initialized ===");
    }
}
