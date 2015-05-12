package io.github.powerlated;

import io.github.powerlated.effects.Explode;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Commands implements CommandExecutor {
	
	public Commands(Main main) {
    }

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("troll")) {
			if (args.length == 0) {
				// Tells command usage
				usage(sender);
				return true;
			}

			if (args[0].equalsIgnoreCase("anvil")) {
				boolean cos = CheckOnlineStatus.check(sender, args, 1);
				if (!checkLength(args, 2)) {
					usage(sender);
					return true;
				}
				if (cos == false) {
					return true;
				}
				Player player = Bukkit.getServer().getPlayer(args[1]);
				Location l = player.getLocation();
				player.sendMessage(ChatColor.RED + "Look up!");
				l = l.add(new Vector(0, 30, 0));
				Block b = l.getBlock();
				b.setType(Material.ANVIL, true);
				return true;
			} else if (args[0].equalsIgnoreCase("hj")) {
				if (!checkLength(args, 2)) {
					return true;
				}
				
				boolean cos = CheckOnlineStatus.check(sender, args, 1);
				if (!cos) {
					return true;
				}
				Main.lift.add(Bukkit.getPlayerExact(args[1]));
				sender.sendMessage(ChatColor.GRAY + "The next time " + args[1]
						+ " she/he will be lifted into the air");

				return true;
			} else if (args[0].equalsIgnoreCase("dp")) {
				if (args.length == 3) {
					if (args[2].equalsIgnoreCase("stop")) {
						Main.dirtPunch.remove(Bukkit.getServer().getPlayer(args[1]));
						sender.sendMessage(ChatColor.GRAY + "Troll stopped for " + args[1]);
						return true;
					}
				}
				if (!checkLength(args, 2)) {
					usage(sender);
					return true;
				}
				if (!CheckOnlineStatus.check(sender, args, 1)) {
					return true;
				}
				sender.sendMessage(ChatColor.GRAY + "When " + args[1]
						+ " left clicks blocks now, they will turn to dirt");
				Main.dirtPunch.add(Bukkit.getPlayerExact(args[1]));
				return true;
			}
			if (args[0].equalsIgnoreCase("explode")) {
				if (!CheckOnlineStatus.check(sender, args, 1)) {
					return true;
				}
				Explode.explode(Bukkit.getPlayer(args[1]));
				sender.sendMessage(ChatColor.GRAY + "F3 + A to stop the lag!");
				return true;
			}
			if (args[0].equalsIgnoreCase("help")) {
				help(sender);
				return true;
			}
			// Tells command usage
			usage(sender);
		}

		return true;
	}

	private void usage(CommandSender sender) {
		if ((sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED
					+ "Usage: /troll <type/help> <player> [parameters]");
		} else {
			System.out
					.println("Usage: /troll <type/help> <player> [parameters]");
		}
	}

	// Pops up when you do /troll help
	// Vanilla styling all the way!

	String helpMessage = (ChatColor.DARK_GREEN
			+ "--- Showing help page 1 out of 1 (/troll help <page> ---\n"
			+ ChatColor.WHITE
			+ "hj - Makes the player jump really high, ONCE\n"
			+ "anvil - Drops an anvil on the player\n" 
			+ "dp - Makes every single block the player clicks on drop dirt\n" 
			+ "    - parameter: stop - Stops the troll"
			+ "explosion - Like 100 TNT minecarts, WITH FIRE!");

	private void help(CommandSender sender) {
		if (sender instanceof Player) {
			sender.sendMessage(helpMessage);
		} else {
			System.out.println(helpMessage);
		}
	}

	private boolean checkLength(String[] args, int length) {
		if (args.length == length) {
			return true;
		} else
			return false;
	}

}
