package net.firewiz.fws4.commands;

import net.firewiz.fws4.FWS4;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class CraftStatsCommandExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (!(sender instanceof Player))
			return false;
		Player p = (Player) sender;
		ConfigurationSection craftSkill = FWS4.config
				.getConfigurationSection("craftSkill");
		if (craftSkill == null) {
			FWS4.config.createSection("craftSkill");
			craftSkill = FWS4.config.getConfigurationSection(
					"craftSkill");
		}
		String playerID = p.getUniqueId().toString();
		ConfigurationSection playerSkills = craftSkill
				.getConfigurationSection(playerID);
		if (playerSkills == null) {
			craftSkill.createSection(playerID);
			playerSkills = craftSkill.getConfigurationSection(playerID);
		}
		for (String s : playerSkills.getKeys(false)) {
			int q = playerSkills.getInt(s);
			p.sendMessage("Skill in " + s + ": " + q);
			ConfigurationSection items = FWS4.config
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
	}

}
