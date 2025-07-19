package net.perrytheplato.nightmare.entity.client;

import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;
import net.perrytheplato.nightmare.NightmareMod;

public class LurkerRenderState extends LivingEntityRenderState {
    public boolean attacking;
   ;
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState walkAnimationState = new AnimationState();
    public AnimationState attackAnimationState = new AnimationState();
    public LurkerRenderState() {
        NightmareMod.LOGGER.info("returned");
        this.idleAnimationState = new AnimationState();
        this.walkAnimationState = new AnimationState();
        this.attackAnimationState = new AnimationState();



    }




}

