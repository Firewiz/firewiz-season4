package net.firewiz.fws4.chat;

import java.util.logging.Level;

import net.firewiz.fws4.FWS4;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class ChatEventsListener implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerJoin(PlayerJoinEvent e) {
		try {
			FWS4.chatManager.joinChannel(0, e.getPlayer());
			FWS4.chatManager.joinChannel(1, e.getPlayer());
			FWS4.chatManager.joinChannel(2, e.getPlayer());
		} catch (NonexistentChannelException e1) {
			FWS4.instance.getLogger().log(Level.SEVERE,
					"Can't happen at onPlayerJoin");
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerQuit(PlayerQuitEvent e) {
		FWS4.chatManager.leaveAllChannels(e.getPlayer());
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (p.getMetadata("ChatChannel").size() == 0) {
			p.setMetadata("ChatChannel", new FixedMetadataValue(FWS4.instance,
					1));
		}
		FWS4.chatManager.sendMessage(p.getMetadata("ChatChannel").get(0)
				.asInt(), "[" + p.getName() + "] " + e.getMessage(), p);
		e.setCancelled(true);
	}
}
