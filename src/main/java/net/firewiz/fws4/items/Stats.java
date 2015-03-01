package net.firewiz.fws4.items;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Stats {
	static HashMap<Player, StatsList> cache;
	static {
		cache = new HashMap<Player, StatsList>();
	}

	public static StatsList getStatsFor(Player p) {
		if (cache.containsKey(p)) {
			return cache.get(p);
		} else {
			recalcStats(p);
			return cache.get(p);
		}
	}

	private static void recalcStats(Player p) {
		int base = p.getLevel() * 3; // TODO: add proper eqn
		StatsList l = new StatsList();
		l.agility = base;
		l.fire = 0;
		l.haste = 0;
		l.power = base;
		l.prot = 0;
		l.regen = 0;
		l.spirit = base;
		l.stamina = base;
		l.strength = base;

		for (ItemStack i : p.getInventory()) {
			if (i == null) continue;
			List<String> lore = i.getItemMeta().getLore();
			if (lore == null) lore = new LinkedList<String>();
			if (lore.contains("§6Equipped")) {
				for (String s : lore) {
					if (s.contains("%")) {
						int percent = Integer.parseInt(s.split("%")[0]);
						double mul = 1 + (percent / 100.0);
						if (s.contains("Strength")) {
							l.strength *= mul;
						} else if (s.contains("Stamina")) {
							l.stamina *= mul;
						} else if (s.contains("Agility")) {
							l.agility *= mul;
						} else if (s.contains("Attack Power")) {
							l.power *= mul;
						} else if (s.contains("Spirit")) {
							l.spirit *= mul;
						}
					}
					if (s.contains("Haste")) {
						l.haste++;
					} else if (s.contains("Resistance")) {
						l.prot++;
					} else if (s.contains("Fire Resistance")) {
						l.fire++;
					} else if (s.contains("Regeneration")) {
						l.regen++;
					}
				}
			}
		}
		cache.put(p, l);
	}

	public static void applyStats(Player p) {
		StatsList l = getStatsFor(p);
		int hp = 6;
		double speed = 0.7;

		if (l.stamina > 30) hp++;
		if (l.stamina > 50) hp++;
		if (l.stamina > 70) hp++;
		if (l.stamina > 95) hp++;
		if (l.stamina > 130) hp++;
		if (l.stamina > 170) hp++;
		if (l.stamina > 230) hp++;
		if (l.stamina > 280) hp++;
		if (l.stamina > 290) hp++;

		speed = (l.agility * 0.037037037 / 100) + 1;

		p.setMaxHealth(hp * 2);
		p.setWalkSpeed(0.2f * (float) speed);

		p.removePotionEffect(PotionEffectType.FAST_DIGGING);
		p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
		p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
		p.removePotionEffect(PotionEffectType.REGENERATION);
		p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);

		if (l.haste > 0)
			p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,
					Integer.MAX_VALUE, (int) l.haste - 1, true, false));
		if (l.prot > 0)
			p.addPotionEffect(new PotionEffect(
					PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE,
					(int) l.prot - 1, true, false));
		if (l.fire > 0)
			p.addPotionEffect(new PotionEffect(
					PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE,
					(int) l.fire - 1, true, false));
		if (l.regen > 0)
			p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,
					Integer.MAX_VALUE, (int) l.regen - 1, true, false));
	}

	public static void invalidateStats(Player p) {
		cache.remove(p);
	}
}
