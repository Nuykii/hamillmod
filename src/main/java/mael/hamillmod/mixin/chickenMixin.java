package mael.hamillmod.mixin;

import mael.hamillmod.HamillMod;
import net.minecraft.core.entity.animal.EntityAnimal;
import net.minecraft.core.world.World;
import net.minecraft.core.entity.animal.EntityChicken;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = EntityChicken.class, remap = false)
public class chickenMixin extends EntityAnimal {
	public chickenMixin(World world) {
		super(world);
	}

	@Inject(method = "getDropItemId", at = @At("HEAD"), cancellable = true)
	protected int getDropItemId(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(this.remainingFireTicks > 0 ? HamillMod.roastedChicken.id: HamillMod.rawChicken.id);
		return this.remainingFireTicks > 0 ? HamillMod.roastedChicken.id : HamillMod.rawChicken.id;
	}
}
