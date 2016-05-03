package de.thexxturboxx.craftoflegends.api;

import java.util.HashMap;

import de.thexxturboxx.craftoflegends.items.InvItem;

public class DataManager {
	
	public static HashMap<String, HashMap<PLAYER_PROPERTY, Integer>> props = new HashMap<>();
	public static HashMap<String, HashMap<PLAYER_PROPERTY, InvItem>> itemprops = new HashMap<>();
	
	public static void setPropPlayer(String uuid, HashMap<PLAYER_PROPERTY, Integer> data) {
		props.put(uuid, data);
	}
	
	public static void setItemsPlayer(String uuid, HashMap<PLAYER_PROPERTY, InvItem> data) {
		itemprops.put(uuid, data);
	}
	
	public static void setGold(String uuid, int gold) {
		HashMap<PLAYER_PROPERTY, Integer> hm = new HashMap<>();
		for(PLAYER_PROPERTY p : props.get(uuid).keySet()) {
			switch(p) {
			case GOLD: hm.put(p, gold); break;
			default: throw new IllegalArgumentException("The Player-Property called " + p.name() + " couldn't be found.");
			}
		}
		setPropPlayer(uuid, hm);
	}
	
	public static int getProperty(String uuid, PLAYER_PROPERTY prop) {
		return props.get(uuid).get(prop);
	}
	
	public static void setItem(String uuid, int index, InvItem i) {
		HashMap<PLAYER_PROPERTY, InvItem> hm = new HashMap<>();
		for(PLAYER_PROPERTY p : itemprops.get(uuid).keySet()) {
			if(p.name().contains(index + "")) {
				hm.put(p, i);
			} else {
				hm.put(p, itemprops.get(uuid).get(p));
			}
		}
		setItemsPlayer(uuid, hm);
	}
	
	public static InvItem getItem(String uuid, PLAYER_PROPERTY prop) {
		return itemprops.get(uuid).get(prop);
	}
	
}
