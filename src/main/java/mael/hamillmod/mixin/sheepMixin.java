package mael.hamillmod.mixin;

import mael.hamillmod.HamillMod;
import net.minecraft.core.entity.animal.EntityAnimal;
import net.minecraft.core.entity.animal.EntitySheep;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = EntitySheep.class, remap = false)
public class sheepMixin extends EntityAnimal {
	public sheepMixin(World world) {
		super(world);
	}

	@Inject(method = "dropFewItems", at = @At("HEAD")) // dropFewItems is EntitySheep specific for some fuckin reason which means for now the chicken don't drop anything other than meat
	protected void dropFewItems(CallbackInfo si) {
		int muttonId = this.remainingFireTicks > 0 ? HamillMod.roastedLamb.id : HamillMod.rawMutton.id;
		if (muttonId > 0) {
			this.spawnAtLocation(muttonId, 1);
		}
	}
}
