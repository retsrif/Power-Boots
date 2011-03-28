package retsrif.PowerBoots;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class PBEntityListener extends EntityListener {
	public static PowerBoots plugin;
	
	public PBEntityListener(PowerBoots instance) {
		plugin = instance;
	}
	
	//Thanks to ssell for this!
	public void onEntityDamage(EntityDamageEvent event)
	 {
	        Entity entity = event.getEntity( );

	        if(entity instanceof Player)
	        {
	            Player player = (Player)entity;

	            if(event.getCause() == DamageCause.FALL)
	            {
	                if(player.getInventory().getBoots().getType( ) == Material.DIAMOND_BOOTS)
	                {
	                    event.setCancelled(true);
	                }
	            }
	        }
	}
}
