package de.thexxturboxx.craftoflegends;

import de.thexxturboxx.craftoflegends.api.COLItems;
import de.thexxturboxx.craftoflegends.blocks.BlockBase;
import de.thexxturboxx.craftoflegends.items.ItemBase;
import de.thexxturboxx.craftoflegends.items.items.ItemAbyssalScepter;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class COLRegistry {
	
	public static void registerItems() {
		COLItems.abyssal_scepter = registerItem(new ItemAbyssalScepter());
	}
	
	public static Item registerItem(ItemBase item) {
		item.registerRecipes();
		return GameRegistry.register(item.setCreativeTab(COLMod.tabCOL).setUnlocalizedName(item.getName()), new ResourceLocation(COLMod.ID, item.getName()));
	}
	
	public static Block registerBlock(BlockBase block) {
		block.registerRecipes();
		return GameRegistry.register(block.setCreativeTab(COLMod.tabCOL).setUnlocalizedName(block.getName()), new ResourceLocation(COLMod.ID, block.getName()));
	}
	
	//Entity-ID-Counter
	private static int c1 = 0;
	
	public static void registerEntity(Class<? extends Entity> entityclass, String name, int egg1, int egg2) {
		EntityRegistry.registerModEntity(entityclass, name, c1++, COLMod.ID, 120, 1, true, egg1, egg2);
	}
	
	public static void registerRenderer(Class<? extends Entity> entityclass, IRenderFactory rf) {
		RenderingRegistry.registerEntityRenderingHandler(entityclass, rf);
	}
	
}
