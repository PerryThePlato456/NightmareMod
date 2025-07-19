package net.perrytheplato.nightmare.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.perrytheplato.nightmare.NightmareMod;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ModItems {
    public static final Item MAGNETITE = registerItem("magnetite", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NightmareMod.MOD_ID,"magnetite")))));
    public static final Item RAW_MAGNETITE = registerItem("raw_magnetite", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NightmareMod.MOD_ID,"raw_magnetite")))));
    public static final Item NOCTURNO_HEART_SCRAP = registerItem("nocturno_heart_scrap", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NightmareMod.MOD_ID,"nocturno_heart_scrap")))));
    public static final Item NIGHTMARE_SMITHING_TEMPLATE =
            registerItem(
                    "nightmare_armor_trim_smithing_template",
                    SmithingTemplateItem.of(
                            new Item.Settings().registryKey(
                                    RegistryKey.of(
                                            RegistryKeys.ITEM,
                                            Identifier.of(NightmareMod.MOD_ID, "nightmare_armor_trim_smithing_template")
                                    )
                            )
                    )
            );
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(NightmareMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        NightmareMod.LOGGER.info("Registering Mod Items for " + NightmareMod.MOD_ID);

                ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(MAGNETITE);
            entries.add(NOCTURNO_HEART_SCRAP);
            entries.add(RAW_MAGNETITE);
            entries.add(NIGHTMARE_SMITHING_TEMPLATE);
        });



    }
}