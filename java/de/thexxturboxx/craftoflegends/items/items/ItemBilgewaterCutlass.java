package de.thexxturboxx.craftoflegends.items.items;

import java.util.ArrayList;
import java.util.List;

import de.thexxturboxx.craftoflegends.api.ItemProperties;
import de.thexxturboxx.craftoflegends.api.PROPERTY;
import de.thexxturboxx.craftoflegends.items.InvItem;
import net.minecraft.item.Item;

public class ItemBilgewaterCutlass extends InvItem {
	
	@Override
	public String getName() {
		return "bilgewater_cutlass";
	}
	
	@Override
	public void registerRecipes() {
		
	}
	
	@Override
	public int getCost() {
		return 1650;
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
				setProperty(PROPERTY.ATTACK_DAMAGE, 25).
				setProperty(PROPERTY.LIFE_STEAL, 10);
	}
}