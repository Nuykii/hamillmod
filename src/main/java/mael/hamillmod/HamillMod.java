package mael.hamillmod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFood;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.ItemHelper;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;

import java.util.Properties;


public class HamillMod implements ModInitializer, GameStartEntrypoint {
	public static final String MOD_ID = "hamillmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static ItemHelper rawBeef;
	public static ItemHelper rawChicken; // this does nothing. I'm keeping it around in case there's something to do with making food cookable. Will know later.
	public static ItemHelper rawMutton;

	private void handleConfig() {
		Properties prop = new Properties();
		prop.setProperty("startingBlockId","10000");
		prop.setProperty("startingItemId","19000");
		ConfigHandler config = new ConfigHandler(MOD_ID,prop);
		config.updateConfig();
		UtilIdRegistrar.initIds(config.getInt("startingBlockId"), config.getInt("startingItemId"));
	}
	/* The function above pulls the startingIds from the .cfg
	* it then updates it with the numbers it gets from UtilIdRegistrar. */

	@Override
	public void onInitialize() {
		handleConfig();
		LOGGER.info("HamillMod succesfully loaded.");
	}

	@Override
	public void beforeGameStart() {
	final Item rawBeef = ItemHelper.createItem(MOD_ID, new ItemFood("food.rawBeef", UtilIdRegistrar.nextIdItem(), 2, true), "rawbeef.png");

	final Item rawChicken = ItemHelper.createItem(MOD_ID, new ItemFood("food.rawChicken", UtilIdRegistrar.nextIdItem(), 2, true), "rawchicken.png");

	final Item rawMutton = ItemHelper.createItem(MOD_ID, new ItemFood("food.rawMutton", UtilIdRegistrar.nextIdItem(), 2, true), "rawmutton.png");

	}

	@Override
	public void afterGameStart() {
		LOGGER.info("Bon appétit! :D");
	}
}
