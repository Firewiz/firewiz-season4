package net.firewiz.fws4;

import java.util.Random;

import net.firewiz.fws4.chat.ChatEventsListener;
import net.firewiz.fws4.chat.ChatManager;
import net.firewiz.fws4.combat.CombatEventsListener;
import net.firewiz.fws4.commands.ChannelCommandExecutor;
import net.firewiz.fws4.commands.CheatCommandExecutor;
import net.firewiz.fws4.commands.CraftStatsCommandExecutor;
import net.firewiz.fws4.commands.EquipCommandExecutor;
import net.firewiz.fws4.commands.JoinCommandExecutor;
import net.firewiz.fws4.commands.LeaveCommandExecutor;
import net.firewiz.fws4.commands.ListCommandExecutor;
import net.firewiz.fws4.gmMods.GMEventsListener;
import net.firewiz.fws4.items.ItemEventsListener;
import net.firewiz.fws4.stats.StatsEventsListener;
import net.firewiz.fws4.world.WorldEventsListener;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class FWS4 extends JavaPlugin {
	public static Plugin instance;
	public static ChatManager chatManager;
	public static Random rand;

	@Override
	public void onEnable() {
		rand = new Random();
		instance = this;
		chatManager = ChatManager.getInstance();
		this.saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new ChatEventsListener(),
				this);
		getServer().getPluginManager().registerEvents(
				new CombatEventsListener(), this);
		getServer().getPluginManager().registerEvents(new GMEventsListener(),
				this);
		getServer().getPluginManager().registerEvents(new ItemEventsListener(),
				this);
		getServer().getPluginManager().registerEvents(
				new StatsEventsListener(), this);
		getServer().getPluginManager().registerEvents(
				new WorldEventsListener(), this);
		(new ChatQueueFlusher()).runTaskTimer(instance, 0, 4);
		chatManager.addChannel("Combat Log");
		chatManager.addChannel("General");
		chatManager.addChannel("Trade");

		this.getCommand("join").setExecutor(new JoinCommandExecutor());
		this.getCommand("leave").setExecutor(new LeaveCommandExecutor());
		this.getCommand("channel").setExecutor(new ChannelCommandExecutor());
		this.getCommand("list").setExecutor(new ListCommandExecutor());
		this.getCommand("cheat").setExecutor(new CheatCommandExecutor());
		this.getCommand("craftstats").setExecutor(new CraftStatsCommandExecutor());
		this.getCommand("equip").setExecutor(new EquipCommandExecutor());
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
