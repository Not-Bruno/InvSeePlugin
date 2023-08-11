package de.bruno.invsee.commands;

import java.sql.Timestamp;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import de.bruno.invsee.main.Color;

public class InvSeeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (player.hasPermission("op")) {
				if (args.length==1) {
					
					Player target = Bukkit.getPlayer(args[1]);
					Inventory invTarget = target.getInventory();
					player.openInventory(invTarget);
					
					player.sendMessage(Color.GREEN+"Inventory of player "+Color.ORANGE+target.getName());
					
					Date date = new Date();
					Timestamp ts = new Timestamp(date.getTime());
					
					System.out.println("[LOG] {"+ts+"} - "+player.getName()+" opened Inventory of "+target.getName());
					
				} else player.sendMessage(Color.RED+"Please use "+Color.ORANGE+"/invsee <player> "+Color.RED+"!");
			} else player.sendMessage(Color.RED+"Missing Permissions!");
		}
		return false;
	}
}
