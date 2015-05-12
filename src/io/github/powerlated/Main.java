package io.github.powerlated;

import io.github.powerlated.effects.DirtPunch;
import io.github.powerlated.effects.LiftOnJump;

import java.util.HashSet;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
	public static HashSet<Player> lift = new HashSet<Player>();
	public static HashSet<Player> dirtPunch = new HashSet<Player>();

	public void onEnable() {
		getServer().getPluginManager().registerEvents(new LiftOnJump(), this);
		getServer().getPluginManager().registerEvents(new DirtPunch(), this);
	}

	public void onDisable() {
	}
}
