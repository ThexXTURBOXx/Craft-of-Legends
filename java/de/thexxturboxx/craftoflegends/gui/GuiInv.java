package de.thexxturboxx.craftoflegends.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;

public class GuiInv extends GuiContainer {
	
	public GuiInv() {
		super(new ContainerInv(Minecraft.getMinecraft().thePlayer.inventory));
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		
	}
	
}
