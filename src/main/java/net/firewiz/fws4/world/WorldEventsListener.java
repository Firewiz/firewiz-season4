package net.firewiz.fws4.world;

import net.firewiz.fws4.FWS4;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class WorldEventsListener implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerMove(PlayerMoveEvent e) {
		if (e.getPlayer().getWorld().getBlockAt(e.getFrom()).getBiome() != e
				.getPlayer().getWorld().getBlockAt(e.getTo()).getBiome()) {
			int biomeLevel = FWS4.instance
					.getConfig()
					.getConfigurationSection("difficulty")
					.getInt(e.getPlayer().getWorld().getBlockAt(e.getTo())
							.getBiome().name().toLowerCase());
			e.getPlayer().sendMessage(
					"Entering a level " + biomeLevel + " biome!");
		}
	}
}
