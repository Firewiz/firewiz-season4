package net.firewiz.fws4.data;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import net.firewiz.fws4.FWS4;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Data {
	private static FileConfiguration customConfig = null;
	private static File customConfigFile = null;

	public static void reloadCustomConfig() {
		if (customConfigFile == null) {
			customConfigFile = new File(FWS4.instance.getDataFolder(),
					"data.yml");
		}
		customConfig = YamlConfiguration.loadConfiguration(customConfigFile);
		Reader defConfigStream;
		try {
			defConfigStream = new InputStreamReader(
					FWS4.instance.getResource("data.yml"), "UTF8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return;
		}
		if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration
					.loadConfiguration(defConfigStream);
			customConfig.setDefaults(defConfig);
		}
	}

	public static FileConfiguration getConfig() {
		if (customConfig == null) {
			reloadCustomConfig();
		}
		return customConfig;
	}

	public static void saveConfig() {
		if (customConfig == null || customConfigFile == null) {
			return;
		}
		try {
			getConfig().save(customConfigFile);
		} catch (IOException ex) {
			FWS4.instance.getLogger().log(Level.SEVERE,
					"Could not save config to " + customConfigFile, ex);
		}
	}

	public static void saveDefaultConfig() {
		if (customConfigFile == null) {
			customConfigFile = new File(FWS4.instance.getDataFolder(),
					"data.yml");
		}
		if (!customConfigFile.exists()) {
			FWS4.instance.saveResource("data.yml", false);
		}
	}

}
