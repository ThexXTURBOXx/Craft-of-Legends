package de.thexxturboxx.craftoflegends.items.items;

import java.util.ArrayList;
import java.util.List;

import de.thexxturboxx.craftoflegends.api.ItemProperties;
import de.thexxturboxx.craftoflegends.api.PROPERTY;
import de.thexxturboxx.craftoflegends.items.InvItem;
import net.minecraft.item.Item;

public class ItemBannerCmd extends InvItem {
	
	@Override
	public String getName() {
		return "banner_command";
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
				setProperty(PROPERTY.HEALTH, 200).
				setProperty(PROPERTY.HEALTH_REGEN, 100).
				setProperty(PROPERTY.ABILITY_POWER, 60).
				setProperty(PROPERTY.MAGIC_RESIST, 20).
				setProperty(PROPERTY.COOLDOWN, 10);
	}
}
