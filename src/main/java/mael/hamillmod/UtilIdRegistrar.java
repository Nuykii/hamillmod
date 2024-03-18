package mael.hamillmod;

import net.minecraft.core.item.Item;

public class UtilIdRegistrar {
	private static int currItemId = 0;
	private static int currBlockId = 0;
	private static boolean[] usedIds;

	public static void initIds(int blockId, int itemId) {
		usedIds = new boolean[Item.itemsList.length];
		for (int i = 0; i < usedIds.length; i++){
			if (Item.itemsList[i] != null){
				usedIds[i] = true;
			}
		}
		currItemId = itemId;
		currBlockId = blockId;
	}

	public static int nextIdItem() {
		throwException(currItemId);
		return currItemId++; 			// returns the base ItemId used in the .cfg to something greater, to avoid the throwException to crash the game
	}

	public static int nextIdBlock() {
		throwException(currBlockId);
		return currBlockId++;
	}

	private static void throwException(int id){
		if (usedIds[id]) { // If id is already used then throw exception
			throw new RuntimeException("Tried to use id: " + id + " while its already being used by " + Item.itemsList[id].getKey() + "!"); // crashes the game if the ID is already in use by something else
		}
		else {
			usedIds[id] = true;
		}
	} }
