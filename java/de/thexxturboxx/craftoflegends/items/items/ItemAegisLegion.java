package de.thexxturboxx.craftoflegends.items.items;

import java.util.ArrayList;
import java.util.List;

import de.thexxturboxx.craftoflegends.api.DataManager;
import de.thexxturboxx.craftoflegends.api.ItemProperties;
import de.thexxturboxx.craftoflegends.api.PLAYER_PROPERTY;
import de.thexxturboxx.craftoflegends.api.PROPERTY;
import de.thexxturboxx.craftoflegends.items.InvItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemAegisLegion extends InvItem {
	
	@Override
	public String getName() {
		return "aegis_legion";
	}
	
	@Override
	public void registerRecipes() {
		
	}
	
	@Override
	public int getCost() {
		return 1500;
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
				setProperty(PROPERTY.HEALTH, 200).
				setProperty(PROPERTY.HEALTH_REGEN, 100).
				setProperty(PROPERTY.MAGIC_RESIST, 20);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {
		if(worldIn.isRemote) {
			System.out.println("1: " + DataManager.getItem(playerIn.getUniqueID().toString(), PLAYER_PROPERTY.ITEM1));
			System.out.println("2: " + DataManager.getItem(playerIn.getUniqueID().toString(), PLAYER_PROPERTY.ITEM2));
			System.out.println("3: " + DataManager.getItem(playerIn.getUniqueID().toString(), PLAYER_PROPERTY.ITEM3));
			System.out.println("4: " + DataManager.getItem(playerIn.getUniqueID().toString(), PLAYER_PROPERTY.ITEM4));
			System.out.println("5: " + DataManager.getItem(playerIn.getUniqueID().toString(), PLAYER_PROPERTY.ITEM5));
			System.out.println("6: " + DataManager.getItem(playerIn.getUniqueID().toString(), PLAYER_PROPERTY.ITEM6));
		}
		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}
	
}
