package net.perrytheplato.nightmare.entity.client;

import net.minecraft.client.render.entity.animation.AnimationDefinition;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

import static net.minecraft.client.render.entity.animation.Transformation.Interpolations.CUBIC;
import static net.minecraft.client.render.entity.animation.Transformation.Interpolations.LINEAR;

public class ShadowAnimations {



    public static final AnimationDefinition IDLE = AnimationDefinition.Builder.create(4f).looping()
            .addBoneAnimation("left_arm",
                    new Transformation(Transformation.Targets.MOVE_ORIGIN,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, 1f, 0f),
                                    LINEAR),
                            new Keyframe(4f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    LINEAR)))
            .addBoneAnimation("right_arm",
                    new Transformation(Transformation.Targets.MOVE_ORIGIN,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, 1f, 0f),
                                    LINEAR),
                            new Keyframe(4f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    LINEAR))).build();
    public static final AnimationDefinition WALK = AnimationDefinition.Builder.create(0f).looping().build();
    public static final AnimationDefinition ATTACK = AnimationDefinition.Builder.create(0.5f)
            .addBoneAnimation("head",
                    new Transformation(Transformation.Targets.MOVE_ORIGIN,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, 0f, -4f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createRotationalVector(-90f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_arm",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createRotationalVector(-90f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR))).build();
}