package de.thexxturboxx.craftoflegends.items.items;

import java.util.ArrayList;
import java.util.List;

import de.thexxturboxx.craftoflegends.api.ItemProperties;
import de.thexxturboxx.craftoflegends.api.PROPERTY;
import de.thexxturboxx.craftoflegends.items.InvItem;
import net.minecraft.item.Item;

public class ItemArdentCenser extends InvItem {
	
	@Override
	public String getName() {
		return "ardent_censer";
	}
	
	@Override
	public void registerRecipes() {
		
	}
	
	@Override
	public int getCost() {
		return 2200;
	}
	
	@Override
	public List<Item> buildsFrom() {
		List<Item> bF = new ArrayList<Item>();
		//bF.add(Blasting Wand);
		//bF.add(Negatron Cloak);
		return bF;
	}
	
	@Override
	public ItemProperties getEffects() {
		return new ItemProperties().
				setProperty(PROPERTY.ABILITY_POWER, 40).
				setProperty(PROPERTY.COOLDOWN, 10).
				setProperty(PROPERTY.MANA_REGEN, 100);
	}
}
