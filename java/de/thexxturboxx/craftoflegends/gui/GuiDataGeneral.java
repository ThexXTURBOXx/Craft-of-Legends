package de.thexxturboxx.craftoflegends.gui;

import java.io.IOException;

import org.lwjgl.opengl.GL11;

import de.thexxturboxx.craftoflegends.COLMod;
import de.thexxturboxx.craftoflegends.api.DataManager;
import de.thexxturboxx.craftoflegends.api.PLAYER_PROPERTY;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class GuiDataGeneral extends GuiScreen {
	
	int guiWidth = 256;
	int guiHeight = 137;
	
	//GuiButton button
	
	@Override
	public void drawScreen(int x, int y, float ticks) {
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		GL11.glColor4f(1, 1, 1, 1);
		drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation(COLMod.ID, "textures/gui/datageneral.png"));
		drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
		fontRendererObj.drawString("Stats", guiX + (guiWidth / 2) - (fontRendererObj.getStringWidth("Stats") / 2), guiY + 4, 0x557661, false);
		drawLine("User: " + mc.thePlayer.getName(), 1);
		drawLine("Gold: " + DataManager.getProperty(mc.thePlayer.getUniqueID().toString(), PLAYER_PROPERTY.GOLD), 2);
		super.drawScreen(x, y, ticks);
	}
	
	@Override
	public void initGui() {
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		buttonList.clear();
		//buttonList.add(button = new GuiButton(buttonId, x, y, buttonText));
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch(button.id) {
		//case 0: ...;
		}
		super.actionPerformed(button);
	}
	
	@Override
	protected void mouseClicked(int x, int y, int button) throws IOException {
		super.mouseClicked(x, y, button);
	}
	
	protected void drawLine(String text, int line) {
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		fontRendererObj.drawString(text, guiX + 2, guiY + 18 + (9 * (line - 1)), 0x557661, false);
	}
	
}