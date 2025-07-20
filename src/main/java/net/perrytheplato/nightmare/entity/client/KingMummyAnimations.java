package net.perrytheplato.nightmare.entity.client;

import net.minecraft.client.render.entity.animation.AnimationDefinition;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

import static net.minecraft.client.render.entity.animation.Transformation.Interpolations.LINEAR;

public class KingMummyAnimations {



    public static final AnimationDefinition WALK = AnimationDefinition.Builder.create(2f).looping()
            .addBoneAnimation("left_arm",
                    new Transformation(Transformation.Targets.MOVE_ORIGIN,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 2f, 0f),
                                    LINEAR)))
            .addBoneAnimation("left_arm",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(-92.5f, 0f, 0f),
                                    LINEAR)))
            .addBoneAnimation("right_arm",
                    new Transformation(Transformation.Targets.MOVE_ORIGIN,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 2f, 0f),
                                    LINEAR)))
            .addBoneAnimation("right_arm",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(-92.5f, 0f, 0f),
                                    LINEAR)))
            .addBoneAnimation("left_leg",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(-27.5f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(1.5f, AnimationHelper.createRotationalVector(27.5f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    LINEAR)))
            .addBoneAnimation("right_leg",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(27.5f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(1.5f, AnimationHelper.createRotationalVector(-27.5f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    LINEAR))).build();
    public static final AnimationDefinition IDLE = AnimationDefinition.Builder.create(4.041677f)
            .addBoneAnimation("left_arm",
                    new Transformation(Transformation.Targets.MOVE_ORIGIN,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, 1f, 0f),
                                    LINEAR),
                            new Keyframe(4.041677f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    LINEAR)))
            .addBoneAnimation("right_arm",
                    new Transformation(Transformation.Targets.MOVE_ORIGIN,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, 1f, 0f),
                                    LINEAR),
                            new Keyframe(4.041677f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    LINEAR)))
            .addBoneAnimation("body1",
                    new Transformation(Transformation.Targets.MOVE_ORIGIN,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, 1f, 0f),
                                    LINEAR),
                            new Keyframe(4.041677f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    LINEAR)))
            .addBoneAnimation("head1",
                    new Transformation(Transformation.Targets.MOVE_ORIGIN,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, -1f, 0f),
                                    LINEAR),
                            new Keyframe(4.041677f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    LINEAR))).build();
    public static final AnimationDefinition ATTACK = AnimationDefinition.Builder.create(0.25f)
            .addBoneAnimation("left_arm",
                    new Transformation(Transformation.Targets.MOVE_ORIGIN,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(0.08343333f, AnimationHelper.createTranslationalVector(0f, 2f, 0f),
                                    LINEAR)))
            .addBoneAnimation("left_arm",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(0.08343333f, AnimationHelper.createRotationalVector(-87.5f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(0.16766666f, AnimationHelper.createRotationalVector(-86.95f, 34.96f, 1.75f),
                                    LINEAR)))
            .addBoneAnimation("right_arm",
                    new Transformation(Transformation.Targets.MOVE_ORIGIN,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(0.08343333f, AnimationHelper.createTranslationalVector(0f, 2f, 0f),
                                    LINEAR)))
            .addBoneAnimation("right_arm",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(0.08343333f, AnimationHelper.createRotationalVector(-87.5f, 0f, 0f),
                                    LINEAR),
                            new Keyframe(0.16766666f, AnimationHelper.createRotationalVector(-86.95f, -34.96f, -1.75f),
                                    LINEAR))).build();
}