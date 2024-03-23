package mael.hamillmod;

import net.minecraft.core.block.Block;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static mael.hamillmod.HamillMod.*;

public class furnaceRecipes implements RecipeEntrypoint { //RecipeEntryPoint is to make making recipes faster
	public void onRecipesReady() { // all the furnace recipes feel free to copy what I did it's very intuitive
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(rawBeef)
			.create("cookSteak", (steak).getDefaultStack());

		RecipeBuilder.Furnace(MOD_ID)
			.setInput(rawChicken)
			.create("cookChicken", (roastedChicken).getDefaultStack());

		RecipeBuilder.Furnace(MOD_ID)
			.setInput(rawMutton)
			.create("cookMutton", (roastedLamb).getDefaultStack());

		RecipeBuilder.Furnace(MOD_ID)
			.setInput(rawPork)
				.create("cookPork", (roastedPorkchop).getDefaultStack());

		RecipeBuilder.BlastFurnace(MOD_ID)
			.setInput(rawBeef)
			.create("blastASteak", (steak).getDefaultStack());

		RecipeBuilder.BlastFurnace(MOD_ID)
			.setInput(rawChicken)
			.create("blastAChicken", (roastedChicken).getDefaultStack());

		RecipeBuilder.BlastFurnace(MOD_ID)
			.setInput(rawMutton)
			.create("blastSomeMutton", (roastedLamb).getDefaultStack());

		RecipeBuilder.BlastFurnace(MOD_ID)
			.setInput(rawPork)
			.create("blastPorkchop", (roastedPorkchop).getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AM", "BB", "W")
			.addInput('A', Item.bucketWater)
			.addInput('M', Block.mushroomBrown)
			.addInput('B', HamillMod.steak)
			.addInput('W', Item.bowl)
			.setConsumeContainer(false)
			.create("beefBourguignon", beefBourguignon.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AU", "W")
			.addInput('A', Item.bucketWater)
			.addInput('U', roastedLamb)
			.addInput('W', Item.bowl)
			.setConsumeContainer(false)
			.create("irishStew", irishStew.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("PG", "W")
			.addInput('P', roastedChicken)
			.addInput('G', Item.seedsPumpkin)
			.addInput('W', Item.bowl)
			.setConsumeContainer(false)
			.create("tikkaMassala", tikkaMassala.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("Q Q"," Q " )
			.addInput('Q', Item.quartz)
			.create("plate", plate.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("PCB", " L ")
			.addInput('P', roastedPorkchop)
			.addInput('C', Item.cherry)
			.addInput('B', Item.foodBread)
			.addInput('L', plate)
			.setConsumeContainer(false)
			.create("fullEnglishBreakfast", fullEnglish.getDefaultStack());
	}
}


