package io.github.powerlated;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CheckOnlineStatus {
	public static boolean check(CommandSender sender, String[] args, int array) {
		Player player = Bukkit.getPlayerExact(args[array]);
		if (player == null) {
			if (sender instanceof Player) {
				sender.sendMessage(ChatColor.RED + "Error: "
						+ args[1] + " is not online");
				return false;
			} else {
				System.out.println(ChatColor.RED + "Error: "
						+ args[1] + " is not online");
				return false;	
			}
		}
		return true;
	}
}
