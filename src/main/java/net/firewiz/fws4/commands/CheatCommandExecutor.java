package net.firewiz.fws4.commands;

import net.firewiz.fws4.items.ItemUtils;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CheatCommandExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		((Player) sender).getInventory().addItem(
				ItemUtils.generateCraftedItem(Integer.parseInt(args[0]),
						Material.valueOf(Material.class, args[1])));
		return true;
	}

}
