package net.perrytheplato.nightmare.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.entity.custom.MiniNocturnoEntity;
import net.perrytheplato.nightmare.entity.custom.ShadowbaneEntity;

public class MiniNocturnoRenderer extends MobEntityRenderer<MiniNocturnoEntity, MiniNocturnoRenderState, MiniNocturnoModel> {


    public MiniNocturnoRenderer(EntityRendererFactory.Context context) {
        super(context, new MiniNocturnoModel(context.getPart(MiniNocturnoModel.MININOCTURNO)), 0.75f);
    }






    @Override
    public MiniNocturnoRenderState createRenderState() {
        return new MiniNocturnoRenderState();
    }

    @Override
    public Identifier getTexture(MiniNocturnoRenderState state) {
        return Identifier.of(NightmareMod.MOD_ID, "textures/entity/mini_nocturno/mini_nocturno.png");
    }

    @Override
    public void updateRenderState(MiniNocturnoEntity livingEntity, MiniNocturnoRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);

    }
}

