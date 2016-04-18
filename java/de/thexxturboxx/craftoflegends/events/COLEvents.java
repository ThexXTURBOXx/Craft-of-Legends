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

import de.thexxturboxx.craftoflegends.api.DataManager;
import de.thexxturboxx.craftoflegends.api.PLAYER_PROPERTY;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class COLEvents {
	
	@SubscribeEvent
	public void onWorldLoad(PlayerEvent.LoadFromFile e) {
		try {
		File f = getPlayerConfig(e.getPlayerDirectory(), e.getEntityPlayer().getUniqueID());
		HashMap<PLAYER_PROPERTY, Integer> hm = new HashMap();
		int gold = 0;
		InputStream i = new FileInputStream(f);
		for(String s : IOUtils.readLines(i)) {
			if(s.contains("gold: ")) {
				gold = Integer.parseInt(s.replace("gold: ", ""));
			}
		}
		hm.put(PLAYER_PROPERTY.GOLD, gold);
		DataManager.setPlayer(e.getPlayerUUID(), hm);
		} catch(IOException e1) {
			e1.printStackTrace();
		}
	}
	
	@SubscribeEvent
	public void onWorldSave(PlayerEvent.SaveToFile e) {
		try {
			File f = getPlayerConfig(e.getPlayerDirectory(), e.getEntityPlayer().getUniqueID());
			FileWriter writer = new FileWriter(f.getAbsoluteFile());
			PrintWriter p = new PrintWriter(writer, true);
			p.write("gold: " + DataManager.getProperty(e.getPlayerUUID(), PLAYER_PROPERTY.GOLD));
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
			
			for(String s : IOUtils.readLines(i)) {
				if(s.contains("gold: ")) goldFound = true;
			}
			
			if(!goldFound) {
				FileWriter writer = new FileWriter(f.getAbsoluteFile());
				PrintWriter p = new PrintWriter(writer, false);
				p.write("gold: 0");
				p.close();
			}
			
			return f;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new IllegalArgumentException("[CraftOfLegends] The Player config file couldn't be initialized.");
	}
	
}
