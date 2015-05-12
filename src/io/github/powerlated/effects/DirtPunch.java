package io.github.powerlated.effects;

import io.github.powerlated.Main;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
public class DirtPunch implements Listener {


	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent event) {
		if ((Main.dirtPunch.contains(event.getPlayer()) && event.getAction() == Action.LEFT_CLICK_BLOCK)) {
			if ((event.getClickedBlock().getType() == Material.RED_ROSE)
			   || (event.getClickedBlock().getType() == Material.YELLOW_FLOWER) || (event.getClickedBlock().getType() == Material.BEDROCK)
			   || (event.getClickedBlock().getType() == Material.LONG_GRASS) || (event.getClickedBlock().getType() == Material.CHEST) || (event.getClickedBlock().getType() == Material.DOUBLE_PLANT)) {
				return;
			}
			event.getClickedBlock().setType(Material.DIRT);
		}
	}
}
