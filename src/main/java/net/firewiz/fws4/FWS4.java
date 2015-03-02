package net.firewiz.fws4;

import java.util.Random;

import net.firewiz.fws4.chat.ChatEventsListener;
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

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class FWS4 extends JavaPlugin {
	public static Plugin instance;
	public static Random rand;
	public static FileConfiguration config;

	@Override
	public void onEnable() {
		rand = new Random();
		instance = this;
		config = getConfig();
		this.saveDefaultConfig();
		registerEventHandlers();
		registerCommandExecutors();
	}

	private void registerCommandExecutors() {
		this.getCommand("join").setExecutor(new JoinCommandExecutor());
		this.getCommand("leave").setExecutor(new LeaveCommandExecutor());
		this.getCommand("channel").setExecutor(new ChannelCommandExecutor());
		this.getCommand("list").setExecutor(new ListCommandExecutor());
		this.getCommand("cheat").setExecutor(new CheatCommandExecutor());
		this.getCommand("craftstats").setExecutor(
				new CraftStatsCommandExecutor());
		this.getCommand("equip").setExecutor(new EquipCommandExecutor());
	}

	private void registerEventHandlers() {
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
	}

	@Override
	public void onDisable() {

	}
}
