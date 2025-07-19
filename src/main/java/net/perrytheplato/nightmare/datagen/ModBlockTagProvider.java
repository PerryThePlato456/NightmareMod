package net.perrytheplato.nightmare.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.block.Block;
import net.minecraft.registry.tag.TagKey;
import net.perrytheplato.nightmare.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.MAGNETITE_BLOCK)
                .add(ModBlocks.RAW_MAGNETITE_BLOCK)
                .add(ModBlocks.NOCTURNO_HEART)
                .add(ModBlocks.MAGNETITE_ORE);

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MAGNETITE_BLOCK)
                .add(ModBlocks.RAW_MAGNETITE_BLOCK)
                .add(ModBlocks.MAGNETITE_ORE)
                .add(ModBlocks.NOCTURNO_HEART);
        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MAGNETITE_BLOCK)
                .add(ModBlocks.RAW_MAGNETITE_BLOCK)
                .add(ModBlocks.MAGNETITE_ORE)
                .add(ModBlocks.NOCTURNO_HEART);
    }
}
