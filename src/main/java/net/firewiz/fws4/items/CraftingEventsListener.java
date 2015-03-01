package net.firewiz.fws4.items;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.firewiz.fws4.FWS4;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class CraftingEventsListener implements Listener {
	static Material[] crafted = { Material.CHAINMAIL_BOOTS,
			Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_HELMET,
			Material.CHAINMAIL_LEGGINGS, Material.DIAMOND_AXE,
			Material.DIAMOND_BOOTS, Material.DIAMOND_CHESTPLATE,
			Material.DIAMOND_HELMET, Material.DIAMOND_LEGGINGS,
			Material.DIAMOND_PICKAXE, Material.DIAMOND_SPADE,
			Material.DIAMOND_SWORD, Material.GOLD_AXE, Material.GOLD_BOOTS,
			Material.GOLD_CHESTPLATE, Material.GOLD_HELMET,
			Material.GOLD_LEGGINGS, Material.GOLD_PICKAXE, Material.GOLD_SPADE,
			Material.GOLD_SWORD, Material.IRON_AXE, Material.IRON_BOOTS,
			Material.IRON_CHESTPLATE, Material.IRON_HELMET,
			Material.IRON_LEGGINGS, Material.IRON_PICKAXE, Material.IRON_SPADE,
			Material.IRON_SWORD, Material.LEATHER_BOOTS,
			Material.LEATHER_CHESTPLATE, Material.LEATHER_HELMET,
			Material.LEATHER_LEGGINGS, Material.STONE_AXE,
			Material.STONE_PICKAXE, Material.STONE_SPADE, Material.STONE_SWORD,
			Material.WOOD_AXE, Material.WOOD_PICKAXE, Material.WOOD_SPADE,
			Material.WOOD_SWORD };

	@EventHandler(priority = EventPriority.NORMAL)
	public void onCraftItem(CraftItemEvent e) {
		if (Arrays.asList(crafted).contains(
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
