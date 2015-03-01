package net.firewiz.fws4;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class ChatManager {
	static ChatManager	 instance;
	static int			 lastChannelID = 0;

	ArrayList<ChatChannel> channels;

	private ChatManager() {
		channels = new ArrayList<ChatChannel>();
	}

	public static ChatManager getInstance() {
		if (instance == null) instance = new ChatManager();
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
			if(channels.get(0).hasPlayer(sender)) {
				sender.sendMessage("[0. Combat Log] " + message);
			}
		}
	}

	public void flushQueue() {
		for (ChatChannel c : instance.channels) {
			c.flushQueue();
		}
	}

	public void joinChannel(int id, Player p) throws NonexistentChannelException {
		if(id >= instance.channels.size() || id < 0) throw new NonexistentChannelException();
		instance.channels.get(id).joinChannel(p);
	}

	public void leaveChannel(int id, Player p) throws NonexistentChannelException {
		if(id >= instance.channels.size() || id < 0) throw new NonexistentChannelException();
		instance.channels.get(id).leaveChannel(p);
	}

	public void leaveAllChannels(Player p) {
		for (ChatChannel c : instance.channels) {
			c.leaveChannel(p);
		}
	}
}
