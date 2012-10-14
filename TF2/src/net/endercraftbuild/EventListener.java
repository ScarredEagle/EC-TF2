package net.endercraftbuild;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class EventListener implements Listener {

@EventHandler
public void DemomanGrenade(ProjectileHitEvent event) {
	if(event.getEntity().getType() == EntityType.SNOWBALL) {
		Location l = event.getEntity().getLocation();
	      if (event.getEntityType() == EntityType.PLAYER)
	        event.getEntity().getWorld().createExplosion(l, 3.0F);
		}
	

}

}