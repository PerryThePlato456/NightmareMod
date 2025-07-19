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
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.perrytheplato.nightmare.ChasePlayerGoal;
import net.perrytheplato.nightmare.entity.client.TreantAnimations;
import net.perrytheplato.nightmare.item.ModItems;

public class MiniNocturnoEntity extends HostileEntity {
    public MiniNocturnoEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();

    private int idleAnimationTimeout = 0;
    private int walkAnimationTimeout = 0;


    public static final AnimationDefinition IDLE = TreantAnimations.IDLE;
    public static final AnimationDefinition WALK = TreantAnimations.WALK;


    public static DefaultAttributeContainer.Builder createMobAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 1)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.5)
                .add(EntityAttributes.ATTACK_DAMAGE, 3 )
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

        if (this.getWorld().isClient()) {
            // 🧪 FORCED animation trigger — remove after testing


            LivingEntity target = this.getTarget();
            if (target != null) {
                this.getNavigation().startMovingTo(target.getX(), target.getY(), target.getZ(), 1.3D);
            }

            this.setupAnimationStates();
        }
    }


    private void setupAnimationStates() {


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


            // 1 in 100 chance to drop 1 oak plank
            if (this.random.nextInt(5) == 0) {
                this.dropItem(world, Items.EXPERIENCE_BOTTLE);
            }

            if (this.random.nextInt(15) == 0) {
                this.dropItem(world, ModItems.NOCTURNO_HEART_SCRAP);
            }

            if (this.random.nextInt(300) == 0) {
                this.dropItem(world, ModItems.NIGHTMARE_SMITHING_TEMPLATE);
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_WITHER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_ENDERMAN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_BOGGED_DEATH;
    }


    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source); // call vanilla death logic (drops, removal, etc.)

        if (!this.getWorld().isClient) {
            // Play particle effect at the mob's position
            ((ServerWorld) this.getWorld()).spawnParticles(
                    ParticleTypes.BUBBLE,  // Replace with your custom particle or existing one
                    this.getX(),
                    this.getY() + this.getHeight() / 2.0,  // spawn around mid-height
                    this.getZ(),
                    50,      // count (number of particles)
                    0.5, 0.5, 0.5, 0.1  // x,y,z spread and speed
            );
        }
    }




}



