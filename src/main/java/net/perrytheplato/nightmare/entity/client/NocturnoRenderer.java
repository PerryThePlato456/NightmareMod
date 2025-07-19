package net.perrytheplato.nightmare.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.entity.custom.NocturnoEntity;
import net.perrytheplato.nightmare.entity.custom.ShadowbaneEntity;

public class NocturnoRenderer extends MobEntityRenderer<NocturnoEntity, NocturnoRenderState, NocturnoModel> {


    public NocturnoRenderer(EntityRendererFactory.Context context) {
    super(context, new NocturnoModel(context.getPart(NocturnoModel.NOCTURNO)), 0.75f);
    }






    @Override
    public NocturnoRenderState createRenderState() {
        return new NocturnoRenderState();
    }



    @Override
    public void updateRenderState(NocturnoEntity livingEntity, NocturnoRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
        livingEntityRenderState.attackAnimationState.copyFrom(livingEntity.attackAnimationState);
    }

    @Override
    public Identifier getTexture(NocturnoRenderState state) {
        return Identifier.of(NightmareMod.MOD_ID, "textures/entity/nocturno/nocturno.png");
    }
}

