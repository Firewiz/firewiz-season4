package net.firewiz.fws4.items;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.firewiz.fws4.FWS4;
import net.firewiz.fws4.data.CraftingData;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemEventsListener implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
	public void onEntityDeath(EntityDeathEvent evt) {
		if (evt.getEntity() instanceof LivingEntity) {
			evt.getDrops().addAll(ItemUtils.dropItemsFor(evt.getEntity()));
		}
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onCraftItem(CraftItemEvent e) {
		if (Arrays.asList(CraftingData.crafted).contains(
				e.getInventory().getResult().getType())) {
			Random r = new Random();
			Player p = (Player) e.getInventory().getHolder();
			ConfigurationSection craftSkill = FWS4.instance.getConfig()
					.getConfigurationSection("craftSkill");
			if (craftSkill == null) {
				FWS4.instance.getConfig().createSection("craftSkill");
				craftSkill = FWS4.instance.getConfig().getConfigurationSection(
						"craftSkill");
			}
			ConfigurationSection playerSkills = craftSkill
					.getConfigurationSection(p.getUniqueId().toString());
			if (playerSkills == null) {
				craftSkill.createSection(p.getUniqueId().toString());
				playerSkills = craftSkill.getConfigurationSection(p
						.getUniqueId().toString());
			}

			int q = playerSkills.getInt(e.getInventory().getResult().getType()
					.toString().split("_")[1]);
			if (q == 0) {
				playerSkills.set(e.getInventory().getResult().getType()
						.toString().split("_")[1], 1);
			}
			e.getInventory().setResult(
					ItemUtils.generateCraftedItem(q, e.getInventory()
							.getResult().getType()));
			if (r.nextInt(100) < (Math.log(251 - q) * (251 - q))
					/ (252 * Math.log(252) / 100)) {
				q++;
				playerSkills.set(e.getInventory().getResult().getType()
						.toString().split("_")[1], q);
				FWS4.chatManager.sendMessage(0,
						"§9Your skill has increased to " + q, p);
			}
			FWS4.instance.saveConfig();
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onBlockBreak(BlockBreakEvent e) {
		if (e.getPlayer() != null) {
			ItemStack hand = e.getPlayer().getItemInHand();
			e.getPlayer().setItemInHand(ItemUtils.damageItem(hand));
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onEntityDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			for (int i = 0; i < 4; i++) {
				p.getInventory().getArmorContents()[i] = ItemUtils.damageItem(p
						.getInventory().getArmorContents()[i]);
			}
		}
		if (e instanceof EntityDamageByEntityEvent) {
			if (((EntityDamageByEntityEvent) e).getDamager() instanceof Player) {
				Player p = (Player) ((EntityDamageByEntityEvent) e)
						.getDamager();
				ItemStack hand = p.getItemInHand();
				p.setItemInHand(ItemUtils.damageItem(hand));
			}
		}
	}
	
	public void onInventoryClick(InventoryClickEvent e) {
		if (!(e.getInventory() instanceof PlayerInventory)) {
			ItemStack i = e.getCurrentItem();
			ItemMeta im = i.getItemMeta();
			if(im == null) return;
			if (im.hasLore()) {
				List<String> l = im.getLore();
				while (l.contains("§6Equipped"))
					l.remove("§6Equipped");
				im.setLore(l);
				i.setItemMeta(im);
			}
		}
	}
}
