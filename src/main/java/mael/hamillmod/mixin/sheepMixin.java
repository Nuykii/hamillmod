package mael.hamillmod.mixin;

import mael.hamillmod.HamillMod;
import net.minecraft.core.block.Block;
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

	@Inject(method = "dropFewItems", at = @At("HEAD"))
	protected void dropFewItems(CallbackInfo si) {
		int muttonId = this.remainingFireTicks > 0 ? HamillMod.roastedLamb.id : HamillMod.rawMutton.id;
		int meat = random.nextInt(2) + 1;
		for (int i = 0; i < meat; i++) {
			this.spawnAtLocation(muttonId, 1);
		}
	}
	@Override
	public void dropFewItems() {
		int amount = random.nextInt(2) + 1;
		for (int i = 0; i < amount; i++)
			spawnAtLocation(Block.wool.id, 1, 0f);
		super.dropFewItems();
	}
}
