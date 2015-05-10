package io.github.powerlated;

import io.github.powerlated.effects.LiftOnJump;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public final class Troll extends org.bukkit.plugin.java.JavaPlugin {
	public static HashSet<Player> lift = new HashSet<Player>();
	private Block bl;

	public void onEnable() {
		getServer().getPluginManager().registerEvents(new LiftOnJump(), this);
	}

	public void onDisable() {
	}

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
				if (cos == false) {
					return true;
				}
				Player player = Bukkit.getServer().getPlayer(args[1]);
				Location l = player.getLocation();
				player.sendMessage(ChatColor.RED + "Look up!");
				Block bl = l.getBlock();
				l = l.add(new Vector(0, 30, 0));
				Block b = l.getBlock();
				b.setType(Material.ANVIL, true);
				return true;
			} else if (args[0].equalsIgnoreCase("hj")) {
				if (args.length == 2) {
					Player player = Bukkit.getPlayerExact(args[1]);
					boolean cos = CheckOnlineStatus.check(sender, args, 1);
					if (!cos) {
						return true;
					}
					lift.add(player);
					sender.sendMessage(ChatColor.GRAY + "The next time "
							+ args[1] + " jumps, his character will be lifted");
				}
				return true;
			} else if (args[0].equalsIgnoreCase("dp")) {

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
			+ "anvil - Drops an anvil on the player\n" + "dc - Makes every single block the player clicks on drop dirt");

	private void help(CommandSender sender) {
		if (sender instanceof Player) {
			sender.sendMessage(helpMessage);
		} else {
			System.out.println(helpMessage);
		}
	}

}
