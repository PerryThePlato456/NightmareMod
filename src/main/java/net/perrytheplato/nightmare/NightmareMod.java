package net.perrytheplato.nightmare;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.perrytheplato.nightmare.block.ModBlocks;
import net.perrytheplato.nightmare.entity.ModEntities;
import net.perrytheplato.nightmare.entity.client.kingmummy.KingMummyModel;
import net.perrytheplato.nightmare.entity.client.kingmummy.KingMummyRenderer;
import net.perrytheplato.nightmare.entity.client.lurker.LurkerModel;
import net.perrytheplato.nightmare.entity.client.lurker.LurkerRenderer;
import net.perrytheplato.nightmare.entity.client.mininocturno.MiniNocturnoModel;
import net.perrytheplato.nightmare.entity.client.mininocturno.MiniNocturnoRenderer;
import net.perrytheplato.nightmare.entity.client.mummy.MummyModel;
import net.perrytheplato.nightmare.entity.client.mummy.MummyRenderer;
import net.perrytheplato.nightmare.entity.client.nightmare.shadow.NightmareModel;
import net.perrytheplato.nightmare.entity.client.nightmare.shadow.NightmareRenderer;
import net.perrytheplato.nightmare.entity.client.nocturno.NocturnoModel;
import net.perrytheplato.nightmare.entity.client.nocturno.NocturnoRenderer;
import net.perrytheplato.nightmare.entity.client.scorchingskeleton.ScorchingSkeletonModel;
import net.perrytheplato.nightmare.entity.client.scorchingskeleton.ScorchingSkeletonRenderer;
import net.perrytheplato.nightmare.entity.client.shadow.ShadowModel;
import net.perrytheplato.nightmare.entity.client.shadow.ShadowRenderer;
import net.perrytheplato.nightmare.entity.client.shadowbane.ShadowbaneModel;
import net.perrytheplato.nightmare.entity.client.shadowbane.ShadowbaneRenderer;
import net.perrytheplato.nightmare.entity.client.treant.TreantModel;
import net.perrytheplato.nightmare.entity.client.treant.TreantRenderer;
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
				NightmareModel.NIGHTMARE,
				NightmareModel::getTexturedModelData
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
		EntityRendererRegistry.register(ModEntities.NIGHTMARE, NightmareRenderer::new);



		LurkerEntity.InitializeAnimations();
		ModEntities.registerModEntities();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		SpawnOnPlacement.register();


		FabricDefaultAttributeRegistry.register(ModEntities.LURKER, LurkerEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.NIGHTMARE, NightmareEntity.createMobAttributes());
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