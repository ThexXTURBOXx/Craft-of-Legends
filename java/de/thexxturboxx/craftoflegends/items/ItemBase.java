package de.thexxturboxx.craftoflegends.items;

import net.minecraft.item.Item;

public abstract class ItemBase extends Item implements ICOLItem {
	
	public ItemBase() {
		setMaxStackSize(1);
	}
	
}
