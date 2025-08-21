package net.perrytheplato.nightmare.entity.client.nightmare.shadow;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.entity.custom.NightmareEntity;
import net.perrytheplato.nightmare.entity.custom.ShadowEntity;

public class NightmareRenderer extends MobEntityRenderer<NightmareEntity, NightmareRenderState, NightmareModel> {

    public NightmareRenderer(EntityRendererFactory.Context context) {
        // Set up the renderer with model and shadow size

        super(context, new NightmareModel(context.getPart(NightmareModel.NIGHTMARE)), 0.75f);

    }





    @Override
    public Identifier getTexture(NightmareRenderState state) {
        return Identifier.of(NightmareMod.MOD_ID, "textures/entity/nightmare/nightmare.png");
    }

    @Override
    public NightmareRenderState createRenderState() {
        return new NightmareRenderState();
    }

    @Override
    public void updateRenderState(NightmareEntity entity, NightmareRenderState state, float tickDelta) {
        // Sync animation states from entity to render state
        super.updateRenderState(entity, state, tickDelta);
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
        state.attackAnimationState.copyFrom(entity.attackAnimationState);
    }
}
