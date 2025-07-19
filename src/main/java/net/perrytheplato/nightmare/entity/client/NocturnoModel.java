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
import net.perrytheplato.nightmare.entity.custom.NocturnoEntity;


public class NocturnoModel extends EntityModel<NocturnoRenderState> {
    public static final EntityModelLayer NOCTURNO = new EntityModelLayer(Identifier.of(NightmareMod.MOD_ID, "nocturno"), "main");
    private final ModelPart torso;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart left_leg;
    private final ModelPart right_leg;
    private final ModelPart neck;
    private final ModelPart head1;
    private final ModelPart head2;
    private final ModelPart head3;

    private final Animation walkingAnimation;
    private final Animation idlingAnimation;
    private final Animation attackAnimation;

    public NocturnoModel(ModelPart root) {
        super(root);
        this.torso = root.getChild("torso");
        this.left_arm = root.getChild("left_arm");
        this.right_arm = root.getChild("right_arm");
        this.left_leg = root.getChild("left_leg");
        this.right_leg = root.getChild("right_leg");
        this.neck = root.getChild("neck");
        this.head1 = root.getChild("head1");
        this.head2 = root.getChild("head2");
        this.head3 = root.getChild("head3");

        this.walkingAnimation = NocturnoAnimations.WALK.createAnimation(root);
        this.idlingAnimation = NocturnoAnimations.IDLE.createAnimation(root);
        this.attackAnimation = NocturnoAnimations.ATTACK.createAnimation(root);
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData torso = modelPartData.addChild("torso", ModelPartBuilder.create().uv(64, 0).cuboid(-9.0F, -15.0F, -4.0F, 18.0F, 23.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.0F, -1.0F, 0.0F, 3.1416F, 0.0F));

        ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.origin(13.0F, -10.0F, 0.0F));

        ModelPartData left_arm_r1 = left_arm.addChild("left_arm_r1", ModelPartBuilder.create().uv(64, 34).cuboid(9.0F, -34.0F, -4.0F, 8.0F, 28.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(13.0F, 34.0F, -3.0F, 0.0F, 3.1416F, 0.0F));

        ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.origin(-13.0F, -10.0F, 0.0F));

        ModelPartData right_arm_r1 = right_arm.addChild("right_arm_r1", ModelPartBuilder.create().uv(64, 70).cuboid(-17.0F, -34.0F, -4.0F, 8.0F, 28.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-13.0F, 34.0F, -3.0F, 0.0F, 3.1416F, 0.0F));

        ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(0, 96).cuboid(-2.9F, 0.0F, -3.0F, 6.0F, 13.0F, 6.0F, new Dilation(0.0F)), ModelTransform.origin(6.0F, 11.0F, -1.0F));

        ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(24, 96).cuboid(-3.1F, 0.0F, -3.0F, 6.0F, 13.0F, 6.0F, new Dilation(0.0F)), ModelTransform.origin(-6.0F, 11.0F, -1.0F));

        ModelPartData neck = modelPartData.addChild("neck", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 70.0F, -48.0F));

        ModelPartData neck_r1 = neck.addChild("neck_r1", ModelPartBuilder.create().uv(96, 34).cuboid(-1.0F, -70.0F, -79.0F, 2.0F, 4.0F, 6.0F, new Dilation(0.0F))
                .uv(96, 44).cuboid(-1.0F, -70.0F, -69.0F, 2.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -15.0F, -1.5708F, 0.0F, 0.0F));

        ModelPartData head1 = modelPartData.addChild("head1", ModelPartBuilder.create(), ModelTransform.origin(4.0F, -16.0F, 0.0F));

        ModelPartData head1_r1 = head1.addChild("head1_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-12.0F, -36.0F, -4.0F, 16.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        ModelPartData head2 = modelPartData.addChild("head2", ModelPartBuilder.create(), ModelTransform.origin(-4.0F, -12.0F, 0.0F));

        ModelPartData head2_r1 = head2.addChild("head2_r1", ModelPartBuilder.create().uv(0, 32).cuboid(-22.0F, -34.0F, -4.0F, 16.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(-27.0F, 18.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        ModelPartData head3 = modelPartData.addChild("head3", ModelPartBuilder.create(), ModelTransform.origin(14.0F, -12.0F, 0.0F));

        ModelPartData head3_r1 = head3.addChild("head3_r1", ModelPartBuilder.create().uv(0, 64).cuboid(-4.0F, -34.0F, -4.0F, 16.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(7.0F, 19.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(NocturnoRenderState state) {
        super.setAngles(state);
        this.setHeadAngles(state.relativeHeadYaw, state.pitch);

        this.walkingAnimation.applyWalking(state.limbSwingAnimationProgress, state.limbSwingAmplitude, 2f, 2.5f);
        this.idlingAnimation.apply(state.idleAnimationState, state.age, 1f);
        this.attackAnimation.apply(state.attackAnimationState, state.age, 1f);



    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head1.yaw = headYaw * 0.017453292F;
        this.head1.pitch = headPitch * 0.017453292F;
        this.head2.yaw = headYaw * 0.017453292F;
        this.head2.pitch = headPitch * 0.017453292F;
        this.head3.yaw = headYaw * 0.017453292F;
        this.head3.pitch = headPitch * 0.017453292F;
    }


    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        torso.render(matrices, vertexConsumer, light, overlay);
        left_arm.render(matrices, vertexConsumer, light, overlay);
        right_arm.render(matrices, vertexConsumer, light, overlay);
        left_leg.render(matrices, vertexConsumer, light, overlay);
        right_leg.render(matrices, vertexConsumer, light, overlay);
        neck.render(matrices, vertexConsumer, light, overlay);
        head1.render(matrices, vertexConsumer, light, overlay);
        head2.render(matrices, vertexConsumer, light, overlay);
        head3.render(matrices, vertexConsumer, light, overlay);
    }

}


