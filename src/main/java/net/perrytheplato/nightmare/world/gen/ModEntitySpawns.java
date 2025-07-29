package net.perrytheplato.nightmare.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.entity.ModEntities;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.perrytheplato.nightmare.block.ModBlocks;
import net.perrytheplato.nightmare.entity.custom.MummyEntity;

public class ModEntitySpawns {

    public static boolean canSpawnAtNight(EntityType<? extends MobEntity> type, ServerWorldAccess worldAccess, SpawnReason reason, BlockPos pos, Random random) {
        return MobEntity.canMobSpawn(type, worldAccess, reason, pos, random)
                && worldAccess.toServerWorld().isNight();
    }
    public static boolean canSpawnLight(EntityType<? extends MobEntity> type, ServerWorldAccess worldAccess, SpawnReason reason, BlockPos pos, Random random) {
        return worldAccess.getLightLevel(pos) <= 7
                && worldAccess.getBlockState(pos.down()).isSolidBlock(worldAccess, pos.down());
    }




    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK, BiomeKeys.DRIPSTONE_CAVES,BiomeKeys.LUSH_CAVES),
                SpawnGroup.MONSTER, ModEntities.LURKER, 30, 1, 4);
        SpawnRestriction.register(
                ModEntities.LURKER,
                SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                MobEntity::canMobSpawn
        );

            BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.NETHER_WASTES, BiomeKeys.BASALT_DELTAS),
                    SpawnGroup.MONSTER, ModEntities.SCORCHING_SKELETON, 30, 1, 5);

            SpawnRestriction.register(ModEntities.SCORCHING_SKELETON, SpawnLocationTypes.ON_GROUND,
                    Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);



        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS,BiomeKeys.FOREST,BiomeKeys.DARK_FOREST,BiomeKeys.BIRCH_FOREST,BiomeKeys.OLD_GROWTH_BIRCH_FOREST),
                SpawnGroup.MONSTER, ModEntities.TREANT, 10, 1, 3);

        SpawnRestriction.register(ModEntities.TREANT, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModEntitySpawns::canSpawnAtNight);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS,BiomeKeys.FOREST,BiomeKeys.DARK_FOREST,BiomeKeys.BIRCH_FOREST,BiomeKeys.MEADOW,BiomeKeys.OLD_GROWTH_BIRCH_FOREST,BiomeKeys.BADLANDS,BiomeKeys.BEACH,BiomeKeys.DESERT,BiomeKeys.PALE_GARDEN),
                SpawnGroup.MONSTER, ModEntities.SHADOWBANE, 60, 1, 7);

        SpawnRestriction.register(ModEntities.SHADOWBANE, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModEntitySpawns::canSpawnAtNight);


        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS,BiomeKeys.FOREST,BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA,BiomeKeys.TAIGA,BiomeKeys.DARK_FOREST,BiomeKeys.BIRCH_FOREST,BiomeKeys.MEADOW,BiomeKeys.OLD_GROWTH_BIRCH_FOREST,BiomeKeys.BADLANDS,BiomeKeys.BEACH,BiomeKeys.DESERT,BiomeKeys.PALE_GARDEN),
                SpawnGroup.MONSTER, ModEntities.SHADOW, 70, 4, 9);

        SpawnRestriction.register(ModEntities.SHADOW, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModEntitySpawns::canSpawnAtNight);


        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS,BiomeKeys.FOREST,BiomeKeys.DARK_FOREST,BiomeKeys.BIRCH_FOREST,BiomeKeys.MEADOW,BiomeKeys.OLD_GROWTH_BIRCH_FOREST,BiomeKeys.BADLANDS,BiomeKeys.BEACH,BiomeKeys.DESERT,BiomeKeys.PALE_GARDEN),
                SpawnGroup.MONSTER, ModEntities.MININOCTURNO, 90, 4, 12);

        SpawnRestriction.register(ModEntities.MININOCTURNO, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModEntitySpawns::canSpawnAtNight);





        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DESERT),
                SpawnGroup.MONSTER, ModEntities.MUMMY, 30, 1, 3);

        SpawnRestriction.register(ModEntities.MUMMY, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModEntitySpawns::canSpawnLight
        );




        NightmareMod.LOGGER.info("Spawning");


}






}



