package de.thexxturboxx.craftoflegends.gui;

import java.io.IOException;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import com.mojang.realmsclient.gui.ChatFormatting;

import de.thexxturboxx.craftoflegends.COLMod;
import de.thexxturboxx.craftoflegends.COLRegistry;
import de.thexxturboxx.craftoflegends.api.DataManager;
import de.thexxturboxx.craftoflegends.api.PLAYER_PROPERTY;
import de.thexxturboxx.craftoflegends.items.InvItem;
import de.thexxturboxx.craftoflegends.util.Helpers;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import scala.actors.threadpool.Arrays;

public class GuiShop extends GuiScreen {
	
	int guiWidth = 256;
	int guiHeight = 137;
	
	int realGuiWidth = 512;
	int realGuiHeight = 274;
	
	int goldWidth = 32;
	int goldHeight = 16;
	
	int scaleFactor = 2;
	
	int scroll = 0;
	int itemsPerLine = 7;
	int linesPerGui = 7;
	
	int currentX = 0;
	int currentY = 0;
	ResourceLocation r = null;
	InvItem itemcurr = null;
	
	//GuiButton button;
	
	@Override
	public void drawScreen(int x, int y, float ticks) {
		int guiX = ((width - realGuiWidth) / 2 / scaleFactor);
		int guiY = ((height - realGuiHeight) / 2 / scaleFactor);
		GL11.glColor4f(1, 1, 1, 1);
		drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation(COLMod.ID, "textures/gui/datageneral.png"));
		GL11.glScaled(scaleFactor, scaleFactor, scaleFactor);
		drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
		String s = Integer.toString(DataManager.getProperty(mc.thePlayer.getUniqueID().toString(), PLAYER_PROPERTY.GOLD));
		int xx = (16 + fontRendererObj.getStringWidth(s)) / 2;
		drawTexturedModalRect(guiX + (guiWidth / 2) - xx, guiY + 2, 0, guiHeight, goldWidth, goldHeight);
		fontRendererObj.drawString(s, guiX + (guiWidth / 2) + xx, guiY + 4, 0xffffff, false);
		GL11.glScaled((1 / (double) scaleFactor), (1 / (double) scaleFactor), (1 / (double) scaleFactor));
		int c = 0;
		for(InvItem is : COLRegistry.itemList) {
			InvItem i = COLRegistry.itemList.get(scroll * itemsPerLine + c);
			if(c < itemsPerLine * 10) {
				ResourceLocation r = new ResourceLocation(COLMod.ID, "textures/items/" + i.getName() + ".png");
				drawNextItem(i, r, c++, itemsPerLine);				
			}
		}
		int guiX1 = guiX * 2;
		int guiY1 = guiY * 2;
		if(Mouse.isCreated() && Mouse.isButtonDown(0)) {
			c = 0;
			for(InvItem is : COLRegistry.itemList) {
				int lineX = (c % itemsPerLine) + 1;
				int lineY = (c - lineX + 1) / itemsPerLine;
				int itemX = guiX1 + ((lineX - 1) * 32) + 8;
				int itemY = guiY1 + (lineY * 32) + 31;
				int ix = Mouse.getEventX() * width / mc.displayWidth;
		        int iy = height - Mouse.getEventY() * height / mc.displayHeight - 4;
				if(ix >= itemX && iy >= itemY && ix <= itemX + 16 && iy <= itemY + 16) {
					r = new ResourceLocation(COLMod.ID, "textures/items/" + is.getName() + ".png");
					itemcurr = is;
				}
				c++;
			}
		}
		if(r != null) {
			currentX = (int) (width * 2 + width / 2);
			currentY = (int) (height + height / 32);
			drawItem(r, currentX, currentY, 0.25);
			fontRendererObj.drawString(Helpers.translate("item." + itemcurr.getName() + ".name"), width / 2 + width / 64, height / 2 - height / 16, 0xffffff, false);
			fontRendererObj.drawString(itemcurr.getCost() + "", width / 2 + width / 64, height / 2 - height / 16 + 10, 0xffffff, false);
		}
		c = 0;
		for(InvItem is : COLRegistry.itemList) {
			int lineX = (c % itemsPerLine) + 1;
			int lineY = (c - lineX + 1) / itemsPerLine;
			int itemX = guiX1 + ((lineX - 1) * 32) + 8;
			int itemY = guiY1 + (lineY * 32) + 31;
			int ix = Mouse.getEventX() * width / mc.displayWidth;
	        int iy = height - Mouse.getEventY() * height / mc.displayHeight - 4;
			if(ix >= itemX && iy >= itemY && ix <= itemX + 16 && iy <= itemY + 16) {
				String[] sa = new String[] {ChatFormatting.AQUA + Helpers.translate("item." + is.getName() + ".name"),
						ChatFormatting.AQUA + Helpers.translate("gui.general.gold") + ": " + ChatFormatting.GOLD + 
						Integer.toString(is.getCost())};
				List<String> strings = Arrays.asList(sa);
				drawHoveringText(strings, ix, iy);
			}
			c++;
		}
		super.drawScreen(x, y, ticks);
	}
	
	protected void drawNextItem(InvItem i, ResourceLocation r, int number, int itemsPerLine) {
		int guiX = (width - realGuiWidth) / scaleFactor;
		int guiY = (height - realGuiHeight) / scaleFactor;
		GL11.glColor4f(1, 1, 1, 1);
		mc.renderEngine.bindTexture(r);
		int lineX = (number % itemsPerLine) + 1;
		int lineY = (number - lineX + 1) / itemsPerLine;
		int itemX = guiX + ((lineX - 1) * 32) + 3;
		int itemY = guiY + (lineY * 32) + 33;
		GL11.glScaled(0.0625, 0.0625, 0.0625);
		drawTexturedModalRect(16 * (itemX + 5), 16 * itemY, 0, 0, 256, 256);
		String cost = Integer.toString(i.getCost());
		int stringX = (itemX + 13) - ((fontRendererObj.getStringWidth(cost) + 1) / 2);
		int stringY = itemY + 17;
		GL11.glScaled(16, 16, 16);
		GL11.glColor4d(0.5, 0.5, 0.5, 1);
		fontRendererObj.drawString(cost, stringX, stringY, 0x557661);
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		if(keyCode == Keyboard.KEY_DOWN) {
			if(scroll + 1 <= Math.ceil(((double) COLRegistry.itemList.size() / (double) itemsPerLine)) - linesPerGui) {
				scroll++;
			}
		}
		if(keyCode == Keyboard.KEY_UP) {
			if(scroll - 1 >= 0) {
				scroll--;
			}
		}
		super.keyTyped(typedChar, keyCode);
	}
	
	@Override
	protected void mouseClicked(int x, int y, int button) throws IOException {
		super.mouseClicked(x, y, button);
	}
	
	protected void drawItem(ResourceLocation r, int x, int y, double scale) {
		GL11.glColor4f(1, 1, 1, 1);
		mc.renderEngine.bindTexture(r);
		GL11.glScaled(scale, scale, scale);
		drawTexturedModalRect(x, y, 0, 0, 256, 256);
		GL11.glScaled(1 / scale, 1 / scale, 1 / scale);
		GL11.glColor4d(0.5, 0.5, 0.5, 1);
	}
}