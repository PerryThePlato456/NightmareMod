package net.perrytheplato.nightmare.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.*;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.item.ModItems;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
public class LurkerEntity extends HostileEntity {
    public LurkerEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState walkAnimationState = new AnimationState();
    private int walkAnimationTimeout = 0;

    private int attackAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    private boolean shouldPlayAttackAnimation = false;


    public static void InitializeAnimations()
    {

    }

    public static DefaultAttributeContainer.Builder createMobAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 18)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.1)
                .add(EntityAttributes.ATTACK_DAMAGE, 30)
                .add(EntityAttributes.FOLLOW_RANGE, 20)
                .add(EntityAttributes.TEMPT_RANGE, 20)
                .add(EntityAttributes.JUMP_STRENGTH, 0)
                .add(EntityAttributes.MOVEMENT_EFFICIENCY, 1)
                .add(EntityAttributes.WATER_MOVEMENT_EFFICIENCY,0);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(2, new TemptGoal(this, 1.25D, Ingredient.ofItems(ModItems.MAGNETITE), false));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));


    }




    protected EntityDimensions getDefaultDimensions() {
        return EntityDimensions.fixed(1.85F, 0.75F); // width, height — adjust as needed
    }
    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();


        }


    }


    private void setupAnimationStates() {
        if (attackAnimationTimeout > 0) {
            --attackAnimationTimeout;
            attackAnimationState.start(this.age);
        }

        if (idleAnimationTimeout <= 0) {
            idleAnimationTimeout = 40;
            idleAnimationState.start(this.age);
        } else {
            --idleAnimationTimeout;
        }

        if (walkAnimationTimeout <= 0) {
            walkAnimationTimeout = 40;
            walkAnimationState.start(this.age);
        } else {
            --walkAnimationTimeout;
        }
    }

    public int getWalkAnimationTimeout() {
        return walkAnimationTimeout;
    }

    public void setWalkAnimationTimeout(int walkAnimationTimeout) {
        this.walkAnimationTimeout = walkAnimationTimeout;
    }

    public int getAttackAnimationTimeout() {
        return attackAnimationTimeout;
    }

    public void setAttackAnimationTimeout(int attackAnimationTimeout) {
        attackAnimationTimeout = 20; // 1 second

    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ZOMBIE_AMBIENT;
    }


    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_HUSK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_DROWNED_DEATH_WATER;
    }

    public boolean tryAttack(ServerWorld world, Entity target) {
        boolean bl = super.tryAttack(world, target);
        if (bl && !this.getWorld().isClient()) {
            this.attackAnimationState.start(this.age);
            }


        return bl;
    }

    public boolean isShouldPlayAttackAnimation() {
        return shouldPlayAttackAnimation;
    }

    public void setShouldPlayAttackAnimation(boolean shouldPlayAttackAnimation) {
        this.shouldPlayAttackAnimation = shouldPlayAttackAnimation;
    }
}
