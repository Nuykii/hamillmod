package mael.hamillmod;

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
	}
}


