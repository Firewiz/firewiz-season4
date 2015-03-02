package net.firewiz.fws4.commands;

import net.firewiz.fws4.FWS4;

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
			if (c < 1) {
				sender.sendMessage("§cNo talking in the combat log!");
				return true;
			} else if (c >= FWS4.chatManager.getChannels().size()) {
				sender.sendMessage("§cThis channel doesn't exist!");
				return true;
			}
			p.setMetadata("ChatChannel", new FixedMetadataValue(FWS4.instance,
					c));
			p.sendMessage("§6Now talking in " + c + ": "
					+ FWS4.chatManager.getChannels().get(c).getChannelName());
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
