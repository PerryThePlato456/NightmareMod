package net.perrytheplato.nightmare.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.*;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.trim.ArmorTrimPattern;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.perrytheplato.nightmare.trim.ModTrimPatterns;
import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.block.ModBlocks;
import net.perrytheplato.nightmare.item.ModItems;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.item.Items.SAND;
import static net.perrytheplato.nightmare.item.ModItems.*;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> MAGNETITE_SMELTABLES = List.of(ModItems.RAW_MAGNETITE, ModBlocks.MAGNETITE_ORE);


                offerSmelting(MAGNETITE_SMELTABLES, RecipeCategory.MISC, ModItems.MAGNETITE, 0.25f, 200, "magnetite");
                offerBlasting(MAGNETITE_SMELTABLES, RecipeCategory.MISC, ModItems.MAGNETITE, 0.25f, 100, "magnetite");



                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.MAGNETITE, RecipeCategory.DECORATIONS, ModBlocks.MAGNETITE_BLOCK);

                createShaped(RecipeCategory.MISC, ModBlocks.RAW_MAGNETITE_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', ModItems.RAW_MAGNETITE)
                        .criterion(hasItem(ModItems.RAW_MAGNETITE), conditionsFromItem(ModItems.RAW_MAGNETITE))
                        .offerTo(exporter);


                createShaped(RecipeCategory.MISC, ModBlocks.NOCTURNO_HEART)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', ModItems.NOCTURNO_HEART_SCRAP)
                        .criterion(hasItem(ModItems.NOCTURNO_HEART_SCRAP), conditionsFromItem(NOCTURNO_HEART_SCRAP))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModBlocks.KING_MUMMY_HEART)
                        .pattern("RRR")
                        .pattern("RSR")
                        .pattern("RRR")
                        .input('R', ModItems.KING_MUMMY_HEART_FRAGMENT)
                        .input('S', SAND)
                        .criterion(hasItem(ModItems.KING_MUMMY_HEART_FRAGMENT), conditionsFromItem(KING_MUMMY_HEART_FRAGMENT))
                        .criterion(hasItem(SAND), conditionsFromItem(SAND))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModBlocks.NOCTURNO_HEART)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', ModItems.NOCTURNO_HEART_SCRAP)
                        .criterion(hasItem(ModItems.NOCTURNO_HEART_SCRAP), conditionsFromItem(NOCTURNO_HEART_SCRAP))
                        .offerTo(exporter);


                createShapeless(RecipeCategory.MISC, ModItems.RAW_MAGNETITE, 9)
                        .input(ModBlocks.RAW_MAGNETITE_BLOCK)
                        .criterion(hasItem(ModBlocks.RAW_MAGNETITE_BLOCK), conditionsFromItem(ModBlocks.RAW_MAGNETITE_BLOCK))
                        .offerTo(exporter);
                //help

                offerSmithingTrimRecipe(NIGHTMARE_SMITHING_TEMPLATE, ModTrimPatterns.NIGHTMARE,
                        RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(NightmareMod.MOD_ID, "nightmare")));

};};}

    @Override
    public String getName() {
        return "Nightmare Recipes";
    }
};