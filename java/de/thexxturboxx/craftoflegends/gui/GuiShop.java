package de.thexxturboxx.craftoflegends.gui;

import org.lwjgl.opengl.GL11;

import de.thexxturboxx.craftoflegends.COLMod;
import de.thexxturboxx.craftoflegends.COLRegistry;
import de.thexxturboxx.craftoflegends.api.DataManager;
import de.thexxturboxx.craftoflegends.api.PLAYER_PROPERTY;
import de.thexxturboxx.craftoflegends.items.InvItem;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class GuiShop extends GuiScreen {
	
	int guiWidth = 256;
	int guiHeight = 137;
	
	int realGuiWidth = 512;
	int realGuiHeight = 274;
	
	int goldWidth = 32;
	int goldHeight = 16;
	
	int scaleFactor = 2;
	
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
		int itemsPerLine = 7;
		int c = 0;
		for(InvItem i : COLRegistry.itemList) {
			ResourceLocation r = new ResourceLocation(COLMod.ID, "textures/items/" + i.getName() + ".png");
			drawNextItem(i, r, c++, itemsPerLine);
		}
		super.drawScreen(x, y, ticks);
	}
	
	protected void drawNextItem(InvItem i, ResourceLocation r, int number, int itemsPerLine) {
		int guiX = (width - realGuiWidth) / 2;
		int guiY = (height - realGuiHeight) / 2;
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
}