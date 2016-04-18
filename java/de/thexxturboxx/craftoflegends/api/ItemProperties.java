package de.thexxturboxx.craftoflegends.api;

import java.util.HashMap;

public class ItemProperties {
	
	private HashMap<PROPERTY, Integer> props = new HashMap<>();
	
	public ItemProperties setProperty(PROPERTY prop, int value) {
		props.put(prop, value);
		return this;
	}
	
	public int getValue(PROPERTY prop) {
		return props.get(prop);
	}
	
	public HashMap<PROPERTY, Integer> getMap() {
		return props;
	}
	
}
