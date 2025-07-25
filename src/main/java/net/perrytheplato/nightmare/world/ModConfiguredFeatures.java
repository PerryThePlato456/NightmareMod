package net.perrytheplato.nightmare.world;

import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> MAGNETITE_ORE_KEY = registerKey("magnetite_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldMagnetiteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.MAGNETITE_ORE.getDefaultState()));

        register(context, Feature.ORE, new OreFeatureConfig(overworldMagnetiteOres, 5));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(NightmareMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   F feature, FC configuration) {
        context.register(ModConfiguredFeatures.MAGNETITE_ORE_KEY, new ConfiguredFeature<>(feature, configuration));
    }
}