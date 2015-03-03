package net.firewiz.fws4.gmMods;

import net.firewiz.fws4.FWS4;
import net.firewiz.fws4.data.DataInterface;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
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

	@EventHandler(priority = EventPriority.HIGH)
	public void onBlockBreak(BlockBreakEvent e) {
		boolean isTree = DataInterface.getItemData(e.getBlock().getType()).isTree;
		boolean hasItemName = e.getPlayer().getItemInHand().getType().name()
				.split("_").length > 0;
		if (isTree
				&& hasItemName
				&& e.getPlayer().getItemInHand().getType().name().split("_")[1]
						.equalsIgnoreCase("axe")) {
			FWS4.instance.getLogger().info(
					"Breaking tree at " + e.getBlock().getLocation()); // DEBUG
			(new TreeBreaker(e.getBlock().getLocation(), e.getPlayer()
					.getItemInHand())).runTask(FWS4.instance);
		}
	}
}
