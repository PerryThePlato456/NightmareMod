package net.perrytheplato.nightmare.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.entity.custom.TreantEntity;

public class TreantRenderer extends MobEntityRenderer<TreantEntity, TreantRenderState, TreantModel> {


    public TreantRenderer(EntityRendererFactory.Context context) {
        super(context, new TreantModel(context.getPart(TreantModel.TREANT)), 0.75f);
    }

    @Override
    public Identifier getTexture(TreantRenderState state) {
        return Identifier.of(NightmareMod.MOD_ID, "textures/entity/treant/treant.png");
    }




    @Override
    public TreantRenderState createRenderState() {
        return new TreantRenderState();
    }

    @Override
    public void updateRenderState(TreantEntity livingEntity, TreantRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);

    }
}

