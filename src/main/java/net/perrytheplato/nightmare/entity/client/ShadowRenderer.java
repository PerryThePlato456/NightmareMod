package net.perrytheplato.nightmare.entity.client;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.entity.custom.ShadowEntity;
import net.perrytheplato.nightmare.entity.client.ShadowModel;
import net.perrytheplato.nightmare.entity.client.ShadowRenderState;
import net.minecraft.util.Identifier;
public class ShadowRenderer extends MobEntityRenderer<ShadowEntity, ShadowRenderState, ShadowModel> {

    public ShadowRenderer(EntityRendererFactory.Context context) {
        // Set up the renderer with model and shadow size

        super(context, new ShadowModel(context.getPart(ShadowModel.SHADOW)), 0.75f);

    }





    @Override
    public Identifier getTexture(ShadowRenderState state) {
        return Identifier.of(NightmareMod.MOD_ID, "textures/entity/shadow/shadow.png");
    }

    @Override
    public ShadowRenderState createRenderState() {
        return new ShadowRenderState();
    }

    @Override
    public void updateRenderState(ShadowEntity entity, ShadowRenderState state, float tickDelta) {
        // Sync animation states from entity to render state
        super.updateRenderState(entity, state, tickDelta);
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
        state.attackAnimationState.copyFrom(entity.attackAnimationState);
    }
}
