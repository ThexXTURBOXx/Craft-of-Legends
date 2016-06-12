package de.thexxturboxx.craftoflegends.gui;

import org.lwjgl.opengl.GL11;

import de.thexxturboxx.craftoflegends.COLMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuiInvShop extends Gui {
	
	 private Minecraft mc;
	 private int widthi = 96, heighti = 58,
			 width, height;
	 
	 public GuiInvShop(Minecraft mc) {
		  super();
		  this.mc = mc;
		  width = mc.displayWidth;
		  height = mc.displayHeight;
	 }
	 
	 @SubscribeEvent
	 public void onRenderExperienceBar(RenderGameOverlayEvent.Post event) {
		 int xPos = 2;
		 int yPos = heighti - height + 2;
		 GL11.glColor4f(1, 1, 1, 1);
		 GL11.glDisable(GL11.GL_LIGHTING);
		 mc.renderEngine.bindTexture(new ResourceLocation(COLMod.MODID, "textures/gui/shopinv.png"));
		 drawTexturedModalRect(xPos, yPos, 2, 2, widthi, heighti);
	 }
}