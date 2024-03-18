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
		return currItemId++;
	}

	public static int nextIdBlock() {
		throwException(currBlockId);
		return currBlockId++;
	}

	private static void throwException(int id){
		if (usedIds[id]) { // If id is already used then throw exception
			throw new RuntimeException("Tried to use id: " + id + " while its already being used by " + Item.itemsList[id].getKey() + "!");
		}
		else {
			usedIds[id] = true;
		}
	} }
