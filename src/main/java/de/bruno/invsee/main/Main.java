package de.bruno.invsee.main;

import java.sql.Timestamp;
import java.util.Date;

import org.bukkit.plugin.java.JavaPlugin;

import de.bruno.invsee.commands.InvClearCommand;
import de.bruno.invsee.commands.InvSeeCommand;

public class Main extends JavaPlugin {
	public static Main plugin;

	
	public void onEnable() {
		plugin = this;
		
		getCommand("invsee").setExecutor(new InvSeeCommand());
		getCommand("invclr").setExecutor(new InvClearCommand());
		
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		
		System.out.println("[LOG] {"+ts+"} - InvSee Plugin loaded successfully");
	}
	
	
	public void onDisable() {
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		
		System.out.println("[LOG] {"+ts+"} - InvSee Plugin unload");
	}
	
	public static Main getPlugin() {
		return plugin;
	}
}
