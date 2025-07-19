package net.perrytheplato.nightmare;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;

public class ChasePlayerGoal extends Goal {
    private final MobEntity mob;

    public ChasePlayerGoal(MobEntity mob) {
        this.mob = mob;
    }

    @Override
    public boolean canStart() {
        return mob.getTarget() instanceof PlayerEntity;
    }

    @Override
    public void start() {
        LivingEntity target = mob.getTarget();
        if (target != null) {
            mob.getNavigation().startMovingTo(target, .1D);
        }
    }

    @Override
    public boolean shouldContinue() {
        return canStart();
    }
}