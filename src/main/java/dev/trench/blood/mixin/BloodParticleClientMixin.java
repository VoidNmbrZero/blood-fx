package dev.trench.blood.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class BloodParticleClientMixin extends Entity {
	public BloodParticleClientMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	@Inject(at = @At("TAIL"), method = "onDamaged")
	private void init(DamageSource damageSource, CallbackInfo info) {
		if (((Object)this) instanceof PlayerEntity) {
			for (int i = 0; i < 48; ++i) {
				double px, py, pz;
				px = this.getX() + ((float) random.nextBetween(-3, 3) / 10);
				py = this.getY() + (this.getHeight() / 1.5F) + ((float) random.nextBetween(-3, 3) / 10);
				pz = this.getZ() + ((float) random.nextBetween(-3, 3) / 10);
				getWorld().addParticle(
						new BlockStateParticleEffect(ParticleTypes.BLOCK, Blocks.REDSTONE_BLOCK.getDefaultState()),
						px, py, pz,
						0, 0, 0
				);
			}
		}
	}
}