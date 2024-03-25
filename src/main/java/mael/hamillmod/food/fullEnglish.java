package mael.hamillmod.food;

import mael.hamillmod.HamillMod;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class fullEnglish extends ItemFood {
	public fullEnglish(String name, int id, int j){
		super(name, id, j, true);
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityPlayer) {
		super.onItemRightClick(itemstack, world, entityPlayer);
		return new ItemStack(HamillMod.plate);
	}
}
