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
	
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		MinecraftForge.EVENT_BUS.register(new GuiDataGeneral());
	}
	
	public static KeyBinding[] keyBindings;
	public static final String categoryKeys = "keys.col.category";
	
	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		keyBindings = new KeyBinding[] {
		//Keybinding for opening the general GUI, id: 0
		new KeyBinding("key.guigeneral.desc", Keyboard.KEY_C, categoryKeys),
		//Keybinding for opening the shop GUI, id: 1
		new KeyBinding("key.guishop.desc", Keyboard.KEY_P, categoryKeys)
		};
		
		for(int i = 0; i < keyBindings.length; ++i) {
		    ClientRegistry.registerKeyBinding(keyBindings[i]);
		}
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}
	
}