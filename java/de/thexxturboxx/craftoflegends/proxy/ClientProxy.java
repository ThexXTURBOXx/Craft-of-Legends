package de.thexxturboxx.craftoflegends.proxy;

import org.lwjgl.input.Keyboard;

import de.thexxturboxx.craftoflegends.gui.GuiDataGeneral;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	public static KeyBinding[] keyBindings;
	public static final String categoryKeys = "keys.col.category";
	
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		MinecraftForge.EVENT_BUS.register(new GuiDataGeneral());
	}
	
	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		keyBindings = new KeyBinding[1];
		
		//Keybinding for opening the general GUI
		keyBindings[0] = new KeyBinding("key.guigeneral.desc", Keyboard.KEY_K, categoryKeys);
		
		for(int i = 0; i < keyBindings.length; ++i) {
		    ClientRegistry.registerKeyBinding(keyBindings[i]);
		}
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}
	
}