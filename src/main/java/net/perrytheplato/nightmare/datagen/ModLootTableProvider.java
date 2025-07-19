package net.perrytheplato.nightmare.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.perrytheplato.nightmare.block.ModBlocks;
import net.perrytheplato.nightmare.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    private final CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup;

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
        this.registryLookup = registryLookup;
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MAGNETITE_BLOCK);
        addDrop(ModBlocks.RAW_MAGNETITE_BLOCK);
        addDrop(ModBlocks.MAGNETITE_ORE, oreDrops(ModBlocks.MAGNETITE_ORE, ModItems.RAW_MAGNETITE));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        // Ensure registryLookup is properly initialized and accessible
        RegistryWrapper.WrapperLookup lookup = registryLookup.join();
        RegistryWrapper.Impl<Enchantment> enchantmentRegistry = lookup.getOrThrow(RegistryKeys.ENCHANTMENT);

        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                        ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops)))))
                .apply(ApplyBonusLootFunction.oreDrops(enchantmentRegistry.getOrThrow(Enchantments.FORTUNE))));
    }
}