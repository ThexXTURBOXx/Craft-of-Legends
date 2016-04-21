package de.thexxturboxx.craftoflegends.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import de.thexxturboxx.craftoflegends.COLMod;
import net.minecraft.util.text.translation.I18n;

public class Helpers {
	
	public static String translate(String toTranslate) {
		String s = I18n.translateToLocal(toTranslate);
		if(s.equalsIgnoreCase(toTranslate)) {
			InputStream in = COLMod.class.getResourceAsStream("/assets/craftoflegends/lang/en_GB.lang");
			try {
				for(String s1 : IOUtils.readLines(in)) {
					if(s1.contains(toTranslate)) {
						s = s1.replace(toTranslate + "=", "");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return s;
	}
	
}
