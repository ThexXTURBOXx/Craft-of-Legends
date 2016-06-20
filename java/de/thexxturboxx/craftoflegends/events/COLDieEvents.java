package de.thexxturboxx.craftoflegends.events;

import de.thexxturboxx.craftoflegends.api.DataManager;
import de.thexxturboxx.craftoflegends.api.PLAYER_PROPERTY;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class COLDieEvents {
	
	@SubscribeEvent
	public void onKill(LivingDeathEvent e) {
		Entity killere = e.getSource().getEntity();
	    EntityLivingBase target = e.getEntityLiving();
	    if(killere != null && killere instanceof EntityPlayer) {
	    	if(target instanceof EntityMob) {
		    	EntityPlayer killer = (EntityPlayer) killere;
		    	DataManager.setGold(killer.getUniqueID().toString(), DataManager.getProperty(killer.getUniqueID().toString(), PLAYER_PROPERTY.GOLD) + 20);
	    	}
	    }
	}
	
}