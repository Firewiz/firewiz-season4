package net.firewiz.fws4;

import java.util.ArrayList;
import java.util.LinkedList;

import org.bukkit.entity.Player;

public class ChatChannel {
	String			 channelName;
	int				channelID;

	ArrayList<Player>  players;
	LinkedList<String> messages;

	public ChatChannel(int id, String name) {
		channelID = id;
		channelName = name;
		players = new ArrayList<Player>();
		messages = new LinkedList<String>();
	}

	void joinChannel(Player p) {
		if (players.contains(p)) return;
		players.add(p);
		p.sendMessage("§6Joined channel " + channelID + ": " + channelName);
	}

	void leaveChannel(Player p) {
		players.remove(p);
		p.sendMessage("§6Left channel " + channelID + ": " + channelName);
	}

	boolean hasPlayer(Player p) {
		return players.contains(p);
	}
	
	void flushQueue() {
		for (String s : messages) {
			for (Player p : players) {
				p.sendMessage("[" + channelID + ". " + channelName + "] " + s);
			}
			messages.remove();
		}
	}

	void addMessage(String s) {
		messages.push(s);
	}
}
