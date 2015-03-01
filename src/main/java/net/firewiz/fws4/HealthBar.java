package net.firewiz.fws4;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

public class HealthBar {

	static int bar_length = 20;

	// TODO: make less buggy and re-enable.
	
	static void addHealthBar(LivingEntity e, double d) {

		return;
		
//		if (e.getPassenger() == null
//				|| e.getPassenger().getType() != EntityType.DROPPED_ITEM) {
//			e.eject();
//			Location l = e.getLocation();
//			Item i = e.getWorld().dropItem(l,
//					new ItemStack(Material.BEDROCK, 0));
//			e.setPassenger(i);
//		}
//
//		Item item = (Item) e.getPassenger();
//
//		String n = new String();
//
//		n += "§" + EntityStaticData.getData(e.getType()).healthBarColor + "["
//				+ (int) d + "/" + (int) e.getMaxHealth() + "] ";
//		int barsFilled = (int) ((d / e.getMaxHealth()) * bar_length);
//
//		for (int i = 0; i < bar_length; i++) {
//			n += "|";
//			if (i == barsFilled) {
//				n += "§8";
//			}
//		}
//
//		item.setCustomName(n);
//		item.setCustomNameVisible(true);
	}

	static void removeHealthBar(LivingEntity e) {
		Entity i = e.getPassenger();
		if (i == null) return;
		e.eject();
		i.remove();
	}
}
