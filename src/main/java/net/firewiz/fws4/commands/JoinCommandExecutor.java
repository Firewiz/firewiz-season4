package net.firewiz.fws4.commands;

import net.firewiz.fws4.FWS4;
import net.firewiz.fws4.chat.NonexistentChannelException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinCommandExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (!(sender instanceof Player))
			return false;
		if (args.length != 1) {
			return false;
		}
		try {
			FWS4.chatManager.joinChannel(Integer.parseInt(args[0]),
					(Player) sender);
		} catch (NumberFormatException e) {
			return false;
		} catch (NonexistentChannelException e) {
			sender.sendMessage("§cThis channel doesn't exist!");
			return true;
		}
		return true;
	}

}
