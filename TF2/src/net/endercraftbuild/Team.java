package net.endercraftbuild;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Team {
	public TF2Main plugin;
	 public Team(TF2Main plugin){
	        this.plugin = plugin; }

public boolean onRed(CommandSender sender, Command cmd, String label, String[] args) {
   if (cmd.getName().equalsIgnoreCase("red")) {
         }
          Player player = (Player)sender;
          plugin.red.add(sender.getName());
           player.sendMessage(ChatColor.AQUA + "[Endercraft TF2]" + ChatColor.GREEN + " You have chosen team RED");
		return true;
         }
public boolean onBlu(CommandSender sender, Command cmd, String label, String[] args) {
	   if (cmd.getName().equalsIgnoreCase("blu")) {
	         }
	          Player player = (Player)sender;
	          plugin.blu.add(sender.getName());
	           player.sendMessage(ChatColor.AQUA + "[Endercraft TF2]" + ChatColor.GREEN + " You have chosen team BLU");
			return true;
}
}