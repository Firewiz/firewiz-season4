package net.firewiz.fws4.chat;

import java.util.ArrayList;

import net.firewiz.fws4.FWS4;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ChatManager {
	static ChatManager instance;
	static int lastChannelID = 0;

	ArrayList<ChatChannel> channels;

	public ArrayList<ChatChannel> getChannels() {
		return channels;
	}

	private ChatManager() {
		channels = new ArrayList<ChatChannel>();
		(new ChatQueueFlusher()).runTaskTimer(FWS4.instance, 0, 4);
	}

	public class ChatQueueFlusher extends BukkitRunnable {

		@Override
		public void run() {
			ChatManager.getInstance().flushQueue();
		}
	}

	public static ChatManager getInstance() {
		if (instance == null)
			instance = new ChatManager();
		return instance;
	}

	public void addChannel(String name) {
		instance.channels.add(new ChatChannel(lastChannelID++, name));
		FWS4.instance.getLogger().info(
				"Added channel " + (lastChannelID - 1) + " \"" + name + "\"");
	}

	public void sendMessage(int id, String message, Player sender) {
		if (id != 0) {
			instance.channels.get(id).addMessage(message);
		} else {
			if (channels.get(0).hasPlayer(sender)) {
				sender.sendMessage("[0. Combat Log] " + message);
			}
		}
	}

	public void flushQueue() {
		for (ChatChannel c : instance.channels) {
			c.flushQueue();
		}
	}

	public void joinChannel(int id, Player p)
			throws NonexistentChannelException {
		if (id >= instance.channels.size() || id < 0)
			throw new NonexistentChannelException();
		instance.channels.get(id).joinChannel(p);
	}

	public void leaveChannel(int id, Player p)
			throws NonexistentChannelException {
		if (id >= instance.channels.size() || id < 0)
			throw new NonexistentChannelException();
		instance.channels.get(id).leaveChannel(p);
	}

	public void leaveAllChannels(Player p) {
		for (ChatChannel c : instance.channels) {
			c.leaveChannel(p);
		}
	}
}
