package retsrif.PowerBoots;

import java.io.File;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;

public class PowerBoots extends JavaPlugin {
	public PBPlayerListener pbpl = new PBPlayerListener(this);
	public PBEntityListener pbel = new PBEntityListener(this);
	public static boolean leatherBoots = true;
	public static boolean ironBoots = true;
	public static boolean goldBoots = true;
	public static boolean diamondBoots = true;

	@Override
	public void onDisable() {
		System.out.println("[Power Boots] disabled.");
	}

	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_MOVE, pbpl, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.ENTITY_DAMAGED, pbel, Event.Priority.Normal, this);
		
		/*Configuration config = getConfiguration();
		File configFile = new File("/plugins/Power Boots/config.yml");
		if(!configFile.exists()) {
			config.setProperty("leather-boots", true);
			config.setProperty("iron-boots", true);
			config.setProperty("gold-boots", true);
			config.setProperty("diamond-boots", true);
		}
		leatherBoots = config.getBoolean("leather-boots", true);
		ironBoots = config.getBoolean("iron-boots", true);
		goldBoots = config.getBoolean("gold-boots", true);
		diamondBoots = config.getBoolean("diamond-boots", true);
		
		config.save();
		*/
		
		System.out.println("[Power Boots] enabled.");
	}

}
