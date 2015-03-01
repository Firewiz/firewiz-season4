package net.firewiz.fws4;

import java.util.LinkedList;
import java.util.List;

import net.firewiz.fws4.items.Stats;
import net.firewiz.fws4.items.StatsList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCommandExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (!(sender instanceof Player))
			return false;
		Player p = (Player) sender;
		switch (label.toLowerCase()) {
		case "craftstats":
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
			for (String s : playerSkills.getKeys(false)) {
				int q = playerSkills.getInt(s);
				p.sendMessage("Skill in " + s + ": " + q);
				ConfigurationSection items = FWS4.instance.getConfig()
						.getConfigurationSection("items");
				ConfigurationSection matBonuses = items
						.getConfigurationSection("matBonuses");
				ConfigurationSection qfinalcfg = items
						.getConfigurationSection("q_final");
				for (int i : new int[] { matBonuses.getInt("wood"),
						matBonuses.getInt("stone"), matBonuses.getInt("iron"),
						matBonuses.getInt("gold"), matBonuses.getInt("diamond") }) {
					String msg = "";
					int q_base = (int) ((Math.log(q) * q) / (3 * Math.log(300)))
							+ i;
					char cc;
					for (int j = 0; j < 25; j++) {
						if (q_base + j < qfinalcfg.getInt("poor"))
							cc = '7';
						else if (q_base + j < qfinalcfg.getInt("common"))
							cc = 'f';
						else if (q_base + j < qfinalcfg.getInt("uncommon"))
							cc = '2';
						else if (q_base + j < qfinalcfg.getInt("rare"))
							cc = '1';
						else if (q_base + j < qfinalcfg.getInt("epic"))
							cc = '5';
						else
							cc = '6';
						msg += "§" + cc + "|||";
					}
					p.sendMessage(msg);
				}
			}
			return true;
		case "equip":
			if (p.getItemInHand().getType().toString().split("_").length < 1)
				return true;
			String type = p.getItemInHand().getType().toString().split("_")[1];
			for (ItemStack i : p.getInventory()) {
				if (i == null)
					continue;
				if (i.getType().toString().split("_").length > 1
						&& (i.getType().toString().split("_")[1]
								.equalsIgnoreCase(type))) {
					ItemMeta im = i.getItemMeta();
					if (im.hasLore()) {
						List<String> l = im.getLore();
						while (l.contains("§6Equipped"))
							l.remove("§6Equipped");
						im.setLore(l);
						i.setItemMeta(im);
					}
				}
			}
			ItemMeta im = p.getItemInHand().getItemMeta();
			if (!im.hasLore()) {
				im.setLore(new LinkedList<String>());
			}
			List<String> l = im.getLore();
			l.add("§6Equipped");
			im.setLore(l);
			p.getItemInHand().setItemMeta(im);
			Stats.invalidateStats(p);
			Stats.applyStats(p);
			StatsList sl = Stats.getStatsFor(p);
			p.sendMessage("New stats:");
			p.sendMessage(new String[] { "Strength: " + sl.strength,
					"Stamina: " + sl.stamina, "Agility: " + sl.agility,
					"Attack Power: " + sl.power, "Spirit: " + sl.spirit,
					"Haste: " + sl.haste, "Protection: " + sl.prot,
					"Fire Resistance:" + sl.fire, "Regeneration: " + sl.regen });
			return true;
		}
		return false;
	}
}
