package net.firewiz.fws4.gmMods;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class GMEventsListener implements Listener {
	@EventHandler(priority = EventPriority.HIGH)
	public void onCreatureSpawn(CreatureSpawnEvent e) {
		if (e.getEntityType() == EntityType.PIG_ZOMBIE) {
			if (e.getLocation().getWorld().getBlockAt(e.getLocation())
					.getLightLevel() > 7) {
				e.getEntity().remove();
				return;
			}
		}
	}
}
