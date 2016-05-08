package de.thexxturboxx.craftoflegends.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.thexxturboxx.craftoflegends.items.InvItem;

public class DataManager {
	
	public static HashMap<String, HashMap<PLAYER_PROPERTY, Integer>> props = new HashMap<String, HashMap<PLAYER_PROPERTY, Integer>>();
	public static HashMap<String, HashMap<PLAYER_PROPERTY, InvItem>> itemprops = new HashMap<String, HashMap<PLAYER_PROPERTY, InvItem>>();
	
	public static void setPropPlayer(String uuid, HashMap<PLAYER_PROPERTY, Integer> data) {
		props.put(uuid, data);
	}
	
	public static void setItemsPlayer(String uuid, HashMap<PLAYER_PROPERTY, InvItem> data) {
		itemprops.put(uuid, data);
	}
	
	public static void setGold(String uuid, int gold) {
		HashMap<PLAYER_PROPERTY, Integer> hm = new HashMap<PLAYER_PROPERTY, Integer>();
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
		HashMap<PLAYER_PROPERTY, InvItem> hm = new HashMap<PLAYER_PROPERTY, InvItem>();
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
	
	public static List<InvItem> getItems(String uuid) {
		List<InvItem> l = new ArrayList();
		l.add(1, getItem(uuid, PLAYER_PROPERTY.ITEM1));
		l.add(2, getItem(uuid, PLAYER_PROPERTY.ITEM2));
		l.add(3, getItem(uuid, PLAYER_PROPERTY.ITEM3));
		l.add(4, getItem(uuid, PLAYER_PROPERTY.ITEM4));
		l.add(5, getItem(uuid, PLAYER_PROPERTY.ITEM5));
		l.add(6, getItem(uuid, PLAYER_PROPERTY.ITEM6));
		return l;
	}
	
}
