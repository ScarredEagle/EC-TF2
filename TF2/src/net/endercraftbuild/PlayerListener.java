package net.endercraftbuild;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerListener {
	public TF2 plugin;
	public PlayerListener(TF2 instance) {
	plugin = instance;
	}
//No friendly fire! Red, untested! (superpeanut911)
@EventHandler(ignoreCancelled=true)
public void onRedHit(EntityDamageByEntityEvent event) {
    Player hurter = (Player) event.getDamager();
    if(TF2.Red.contains((hurter.getName())))
    {
    	if (event.getEntity().getType().equals(EntityType.PLAYER))  
	  {
    	if(TF2.Red.contains(((Player) event.getEntity()).getName()))
			{
				if (event.getEntity().getType().equals(EntityType.PLAYER)) {
						event.setCancelled(true);
					((Player)event.getDamager()).sendMessage(ChatColor.AQUA + "[Endercraft TF2]" + ChatColor.RED + ChatColor.BOLD + " Friendly Fire! No hurting team mates!");
				 }
			 }
		 }
	  }
   }
//No friendly fire! Blu, untested! (superpeanut911)
@EventHandler(ignoreCancelled=true)
public void onBluHit(EntityDamageByEntityEvent event) {
    Player hurter = (Player) event.getDamager();
    if(TF2.Blu.contains((hurter.getName())))
    {
    	if (event.getEntity().getType().equals(EntityType.PLAYER))  
	  {
    	if(TF2.Blu.contains(((Player) event.getEntity()).getName()))
			{
				if (event.getEntity().getType().equals(EntityType.PLAYER)) {
						event.setCancelled(true);
					((Player)event.getDamager()).sendMessage(ChatColor.AQUA + "[Endercraft TF2]" + ChatColor.RED + ChatColor.BOLD + " Friendly Fire! No hurting team mates!");
					}
				}
	  		}
    	}
	}
}
    
					
					
					