package mael.hamillmod.mixin;

import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.entity.animal.EntityChicken;
import net.minecraft.core.item.Item;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = EntityChicken.class, remap = false)
public abstract class getFeatherItemId extends EntityLiving {
	public getFeatherItemId(World world) {
		super(world);
	}
	@Shadow
	protected abstract int getDropItemId();
	@Override
	public void dropFewItems() {
		int amount = random.nextInt(1) + 1;
		for (int i = 0; i < amount; i++)
			spawnAtLocation(Item.featherChicken.id, 1, 0f);
		super.dropFewItems();
	}
}
