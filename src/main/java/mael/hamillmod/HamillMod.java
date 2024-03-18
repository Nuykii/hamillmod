package mael.hamillmod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.render.block.model.BlockModelRenderBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockTorch;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.block.ItemBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.ItemHelper;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;


public class HamillMod implements ModInitializer, GameStartEntrypoint {
	public static final String MOD_ID = "hamillmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static BlockBuilder Diorite = new BlockBuilder(MOD_ID) // uses blockbuilder to assign the string Diorite a block
		.setHardness(0.7f); // Sets the hardness which affects the time to mine the blocks
	public static BlockBuilder Andesite = new BlockBuilder(MOD_ID) // same as diorite
		.setHardness(0.8f);
	public static Block customBlockItem;
	@Override
	public void onInitialize() {
		LOGGER.info("HamillMod succesfully launched.");
	}

	@Override
	static void beforeGameStart() {
		// This is to make sure block IDs don't conflict with each other and with other potential mods.
		int startingBlockId = 2000;
		int startingItemId = 17000;

		// Creates the block Diorite which uses the stone material and is mineable by pickaxe
		customBlockItem = Diorite
			.setTextures("diorite.png")
			.setTags(BlockTags.MINEABLE_BY_PICKAXE)// Makes the block drop itself when mined by a pickaxe
			.build(new Block("diorite", startingBlockId++, Material.stone));

		customBlockItem = Andesite
			.setTextures(8,1) // top of a grass block lmao
			.setTags(BlockTags.MINEABLE_BY_PICKAXE)
			.build(new Block("andesite", startingBlockId++, Material.stone));



	//I will try to implement a food item
		// this works but is dissimilar to what Lukei made, he started the function with public static

	final Item uncookedSteak = ItemHelper.createItem(MOD_ID, new ItemFood("food.uncookedSteak", startingItemId++, 2, true), "uncookedsteak.png");

		// renderType ids, the vanilla game uses id numbers to specify the model a block should render with
		// type	| Model
		// 	0	|	Standard Block
		//	1	|	Cross block (like flowers and sugarcane)
		//	2	|	Torch
		//	3	|	Fire
		//	4	|	Fluids
		//	5	|	Redstone wire
		//	6	|	Crops (like wheat)
		//	7	|	Door Block
		//	8	|	Ladder
		//	9	|	Minecart Rail
		//	10	|	Stairs
		//	11	|	Fence
		//	12	|	Lever
		//	13	|	Cactus??
		//	14	|	Block Bed
		//	15	|	Redstone repeater
		//	16	|	Piston Base
		//	17	|	Piston Head
		//	18	|	Fence Gate
		//	19	|	Spikes
		//	20	|	Standard Block again (might do something special but is currently not used by anything)
		//	21	|	Mossy Stone
		//	22	|	Legacy Painted Chest model (unused as of 7.1)
		//	23	|	Flowering Cherry Leaves
		//	24	|	Algae
		//	25	|	Candle (For the currently implemented soulwax candle)
		//	26	|	Firefly lanterns
		//	27	|	Axis aligned (Used by logs and the marble pillar etc)
		//	28	|	Basket
		//	29	|	Pebbles
		//	30	|	Trapdoors
		//	31	|	Chainlink Fence
		//	32	|	Crops Pumpkin
		//	33	|	Cacao Leaves
		//	34	|	Flower Jar (rendering is split between the block and the tile entity)
		//	35	|	Seat


		// everytime you set parameters on the blockbuilder it returns a new blockbuilder object, this prevents later modifications to the builder from
		// modifying the block builder template that you previously made

	}

	@Override
	public void afterGameStart() {

	}
}
