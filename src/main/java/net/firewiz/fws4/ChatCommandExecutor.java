package net.firewiz.fws4;

import net.firewiz.fws4.items.ItemUtils;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public class ChatCommandExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (!(sender instanceof Player)) return false;
		Player p = (Player) sender;
		switch (command.getName().toLowerCase()) {
		case "join":
			if (args.length != 1) { return false; }
			try {
				FWS4.chatManager.joinChannel(Integer.parseInt(args[0]), p);
			} catch (NumberFormatException e) {
				return false;
			} catch (NonexistentChannelException e) {
				sender.sendMessage("§cThis channel doesn't exist!");
				return true;
			}
			return true;
		case "leave":
			if (args.length != 1) { return false; }
			try {
				FWS4.chatManager.leaveChannel(Integer.parseInt(args[0]), p);
			} catch (NumberFormatException e) {
				return false;
			} catch (NonexistentChannelException e) {
				sender.sendMessage("§cThis channel doesn't exist!");
				return true;
			}
			return true;
		case "channel":
			if (args.length != 1) { return false; }
			try {
				int c = Integer.parseInt(args[0]);
				if (c < 1) {
					sender.sendMessage("§cNo talking in the combat log!");
					return true;
				} else if (c >= FWS4.chatManager.channels.size()) {
					sender.sendMessage("§cThis channel doesn't exist!");
					return true;
				}
				p.setMetadata("ChatChannel", new FixedMetadataValue(
						FWS4.instance, c));
				p.sendMessage("§6Now talking in " + c + ": "
						+ FWS4.chatManager.channels.get(c).channelName);
			} catch (NumberFormatException e) {
				return false;
			}
			return true;
		case "list":
			for (ChatChannel c : FWS4.chatManager.channels) {
				sender.sendMessage("§a" + c.channelID + ": " + c.channelName);
			}
			return true;
		case "cheat":
			p.getInventory().addItem(
					ItemUtils.generateCraftedItem(Integer.parseInt(args[0]),
							Material.valueOf(Material.class, args[1])));
			return true;
		}
		return false;
	}

}
