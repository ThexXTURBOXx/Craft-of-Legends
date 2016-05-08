package de.thexxturboxx.craftoflegends.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public abstract class ItemBase extends Item implements ICOLItem {
	
	public ItemBase() {
		setMaxStackSize(1);
	}
	
	public NBTTagCompound getCompound(ItemStack stack) {
		NBTTagCompound compound = stack.getTagCompound();
		if(compound == null) {
			compound = new NBTTagCompound();
			stack.setTagCompound(compound);
		}
		return compound;
	}
	
}
