package me.otterboy.goremagala;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;
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
        // 1.21.11 uses Identifier.fromNamespaceAndPath
        ResourceKey<LootTable> goreMagalaLootTable = ResourceKey.create(
                Registries.LOOT_TABLE,
                Identifier.fromNamespaceAndPath("goremagala", "entities/gore_magala")
        );

        biConsumer.accept(
                goreMagalaLootTable,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0f, 1.0f))
                                .add(LootItem.lootTableItem()
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f)))
                                        // Safely uses our captured registries field
                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registriesLookup, UniformGenerator.between(0.0f, 1.0f)))
                                )
                        )
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0f, 1.0f))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .add(LootItem.lootTableItem(Items.OBSIDIAN)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 5.0f)))
                                )
                        )
        );
    }
}