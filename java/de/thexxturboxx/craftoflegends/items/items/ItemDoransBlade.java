package de.thexxturboxx.craftoflegends.items.items;

import java.util.ArrayList;
import java.util.List;

import de.thexxturboxx.craftoflegends.api.ItemProperties;
import de.thexxturboxx.craftoflegends.api.PROPERTY;
import de.thexxturboxx.craftoflegends.items.InvItem;
import net.minecraft.item.Item;

public class ItemDoransBlade extends InvItem {
	
	@Override
	public String getName() {
		return "dorans_blade";
	}
	
	@Override
	public void registerRecipes() {
		
	}
	
	@Override
	public int getCost() {
		return 450;
	}
	
	@Override
	public List<Item> buildsFrom() {
		List<Item> bF = new ArrayList<Item>();
		return bF;
	}
	
	@Override
	public ItemProperties getEffects() {
		return new ItemProperties().
				setProperty(PROPERTY.ATTACK_DAMAGE, 8).
				setProperty(PROPERTY.HEALTH, 80).
				setProperty(PROPERTY.LIFE_STEAL, 3);
	}
}
