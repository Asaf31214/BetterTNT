package org.siverek.bettertnt.block;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;



public class EnhancedTNTEntity extends TntEntity {

    public EnhancedTNTEntity(EntityType<? extends TntEntity> entityType, World world) {
        super(entityType, world);
    }

    public EnhancedTNTEntity(World world, double x, double y, double z, @Nullable LivingEntity igniter) {
        super(world, x, y, z, igniter);
    }

    @Override
    public void tick() {
        super.tick(); // Call the parent tick method
        if (this.getFuse() <= 0) {
            this.discard();
            if (!this.getWorld().isClient) {
                customExplode();
            }
        }
    }

    // Custom explosion method with increased power
    private void customExplode() {
        float power = 36.0F;
        this.getWorld().createExplosion(this, Explosion.createDamageSource(this.getWorld(), this),
                null,
                this.getX(), this.getY(), this.getZ(),
                power, false, World.ExplosionSourceType.TNT);
    }
}
