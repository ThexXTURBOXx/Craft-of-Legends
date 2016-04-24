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
	
	int goldWidth = 32;
	int goldHeight = 16;
	
	//GuiButton button;
	
	@Override
	public void drawScreen(int x, int y, float ticks) {
		int guiX = (width - guiWidth) / 8;
		int guiY = (height - guiHeight) / 8;
		GL11.glColor4f(1, 1, 1, 1);
		drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation(COLMod.ID, "textures/gui/datageneral.png"));
		GL11.glScaled(2, 2, 2);
		drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
		drawTexturedModalRect(guiX + (guiWidth / 2) - 17, guiY + 2, 0, guiHeight, goldWidth, goldHeight);
		String s = Integer.toString(DataManager.getProperty(mc.thePlayer.getUniqueID().toString(), PLAYER_PROPERTY.GOLD));
		fontRendererObj.drawString(s, guiX + (guiWidth / 2) + 17, guiY + 4, 0xffffff, false);
		GL11.glScaled(0.5, 0.5, 0.5);
		int c = 0;
		for(InvItem i : COLRegistry.itemList) {
			ResourceLocation r = new ResourceLocation(COLMod.ID, "textures/items/" + i.getName() + ".png");
			drawNextItem(i, r, c++);
		}
		super.drawScreen(x, y, ticks);
	}
	
	protected void drawNextItem(InvItem i, ResourceLocation r, int number) {
		int guiX = (width - guiWidth) / 4;
		int guiY = (height - guiHeight) / 4;
		mc.renderEngine.bindTexture(r);
		int itemsPerLine = 7;
		int lineX = (number % itemsPerLine) + 1;
		int lineY = (number - lineX + 1) / itemsPerLine;
		int itemX = guiX + ((lineX - 1) * 32) + 3;
		int itemY = guiY + (lineY * 32) + 33;
		drawTexturedModalRect(itemX + 5, itemY, 0, 0, 16, 16);
		String cost = Integer.toString(i.getCost());
		int stringX = (itemX + 13) - ((fontRendererObj.getStringWidth(cost) + 1) / 2);
		int stringY = itemY + 17;
		fontRendererObj.drawString(cost, stringX, stringY, 0x557661);
	}
}