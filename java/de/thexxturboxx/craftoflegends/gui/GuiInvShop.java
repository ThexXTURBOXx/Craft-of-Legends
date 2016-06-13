package de.thexxturboxx.craftoflegends.gui;

import org.lwjgl.opengl.GL11;

import de.thexxturboxx.craftoflegends.COLMod;
import de.thexxturboxx.craftoflegends.api.DataManager;
import de.thexxturboxx.craftoflegends.api.PLAYER_PROPERTY;
import de.thexxturboxx.craftoflegends.items.InvItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuiInvShop extends Gui {
	
	 private Minecraft mc;
	 private int widthi = 81, heighti = 49,
			 width, height;
	 
	 public GuiInvShop(Minecraft mc) {
		  super();
		  this.mc = mc;
	 }
	 
	 @SubscribeEvent
	 public void onRenderExperienceBar(RenderGameOverlayEvent event) {
		 if(event.isCancelable() || event.getType() != ElementType.EXPERIENCE) {      
			 return;
		 }
		 width = event.getResolution().getScaledWidth();
		 height = event.getResolution().getScaledHeight();
		 int xPos = 2;
		 int yPos = height - heighti - 2;
		 GL11.glColor4f(1, 1, 1, 1);
		 GL11.glDisable(GL11.GL_LIGHTING);
		 mc.renderEngine.bindTexture(new ResourceLocation(COLMod.MODID, "textures/gui/shopinv.png"));
		 drawTexturedModalRect(xPos, yPos, 2, 2, widthi, heighti);
		 
		 GL11.glScaled(0.0625, 0.0625, 0.0625);
		 int c = 0;
		 for(InvItem i : DataManager.getItems(mc.thePlayer.getUniqueID().toString())) {
			 if(i != null) {
				 int z = 0, j = c;
				 if(c > 2) {
					 z = 1;
					 j = c - 3;
				 }
				 ResourceLocation r = new ResourceLocation(COLMod.MODID, "textures/items/" + i.getName() + ".png");
				 mc.renderEngine.bindTexture(r);
				 drawTexturedModalRect((xPos + 2 + (j * 18)) * 16, (yPos + 2 + (z * 18)) * 16, 0, 0, 256, 256);
			 }
			 c++;
		 }
		 GL11.glScaled(16, 16, 16);
		 
		 String gold = Integer.toString(DataManager.getProperty(mc.thePlayer.getUniqueID().toString(), PLAYER_PROPERTY.GOLD));
		 mc.fontRendererObj.drawString(gold, xPos + 2 + widthi / 2 - (mc.fontRendererObj.getStringWidth(gold) / 2 + 2), height - 11, 0x557661, false);
	 }
}