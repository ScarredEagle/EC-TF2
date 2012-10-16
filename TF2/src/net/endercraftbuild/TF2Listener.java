package net.endercraftbuild;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

//Adds hats, teams on block hit, No friendly fire
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
	
	@SuppressWarnings("deprecation")
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
							player.getInventory().setHelmet(new ItemStack(Material.WOOL));
							player.getInventory().getHelmet().setDurability((short) 11);
							player.updateInventory();
							player.sendMessage(ChatColor.BLUE + "[EC TF2] " + "You Joined Team Blu!");
							player.sendMessage(ChatColor.BLUE + "Blu Team " + TF2.Blu.toString());
						}else
						{
							player.sendMessage(ChatColor.BLUE + "[EC TF2] " + "You Are Already On That Team.");
						}
					}else
					{
						player.sendMessage(ChatColor.BLUE + "[EC TF2] " + "Team Blu Has Too Many Players.");
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
							player.getInventory().setHelmet(new ItemStack(Material.WOOL));
							player.getInventory().getHelmet().setDurability((short) 14);
							player.updateInventory();
							player.sendMessage(ChatColor.RED + "[EC TF2] " + "You Joined Team Red!");
							player.sendMessage(ChatColor.RED + "Red Team " + TF2.Red.toString());
						}else
						{
							player.sendMessage(ChatColor.RED + "[EC TF2] " + "You Are Already On That Team.");
						}
					}else
					{
						player.sendMessage(ChatColor.RED + "[EC TF2] " + "Team Red Has Too Many Players.");
					}
				}
			}
		}
	}
	
	//Friendly Fire Preventer by superpeanut911 (Edited/Shortened by geekguy44)
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onHit(EntityDamageByEntityEvent event)
	{
		if(event.isCancelled())
		{
			return;
		}
		if(event.getEntity().getType().equals(EntityType.PLAYER) && event.getDamager().getType().equals(EntityType.PLAYER))
		{
			Player attacker = (Player) event.getDamager();
			Player player = (Player) event.getEntity();
			if(TF2.Blu.contains(attacker.getName()) && TF2.Blu.contains(player.getName()))
			{
				event.setCancelled(true);
			}
			if(TF2.Red.contains(attacker.getName()) && TF2.Red.contains(player.getName()))
			{
				event.setCancelled(true);
			}
		}
	}
	//Prevent moving items
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onInv(InventoryClickEvent event)
	{
		if(event.isCancelled())
		{
			return;
		}
		if(!TF2.Builders.contains(event.getView().getPlayer().getName()))
		{
			event.setCancelled(true);
			Player player = (Player) event.getView().getPlayer();
			player.sendMessage(ChatColor.GREEN + "[TF2] You Can't Move Items Within Your Inventory.");
		}
	}
	
	//Prevent dropping item
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDrop(PlayerDropItemEvent event)
	{
		if(event.isCancelled())
		{
			return;
		}
		if(!TF2.Builders.contains(event.getPlayer().getName()))
		{
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.GREEN + "[TF2] You Can't Drop Items.");
		}
	}
	
	//Prevents dropping items on death
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDeath(PlayerDeathEvent event)
	{
		event.getDrops().clear();
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onLogOut(PlayerQuitEvent event)
	{
		event.getPlayer().getInventory().clear();
		event.getPlayer().getInventory().setHelmet(new ItemStack(Material.AIR));
		event.getPlayer().getInventory().setChestplate(new ItemStack(Material.AIR));
		event.getPlayer().getInventory().setLeggings(new ItemStack(Material.AIR));
		event.getPlayer().getInventory().setBoots(new ItemStack(Material.AIR));
		if(TF2.Blu.contains(event.getPlayer().getName()))
		{
			TF2.Blu.remove(event.getPlayer().getName());
		}
		if(TF2.Red.contains(event.getPlayer().getName()))
		{
			TF2.Red.remove(event.getPlayer().getName());
		}
		Location loc = event.getPlayer().getLocation();
		World world = event.getPlayer().getWorld();
		loc.setYaw(50);
		loc.setPitch(50);
		loc.setWorld(world);
		loc.setX(29);
		loc.setY(67);
		loc.setZ(259);
		event.getPlayer().teleport(loc);
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void preventLandDestructionOnExplode(EntityExplodeEvent event)
	{
		event.blockList().clear();
	}
}
