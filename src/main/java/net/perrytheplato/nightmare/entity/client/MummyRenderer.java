package net.perrytheplato.nightmare.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.entity.custom.MummyEntity;
import net.perrytheplato.nightmare.entity.custom.ShadowEntity;

public class MummyRenderer extends MobEntityRenderer<MummyEntity, MummyRenderState, MummyModel> {

    public MummyRenderer(EntityRendererFactory.Context context) {
        // Set up the renderer with model and shadow size

        super(context, new MummyModel(context.getPart(MummyModel.MUMMY)), 0.75f);

    }





    @Override
    public Identifier getTexture(MummyRenderState state) {
        return Identifier.of(NightmareMod.MOD_ID, "textures/entity/mummy/mummy.png");
    }

    @Override
    public MummyRenderState createRenderState() {
        return new MummyRenderState();
    }

    @Override
    public void updateRenderState(MummyEntity entity, MummyRenderState state, float tickDelta) {
        // Sync animation states from entity to render state
        super.updateRenderState(entity, state, tickDelta);
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
        state.attackAnimationState.copyFrom(entity.attackAnimationState);
    }
}
