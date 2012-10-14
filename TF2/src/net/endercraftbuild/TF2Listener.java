package net.endercraftbuild;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class TF2Listener implements Listener
{
  @EventHandler(priority = EventPriority.HIGHEST)
  public void onBlockBreak(BlockBreakEvent event)
  {
    if(event.isCancelled())
    {
      return;
    }else
    {
      if(!TF2.Builders.contains(event.getPlayer().getName()))
      {
        event.setCancelled(true);
        return;
      }
    }
  }
  
  @EventHandler(priority = EventPriority.HIGHEST)
  public void onBlockClick(PlayerInteractEvent event)
  {
    if(event.isCancelled())
    {
      return;
    }
    if(event.getAction() == Action.RIGHT_CLICK_BLOCK)
    {
      if(event.getClickedBlock().getType() == Material.WOOL)
      {
        Location loc = event.getClickedBlock().getLocation();
        Player player = event.getPlayer();
        if(loc.getBlockX() == 27 && loc.getBlockY() == 67 && loc.getBlockZ() == 262)
        {
          if(TF2.Blu.size() <= TF2.Red.size() || TF2.Blu.contains(player.getName()))
          {
            if(!TF2.Blu.contains(player.getName()))
            {
              if(TF2.Red.contains(player.getName()))
              {
                TF2.Red.remove(player.getName());
              }
              TF2.Blu.add(player.getName());
              player.sendMessage(ChatColor.AQUA + "[Endercraft TF2] " + "You Joined Team Blu!");
              player.sendMessage(ChatColor.AQUA + "[Endercraft TF2] " + ChatColor.BLUE + "Blu Team " + TF2.Blu.toString());
            }else
            {
              player.sendMessage(ChatColor.AQUA + "[Endercraft TF2] " + ChatColor.RED + "You Are Already On That Team.");
            }
          }else
          {
            player.sendMessage(ChatColor.AQUA + "[Endercraft TF2] " + ChatColor.RED + "Team Blu Has Too Many Players.");
          }
        }
        if(loc.getBlockX() == 30 && loc.getBlockY() == 67 && loc.getBlockZ() == 262)
        {
          if(TF2.Red.size() <= TF2.Blu.size() || TF2.Red.contains(player.getName()))
          {
            if(!TF2.Red.contains(player.getName()))
            {
              if(TF2.Blu.contains(player.getName()))
              {
                TF2.Blu.remove(player.getName());
              }
              TF2.Red.add(player.getName());
              player.sendMessage(ChatColor.AQUA + "[Endercraft TF2] " + ChatColor.RED + "You Joined Team RED!");
              player.sendMessage(ChatColor.AQUA + "[Endercraft TF2] " + ChatColor.RED + "Red Team " + TF2.Red.toString());
            }else
            {
              player.sendMessage(ChatColor.RED + "[TF2] " + "You Are Already On That Team.");
            }
          }else
          {
            player.sendMessage(ChatColor.RED + "[TF2] " + "Team Red Has Too Many Players.");
          }
        }
      }
    }
  }
}
