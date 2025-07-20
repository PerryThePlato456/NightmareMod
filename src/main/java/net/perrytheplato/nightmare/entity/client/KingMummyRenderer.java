package net.perrytheplato.nightmare.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.entity.custom.KingMummyEntity;
import net.perrytheplato.nightmare.entity.custom.MummyEntity;

public class KingMummyRenderer extends MobEntityRenderer<KingMummyEntity, KingMummyRenderState, KingMummyModel> {

    public KingMummyRenderer(EntityRendererFactory.Context context) {
        // Set up the renderer with model and shadow size

        super(context, new KingMummyModel(context.getPart(KingMummyModel.KINGMUMMY)), 0.75f);

    }





    @Override
    public Identifier getTexture(KingMummyRenderState state) {
        return Identifier.of(NightmareMod.MOD_ID, "textures/entity/kingmummy/kingmummy.png");
    }

    @Override
    public KingMummyRenderState createRenderState() {
        return new KingMummyRenderState();
    }

    @Override
    public void updateRenderState(KingMummyEntity entity, KingMummyRenderState state, float tickDelta) {
        // Sync animation states from entity to render state
        super.updateRenderState(entity, state, tickDelta);
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
        state.attackAnimationState.copyFrom(entity.attackAnimationState);
    }
}
