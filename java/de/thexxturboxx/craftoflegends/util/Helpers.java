package de.thexxturboxx.craftoflegends.util;

import net.minecraft.util.text.translation.I18n;

public class Helpers {
	
	public static String translate(String toTranslate) {
		String s = I18n.translateToLocal(toTranslate);
		if(s == toTranslate) {
			
		}
		return s;
	}
	
}
