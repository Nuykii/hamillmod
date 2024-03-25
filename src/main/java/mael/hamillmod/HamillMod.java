package mael.hamillmod;

import mael.hamillmod.blocks.simpleFoodsBlocks;
import mael.hamillmod.food.fullEnglish;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.block.*;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFoodStackable;
import net.minecraft.core.item.ItemSeeds;
import net.minecraft.core.item.ItemSoup;
import net.minecraft.core.block.BlockCropsWheat;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.ItemHelper;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.Properties;


public class HamillMod implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
	public static final String MOD_ID = "hamillmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	static{ //this just uses UtilIdRegistrar for Ids
			Properties prop = new Properties();
			prop.setProperty("startingBlockId","10000");
			prop.setProperty("startingItemId","19000");
			ConfigHandler config = new ConfigHandler(MOD_ID,prop);
			config.updateConfig();
			UtilIdRegistrar.initIds(config.getInt("startingBlockId"), config.getInt("startingItemId"));
	}

	public static Item rawBeef = ItemHelper.createItem(MOD_ID, new ItemFoodStackable("food.rawBeef", UtilIdRegistrar.nextIdItem(), 2, true, 16), "rawBeef.png");
	public static Item rawChicken = ItemHelper.createItem(MOD_ID, new ItemFoodStackable("food.rawChicken", UtilIdRegistrar.nextIdItem(), 1, true, 16), "rawChicken.png");
	public static Item rawPork = ItemHelper.createItem(MOD_ID, new ItemFoodStackable("food.rawPork", UtilIdRegistrar.nextIdItem(), 2, true, 16), "rawPork.png");
	public static Item rawMutton = ItemHelper.createItem(MOD_ID, new ItemFoodStackable("food.rawMutton", UtilIdRegistrar.nextIdItem(), 2, true, 16), "rawMutton.png");
	public static Item steak = ItemHelper.createItem(MOD_ID, new ItemFoodStackable("food.steak", UtilIdRegistrar.nextIdItem(), 8, true, 16), "steak.png");
	public static Item roastedLamb = ItemHelper.createItem(MOD_ID, new ItemFoodStackable("food.roastedLamb", UtilIdRegistrar.nextIdItem(), 5, true, 16), "roastedLamb.png");
	public static Item roastedChicken = ItemHelper.createItem(MOD_ID, new ItemFoodStackable("food.roastedChicken", UtilIdRegistrar.nextIdItem(), 6, true, 16), "roastedChicken.png");
	public static Item roastedPorkchop = ItemHelper.createItem(MOD_ID, new ItemFoodStackable("food.roastedPorkchop", UtilIdRegistrar.nextIdItem(), 6, true, 16), "roastedPorkchop.png");
	public static ItemSoup beefBourguignon = (ItemSoup) ItemHelper.createItem(MOD_ID, new ItemSoup("food.beefBourguignon", UtilIdRegistrar.nextIdItem(), 10), "beefBourguignon.png" );
	public static ItemSoup irishStew = (ItemSoup) ItemHelper.createItem(MOD_ID, new ItemSoup("food.irishStew", UtilIdRegistrar.nextIdItem(), 8), "irishStew.png"); // Michael I miss you so much
	public static ItemSoup tikkaMassala = (ItemSoup) ItemHelper.createItem(MOD_ID, new ItemSoup("food.tikkaMassala", UtilIdRegistrar.nextIdItem(), 7), "tikkaMassala.png");
	public static Item fullEnglish = ItemHelper.createItem(MOD_ID, new fullEnglish("food.fullEnglish", UtilIdRegistrar.nextIdItem(), 15), "fullEnglish.png");
	public static Item melonSlice = ItemHelper.createItem(MOD_ID, new ItemFoodStackable("food.melonSlice", UtilIdRegistrar.nextIdItem(), 3, false, 64), "melonSlice.png");

	// food utensils start here
	public static Item plate = ItemHelper.createItem(MOD_ID, new Item("plate", UtilIdRegistrar.nextIdItem()), "plate.png");

	@Override
	public void onInitialize() {
		LOGGER.info("HamillMod successfully loaded.");
	}

	@Override
	public void beforeGameStart() {
		new simpleFoodsBlocks().makeNewBlocks();
	}

	public void onRecipesReady() {
	}

	@Override
	public void afterGameStart() {
		LOGGER.info("Bon appétit! :D");
	}
}
