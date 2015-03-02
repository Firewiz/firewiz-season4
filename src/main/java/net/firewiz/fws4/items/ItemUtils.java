package net.firewiz.fws4.items;

import java.util.LinkedList;
import java.util.List;

import net.firewiz.fws4.FWS4;
import net.firewiz.fws4.data.CraftingData;
import net.firewiz.fws4.data.EntityStaticData;
import net.firewiz.fws4.data.ItemLookup;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils {

	static String[][] enchSuffixes = {
			{ "of Strength", "of Stamina", "of Agility", "of Power",
					"of Spirit" },
			{ "of the Cheetah", "of the Guardian", "of the Deer",
					"of the Eagle", "of the Horse" },
			{ "of the Bear", "of the Elephant", "of the Lion", "of the Ox",
					"of the Whale" },
			{ "of the Nether", "of the Wither", "of the Fireflash",
					"of the Squid", "of the Ghast" },
			{ "of the Hawk", "of Invulnerability", "of the Dolphin",
					"of the Vulture", "of the Owl" } };

	public static ItemStack generateCraftedItem(int q, Material itemType) {
		ItemStack i = new ItemStack(itemType, 1);

		ConfigurationSection items = FWS4.config
				.getConfigurationSection("items");
		ConfigurationSection matBonuses = items
				.getConfigurationSection("matBonuses");
		ConfigurationSection qfinalcfg = items
				.getConfigurationSection("q_final");

		if (itemType.toString().contains("WOOD"))
			q += matBonuses.getInt("wood");
		else if (itemType.toString().contains("STONE"))
			q += matBonuses.getInt("stone");
		else if (itemType.toString().contains("IRON"))
			q += matBonuses.getInt("iron");
		else if (itemType.toString().contains("GOLD"))
			q += matBonuses.getInt("gold");
		else if (itemType.toString().contains("DIAMOND"))
			q += matBonuses.getInt("diamond");

		int q_final = (int) ((Math.log(q) * q) / (3 * Math.log(300)) + FWS4.rand
				.nextInt(25));
		if (q_final < 0)
			q_final = 0;

		ItemQuality iq;
		if (q_final < qfinalcfg.getInt("poor"))
			iq = ItemQuality.POOR;
		else if (q_final < qfinalcfg.getInt("common"))
			iq = ItemQuality.COMMON;
		else if (q_final < qfinalcfg.getInt("uncommon"))
			iq = ItemQuality.UNCOMMON;
		else if (q_final < qfinalcfg.getInt("rare"))
			iq = ItemQuality.RARE;
		else if (q_final < qfinalcfg.getInt("epic"))
			iq = ItemQuality.EPIC;
		else
			iq = ItemQuality.LEGENDARY;

		FWS4.instance.getLogger().info(
				"Created a(n) " + iq.toString() + " item");

		ItemMeta im = i.getItemMeta();
		im.setDisplayName("§" + iq.colorCode
				+ ItemLookup.lt.get(i.getType()).name);
		i.setItemMeta(im);

		enchantItemStack(i, iq);
		setItemDurability(i, iq);

		return i;
	}

	public static double triangular(double a, double b, double c) {
		double U = FWS4.rand.nextDouble();
		double F = (c - a) / (b - a);
		if (U <= F)
			return a + Math.sqrt(U * (b - a) * (c - a));
		else
			return b - Math.sqrt((1 - U) * (b - a) * (b - c));
	}

	static void enchantItemStack(ItemStack i, ItemQuality q) {

		boolean hasEnchant1 = false, hasEnchant2 = false;
		int eid1, eid2 = -1;
		ItemMeta im = i.getItemMeta();
		int percent = 0;
		ConfigurationSection items = FWS4.config
				.getConfigurationSection("items");
		ConfigurationSection enchant = items.getConfigurationSection("enchant");
		ConfigurationSection e1 = enchant.getConfigurationSection("e1");
		ConfigurationSection e1Rate = e1.getConfigurationSection("rate");
		ConfigurationSection e1Power = e1.getConfigurationSection("power");
		ConfigurationSection e2 = enchant.getConfigurationSection("e2");
		ConfigurationSection e2Rate = e2.getConfigurationSection("rate");
		hasEnchant1 = FWS4.rand.nextInt(1000) < e1Rate.getInt(q.toString()
				.toLowerCase());
		if (!hasEnchant1)
			return;
		Integer[] e1Triangular = e1Power.getList(q.name().toLowerCase())
				.toArray(new Integer[0]);
		percent = (int) triangular(e1Triangular[0], e1Triangular[1],
				e1Triangular[2]);
		hasEnchant2 = FWS4.rand.nextInt(1000) < e2Rate.getInt(q.toString()
				.toLowerCase());

		List<String> lore = im.getLore();
		if (lore == null)
			lore = new LinkedList<String>();

		eid1 = FWS4.rand.nextInt(5);
		switch (eid1) {
		case 0:
			lore.add("+" + percent + "% Strength");
			break;
		case 1:
			lore.add("+" + percent + "% Stamina");
			break;
		case 2:
			lore.add("+" + percent + "% Agility");
			break;
		case 3:
			lore.add("+" + percent + "% Attack Power");
			break;
		case 4:
			lore.add("+" + percent + "% Spirit");
			break;
		}
		if (hasEnchant2) {
			eid2 = FWS4.rand.nextInt(4);
			switch (eid2) {
			case 0:
				lore.add("+1 Haste");
				break;
			case 1:
				lore.add("+1 Resistance");
				break;
			case 2:
				lore.add("+1 Fire Resistance");
				break;
			case 3:
				lore.add("+1 Regeneration");
				break;
			}
		}

		im.setLore(lore);
		im.setDisplayName(im.getDisplayName() + " "
				+ enchSuffixes[eid2 + 1][eid1]);

		i.setItemMeta(im);

	}

	public static List<ItemStack> dropItemsFor(LivingEntity e) {
		LinkedList<ItemStack> l = new LinkedList<ItemStack>();
		ConfigurationSection items = FWS4.config
				.getConfigurationSection("items");
		ConfigurationSection loot = items.getConfigurationSection("loot");
		ConfigurationSection poor = loot.getConfigurationSection("poor");
		ConfigurationSection rare = loot.getConfigurationSection("rare");

		if (EntityStaticData.getData(e.getType()).poorDrops) {
			if (FWS4.rand.nextInt(1000) < poor.getInt("rate")) {
				Material m = CraftingData.crafted[FWS4.rand
						.nextInt(CraftingData.crafted.length)];
				ItemStack i = new ItemStack(m, 1);
				enchantItemStack(i, ItemQuality.POOR);
				ItemMeta im = i.getItemMeta();
				im.setDisplayName("§" + ItemQuality.POOR.colorCode
						+ ItemLookup.lt.get(i.getType()).name);
				i.setItemMeta(im);
				setItemDurability(i, ItemQuality.POOR);
				l.add(i);
			}
		}
		if (EntityStaticData.getData(e.getType()).rareDrops) {
			if (FWS4.rand.nextInt(1000) < rare.getInt("rate")) {
				Material m = CraftingData.crafted[FWS4.rand
						.nextInt(CraftingData.crafted.length)];
				ItemStack i = new ItemStack(m, 1);
				ItemQuality q;
				int r = FWS4.rand.nextInt(100);
				if (r < rare.getList("types").toArray(new Integer[0])[0]) {
					q = ItemQuality.COMMON;
				} else if (r < rare.getList("types").toArray(new Integer[0])[1]) {
					q = ItemQuality.UNCOMMON;
				} else if (r < rare.getList("types").toArray(new Integer[0])[2]) {
					q = ItemQuality.RARE;
				} else if (r < rare.getList("types").toArray(new Integer[0])[3]) {
					q = ItemQuality.EPIC;
				} else {
					q = ItemQuality.LEGENDARY;
				}

				enchantItemStack(i, q);
				ItemMeta im = i.getItemMeta();
				im.setDisplayName("§" + q.colorCode
						+ ItemLookup.lt.get(i.getType()).name);
				i.setItemMeta(im);
				setItemDurability(i, q);
				l.add(i);
			}
		}
		return l;
	}

	public static void setItemDurability(ItemStack i, ItemQuality q) {
		ItemMeta im = i.getItemMeta();
		ConfigurationSection items = FWS4.config
				.getConfigurationSection("items");
		ConfigurationSection durability = items
				.getConfigurationSection("durability");
		ConfigurationSection specific = durability
				.getConfigurationSection((ItemLookup.lt.get(i.getType()).isArmor) ? "armor"
						: "tools");
		int dur = specific.getInt(q.name().toLowerCase());
		List<String> lore = im.getLore();
		if (lore == null)
			lore = new LinkedList<String>();

		lore.add("Durability: " + dur + "/" + dur);

		im.setLore(lore);
		i.setItemMeta(im);
		i.setDurability((short) 0);
	}

	public static ItemStack damageItem(ItemStack i) {
		if (i == null)
			return null;
		ItemMeta im = i.getItemMeta();
		if (im == null)
			return i;
		List<String> lore = im.getLore();
		if (lore == null)
			return i;

		for (int n = 0; n < lore.size(); n++) {
			if (lore.get(n).contains("Durability")) {
				int newDur = Integer.parseInt(lore.get(n).split(" ")[1]
						.split("/")[0]) - 1;
				if (newDur > 0) {
					int maxDur = Integer.parseInt(lore.get(n).split(" ")[1]
							.split("/")[1]);
					i.setDurability((short) (((double) (maxDur - newDur) / (double) maxDur) * i
							.getType().getMaxDurability()));
					lore.set(n, "Durability: " + newDur + "/" + maxDur);
				} else {
					return null;
				}
			}
		}
		im.setLore(lore);
		i.setItemMeta(im);
		return i;
	}

	public static void stripEquipped(String type, ItemStack i) {
		if (i == null)
			return;
		if (i.getType().toString().split("_").length > 1
				&& (i.getType().toString().split("_")[1].equalsIgnoreCase(type))) {
			ItemMeta im = i.getItemMeta();
			if (im.hasLore()) {
				List<String> l = im.getLore();
				while (l.contains("§6Equipped"))
					l.remove("§6Equipped");
				im.setLore(l);
				i.setItemMeta(im);
			}
		}
	}

}
