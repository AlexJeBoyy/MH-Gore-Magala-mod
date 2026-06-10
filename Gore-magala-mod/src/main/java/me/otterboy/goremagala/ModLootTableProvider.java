package me.otterboy.goremagala;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModLootTableProvider extends SimpleFabricLootTableProvider {

    private final CompletableFuture<HolderLookup.Provider> registriesLookup;

    public ModLootTableProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup, LootContextParamSets.ENTITY);
        this.registriesLookup = registryLookup;
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
        ResourceKey<LootTable> goreMagalaLootTable = ResourceKey.create(
                Registries.LOOT_TABLE,
                Identifier.fromNamespaceAndPath("goremagala", "entities/gore_magala")
        );

        try {
            Item goreScale = BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath("goremagala", "gore_magala_scale")).get().value();
            Item goreWing = BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath("goremagala", "gore_magala_wing")).get().value();
            Item goreGem = BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath("goremagala", "gore_magala_gem")).get().value();

            HolderLookup.Provider rawProvider = this.registriesLookup.join();

            biConsumer.accept(
                    goreMagalaLootTable,
                    LootTable.lootTable()
                            // Pool 1: Scales (Common drop, 1-3 base, affected by looting)
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(1.0f, 1.0f))
                                    .add(LootItem.lootTableItem(goreScale)
                                            .setWeight(10)
                                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)))
                                            .apply(EnchantedCountIncreaseFunction.lootingMultiplier(rawProvider, UniformGenerator.between(0.0f, 1.0f)))
                                    )
                            )
                            // Pool 2: Wings (Uncommon drop, 1-2 base, affected by looting)
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(1.0f, 1.0f))
                                    .add(LootItem.lootTableItem(goreWing)
                                            .setWeight(4)
                                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                            .apply(EnchantedCountIncreaseFunction.lootingMultiplier(rawProvider, UniformGenerator.between(0.0f, 1.0f)))
                                    )
                            )
                            // Pool 3: Gore Magala Gem (Rare drop, player-kill only)
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(1.0f, 1.0f))
                                    .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                    .add(LootItem.lootTableItem(goreGem)
                                            .setWeight(1)
                                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                    )
                            )
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate Gore Magala loot table", e);
        }
    }
}