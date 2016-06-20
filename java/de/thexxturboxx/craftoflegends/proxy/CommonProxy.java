package de.thexxturboxx.craftoflegends.proxy;

import de.thexxturboxx.craftoflegends.COLRegistry;
import de.thexxturboxx.craftoflegends.events.COLDieEvents;
import de.thexxturboxx.craftoflegends.events.COLSaveLoadEvents;
import de.thexxturboxx.craftoflegends.events.COLTickEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e) {
		COLRegistry.registerItems();
		MinecraftForge.EVENT_BUS.register(new COLSaveLoadEvents());
		MinecraftForge.EVENT_BUS.register(new COLTickEvents());
		MinecraftForge.EVENT_BUS.register(new COLDieEvents());
	}
	
	public void init(FMLInitializationEvent e) {
		
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		
	}
	
}
