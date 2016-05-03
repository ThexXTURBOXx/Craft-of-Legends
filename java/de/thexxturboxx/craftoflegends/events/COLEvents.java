package de.thexxturboxx.craftoflegends.events;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.UUID;

import org.apache.commons.io.IOUtils;

import de.thexxturboxx.craftoflegends.COLMod;
import de.thexxturboxx.craftoflegends.api.DataManager;
import de.thexxturboxx.craftoflegends.api.PLAYER_PROPERTY;
import de.thexxturboxx.craftoflegends.gui.GuiDataGeneral;
import de.thexxturboxx.craftoflegends.gui.GuiInv;
import de.thexxturboxx.craftoflegends.gui.GuiShop;
import de.thexxturboxx.craftoflegends.items.InvItem;
import de.thexxturboxx.craftoflegends.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class COLEvents {
	
	@SubscribeEvent
	public void onWorldLoad(PlayerEvent.LoadFromFile e) {
		try {
			File f = getPlayerConfig(e.getPlayerDirectory(), e.getEntityPlayer().getUniqueID());
			HashMap<PLAYER_PROPERTY, Integer> hmp = new HashMap();
			HashMap<PLAYER_PROPERTY, InvItem> hmi = new HashMap();
			int gold = 0;
			InvItem item1 = null;
			InvItem item2 = null;
			InvItem item3 = null;
			InvItem item4 = null;
			InvItem item5 = null;
			InvItem item6 = null;
			InputStream i = new FileInputStream(f);
			for(String s : IOUtils.readLines(i)) {
				if(s.contains("gold: ")) {
					gold = Integer.parseInt(s.replace("gold: ", ""));
				}
				if(s.contains("item1: ")) {
					if(s.replace("item1: ", "").equals("null")) {item1 = null; break;}
					item1 = (InvItem) Item.REGISTRY.getObject(new ResourceLocation(COLMod.MODID.toLowerCase(), s.replace("item1: ", "")));
				}
				if(s.contains("item2: ")) {
					if(s.replace("item2: ", "").equals("null")) {item2 = null; break;}
					item2 = (InvItem) Item.REGISTRY.getObject(new ResourceLocation(COLMod.MODID.toLowerCase(), s.replace("item2: ", "")));
				}
				if(s.contains("item3: ")) {
					if(s.replace("item3: ", "").equals("null")) {item3 = null; break;}
					item3 = (InvItem) Item.REGISTRY.getObject(new ResourceLocation(COLMod.MODID.toLowerCase(), s.replace("item3: ", "")));
				}
				if(s.contains("item4: ")) {
					if(s.replace("item4: ", "").equals("null")) {item4 = null; break;}
					item4 = (InvItem) Item.REGISTRY.getObject(new ResourceLocation(COLMod.MODID.toLowerCase(), s.replace("item4: ", "")));
				}
				if(s.contains("item5: ")) {
					if(s.replace("item5: ", "").equals("null")) {item5 = null; break;}
					item5 = (InvItem) Item.REGISTRY.getObject(new ResourceLocation(COLMod.MODID.toLowerCase(), s.replace("item5: ", "")));
				}
				if(s.contains("item6: ")) {
					if(s.replace("item6: ", "").equals("null")) {item6 = null; break;}
					item6 = (InvItem) Item.REGISTRY.getObject(new ResourceLocation(COLMod.MODID.toLowerCase(), s.replace("item6: ", "")));
				}
			}
			hmp.put(PLAYER_PROPERTY.GOLD, gold);
			DataManager.setPropPlayer(e.getPlayerUUID(), hmp);
			hmi.put(PLAYER_PROPERTY.ITEM1, item1);
			hmi.put(PLAYER_PROPERTY.ITEM2, item2);
			hmi.put(PLAYER_PROPERTY.ITEM3, item3);
			hmi.put(PLAYER_PROPERTY.ITEM4, item4);
			hmi.put(PLAYER_PROPERTY.ITEM5, item5);
			hmi.put(PLAYER_PROPERTY.ITEM6, item6);
			DataManager.setItemsPlayer(e.getPlayerUUID(), hmi);
		} catch(IOException e1) {
			e1.printStackTrace();
		}
	}
	
	@SubscribeEvent
	public void onWorldSave(PlayerEvent.SaveToFile e) {
		try {
			File f = getPlayerConfig(e.getPlayerDirectory(), e.getEntityPlayer().getUniqueID());
			FileWriter writer = new FileWriter(f.getAbsoluteFile());
			PrintWriter p = new PrintWriter(writer, false);
			InvItem i;
			p.flush();
			p.println("gold: " + DataManager.getProperty(e.getPlayerUUID(), PLAYER_PROPERTY.GOLD));
			if((i = DataManager.getItem(e.getPlayerUUID(), PLAYER_PROPERTY.ITEM1)) != null) {
				p.println("item1: " + i.getName());
			} else {
				p.println("item1: null");
			}
			if((i = DataManager.getItem(e.getPlayerUUID(), PLAYER_PROPERTY.ITEM2)) != null) {
				p.println("item2: " + i.getName());
			} else {
				p.println("item2: null");
			}
			if((i = DataManager.getItem(e.getPlayerUUID(), PLAYER_PROPERTY.ITEM3)) != null) {
				p.println("item3: " + i.getName());
			} else {
				p.println("item3: null");
			}
			if((i = DataManager.getItem(e.getPlayerUUID(), PLAYER_PROPERTY.ITEM4)) != null) {
				p.println("item4: " + i.getName());
			} else {
				p.println("item4: null");
			}
			if((i = DataManager.getItem(e.getPlayerUUID(), PLAYER_PROPERTY.ITEM5)) != null) {
				p.println("item5: " + i.getName());
			} else {
				p.println("item5: null");
			}
			if((i = DataManager.getItem(e.getPlayerUUID(), PLAYER_PROPERTY.ITEM6)) != null) {
				p.println("item6: " + i.getName());
			} else {
				p.println("item6: null");
			}
			p.close();
		} catch(IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public File getPlayerConfig(File dir, UUID uuid) {
		try {
			File f = new File(dir, uuid.toString() + "-col.yml");
			
			if(!f.exists()) {
				f.createNewFile();
			}
			
			InputStream i = new FileInputStream(f);
			
			boolean goldFound = false;
			boolean item1Found = false;
			boolean item2Found = false;
			boolean item3Found = false;
			boolean item4Found = false;
			boolean item5Found = false;
			boolean item6Found = false;
			
			int gold = 0;
			String item1 = null;
			String item2 = null;
			String item3 = null;
			String item4 = null;
			String item5 = null;
			String item6 = null;
			
			for(String s : IOUtils.readLines(i)) {
				if(s.contains("gold: ")) {
					goldFound = true;
					gold = Integer.parseInt(s.replace("gold: ", ""));
				}
				if(s.contains("item1: ")) {
					item1Found = true;
					item1 = s;
				}
				if(s.contains("item2: ")) {
					item2Found = true;
					item2 = s;
				}
				if(s.contains("item3: ")) {
					item3Found = true;
					item3 = s;
				}
				if(s.contains("item4: ")) {
					item4Found = true;
					item4 = s;
				}
				if(s.contains("item5: ")) {
					item5Found = true;
					item5 = s;
				}
				if(s.contains("item6: ")) {
					item6Found = true;
					item6 = s;
				}
			}
			
			FileWriter writer = new FileWriter(f.getAbsoluteFile());
			PrintWriter p = new PrintWriter(writer, false);
			
			if(!goldFound) {
				p.println("gold: 0");
			} else {
				p.println(gold);
			}
			
			if(!item1Found) {
				p.println("item1: null");
			} else {
				p.println(item1);
			}
			
			if(!item2Found) {
				p.println("item2: null");
			} else {
				p.println(item2);
			}
			
			if(!item3Found) {
				p.println("item3: null");
			} else {
				p.println(item3);
			}
			
			if(!item4Found) {
				p.println("item4: null");
			} else {
				p.println(item4);
			}
			
			if(!item5Found) {
				p.println("item5: null");
			} else {
				p.println(item5);
			}
			
			if(!item6Found) {
				p.println("item6: null");
			} else {
				p.println(item6);
			}
			p.close();
			
			return f;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new IllegalArgumentException("[CraftOfLegends] The Player config file couldn't be initialized.");
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(receiveCanceled=true)
	public void onKeyboardPressed(KeyInputEvent event) {
		KeyBinding[] keyBindings = ClientProxy.keyBindings;
		if(keyBindings[0].isPressed()) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiDataGeneral());
		}
		if(keyBindings[1].isPressed()) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiShop());			
		}
		if(keyBindings[2].isPressed()) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiInv());			
		}
	}
}