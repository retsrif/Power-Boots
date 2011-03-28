package retsrif.PowerBoots;

import org.bukkit.Location;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class PBPlayerListener extends PlayerListener {
	public static PowerBoots plugin;
	
	public PBPlayerListener(PowerBoots instance) {
		plugin = instance;
	}
	
	public void onPlayerMove(PlayerMoveEvent event) {
		final Player player = event.getPlayer();
		ItemStack boots = player.getInventory().getBoots();
		
		if(boots.getType() == Material.LEATHER_BOOTS && PowerBoots.leatherBoots == true) {
			leatherBoot(player);
		}
		
		if(boots.getType() == Material.IRON_BOOTS && PowerBoots.ironBoots == true) {
			ironBoot(player);
		}
		
		if(boots.getType() == Material.GOLD_BOOTS && PowerBoots.goldBoots == true) {
			goldBoot(player);
		}
		
	}
	
	public void leatherBoot(final Player player) {
		final Location location = player.getLocation();
		final int x = location.getBlockX();
		final int y = location.getBlockY();
		final int z = location.getBlockZ();
		
		Block blockPlayer = player.getWorld().getBlockAt(x, y, z);
		Block block = blockPlayer.getFace(BlockFace.DOWN);
		
		if(block.getType() == Material.SAND || block.getType() == Material.DIRT) {
			block.setType(Material.GRASS);
		}
	}
	
	public void ironBoot(final Player player) {
		final Location location = player.getLocation();
		final int x = location.getBlockX();
		final int y = location.getBlockY();
		final int z = location.getBlockZ();
		
		Block blockPlayer = player.getWorld().getBlockAt(x, y, z);
		final Block block = blockPlayer.getFace(BlockFace.DOWN);
		final Material bm = block.getType();
		
		if(bm == Material.ICE) {
			return;
		}

		block.setType(Material.ICE);
		changeBack(block, bm);
	}
	
	public void goldBoot(final Player player) {
		final Location location = player.getLocation();
		final int x = location.getBlockX();
		final int y = location.getBlockY();
		final int z = location.getBlockZ();
		final String locString = x+":"+y+":"+z;
		
		final Block block = player.getWorld().getBlockAt(x, y, z);
		
		final Runnable checkLoc = new Runnable() {
			public void run() {
				String testLoc = playerLoc(player);
				
				if(!testLoc.equals(locString)) {
					block.setType(Material.FIRE);
				}
			}
		};
		
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, checkLoc, 20L);
	}
	
	public String playerLoc(Player player) {
		Location location = player.getLocation();
		int x = location.getBlockX();
		int y = location.getBlockY();
		int z = location.getBlockZ();
		
		return x+":"+y+":"+z;
	}
	
	public void changeBack(final Block block, final Material type) {
		final Runnable change = new Runnable() {
			public void run() {
				block.setType(Material.GLASS);
				block.setType(type);
			}
		};
		
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, change, 60L);
	}


}
