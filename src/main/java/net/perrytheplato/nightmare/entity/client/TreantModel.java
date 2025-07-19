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
import net.perrytheplato.nightmare.entity.custom.TreantEntity;

public class TreantModel extends EntityModel<TreantRenderState> {
    public static final EntityModelLayer TREANT = new EntityModelLayer(Identifier.of(NightmareMod.MOD_ID, "treant"), "main");
    private final ModelPart head;
    private final ModelPart torso;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart left_leg;
    private final ModelPart right_leg;

    private final Animation walkingAnimation;
    private final Animation idlingAnimation;

    public TreantModel(ModelPart root) {
        super(root);
        this.head = root.getChild("head");
        this.torso = root.getChild("torso");
        this.left_arm = root.getChild("left_arm");
        this.right_arm = root.getChild("right_arm");
        this.left_leg = root.getChild("left_leg");
        this.right_leg = root.getChild("right_leg");

        this.walkingAnimation = TreantAnimations.WALK.createAnimation(root);
        this.idlingAnimation = TreantAnimations.IDLE.createAnimation(root);
    }



    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 32).cuboid(-6.0F, -18.0F, -5.0F, 12.0F, 18.0F, 10.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, -10.0F, -1.0F));

        ModelPartData torso = modelPartData.addChild("torso", ModelPartBuilder.create().uv(0, 0).cuboid(-9.0F, -13.0F, -4.0F, 18.0F, 21.0F, 11.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 3.0F, -1.0F));

        ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create().uv(44, 32).cuboid(-4.0F, 0.0F, -4.0F, 5.0F, 28.0F, 8.0F, new Dilation(0.0F)), ModelTransform.origin(13.0F, -10.0F, 0.0F));

                ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create().uv(0, 60).cuboid(-1.0F, 0.0F, -4.0F, 5.0F, 28.0F, 8.0F, new Dilation(0.0F)), ModelTransform.origin(-13.0F, -10.0F, 0.0F));

        ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(58, 0).cuboid(-2.9F, 0.0F, -3.0F, 6.0F, 13.0F, 6.0F, new Dilation(0.0F)), ModelTransform.origin(6.0F, 11.0F, -1.0F));

        ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(26, 68).cuboid(-3.1F, 0.0F, -3.0F, 6.0F, 13.0F, 6.0F, new Dilation(0.0F)), ModelTransform.origin(-6.0F, 11.0F, -1.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(TreantRenderState state) {
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
        head.render(matrices, vertexConsumer, light, overlay);
        torso.render(matrices, vertexConsumer, light, overlay);
        left_arm.render(matrices, vertexConsumer, light, overlay);
        right_arm.render(matrices, vertexConsumer, light, overlay);
        left_leg.render(matrices, vertexConsumer, light, overlay);
        right_leg.render(matrices, vertexConsumer, light, overlay);
    }
}
