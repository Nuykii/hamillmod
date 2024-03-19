package mael.hamillmod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFoodStackable;
import org.lwjgl.openal.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.ItemHelper;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;
import mael.hamillmod.furnaceRecipes;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.Properties;


public class HamillMod implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
	public static final String MOD_ID = "hamillmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	static{ //this just uses the UtilIdRegistrar for Ids
			Properties prop = new Properties();
			prop.setProperty("startingBlockId","10000");
			prop.setProperty("startingItemId","19000");
			ConfigHandler config = new ConfigHandler(MOD_ID,prop);
			config.updateConfig();
			UtilIdRegistrar.initIds(config.getInt("startingBlockId"), config.getInt("startingItemId"));
	}
	public static Item rawBeef = ItemHelper.createItem(MOD_ID, new ItemFoodStackable("food.rawBeef", UtilIdRegistrar.nextIdItem(), 2, true, 16), "rawbeef.png");
	public static Item rawChicken = ItemHelper.createItem(MOD_ID, new ItemFoodStackable("food.rawChicken", UtilIdRegistrar.nextIdItem(), 2, true, 16), "rawchicken.png");
	public static Item rawMutton = ItemHelper.createItem(MOD_ID, new ItemFoodStackable("food.rawMutton", UtilIdRegistrar.nextIdItem(), 2, true, 16), "rawmutton.png");
	public static Item steak = ItemHelper.createItem(MOD_ID, new ItemFoodStackable("food.steak", UtilIdRegistrar.nextIdItem(), 8, true, 16), "steak.png");
	public static Item roastedLamb = ItemHelper.createItem(MOD_ID, new ItemFoodStackable("food.roastedLamb", UtilIdRegistrar.nextIdItem(), 6, true, 16), "roastedLamb.png");
	public static Item roastedChicken = ItemHelper.createItem(MOD_ID, new ItemFoodStackable("food.roastedChicken", UtilIdRegistrar.nextIdItem(), 6, true, 16), "roastedChicken.png");


	@Override
	public void onInitialize() {
		LOGGER.info("HamillMod succesfully loaded.");
	}

	@Override
	public void beforeGameStart() {

	}

	public void onRecipesReady() {
	}

	@Override
	public void afterGameStart() {
		LOGGER.info("Bon appétit! :D");
	}
}
