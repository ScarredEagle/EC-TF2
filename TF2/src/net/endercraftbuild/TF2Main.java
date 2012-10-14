package net.endercraftbuild;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class TF2Main extends JavaPlugin implements Listener {

	
	public static ArrayList<String> red = new ArrayList<String>();
	public static ArrayList<String> blu = new ArrayList<String>(); 
	
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
	
	
}