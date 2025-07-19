package net.perrytheplato.nightmare.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.BlockState;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.perrytheplato.nightmare.block.ModBlocks;
import net.perrytheplato.nightmare.entity.ModEntities;
import net.perrytheplato.nightmare.entity.custom.NocturnoEntity;

import java.util.HashSet;
import java.util.Set;

public class SpawnOnPlacement {

    private static final Set<BlockPos> triggeredPositions = new HashSet<>();

    public static void register() {
        ServerTickEvents.END_WORLD_TICK.register(world -> {
            for (ServerPlayerEntity player : world.getPlayers()) {
                BlockPos center = player.getBlockPos();

                int radius = 6;
                for (int x = -radius; x <= radius; x++) {
                    for (int y = -2; y <= 3; y++) {
                        for (int z = -radius; z <= radius; z++) {
                            BlockPos pos = center.add(x, y, z);
                            BlockState above = world.getBlockState(pos);
                            BlockState below = world.getBlockState(pos.down());

                            if (above.isOf(ModBlocks.NOCTURNO_HEART)
                                    && below.isOf(ModBlocks.BOSS_PEDESTAL)
                                    && !triggeredPositions.contains(pos)) {

                                // Spawn Nocturno
                                NocturnoEntity nocturno = new NocturnoEntity(ModEntities.NOCTURNO, world);
                                nocturno.refreshPositionAndAngles(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0, 0);
                                world.spawnEntity(nocturno);

                                // Remove both ritual blocks
                                world.removeBlock(pos, false);
                                world.removeBlock(pos.down(), false);

                                // Track this position to avoid re-trigger
                                triggeredPositions.add(pos);
                            }
                        }
                    }
                }
            }
        });
    }

}