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


public class KingMummyModel extends EntityModel<KingMummyRenderState> {
    public static final EntityModelLayer KINGMUMMY = new EntityModelLayer(Identifier.of(NightmareMod.MOD_ID, "kingmummy"), "main");
    private final ModelPart body;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart left_leg;
    private final ModelPart right_leg;
    private final ModelPart head;
    private final ModelPart body1;
    private final ModelPart head1;

    private final Animation walkingAnimation;
    private final Animation idlingAnimation;
    private final Animation attackAnimation;

    public KingMummyModel(ModelPart root) {
        super(root);
        this.body = root.getChild("body");
        this.left_arm = root.getChild("left_arm");
        this.right_arm = root.getChild("right_arm");
        this.left_leg = root.getChild("left_leg");
        this.right_leg = root.getChild("right_leg");
        this.head = root.getChild("head");
        this.body1 = root.getChild("body1");
        this.head1 = root.getChild("head1");


        this.walkingAnimation = KingMummyAnimations.WALK.createAnimation(root);
        this.idlingAnimation = KingMummyAnimations.IDLE.createAnimation(root);
        this.attackAnimation = KingMummyAnimations.ATTACK.createAnimation(root);

    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 0.0F, 0.0F));

        ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create().uv(26, 18).cuboid(1.0F, -1.0F, -1.0F, 4.0F, 11.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(5.0F, 2.0F, 0.0F));

        ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create().uv(2, 34).cuboid(-4.0F, -1.0F, -1.0F, 4.0F, 11.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(-5.0F, 2.0F, 0.0F));

        ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(32, 0).cuboid(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(1.9F, 12.0F, 0.0F));

        ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(16, 32).cuboid(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(-1.9F, 12.0F, 0.0F));

        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 0.0F, 0.0F));

        ModelPartData body1 = modelPartData.addChild("body1", ModelPartBuilder.create().uv(-2, 14).cuboid(-10.0F, 3.9F, -2.5F, 20.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, -6.0F, 0.0F));

        ModelPartData head1 = modelPartData.addChild("head1", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, -6.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }


    @Override
    public void setAngles(KingMummyRenderState state) {
        super.setAngles(state);
        this.setHeadAngles(state.relativeHeadYaw, state.pitch);

        this.walkingAnimation.applyWalking(state.limbSwingAnimationProgress, state.limbSwingAmplitude, 2f, 2.5f);
        this.idlingAnimation.apply(state.idleAnimationState, state.age, 1f);
        this.attackAnimation.apply(state.attackAnimationState, state.age, 1f);



    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
        this.head1.yaw = headYaw * 0.017453292F;
        this.head1.pitch = headPitch * 0.017453292F;
    }


    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        body.render(matrices, vertexConsumer, light, overlay);
        left_arm.render(matrices, vertexConsumer, light, overlay);
        right_arm.render(matrices, vertexConsumer, light, overlay);
        left_leg.render(matrices, vertexConsumer, light, overlay);
        right_leg.render(matrices, vertexConsumer, light, overlay);
        head.render(matrices, vertexConsumer, light, overlay);
        body1.render(matrices, vertexConsumer, light, overlay);
        head1.render(matrices, vertexConsumer, light, overlay);
    }

}


