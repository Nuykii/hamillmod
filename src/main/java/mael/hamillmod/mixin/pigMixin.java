package mael.hamillmod.mixin;

import mael.hamillmod.HamillMod;
import net.minecraft.core.entity.animal.EntityAnimal;
import net.minecraft.core.entity.animal.EntityPig;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = EntityPig.class, remap = false)
public class pigMixin extends EntityAnimal {
	public pigMixin(World world) {
		super(world);
	}

	@Inject(method = "getDropItemId", at = @At("HEAD"), cancellable = true)
	protected int getDropItemId(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(this.remainingFireTicks > 0 ? HamillMod.roastedPorkchop.id: HamillMod.rawPork.id);
		return this.remainingFireTicks > 0 ? HamillMod.roastedPorkchop.id : HamillMod.rawPork.id;
	}
}
