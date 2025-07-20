package net.perrytheplato.nightmare;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.structure.JigsawStructure;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;
import net.perrytheplato.nightmare.block.ModBlocks;
import net.perrytheplato.nightmare.entity.ModEntities;
import net.perrytheplato.nightmare.entity.client.*;
import net.perrytheplato.nightmare.entity.custom.*;
import net.perrytheplato.nightmare.event.SpawnOnPlacement;
import net.perrytheplato.nightmare.item.ModItems;
import net.perrytheplato.nightmare.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NightmareMod implements ModInitializer {
	public static final String MOD_ID = "nightmare-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {




		EntityModelLayerRegistry.registerModelLayer(LurkerModel.LURKER, LurkerModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(
				ScorchingSkeletonModel.SCORCHING_SKELETON,
				ScorchingSkeletonModel::getTexturedModelData
		);

		EntityModelLayerRegistry.registerModelLayer(
				TreantModel.TREANT,
				TreantModel::getTexturedModelData
		);

		EntityModelLayerRegistry.registerModelLayer(
				ShadowbaneModel.SHADOWBANE,
				ShadowbaneModel::getTexturedModelData
		);


		EntityModelLayerRegistry.registerModelLayer(
				ShadowModel.SHADOW,
				ShadowModel::getTexturedModelData
		);
		EntityModelLayerRegistry.registerModelLayer(
				MummyModel.MUMMY,
				MummyModel::getTexturedModelData

		);
		EntityModelLayerRegistry.registerModelLayer(
				KingMummyModel.KINGMUMMY,
				KingMummyModel::getTexturedModelData

		);



		EntityModelLayerRegistry.registerModelLayer(
				MiniNocturnoModel.MININOCTURNO,
				MiniNocturnoModel::getTexturedModelData
		);

		EntityModelLayerRegistry.registerModelLayer(
				NocturnoModel.NOCTURNO,
				NocturnoModel::getTexturedModelData
		);


		// Then register the renderer
		EntityRendererRegistry.register(ModEntities.LURKER, LurkerRenderer::new);
		EntityRendererRegistry.register(ModEntities.SCORCHING_SKELETON, ScorchingSkeletonRenderer::new);
		EntityRendererRegistry.register(ModEntities.TREANT, TreantRenderer::new);
		EntityRendererRegistry.register(ModEntities.SHADOWBANE, ShadowbaneRenderer::new);
		EntityRendererRegistry.register(ModEntities.SHADOW, ShadowRenderer::new);
		EntityRendererRegistry.register(ModEntities.SHADOW, ShadowRenderer::new);
		EntityRendererRegistry.register(ModEntities.MUMMY, MummyRenderer::new);
		EntityRendererRegistry.register(ModEntities.KINGMUMMY, KingMummyRenderer::new);
		EntityRendererRegistry.register(ModEntities.MININOCTURNO, MiniNocturnoRenderer::new);
		EntityRendererRegistry.register(ModEntities.NOCTURNO, NocturnoRenderer::new);



		LurkerEntity.InitializeAnimations();
		ModEntities.registerModEntities();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		SpawnOnPlacement.register();


		FabricDefaultAttributeRegistry.register(ModEntities.LURKER, LurkerEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SCORCHING_SKELETON, ScorchingSkeletonEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.TREANT, TreantEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SHADOWBANE, ShadowbaneEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SHADOW, ShadowEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.MUMMY, MummyEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.KINGMUMMY, KingMummyEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.MININOCTURNO, MiniNocturnoEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.NOCTURNO, NocturnoEntity.createMobAttributes());
		ModWorldGeneration.generateModWorldGen();

	}

	public static String getModId() {
		return MOD_ID;
	}
}