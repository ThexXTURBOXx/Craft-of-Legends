package de.thexxturboxx.craftoflegends.items;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public interface ICOLItem {
	
	public String getName();
	
	public void registerRecipes();
	
	public default NBTTagCompound getCompound(ItemStack stack) {
		NBTTagCompound compound = stack.getTagCompound();
		if(compound == null) {
			compound = new NBTTagCompound();
			stack.setTagCompound(compound);
		}
		return compound;
	}
	
}
