package de.thexxturboxx.craftoflegends.gui;

import de.thexxturboxx.craftoflegends.items.InvItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotInv extends Slot {
	
    public SlotInv(IInventory inv, int index, int x, int y) {
        super(inv, index, x, y);
    }
    
    @Override
    public boolean isItemValid(ItemStack stack) {
    	return stack != null && stack.getItem() != null && stack.getItem() instanceof InvItem;
    }
    
	@Override
	public boolean canTakeStack(EntityPlayer player) {
		return getStack() != null;
	}
	
	@Override
    public int getSlotStackLimit() {
        return 1;
    }
	
}