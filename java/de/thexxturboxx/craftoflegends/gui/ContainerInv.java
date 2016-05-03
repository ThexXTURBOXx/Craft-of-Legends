package de.thexxturboxx.craftoflegends.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerInv extends Container {

    public ContainerInv (InventoryPlayer inventoryPlayer){
    	for (int i = 0; i < 2; i++) {
    		for (int j = 0; j < 3; j++) {
    			addSlotToContainer(new Slot(new InventoryInv(inventoryPlayer.player), j + i * 3, 62 + j * 18, 17 + i * 18));
    		}
    	}
    	bindPlayerInventory(inventoryPlayer);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
    	return true;
    }
    
    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
    	for (int i = 0; i < 3; i++) {
    		for (int j = 0; j < 9; j++) {
    			addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
    					8 + j * 18, 84 + i * 18));
    		}
    	}
    	
    	for (int i = 0; i < 9; i++) {
    		addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
    	}
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
    	ItemStack stack = null;
    	Slot slotObject = inventorySlots.get(slot);
    	if (slotObject != null && slotObject.getHasStack()) {
    		ItemStack stackInSlot = slotObject.getStack();
    		stack = stackInSlot.copy();
    		
    		if (stackInSlot.stackSize == 0) {
    			slotObject.putStack(null);
    		} else {
    			slotObject.onSlotChanged();
    		}
    		
    		if (stackInSlot.stackSize == stack.stackSize) {
    			return null;
    		}
    		slotObject.onPickupFromSlot(player, stackInSlot);
    	}
    	return stack;
    }
	
}