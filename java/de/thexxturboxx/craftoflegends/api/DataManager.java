package de.thexxturboxx.craftoflegends.api;

import java.util.HashMap;

public class DataManager {
	
	public static HashMap<String, HashMap<PLAYER_PROPERTY, Integer>> props = new HashMap<>();
	
	public static void setPlayer(String uuid, HashMap<PLAYER_PROPERTY, Integer> data) {
		props.put(uuid, data);
	}
	
	public static void setGold(String uuid, int gold) {
		HashMap<PLAYER_PROPERTY, Integer> hm = new HashMap<>();
		for(PLAYER_PROPERTY p : props.get(uuid).keySet()) {
			switch(p) {
			case GOLD: hm.put(p, gold); break;
			default: throw new IllegalArgumentException("The Player-Property called " + p.name() + " couldn't be found.");
			}
		}
		setPlayer(uuid, hm);
	}
	
	public static int getProperty(String uuid, PLAYER_PROPERTY prop) {
		return props.get(uuid).get(prop);
	}
	
}
