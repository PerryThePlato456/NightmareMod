package net.perrytheplato.nightmare.entity.custom;

import net.minecraft.client.render.entity.animation.AnimationDefinition;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.perrytheplato.nightmare.ChasePlayerGoal;
import net.perrytheplato.nightmare.item.ModItems;
import org.jetbrains.annotations.Nullable;
import net.minecraft.enchantment.EnchantmentHelper;

public class ScorchingSkeletonEntity extends HostileEntity {
    public ScorchingSkeletonEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private int walkAnimationTimeout = 0;
    private int attackAnimationTimeout = 0;

    public static DefaultAttributeContainer.Builder createMobAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 18.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.3)
                .add(EntityAttributes.ATTACK_DAMAGE, 8)
                .add(EntityAttributes.FOLLOW_RANGE, 32.0); // updated range!
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.2D, true)); // faster movement
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 12.0F));
        this.goalSelector.add(3, new WanderAroundGoal(this, 1D));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.goalSelector.add(2, new ChasePlayerGoal(this));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }


    protected void initDataTracker() {}

    @Override
    public void tick() {
        super.tick();

        if (!this.getWorld().isClient()) {
            LivingEntity target = this.getTarget();
            if (target != null) {
                this.getNavigation().startMovingTo(target.getX(), target.getY(), target.getZ(), 1.3D);
            }
        }


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


    public EntityDimensions getDefaultDimensions() {
        return EntityDimensions.fixed(1.85F, 0.75F);
    }

    protected void dropLoot(ServerWorld world, DamageSource source, boolean causedByPlayer) {
        if (causedByPlayer) {


            if (this.random.nextInt(2) == 0) {
                this.dropItem(world, Items.BLAZE_ROD);
            }

        }
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SKELETON_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SKELETON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SKELETON_DEATH;
    }

    public boolean tryAttack(ServerWorld world, Entity target) {
        boolean success = super.tryAttack(world, target);
        if (success && !this.getWorld().isClient()) {
            attackAnimationState.start(this.age);
        }
        return success;
    }
    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source); // call vanilla death logic (drops, removal, etc.)

        if (!this.getWorld().isClient) {
            // Play particle effect at the mob's position
            ((ServerWorld) this.getWorld()).spawnParticles(
                    ParticleTypes.FLAME,  // Replace with your custom particle or existing one
                    this.getX(),
                    this.getY() + this.getHeight() / 2.0,  // spawn around mid-height
                    this.getZ(),
                    50,      // count (number of particles)
                    0.5, 0.5, 0.5, 0.1  // x,y,z spread and speed
            );
        }
    }
    public void setAttackAnimationTimeout(int timeout) {
        this.attackAnimationTimeout = timeout;
    }

    public void setWalkAnimationTimeout(int timeout) {
        this.walkAnimationTimeout = timeout;
    }

    public int getAttackAnimationTimeout() {
        return attackAnimationTimeout;
    }

    public int getWalkAnimationTimeout() {
        return walkAnimationTimeout;
    }
}

