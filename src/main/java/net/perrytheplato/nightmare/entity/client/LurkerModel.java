package net.perrytheplato.nightmare.entity.client;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.entity.custom.LurkerEntity;

public class LurkerModel extends EntityModel<LurkerRenderState>  {
    public static final EntityModelLayer LURKER = new EntityModelLayer(Identifier.of(NightmareMod.MOD_ID, "lurker"), "main");
    private final ModelPart lurker;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart left_leg;
    private final ModelPart right_leg;
    private final Animation walkingAnimation;
    private final Animation idlingAnimation;
    private final Animation attackAnimation;
   ;
    public LurkerModel(ModelPart root) {
        super(root);

        this.lurker = root.getChild("lurker");
        this.head = this.lurker.getChild("head");
        this.body = this.lurker.getChild("body");
        this.left_arm = this.lurker.getChild("left_arm");
        this.right_arm = this.lurker.getChild("right_arm");
        this.left_leg = this.lurker.getChild("left_leg");
        this.right_leg = this.lurker.getChild("right_leg");
        this.walkingAnimation = LurkerAnimations.WALK.createAnimation(root);
        this.idlingAnimation = LurkerAnimations.IDLE.createAnimation(root);
        this.attackAnimation = LurkerAnimations.ATTACK.createAnimation(root);
    }



    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData lurker = modelPartData.addChild("lurker", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 24.0F, 0.0F));

        ModelPartData head = lurker.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -32.0F, -2.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(0, 16).cuboid(-4.0F, -32.0F, -2.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F)), ModelTransform.of(0.0F, -2.0F, 17.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData body = lurker.addChild("body", ModelPartBuilder.create().uv(0, 32).cuboid(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 17.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData left_arm = lurker.addChild("left_arm", ModelPartBuilder.create().uv(32, 0).cuboid(4.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 17.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData right_arm = lurker.addChild("right_arm", ModelPartBuilder.create().uv(32, 16).cuboid(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 17.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData left_leg = lurker.addChild("left_leg", ModelPartBuilder.create().uv(24, 32).cuboid(0.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 17.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData right_leg = lurker.addChild("right_leg", ModelPartBuilder.create().uv(40, 32).cuboid(-4.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 17.0F, 1.5708F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    public void setAngles(LurkerRenderState camelEntityRenderState, LurkerEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitc) {
        super.setAngles(camelEntityRenderState);
        this.setHeadAngles(camelEntityRenderState, camelEntityRenderState.relativeHeadYaw, camelEntityRenderState.pitch);
        this.walkingAnimation.applyWalking(camelEntityRenderState.limbSwingAnimationProgress, camelEntityRenderState.limbSwingAmplitude, 2.0F, 2.5F);
        this.idlingAnimation.apply(camelEntityRenderState.idleAnimationState, camelEntityRenderState.age, 1.0F);
        this.attackAnimation.apply(camelEntityRenderState.attackAnimationState, camelEntityRenderState.age, .5F);

    }

    private void setHeadAngles(LurkerRenderState state, float headYaw, float headPitch) {

    }
}




