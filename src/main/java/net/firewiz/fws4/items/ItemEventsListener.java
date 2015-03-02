package net.firewiz.fws4.items;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.firewiz.fws4.FWS4;
import net.firewiz.fws4.chat.ChatManager;
import net.firewiz.fws4.data.DataInterface;

import org.bukkit.Material;
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
		ItemStack result = e.getInventory().getResult();
		Material resultMaterial = result.getType();
		if (Arrays.asList(DataInterface.crafted).contains(resultMaterial)) {
			Random r = new Random();
			Player p = (Player) e.getInventory().getHolder();
			ConfigurationSection craftSkill = FWS4.config
					.getConfigurationSection("craftSkill");
			if (craftSkill == null) {
				FWS4.config.createSection("craftSkill");
				craftSkill = FWS4.config.getConfigurationSection("craftSkill");
			}
			String playerID = p.getUniqueId().toString();
			ConfigurationSection playerSkills = craftSkill
					.getConfigurationSection(playerID);
			if (playerSkills == null) {
				craftSkill.createSection(playerID);
				playerSkills = craftSkill.getConfigurationSection(playerID);
			}

			String typeString = resultMaterial.toString().split("_")[1];
			int q = playerSkills.getInt(typeString);
			if (q == 0) {
				playerSkills.set(typeString, 1);
			}
			e.getInventory().setResult(
					ItemUtils.generateCraftedItem(q, resultMaterial));
			if (r.nextInt(100) < (Math.log(251 - q) * (251 - q))
					/ (252 * Math.log(252) / 100)) {
				q++;
				playerSkills.set(typeString, q);
				ChatManager.getInstance().sendMessage(0,
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
			if (im == null)
				return;
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
