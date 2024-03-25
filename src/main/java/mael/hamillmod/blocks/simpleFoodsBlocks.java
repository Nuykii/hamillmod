package mael.hamillmod.blocks;

import mael.hamillmod.HamillMod;
import mael.hamillmod.UtilIdRegistrar;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.util.ConfigHandler;

import java.util.Properties;


public class simpleFoodsBlocks {
	public static final String MOD_ID = HamillMod.MOD_ID;

	static{ //this just uses UtilIdRegistrar for Ids
		Properties prop = new Properties();
		prop.setProperty("startingBlockId","10000");
		prop.setProperty("startingItemId","19000");
		ConfigHandler config = new ConfigHandler(MOD_ID,prop);
		config.updateConfig();
		UtilIdRegistrar.initIds(config.getInt("startingBlockId"), config.getInt("startingItemId"));
	}
	public static Block blockMelon;

	public void makeNewBlocks() {
		BlockBuilder melonBuilder = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.WOOD)
			.setResistance(0.8F)
			.setHardness(0.8F)
			.setTags(BlockTags.MINEABLE_BY_HOE);

		blockMelon = melonBuilder
			.setSideTextures(MOD_ID, "melonSide.png")
			.setBottomTexture(MOD_ID, "melonSide.png")
			.setTopTexture(MOD_ID, "melonTop.png")
			.build(new blockMelon("block.blockMelon", UtilIdRegistrar.nextIdBlock()));
	}
}
