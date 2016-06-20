package de.thexxturboxx.craftoflegends;

import java.util.ArrayList;
import java.util.List;

import de.thexxturboxx.craftoflegends.api.COLItems;
import de.thexxturboxx.craftoflegends.blocks.BlockBase;
import de.thexxturboxx.craftoflegends.items.InvItem;
import de.thexxturboxx.craftoflegends.items.ItemBase;
import de.thexxturboxx.craftoflegends.items.items.ItemAbyssalScepter;
import de.thexxturboxx.craftoflegends.items.items.ItemAegisLegion;
import de.thexxturboxx.craftoflegends.items.items.ItemAetherWisp;
import de.thexxturboxx.craftoflegends.items.items.ItemAmplifyingTome;
import de.thexxturboxx.craftoflegends.items.items.ItemAncientCoin;
import de.thexxturboxx.craftoflegends.items.items.ItemArchangelStaff;
import de.thexxturboxx.craftoflegends.items.items.ItemArdentCenser;
import de.thexxturboxx.craftoflegends.items.items.ItemAthene;
import de.thexxturboxx.craftoflegends.items.items.ItemBFSword;
import de.thexxturboxx.craftoflegends.items.items.ItemBamisCinder;
import de.thexxturboxx.craftoflegends.items.items.ItemBannerCmd;
import de.thexxturboxx.craftoflegends.items.items.ItemBansheeVeil;
import de.thexxturboxx.craftoflegends.items.items.ItemBerserkerGreaves;
import de.thexxturboxx.craftoflegends.items.items.ItemBilgewaterCutlass;
import de.thexxturboxx.craftoflegends.items.items.ItemBladeKing;
import de.thexxturboxx.craftoflegends.items.items.ItemBlastingWand;
import de.thexxturboxx.craftoflegends.items.items.ItemBootsMobility;
import de.thexxturboxx.craftoflegends.items.items.ItemBootsSpeed;
import de.thexxturboxx.craftoflegends.items.items.ItemBootsSwiftness;
import de.thexxturboxx.craftoflegends.items.items.ItemBrawlerGloves;
import de.thexxturboxx.craftoflegends.items.items.ItemCatalyst;
import de.thexxturboxx.craftoflegends.items.items.ItemCaulfieldWH;
import de.thexxturboxx.craftoflegends.items.items.ItemChainVest;
import de.thexxturboxx.craftoflegends.items.items.ItemChalice;
import de.thexxturboxx.craftoflegends.items.items.ItemCloakAgility;
import de.thexxturboxx.craftoflegends.items.items.ItemClothArmor;
import de.thexxturboxx.craftoflegends.items.items.ItemCorruptingPotion;
import de.thexxturboxx.craftoflegends.items.items.ItemCrystallineBracer;
import de.thexxturboxx.craftoflegends.items.items.ItemCull;
import de.thexxturboxx.craftoflegends.items.items.ItemDagger;
import de.thexxturboxx.craftoflegends.items.items.ItemDeadMansPlate;
import de.thexxturboxx.craftoflegends.items.items.ItemDeathsDance;
import de.thexxturboxx.craftoflegends.items.items.ItemDervishBlade;
import de.thexxturboxx.craftoflegends.items.items.ItemDoransBlade;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class COLRegistry {
	
	public static final List<InvItem> itemList = new ArrayList();
	
	public static void registerItems() {
		COLItems.abyssal_scepter = registerItem(new ItemAbyssalScepter());
		COLItems.aegis_legion = registerItem(new ItemAegisLegion());
		COLItems.aether_wisp = registerItem(new ItemAetherWisp());
		COLItems.amplifying_tome = registerItem(new ItemAmplifyingTome());
		COLItems.ancient_coin = registerItem(new ItemAncientCoin());
		COLItems.archangels_staff = registerItem(new ItemArchangelStaff());
		COLItems.ardent_censer = registerItem(new ItemArdentCenser());
		COLItems.athene = registerItem(new ItemAthene());
		COLItems.bamis_cinder = registerItem(new ItemBamisCinder());
		COLItems.banner_command = registerItem(new ItemBannerCmd());
		COLItems.banshees_veil = registerItem(new ItemBansheeVeil());
		COLItems.berserkers_greaves = registerItem(new ItemBerserkerGreaves());
		COLItems.bf_sword = registerItem(new ItemBFSword());
		COLItems.bilgewater_cutlass = registerItem(new ItemBilgewaterCutlass());
		COLItems.blade_king = registerItem(new ItemBladeKing());
		COLItems.blasting_wand = registerItem(new ItemBlastingWand());
		COLItems.boots_mobility = registerItem(new ItemBootsMobility());
		COLItems.boots_speed = registerItem(new ItemBootsSpeed());
		COLItems.boots_swiftness = registerItem(new ItemBootsSwiftness());
		COLItems.brawler_gloves = registerItem(new ItemBrawlerGloves());
		COLItems.catalyst = registerItem(new ItemCatalyst());
		COLItems.caulfield_wh = registerItem(new ItemCaulfieldWH());
		COLItems.chain_vest = registerItem(new ItemChainVest());
		COLItems.chalice = registerItem(new ItemChalice());
		COLItems.cloak_agility = registerItem(new ItemCloakAgility());
		COLItems.cloth_armor = registerItem(new ItemClothArmor());
		COLItems.corrupting_potion = registerItem(new ItemCorruptingPotion());
		COLItems.crystalline_bracer = registerItem(new ItemCrystallineBracer());
		COLItems.cull = registerItem(new ItemCull());
		COLItems.dagger = registerItem(new ItemDagger());
		COLItems.dead_mans_plate = registerItem(new ItemDeadMansPlate());
		COLItems.deaths_dance = registerItem(new ItemDeathsDance());
		COLItems.dervish_blade = registerItem(new ItemDervishBlade());
		COLItems.dorans_blade = registerItem(new ItemDoransBlade());
	}
	
	public static Item registerItem(ItemBase item) {
		item.registerRecipes();
		if(item instanceof InvItem) itemList.add((InvItem) item);
		return GameRegistry.register(item.setCreativeTab(COLMod.tabCOL).setUnlocalizedName(item.getName()), new ResourceLocation(COLMod.MODID, item.getName()));
	}
	
	public static Block registerBlock(BlockBase block) {
		block.registerRecipes();
		return GameRegistry.register(block.setCreativeTab(COLMod.tabCOL).setUnlocalizedName(block.getName()), new ResourceLocation(COLMod.MODID, block.getName()));
	}
	
	//Entity-ID-Counter
	private static int c1 = 0;
	
	public static void registerEntity(Class<? extends Entity> entityclass, String name, int egg1, int egg2) {
		EntityRegistry.registerModEntity(entityclass, name, c1++, COLMod.MODID, 120, 1, true, egg1, egg2);
	}
	
	public static void registerRenderer(Class<? extends Entity> entityclass, IRenderFactory rf) {
		RenderingRegistry.registerEntityRenderingHandler(entityclass, rf);
	}
	
}
