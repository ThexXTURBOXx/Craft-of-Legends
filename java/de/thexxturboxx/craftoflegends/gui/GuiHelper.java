package de.thexxturboxx.craftoflegends.gui;

import de.thexxturboxx.craftoflegends.COLMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiHelper extends GuiScreen {
	
	Minecraft mc;
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	protected void drawGuiContainerBackgroundLayer(RenderGameOverlayEvent e) {
		mc = Minecraft.getMinecraft();
		
		mc.renderEngine.bindTexture(new ResourceLocation(COLMod.ID, "textures/gui/container.png"));
		
		int x = e.getResolution().getScaledWidth();
		int y = e.getResolution().getScaledHeight();
		
		drawTexturedModalRect(x / 2, y / 2, 0, 0, 256, 256);
	}
	
}