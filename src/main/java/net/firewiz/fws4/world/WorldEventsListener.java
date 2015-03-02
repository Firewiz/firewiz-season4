package net.firewiz.fws4.world;

import net.firewiz.fws4.FWS4;

import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class WorldEventsListener implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerMove(PlayerMoveEvent e) {
		World world = e.getPlayer().getWorld();
		if (world.getBlockAt(e.getFrom()).getBiome() != world.getBlockAt(
				e.getTo()).getBiome()) {
			ConfigurationSection difficulty = FWS4.config
					.getConfigurationSection("difficulty");
			String biomeName = world.getBlockAt(e.getTo()).getBiome().name()
					.toLowerCase();
			int biomeLevel = difficulty.getInt(biomeName);
			e.getPlayer().sendMessage(
					"Entering a level " + biomeLevel + " biome!");
		}
	}
}
