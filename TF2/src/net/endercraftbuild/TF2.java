package net.endercraftbuild;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

//Main class
public class TF2 extends JavaPlugin
{
	public static ArrayList<String> Red = new ArrayList<String>();
	public static ArrayList<String> Blu = new ArrayList<String>();
	public static ArrayList<String> Builders = new ArrayList<String>();

	@Override
	public void onEnable()
	{
		File configFile = new File(this.getDataFolder() + "/config.yml");
		if(!configFile.exists())
		{
				this.saveDefaultConfig();
		}
		PluginManager manager = this.getServer().getPluginManager();
		manager.registerEvents(new TF2Listener(), this);
		Builders.add("geekguy44");
		Builders.add("superpeanut911");
	    Builders.add("wacky3zaybxc");
	    Builders.add("Darknight390");
	}	
		
	@Override
	public void onDisable()
	{
			
	}
		
}
