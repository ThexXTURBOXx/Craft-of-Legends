package de.thexxturboxx.craftoflegends;

import de.thexxturboxx.craftoflegends.api.COLItems;
import de.thexxturboxx.craftoflegends.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = COLMod.ID, version = COLMod.VERSION, name = COLMod.NAME, updateJSON = "https://raw.githubusercontent.com/ThexXTURBOXx/Craft-of-Legends/master/version.json")
public class COLMod {
	public static final String NAME = "Craft of Legends";
    public static final String ID = "craftoflegends";
    public static final String VERSION = "0.0.1";
    
    public static final CreativeTabs tabCOL = new CreativeTabs(ID) {
		@Override
		public Item getTabIconItem() {
			return COLItems.abyssal_scepter;
		}
	};
    
    @Instance(ID)
    public static COLMod instance;
    
    @SidedProxy(modId = ID,
    		clientSide = "de.thexxturboxx.craftoflegends.proxy.ClientProxy",
    		serverSide = "de.thexxturboxx.craftoflegends.proxy.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}