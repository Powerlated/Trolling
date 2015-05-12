package io.github.powerlated.effects;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Explode {
	public static void explode(Player player) {
		Location l = player.getLocation();
		int e = 1;
		while (e != 10) {
			player.getWorld().createExplosion(l, (float) 20, true);
			e++;
		}
		return;
	}
}
