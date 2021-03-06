package de.thexxturboxx.craftoflegends.items.items;

import java.util.ArrayList;
import java.util.List;

import de.thexxturboxx.craftoflegends.api.ItemProperties;
import de.thexxturboxx.craftoflegends.api.PROPERTY;
import de.thexxturboxx.craftoflegends.items.InvItem;
import net.minecraft.item.Item;

public class ItemDeadMansPlate extends InvItem {
	
	@Override
	public String getName() {
		return "dead_mans_plate";
	}
	
	@Override
	public void registerRecipes() {
		
	}
	
	@Override
	public int getCost() {
		return 2900;
	}
	
	@Override
	public List<Item> buildsFrom() {
		List<Item> bF = new ArrayList<Item>();
		return bF;
	}
	
	@Override
	public ItemProperties getEffects() {
		return new ItemProperties().
				setProperty(PROPERTY.HEALTH, 500).
				setProperty(PROPERTY.ARMOR, 50);
	}
}
