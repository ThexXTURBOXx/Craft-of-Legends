package de.thexxturboxx.craftoflegends.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import de.thexxturboxx.craftoflegends.COLMod;
import net.minecraft.util.text.translation.I18n;

public class Helpers {
	
	public static String translate(String toTranslate) {
		String s = I18n.translateToLocal(toTranslate);
		if(s.contains(toTranslate)) {
			s = getNewTranslation(toTranslate, "en_GB");
		}
		if(s.contains(toTranslate)) {
			s = getNewTranslation(toTranslate, "en_US");			
		}
		return s;
	}
	
	public static String getNewTranslation(String toTranslate, String language) {
		InputStream in = COLMod.class.getResourceAsStream("/assets/craftoflegends/lang/" + language + ".lang");
		try {
			for(String s1 : IOUtils.readLines(in)) {
				if(s1.contains(toTranslate)) {
					return s1.replace(toTranslate + "=", "");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return toTranslate;
	}
	
}
