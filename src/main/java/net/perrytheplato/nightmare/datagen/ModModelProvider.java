package net.perrytheplato.nightmare.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;  // Corrected import
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Model;
import net.minecraft.util.Identifier;
import net.perrytheplato.nightmare.block.ModBlocks;
import net.perrytheplato.nightmare.item.ModItems;
import net.minecraft.client.data.Models;

import java.util.Optional;

public class  ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGNETITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_MAGNETITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGNETITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NOCTURNO_HEART);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KING_MUMMY_HEART);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BOSS_PEDESTAL);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MAGNETITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.NOCTURNO_HEART_SCRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.KING_MUMMY_HEART_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_MAGNETITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.NIGHTMARE_SMITHING_TEMPLATE, Models.GENERATED);

    }}



