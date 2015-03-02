package net.firewiz.fws4.commands;

import java.util.ArrayList;

import net.firewiz.fws4.FWS4;
import net.firewiz.fws4.chat.ChatChannel;
import net.firewiz.fws4.chat.ChatManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public class ChannelCommandExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (!(sender instanceof Player))
			return false;
		Player p = (Player) sender;
		if (args.length != 1) {
			return false;
		}
		try {
			int c = Integer.parseInt(args[0]);
			ArrayList<ChatChannel> channelList = ChatManager.getInstance()
					.getChannels();
			if (c < 1) {
				sender.sendMessage("§cNo talking in the combat log!");
				return true;
			} else if (c >= channelList.size()) {
				sender.sendMessage("§cThis channel doesn't exist!");
				return true;
			}
			p.setMetadata("ChatChannel", new FixedMetadataValue(FWS4.instance,
					c));
			p.sendMessage("§6Now talking in " + c + ": "
					+ channelList.get(c).getChannelName());
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
