package net.perrytheplato.nightmare.trim;

import net.minecraft.item.Item;
import net.minecraft.item.equipment.trim.ArmorTrimAssets;
import net.minecraft.item.equipment.trim.ArmorTrimMaterial;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.item.ModItems;


public class ModTrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial> MAGNETITE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(NightmareMod.MOD_ID, "magnetite"));

    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable) {
        register(registerable, MAGNETITE, Registries.ITEM.getEntry(ModItems.MAGNETITE),
                Style.EMPTY.withColor(TextColor.parse("#5d6d7e").getOrThrow()));

    }

    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> armorTrimKey,
                                 RegistryEntry<Item> item, Style style) {
        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(ArmorTrimAssets.of("magnetite"),
                Text.translatable(Util.createTranslationKey("trim_material", armorTrimKey.getValue())).fillStyle(style));

        registerable.register(armorTrimKey, trimMaterial);
    }}