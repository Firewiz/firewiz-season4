package net.firewiz.fws4;

import java.util.Random;

import net.firewiz.fws4.items.CraftingEventsListener;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class FWS4 extends JavaPlugin {
	public static Plugin	  instance;
	public static ChatManager chatManager;
	public static Random	  rand;

	@Override
	public void onEnable() {
		rand = new Random();
		instance = this;
		chatManager = ChatManager.getInstance();
		this.saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new EventsListener(this),
				this);
		getServer().getPluginManager().registerEvents(
				new CraftingEventsListener(), this);
		(new ChatQueueFlusher()).runTaskTimer(instance, 0, 4);
		chatManager.addChannel("Combat Log");
		chatManager.addChannel("General");
		chatManager.addChannel("Trade");

		this.getCommand("join").setExecutor(new ChatCommandExecutor());
		this.getCommand("leave").setExecutor(new ChatCommandExecutor());
		this.getCommand("channel").setExecutor(new ChatCommandExecutor());
		this.getCommand("list").setExecutor(new ChatCommandExecutor());
		
		this.getCommand("cheat").setExecutor(new ChatCommandExecutor());
		
		this.getCommand("craftstats").setExecutor(new ItemCommandExecutor());
		
		this.getCommand("equip").setExecutor(new ItemCommandExecutor());
	}

	@Override
	public void onDisable() {

	}

	public class ChatQueueFlusher extends BukkitRunnable {

		@Override
		public void run() {
			chatManager.flushQueue();
		}
	}
}
