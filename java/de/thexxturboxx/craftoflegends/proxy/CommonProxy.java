package de.thexxturboxx.craftoflegends.proxy;

import de.thexxturboxx.craftoflegends.COLRegistry;
import de.thexxturboxx.craftoflegends.events.COLEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e) {
		COLRegistry.registerItems();
		MinecraftForge.EVENT_BUS.register(new COLEvents());
	}
	
	public void init(FMLInitializationEvent e) {
		
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		
	}
	
}
