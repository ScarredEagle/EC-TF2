package net.endercraftbuild;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TF2Main extends JavaPlugin implements Listener {

	
	public ArrayList<String> red = new ArrayList<String>();
	public ArrayList<String> blu = new ArrayList<String>(); 
	
	public void onEnable(){
		File configFile = new File(this.getDataFolder() + "/config.yml");{
			if(!configFile.exists())
			{
				this.saveDefaultConfig(); }
		
		getLogger().info("EC TF2 by superpeanut911 has been enabled!");
		getServer().getPluginManager().registerEvents(this, this);
		}
	}

	public void onDisable(){
		getLogger().info("EC TF2 has been disabled!"); }
	
	
	@EventHandler
	public void DemomanGrenade(ProjectileHitEvent event) {
		if(event.getEntity().getType() == EntityType.SNOWBALL) {
			Location l = event.getEntity().getLocation();
		      if (event.getEntityType() == EntityType.PLAYER)
		        event.getEntity().getWorld().createExplosion(l, 3.0F);
		}
	}
}