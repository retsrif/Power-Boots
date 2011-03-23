package retsrif.PowerBoots;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PowerBoots extends JavaPlugin {
	public PBPlayerListener pbpl = new PBPlayerListener(this);

	@Override
	public void onDisable() {
		System.out.println("[Power Boots] disabled.");
	}

	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvent(Event.Type.PLAYER_MOVE, pbpl, Event.Priority.Normal, this);
		System.out.println("[Power Boots] enabled.");
	}

}
