package net.firewiz.fws4.combat;

import net.firewiz.fws4.FWS4;
import net.firewiz.fws4.items.ItemUtils;
import net.firewiz.fws4.stats.Stats;
import net.firewiz.fws4.stats.StatsList;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class CombatEventsListener implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void onCreatureSpawn(CreatureSpawnEvent e) {
		int biomeLevel = FWS4.instance
				.getConfig()
				.getConfigurationSection("difficulty")
				.getInt(e.getEntity().getWorld()
						.getBlockAt(e.getEntity().getLocation()).getBiome()
						.name().toLowerCase());
		int creatureLevel = (int) ItemUtils.triangular(
				(biomeLevel > 5) ? biomeLevel - 5 : 0, biomeLevel + 5,
				biomeLevel);
		double cStatsMultiplier = Math.pow(2, (creatureLevel - 50) / 100.0);
		e.getEntity().setMaxHealth(
				e.getEntity().getMaxHealth() * cStatsMultiplier);
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onEntityDamage(EntityDamageEvent evt) {
		if (evt.getEntity() instanceof LivingEntity) {
			if (evt instanceof EntityDamageByEntityEvent) {
				EntityDamageByEntityEvent evt2 = (EntityDamageByEntityEvent) evt;

				Entity source = evt2.getDamager();
				Entity target = evt2.getEntity();

				if (source instanceof Projectile) {
					Projectile a = (Projectile) source;
					source = (Entity) a.getShooter();
				}

				if (source instanceof Player) {
					Player p = (Player) source;
					StatsList l = Stats.getStatsFor(p);
					int f_str = (int) (l.strength + l.power);

					int percent = (int) (0.0000000015 * Math.pow(f_str, 4)
							- 0.0000012795 * Math.pow(f_str, 3) + 0.0004479362
							* Math.pow(f_str, 2) + 0.079798914 * f_str + 0.2372116715);
					double d_mult = 1 + (percent / 100.0);
					evt.setDamage(evt.getDamage() * d_mult);

					FWS4.chatManager.sendMessage(0, "§c» §7Your attack hit "
							+ ((target instanceof Player) ? target.getName()
									: "the " + target.getType()) + " for "
							+ (int) evt.getFinalDamage(), p);

				}
				if (target instanceof Player) {
					Player p = (Player) target;
					FWS4.chatManager.sendMessage(0, "§c« §7You were hit by "
							+ ((source instanceof Player) ? source.getName()
									: "the " + source.getType()) + " for "
							+ (int) evt.getFinalDamage(), p);
				}
			}
		}
	}
}
