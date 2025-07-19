package net.perrytheplato.nightmare.entity.client;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.entity.custom.ScorchingSkeletonEntity;

public class ScorchingSkeletonRenderer extends MobEntityRenderer<ScorchingSkeletonEntity, ScorchingSkeletonRenderState, ScorchingSkeletonModel> {


    public ScorchingSkeletonRenderer(EntityRendererFactory.Context context) {
        super(context, new ScorchingSkeletonModel(context.getPart(ScorchingSkeletonModel.SCORCHING_SKELETON)), 0.75f);
    }

    @Override
    public Identifier getTexture(ScorchingSkeletonRenderState state) {
        return Identifier.of(NightmareMod.MOD_ID, "textures/entity/scorching_skeleton/scorching_skeleton.png");
    }




    @Override
    public ScorchingSkeletonRenderState createRenderState() {
        return new ScorchingSkeletonRenderState();
    }

    @Override
    public void updateRenderState(ScorchingSkeletonEntity livingEntity, ScorchingSkeletonRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);

    }
}
