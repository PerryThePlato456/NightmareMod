package net.perrytheplato.nightmare.entity.client;

import net.minecraft.client.render.entity.animation.AnimationDefinition;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

import static net.minecraft.client.render.entity.animation.Transformation.Interpolations.CUBIC;
import static net.minecraft.client.render.entity.animation.Transformation.Interpolations.LINEAR;

public class ShadowbaneAnimations {


    public static final AnimationDefinition IDLE = AnimationDefinition.Builder.create(0.25f).looping()
            .addBoneAnimation("right_arm",
                    new Transformation(Transformation.Targets.MOVE_ORIGIN,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(0.125f, AnimationHelper.createTranslationalVector(0f, 1f, 0f),
                                    LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    LINEAR)))
            .addBoneAnimation("left_arm",
                    new Transformation(Transformation.Targets.MOVE_ORIGIN,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(0.125f, AnimationHelper.createTranslationalVector(0f, 1f, 0f),
                                    LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    LINEAR))).build();
    public static final AnimationDefinition WALK = AnimationDefinition.Builder.create(0.5416766f).looping()
            .addBoneAnimation("left_leg",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(0.125f, AnimationHelper.createRotationalVector(10f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(0.4167667f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(0.5416766f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    LINEAR)))
            .addBoneAnimation("right_leg",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(0.125f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(0.4167667f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(0.5416766f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    LINEAR))).build();
    public static final AnimationDefinition ATTACK = AnimationDefinition.Builder.create(0.9f)
            .addBoneAnimation("right_arm",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), CUBIC),
                            new Keyframe(0.2f, AnimationHelper.createRotationalVector(-130f, 10f, -5f), CUBIC),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(-60f, -3f, 2f), CUBIC),
                            new Keyframe(0.9f, AnimationHelper.createRotationalVector(0f, 0f, 0f), LINEAR)
                    )
            )
            .addBoneAnimation("left_arm",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), CUBIC),
                            new Keyframe(0.2f, AnimationHelper.createRotationalVector(-120f, -15f, 3f), CUBIC),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(-60f, 5f, -2f), CUBIC),
                            new Keyframe(0.9f, AnimationHelper.createRotationalVector(0f, 0f, 0f), LINEAR)
                    )
            )
            .addBoneAnimation("body",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), LINEAR),
                            new Keyframe(0.3f, AnimationHelper.createRotationalVector(-10f, 0f, 5f), CUBIC),
                            new Keyframe(0.9f, AnimationHelper.createRotationalVector(0f, 0f, 0f), LINEAR)
                    )
            ).build();
}