package de.thexxturboxx.craftoflegends.items.items;

import java.util.ArrayList;
import java.util.List;

import de.thexxturboxx.craftoflegends.api.ItemProperties;
import de.thexxturboxx.craftoflegends.api.PROPERTY;
import de.thexxturboxx.craftoflegends.items.InvItem;
import net.minecraft.item.Item;

public class ItemAthene extends InvItem {
	
	@Override
	public String getName() {
		return "athene_grail";
	}
	
	@Override
	public void registerRecipes() {
		
	}
	
	@Override
	public int getCost() {
		return 2700;
	}
	
	@Override
	public List<Item> buildsFrom() {
		List<Item> bF = new ArrayList<Item>();
		return bF;
	}
	
	@Override
	public ItemProperties getEffects() {
		return new ItemProperties().
				setProperty(PROPERTY.ABILITY_POWER, 60).
				setProperty(PROPERTY.MAGIC_RESIST, 25).
				setProperty(PROPERTY.COOLDOWN, 20).
				setProperty(PROPERTY.MANA_REGEN, 100);
	}
}
