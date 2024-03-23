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
		cir.setReturnValue(this.remainingFireTicks > 0 ? HamillMod.roastedPorkchop.id : HamillMod.rawPork.id);
		return this.remainingFireTicks > 0 ? HamillMod.roastedPorkchop.id : HamillMod.rawPork.id;
	}

	@Override
	public int getDropItemId() {
		float drop = this.world.rand.nextFloat();
		if (drop < 0.5F) {
			return 0;
		} else if (drop < 0.95F) {
			return this.isOnFire() ? HamillMod.roastedPorkchop.id : HamillMod.rawPork.id;
		} else {
			return this.isOnFire() ? HamillMod.roastedPorkchop.id : HamillMod.rawPork.id;
		}
	}
}
/* Combining the two blocks above is the only way I found to have satisfactory droprates AND to have cooked food when a burning pork dies
* there is voodoo happening in this code and I suggest all users to say a prayer of Exorcism before touching this
* God help me
* */
