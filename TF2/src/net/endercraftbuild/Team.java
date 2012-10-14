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
          Player player = (Player)sender;
          if(TF2Main.red.size() <= TF2Main.blu.size())
			{
				if(!TF2Main.red.contains(sender.getName()))
				{
					TF2Main.red.add(sender.getName());
					return true;
				}else
				{
					player.sendMessage(ChatColor.AQUA + "[Endercraft TF2]" + ChatColor.RED + " You Are Already On This Team");
				}
			}else
			{
				player.sendMessage(ChatColor.AQUA + "[Endercraft TF2]" + ChatColor.RED + " This Team Has Too Many Players");
			}
   			} 
   return true;
         }
public boolean onBlu(CommandSender sender, Command cmd, String label, String[] args) {
	   if (cmd.getName().equalsIgnoreCase("blu")) {
		   Player player = (Player)sender;
		   if(TF2Main.blu.size() <= TF2Main.red.size())
			{
				if(!TF2Main.blu.contains(sender.getName()))
				{
					TF2Main.blu.add(sender.getName());
					return true;
				}else
				{
					player.sendMessage(ChatColor.AQUA + "[Endercraft TF2]" + ChatColor.RED + " You Are Already On This Team");
				}
			}else
			{
				player.sendMessage(ChatColor.AQUA + "[Endercraft TF2]" + ChatColor.RED + " This Team Has Too Many Players");
			}
	         }
			return true;
}
}
