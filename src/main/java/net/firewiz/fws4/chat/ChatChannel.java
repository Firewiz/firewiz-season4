package net.firewiz.fws4.chat;

import java.util.ArrayList;
import java.util.LinkedList;

import org.bukkit.entity.Player;

public class ChatChannel {
	private String channelName;
	private final int channelID;

	ArrayList<Player> players;
	LinkedList<String> messages;

	public ChatChannel(int id, String name) {
		channelID = id;
		setChannelName(name);
		players = new ArrayList<Player>();
		messages = new LinkedList<String>();
	}

	void joinChannel(Player p) {
		if (players.contains(p))
			return;
		players.add(p);
		p.sendMessage("§6Joined channel " + getChannelID() + ": "
				+ getChannelName());
	}

	void leaveChannel(Player p) {
		players.remove(p);
		p.sendMessage("§6Left channel " + getChannelID() + ": "
				+ getChannelName());
	}

	boolean hasPlayer(Player p) {
		return players.contains(p);
	}

	void flushQueue() {
		for (String s : messages) {
			for (Player p : players) {
				p.sendMessage("[" + getChannelID() + ". " + getChannelName()
						+ "] " + s);
			}
			messages.remove();
		}
	}

	void addMessage(String s) {
		messages.push(s);
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public int getChannelID() {
		return channelID;
	}
}
