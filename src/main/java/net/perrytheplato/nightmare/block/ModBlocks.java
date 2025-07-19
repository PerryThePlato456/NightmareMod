package net.perrytheplato.nightmare.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.perrytheplato.nightmare.NightmareMod;

public class ModBlocks {

public static final Block MAGNETITE_BLOCK = registerBlock("magnetite_block", new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(NightmareMod.MOD_ID, "magnetite_block.json"))).strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_MAGNETITE_BLOCK = registerBlock("raw_magnetite_block", new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(NightmareMod.MOD_ID, "raw_magnetite_block"))).strength(2f).requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS)));
    public static final Block MAGNETITE_ORE = registerBlock("magnetite_ore",  new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(NightmareMod.MOD_ID, "magnetite_ore"))).strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block NOCTURNO_HEART = registerBlock("nocturno_heart", new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(NightmareMod.MOD_ID, "nocturno_heart"))).strength(2f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block BOSS_PEDESTAL = registerBlock("boss_pedestal", new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(NightmareMod.MOD_ID, "boss_pedestal"))).strength(2000f).requiresTool().sounds(BlockSoundGroup.STONE)));
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(NightmareMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(NightmareMod.MOD_ID, name), new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NightmareMod.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }

    public static void registerModBlocks() {
        NightmareMod.LOGGER.info("Registering Mod Blocks for " + NightmareMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.MAGNETITE_BLOCK);
            entries.add(ModBlocks.BOSS_PEDESTAL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.RAW_MAGNETITE_BLOCK);
            entries.add(ModBlocks.MAGNETITE_ORE);
            entries.add(ModBlocks.NOCTURNO_HEART);
        });
    }
}
