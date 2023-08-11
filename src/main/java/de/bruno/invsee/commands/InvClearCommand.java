package de.bruno.invsee.commands;

import java.util.Date;
import java.sql.Timestamp;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.bruno.invsee.main.Color;

public class InvClearCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (player.hasPermission("op")) {
				if (args.length==1) {
					
					Player target = Bukkit.getPlayer(args[1]);
					target.getInventory().clear();
					
					player.sendMessage(Color.GREEN+"Cleared Inventory of "+Color.ORANGE+target.getName());
					
					Date date = new Date();
					Timestamp ts = new Timestamp(date.getTime());
					
					System.out.println("[LOG] {"+ts+"} - "+player.getName()+" cleared Inventory of "+target.getName());
				
				} else player.sendMessage(Color.RED+"Please use "+Color.ORANGE+"/invclr <player> "+Color.RED+"!");
			} else player.sendMessage(Color.RED+"Missing Permissions!");
		}
		return false;
	}
}
