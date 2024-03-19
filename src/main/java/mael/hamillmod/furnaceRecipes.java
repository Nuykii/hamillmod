package mael.hamillmod;

import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static mael.hamillmod.HamillMod.*;

public class furnaceRecipes implements RecipeEntrypoint { //RecipeEntryPoint is to make making recipes faster
	public void onRecipesReady() {
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(rawBeef)
			.create("cookASteak", (steak).getDefaultStack());

		RecipeBuilder.Furnace(MOD_ID)
			.setInput(rawChicken)
			.create("cookSomeChicken", (roastedChicken).getDefaultStack());

		RecipeBuilder.Furnace(MOD_ID)
			.setInput(rawMutton)
			.create("cookMutton", (roastedLamb).getDefaultStack());

	}
}


