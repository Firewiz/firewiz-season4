package net.firewiz.fws4.gmMods;

import java.util.ArrayList;

import net.firewiz.fws4.FWS4;
import net.firewiz.fws4.data.DataInterface;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

class TreeBreaker extends BukkitRunnable {

	static ArrayList<Location> breakingBlocks;
	static {
		breakingBlocks = new ArrayList<Location>();
	}

	Location l;
	ItemStack hand;
	World w;

	TreeBreaker(Location l, ItemStack hand, World w) {
		this.l = l;
		this.hand = hand;
		this.w = w;
	}

	@Override
	public void run() {
		l.getBlock().breakNaturally(hand);
		Location lb;
		int ax = -1, ay = -1, az = -1;
		for (ax = -1; ax < 2; ax++) {
			for (ay = -1; ay < 2; ay++) {
				for (az = -1; az < 2; az++) {
					lb = new Location(w, l.getX() + ax, l.getY() + ay, l.getZ()
							+ az);
					if (DataInterface.getItemData(w.getBlockAt(lb).getType()).isTree
							&& !breakingBlocks.contains(lb)) {
						(new TreeBreaker(lb, hand, w)).runTask(FWS4.instance);
					}
				}
			}
		}
		breakingBlocks.remove(l);
	}

}