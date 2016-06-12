package de.thexxturboxx.craftoflegends;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

@Mod(modid = COLMod.MODID, version = COLMod.VERSION, name = COLMod.NAME, updateJSON = "https://raw.githubusercontent.com/ThexXTURBOXx/Craft-of-Legends/master/version.json")
public class COLMod {
	public static final String NAME = "Craft of Legends";
    public static final String MODID = "craftoflegends";
    public static final String VERSION = "0.0.1a";
    
    public static final Logger log = LogManager.getLogger(NAME);
    
    public static final CreativeTabs tabCOL = new CreativeTabs(MODID) {
		@Override
		public Item getTabIconItem() {
			return COLItems.abyssal_scepter;
		}
	};
    
    @Instance(MODID)
    public static COLMod instance;
    
    @SidedProxy(modId = MODID,
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
