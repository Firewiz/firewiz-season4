package net.firewiz.fws4.commands;

import net.firewiz.fws4.FWS4;
import net.firewiz.fws4.chat.ChatChannel;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ListCommandExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		for (ChatChannel c : FWS4.chatManager.getChannels()) {
			sender.sendMessage("§a" + c.getChannelID() + ": "
					+ c.getChannelName());
		}
		return true;
	}

}
