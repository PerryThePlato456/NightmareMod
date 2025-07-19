package net.perrytheplato.nightmare.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.entity.custom.LurkerEntity;

public final class LurkerRenderer extends MobEntityRenderer<LurkerEntity, LurkerRenderState, EntityModel<? super LurkerRenderState>> {

    public LurkerRenderer(EntityRendererFactory.Context context) {
        super(context, new LurkerModel(context.getPart(LurkerModel.LURKER)), 0.75f);
    }

    public LurkerRenderState createRenderState() {
        return new LurkerRenderState();
    }
    public void updateRenderState(LurkerEntity lurker, LurkerRenderState lurkerRenderState, float f) {
        super.updateRenderState(lurker, lurkerRenderState, f);
        lurkerRenderState.walkAnimationState.copyFrom(lurker.walkAnimationState);
        lurkerRenderState.idleAnimationState.copyFrom(lurker.idleAnimationState);
        lurkerRenderState.attackAnimationState.copyFrom(lurker.attackAnimationState);
    }


    public Identifier getTexture(LurkerEntity entity) {
        return Identifier.of(NightmareMod.MOD_ID, "textures/entity/lurker/lurker.png");
    }


    public void render(LurkerRenderState livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {


        super.render(livingEntity, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(LurkerRenderState state) {
        return Identifier.of(NightmareMod.MOD_ID, "textures/entity/lurker/lurker.png");
    }
}