package net.perrytheplato.nightmare.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.entity.custom.ShadowbaneEntity;

public class ShadowbaneRenderer extends MobEntityRenderer<ShadowbaneEntity, ShadowbaneRenderState, ShadowbaneModel> {


    public ShadowbaneRenderer(EntityRendererFactory.Context context) {
        super(context, new ShadowbaneModel(context.getPart(ShadowbaneModel.SHADOWBANE)), 0.75f);
    }






    @Override
    public ShadowbaneRenderState createRenderState() {
        return new ShadowbaneRenderState();
    }

    @Override
    public Identifier getTexture(ShadowbaneRenderState state) {
        return Identifier.of(NightmareMod.MOD_ID, "textures/entity/shadowbane/shadowbane.png");
    }

    @Override
    public void updateRenderState(ShadowbaneEntity livingEntity, ShadowbaneRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
        livingEntityRenderState.attackAnimationState.copyFrom(livingEntity.attackAnimationState);
    }
}

