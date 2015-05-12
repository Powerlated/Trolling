package io.github.powerlated.effects;

import io.github.powerlated.Main;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class LiftOnJump implements Listener {

	Vector v1 = new Vector(0.0D, 0.41D, 0.0D);
	Vector v2 = new Vector(0.0D, 0.45D, 0.0D);

	@EventHandler
	public void liftOnJump(PlayerMoveEvent event) throws InterruptedException {
		Vector v = event.getPlayer().getVelocity();
		if ((this.v1.getY() < v.getY()) && (this.v2.getY() > v.getY())
				&& (Main.lift.contains(event.getPlayer()))) {
			Location loc = event.getPlayer().getLocation();
			Block b = loc.getBlock();
			if ((b.getType() == Material.STATIONARY_WATER)
					|| (b.getType() == Material.WATER)) {
				return;
			}
			event.getPlayer().setVelocity(new Vector(0, 10, 0));
			Main.lift.remove(event.getPlayer());
		}
	}
}