package de.bruno.invsee.main;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public static Main plugin;

	
	public void onEnable() {
		plugin = this;
		
		
		
		System.out.println("[LOG] - InvSee Plugin loaded successfully");
	}
	
	
	public void onDisable() {
		System.out.println("[LOG] - InvSee Plugin unload");
	}
	
	public static Main getPlugin() {
		return plugin;
	}
}
