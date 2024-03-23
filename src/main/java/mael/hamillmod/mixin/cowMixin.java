package mael.hamillmod.mixin;

import mael.hamillmod.HamillMod;
import net.minecraft.core.entity.animal.EntityAnimal;
import net.minecraft.core.entity.animal.EntityCow;
import net.minecraft.core.item.Item;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = EntityCow.class, remap = false)
public class cowMixin extends EntityAnimal {
	public cowMixin(World world) {
		super(world);
	}

	@Inject(method = "getDropItemId", at = @At("HEAD"), cancellable = true)
	protected int getDropItemId(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(this.remainingFireTicks > 0 ? HamillMod.steak.id : HamillMod.rawBeef.id);
		return this.remainingFireTicks > 0 ? HamillMod.steak.id : HamillMod.rawBeef.id;
	}

	@Override
	public void dropFewItems() {
		int amount = random.nextInt(3) + 1;
		for (int i = 0; i < amount; i++)
			spawnAtLocation(Item.leather.id, 1, 0f);
		super.dropFewItems();
		}

	}

// I don't give a FUCK what you think I'm keeping this the droprates are great for my purposes fuck you FUCK YOU FUCK YOUUUUUUU
