package net.firewiz.fws4.commands;

import java.util.LinkedList;
import java.util.List;

import net.firewiz.fws4.items.ItemUtils;
import net.firewiz.fws4.stats.Stats;
import net.firewiz.fws4.stats.StatsList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EquipCommandExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player p = (Player) sender;
		if (p.getItemInHand().getType().toString().split("_").length < 1)
			return true;
		String type = p.getItemInHand().getType().toString().split("_")[1];
		for (ItemStack i : p.getInventory()) {
			ItemUtils.stripEquipped(type, i);
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
}
