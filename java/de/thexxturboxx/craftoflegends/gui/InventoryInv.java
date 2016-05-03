package de.thexxturboxx.craftoflegends.gui;

import de.thexxturboxx.craftoflegends.api.DataManager;
import de.thexxturboxx.craftoflegends.items.InvItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;

public class InventoryInv implements IInventory {
	
	EntityPlayer player;
	ItemStack[] stackList;
	
	public InventoryInv(EntityPlayer player) {
		stackList = new ItemStack[6];
		this.player = player;
	}
	
	@Override
	public String getName() {
		return "COLInventory";
	}
	
	@Override
	public boolean hasCustomName() {
		return false;
	}
	
	@Override
	public ITextComponent getDisplayName() {
		return null;
	}
	
	@Override
	public int getSizeInventory() {
		return stackList.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int index) {
		return index >= getSizeInventory() ? null : stackList[index];
	}
	
	@Override
	public ItemStack decrStackSize(int index, int count) {
		if(stackList[index] != null) {
			
			ItemStack itemstack;
			
			if(stackList[index].stackSize <= count) {
				itemstack = stackList[index];
				stackList[index] = null;
				return itemstack;
			} else {
				itemstack = stackList[index].splitStack(count);
				
				if(stackList[index].stackSize == 0) {
					stackList[index] = null;
				}
				
				return itemstack;
			}
		} else {
			return null;
		}
	}
	
	@Override
	public ItemStack removeStackFromSlot(int index) {
		if(stackList[index] != null) {
			ItemStack itemstack = stackList[index];
			stackList[index] = null;
			return itemstack;
		} else {
			return null;
		}
	}
	
	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		InvItem i = (InvItem) stack.getItem();
		DataManager.setItem(player.getUniqueID().toString(), index + 1, i);
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 1;
	}
	
	@Override
	public void markDirty() {
		player.inventory.markDirty();
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.player.isDead ? false : player.getDistanceSqToEntity(this.player) <= 64.0D;
	}
	
	@Override
	public void openInventory(EntityPlayer player) {
		
	}
	
	@Override
	public void closeInventory(EntityPlayer player) {
		
	}
	
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if(stack == null || !(stack.getItem() instanceof InvItem)) return false;
		return true;
	}
	
	@Override
	public int getField(int id) {
		return 0;
	}
	
	@Override
	public void setField(int id, int value) {
		
	}
	
	@Override
	public int getFieldCount() {
		return 0;
	}
	
	@Override
	public void clear() {
		for(int i = 0; i < stackList.length; i++) {
			stackList[i] = null;
		}
	}
	
}
