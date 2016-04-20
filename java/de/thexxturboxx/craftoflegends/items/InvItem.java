package de.thexxturboxx.craftoflegends.items;

import java.util.HashMap;
import java.util.List;

import de.thexxturboxx.craftoflegends.api.ItemProperties;
import de.thexxturboxx.craftoflegends.api.PROPERTY;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class InvItem extends ItemBase {
	
	/**@return The effects, which the item gives.
	 * Returns null, if there are none.*/
	public abstract ItemProperties getEffects();
	
	/**@return The amount of gold the item costs.*/
	public abstract int getCost();
	
	/**@return The items which is this item built from.
	 * Returns null, if there are none.*/
	public abstract List<Item> buildsFrom();
	
	/**Prints the effects of the item*/
	public void printEffects() {
		HashMap<PROPERTY, Integer> hm = getEffects().getMap();
		for(PROPERTY p : hm.keySet()) {
			System.out.println(p.name() + ": " + hm.get(p));
		}
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		if(getEffects() != null) {
			for(PROPERTY p : getEffects().getMap().keySet()) {
				tooltip.add(getEffectString(p, getEffects().getMap().get(p)));
			}			
		}
	}
	
	/**Returns the effect in the right way*/
	public String getEffectString(PROPERTY p, int v) {
		String s;
		switch(p) {
		case ABILITY_POWER: s =  "+ " + v + " $a"; break;
		case ARMOR: s =  "+ " + v + " $a"; break;
		case ARMOR_PENETRATION: s = "+ " + v + " $a"; break;
		case ATTACK_DAMAGE: s =  "+ " + v + " $a"; break;
		case ATTACK_SPEED: s = "+ " + v + "% $a"; break;
		case COOLDOWN: s =  "+ " + v + "% $a"; break;
		case CRIT_CHANCE: s =  "+ " + v + "% $a"; break;
		case GOLD_PER_SEC: s =  "+ " + v + " $a"; break;
		case HEALTH: s =  "+ " + v + " $a"; break;
		case HEALTH_REGEN: s =  "+ " + v + "% $a"; break;
		case LIFE_ON_HIT: s = "+ " + v + " $a"; break;
		case LIFE_STEAL: s =  "+ " + v + " $a"; break;
		case MAGIC_RESIST: s =  "+ " + v + " $a"; break;
		case MAGIC_PENETRATION: s =  "+ " + v + " $a"; break;
		case MANA: s =  "+ " + v + " $a"; break;
		case MANA_REGEN: s =  "+ " + v + "% $a"; break;
		case MOVEMENT: s =  "+ " + v + " $a"; break;
		default: throw new IllegalArgumentException("The property called " + p.name() + " couldn#t be found!");
		}
		return s.replace("$a", p.realName());
	}
}
