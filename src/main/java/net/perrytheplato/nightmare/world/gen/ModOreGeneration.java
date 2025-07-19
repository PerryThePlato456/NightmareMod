package net.perrytheplato.nightmare.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.perrytheplato.nightmare.world.ModPlacedFeatures;
import net.minecraft.world.gen.GenerationStep;

import static net.perrytheplato.nightmare.NightmareMod.LOGGER;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.MAGNETITE_ORE_PLACED_KEY);
        LOGGER.info("Nightmare ORES loaded successfully!");


    }
}