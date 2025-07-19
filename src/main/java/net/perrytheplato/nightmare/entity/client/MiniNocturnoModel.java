package net.perrytheplato.nightmare.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.entity.custom.MiniNocturnoEntity;


public class MiniNocturnoModel extends EntityModel<MiniNocturnoRenderState> {
    public static final EntityModelLayer MININOCTURNO = new EntityModelLayer(Identifier.of(NightmareMod.MOD_ID, "mininocturno"), "main");
    private final ModelPart left_arm;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart right_arm;

    private final Animation walkingAnimation;
    private final Animation idlingAnimation;

    public MiniNocturnoModel(ModelPart root) {
        super(root);
        this.left_arm = root.getChild("left_arm");
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.right_arm = root.getChild("right_arm");

        this.walkingAnimation = MiniNocturnoAnimations.WALK.createAnimation(root);
        this.idlingAnimation = MiniNocturnoAnimations.IDLE.createAnimation(root);
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create().uv(10, 16).cuboid(-0.5F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(2.0F, 18.5F, 0.0F));

        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-2.5F, -5.0F, -2.5F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 18.0F, 0.0F));

        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(10, 10).cuboid(-1.5F, 0.0F, -1.0F, 3.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 10).cuboid(-1.5F, 1.0F, -1.0F, 3.0F, 5.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.origin(0.0F, 18.0F, 0.0F));

        ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create().uv(0, 17).cuboid(-1.5F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(-2.0F, 18.5F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }
    @Override
    public void setAngles(MiniNocturnoRenderState state) {
        super.setAngles(state);
        this.setHeadAngles(state.relativeHeadYaw, state.pitch);

        this.walkingAnimation.applyWalking(state.limbSwingAnimationProgress, state.limbSwingAmplitude, 2f, 2.5f);
        this.idlingAnimation.apply(state.idleAnimationState, state.age, 1f);




    }


    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }


    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        left_arm.render(matrices, vertexConsumer, light, overlay);
        head.render(matrices, vertexConsumer, light, overlay);
        body.render(matrices, vertexConsumer, light, overlay);
        right_arm.render(matrices, vertexConsumer, light, overlay);
    }


}


