package net.perrytheplato.nightmare.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.entity.custom.*;

public class ModEntities {
    public static final RegistryKey<EntityType<?>> LURKER_KEY = RegistryKey.of(
            Registries.ENTITY_TYPE.getKey(),
            Identifier.of(NightmareMod.MOD_ID, "lurker")
    );
    public static final RegistryKey<EntityType<?>> SCORCHING_SKELETON_KEY = RegistryKey.of(
            Registries.ENTITY_TYPE.getKey(),
            Identifier.of(NightmareMod.MOD_ID, "scorching_skeleton")
    );
    public static final RegistryKey<EntityType<?>> TREANT_KEY = RegistryKey.of(
            Registries.ENTITY_TYPE.getKey(),
            Identifier.of(NightmareMod.MOD_ID, "treant")
    );

    public static final RegistryKey<EntityType<?>> SHADOWBANE_KEY = RegistryKey.of(
            Registries.ENTITY_TYPE.getKey(),
            Identifier.of(NightmareMod.MOD_ID, "shadowbane")
    );

    public static final RegistryKey<EntityType<?>> SHADOW_KEY = RegistryKey.of(
            Registries.ENTITY_TYPE.getKey(),
            Identifier.of(NightmareMod.MOD_ID, "shadow")
    );

    public static final RegistryKey<EntityType<?>> MININOCTURNO_KEY = RegistryKey.of(
            Registries.ENTITY_TYPE.getKey(),
            Identifier.of(NightmareMod.MOD_ID, "mininocturno")
    );

    public static final RegistryKey<EntityType<?>> NOCTURNO_KEY = RegistryKey.of(
            Registries.ENTITY_TYPE.getKey(),
            Identifier.of(NightmareMod.MOD_ID, "nocturno")
    );

    public static final RegistryKey<EntityType<?>> MUMMY_KEY = RegistryKey.of(
            Registries.ENTITY_TYPE.getKey(),
            Identifier.of(NightmareMod.MOD_ID, "mummy")
    );

    public static final RegistryKey<EntityType<?>> KINGMUMMY_KEY = RegistryKey.of(
            Registries.ENTITY_TYPE.getKey(),
            Identifier.of(NightmareMod.MOD_ID, "kingmummy")
    );

    public static final EntityType<LurkerEntity> LURKER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(NightmareMod.MOD_ID, "lurker"),
            EntityType.Builder.create(LurkerEntity::new, SpawnGroup.MONSTER)
                    .dimensions(1.7f, .725f).build(LURKER_KEY));
    public static final EntityType<ScorchingSkeletonEntity> SCORCHING_SKELETON = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(NightmareMod.MOD_ID, "scorching_skeleton"),
            EntityType.Builder.create(ScorchingSkeletonEntity::new, SpawnGroup.MONSTER)
                    .dimensions(.6f, 2f).build(SCORCHING_SKELETON_KEY));
    public static final EntityType<TreantEntity> TREANT = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(NightmareMod.MOD_ID, "treant"),
            EntityType.Builder.create(TreantEntity::new, SpawnGroup.MONSTER)
                    .dimensions(1.5f, 3f).build(TREANT_KEY));
    public static final EntityType<ShadowbaneEntity> SHADOWBANE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(NightmareMod.MOD_ID, "shadowbane"),
            EntityType.Builder.create(ShadowbaneEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.5f, 3f).build(SHADOWBANE_KEY));
    public static final EntityType<ShadowEntity> SHADOW = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(NightmareMod.MOD_ID, "shadow"),
            EntityType.Builder.create(ShadowEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 2f).build(SHADOW_KEY));


    public static final EntityType<MiniNocturnoEntity> MININOCTURNO = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(NightmareMod.MOD_ID, "mininocturno"),
            EntityType.Builder.create(MiniNocturnoEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.5f, 0.7f).build(MININOCTURNO_KEY));

    public static final EntityType<NocturnoEntity> NOCTURNO = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(NightmareMod.MOD_ID, "nocturno"),
            EntityType.Builder.create(NocturnoEntity::new, SpawnGroup.MONSTER)
                    .dimensions(2.3f, 2.99f).build(NOCTURNO_KEY));

    public static final EntityType<MummyEntity> MUMMY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(NightmareMod.MOD_ID, "mummy"),
            EntityType.Builder.create(MummyEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 2f).build(MUMMY_KEY));
    public static final EntityType<KingMummyEntity> KINGMUMMY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(NightmareMod.MOD_ID, "kingmummy"),
            EntityType.Builder.create(KingMummyEntity::new, SpawnGroup.MONSTER)
                    .dimensions(1f, 2f).build(KINGMUMMY_KEY));


    public static void registerModEntities() {
        NightmareMod.LOGGER.info("Registering Mod Entities for " + NightmareMod.MOD_ID);
    }
}
