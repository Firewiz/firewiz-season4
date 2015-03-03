package net.firewiz.fws4.gmMods;

import java.util.ArrayList;

import net.firewiz.fws4.FWS4;
import net.firewiz.fws4.data.DataInterface;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

class TreeBreaker extends BukkitRunnable {

	static ArrayList<Location> breakingBlocks;
	static {
		breakingBlocks = new ArrayList<Location>();
	}

	Location l;
	ItemStack hand;

	TreeBreaker(Location l, ItemStack hand) {
		this.l = l;
		this.hand = hand;
	}

	@Override
	public void run() {
		l.getBlock().breakNaturally(hand);
		int ax = -1, ay = -1, az = -1;
		for (; ax < 2; ax++) {
			for (; ay < 2; ay++) {
				for (; az < 2; az++) {
					if (DataInterface.getItemData(l.add(ax, ay, az).getBlock()
							.getType()).isTree
							&& !breakingBlocks.contains(l.add(ax, ay, az))) {
						(new TreeBreaker(l.add(ax, ay, az), hand))
								.runTask(FWS4.instance);
					}
				}
			}
		}
	}

}