package de.thexxturboxx.craftoflegends.items.items;

import java.util.ArrayList;
import java.util.List;

import de.thexxturboxx.craftoflegends.api.ItemProperties;
import de.thexxturboxx.craftoflegends.api.PROPERTY;
import de.thexxturboxx.craftoflegends.items.InvItem;
import net.minecraft.item.Item;

public class ItemAbyssalScepter extends InvItem {
	
	@Override
	public String getName() {
		return "abyssal_scepter";
	}
	
	@Override
	public void registerRecipes() {
		
	}
	
	@Override
	public int getCost() {
		return 2350;
	}
	
	@Override
	public List<Item> buildsFrom() {
		List<Item> bF = new ArrayList<>();
		//bF.add(Blasting Wand);
		//bF.add(Negatron Cloak);
		return bF;
	}
	
	@Override
	public ItemProperties getEffects() {
		return new ItemProperties().
				setProperty(PROPERTY.ABILITY_POWER, 70).
				setProperty(PROPERTY.MAGIC_RESIST, 50);
	}
}