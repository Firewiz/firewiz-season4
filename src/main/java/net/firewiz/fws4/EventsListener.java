package net.firewiz.fws4;

import java.util.logging.Level;

import net.firewiz.fws4.items.Stats;
import net.firewiz.fws4.items.StatsList;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class EventsListener implements Listener {

	Plugin pl;

	EventsListener(Plugin p) {
		pl = p;
	}

	@EventHandler(
			priority = EventPriority.NORMAL)
	public void onCreatureSpawn(CreatureSpawnEvent evt) {
		if (evt.getEntityType() == EntityType.PIG_ZOMBIE) {
			if (evt.getLocation().getWorld().getBlockAt(evt.getLocation())
					.getLightLevel() > 7) {
				evt.getEntity().remove();
				return;
			}
		}
		HealthBar.addHealthBar((LivingEntity) evt.getEntity(), evt.getEntity()
				.getHealth());
	}

	@EventHandler(
			priority = EventPriority.NORMAL)
	public void onEntityDeath(EntityDeathEvent evt) {
		if (evt.getEntity() instanceof LivingEntity) {
			LivingEntity entity = (LivingEntity) evt.getEntity();
			HealthBar.removeHealthBar(entity);
		}
	}

	@EventHandler(
			priority = EventPriority.NORMAL)
	public void onEntityDamage(EntityDamageEvent evt) {
		if (evt.getEntity() instanceof LivingEntity) {
			LivingEntity entity = (LivingEntity) evt.getEntity();
			HealthBar.addHealthBar(entity,
					entity.getHealth() - evt.getFinalDamage());
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

	class ItemDeleter extends BukkitRunnable {
		Item item;

		ItemDeleter(Item e) {
			item = e;
		}

		@Override
		public void run() {
			item.remove();
		}

	}

	@EventHandler(
			priority = EventPriority.NORMAL)
	public void onEntityRegainHealth(EntityRegainHealthEvent evt) {
		if (evt.getEntity() instanceof LivingEntity) {
			LivingEntity e = (LivingEntity) evt.getEntity();
			HealthBar.addHealthBar(
					e,
					(e.getHealth() + evt.getAmount() >= e.getMaxHealth()) ? e
							.getMaxHealth() : e.getHealth() + evt.getAmount());
		}
	}

	@EventHandler(
			priority = EventPriority.NORMAL)
	public void onVehicleExit(VehicleExitEvent e) {
		if (e.getExited().getType() == EntityType.DROPPED_ITEM) {
			e.setCancelled(true);
			e.getVehicle().setPassenger(e.getExited());
		}
	}

	@EventHandler(
			priority = EventPriority.NORMAL)
	public void onPlayerJoin(PlayerJoinEvent e) {
		HealthBar.addHealthBar(e.getPlayer(), e.getPlayer().getHealth());
		try {
			FWS4.chatManager.joinChannel(0, e.getPlayer());
			FWS4.chatManager.joinChannel(1, e.getPlayer());
			FWS4.chatManager.joinChannel(2, e.getPlayer());
		} catch (NonexistentChannelException e1) {
			FWS4.instance.getLogger().log(Level.SEVERE,
					"Can't happen at onPlayerJoin");
		}
		Stats.applyStats(e.getPlayer());
	}

	@EventHandler(
			priority = EventPriority.NORMAL)
	public void onPlayerQuit(PlayerQuitEvent e) {
		HealthBar.removeHealthBar(e.getPlayer());
		FWS4.chatManager.leaveAllChannels(e.getPlayer());
	}

	@EventHandler(
			priority = EventPriority.NORMAL)
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (p.getMetadata("ChatChannel").size() == 0) {
			p.setMetadata("ChatChannel", new FixedMetadataValue(FWS4.instance,
					1));
		}
		FWS4.chatManager.sendMessage(p.getMetadata("ChatChannel").get(0)
				.asInt(), "[" + p.getName() + "] " + e.getMessage(), p);
		e.setCancelled(true);
	}

//	@EventHandler(
//			priority = EventPriority.NORMAL)
//	public void onItemDespawn(ItemDespawnEvent e) {
//		if (e.getEntity().getItemStack().getType() == Material.BEDROCK) {
//			e.setCancelled(true);
//		}
//	}
}