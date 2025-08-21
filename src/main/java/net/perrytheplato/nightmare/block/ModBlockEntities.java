package net.perrytheplato.nightmare.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<MagnetiteWaystoneBlockEntity> WAYSTONE;

    public static void registerBlockEntities() {
        WAYSTONE = Registry.register(
                Registry.BLOCK_ENTITY_TYPE,
                Identifier.of("nightmare-mod", "waystone"),
                FabricBlockEntityTypeBuilder.create(MagnetiteWaystoneBlockEntity::new, ModBlocks.WAYSTONE).build(null)
        );
    }
}