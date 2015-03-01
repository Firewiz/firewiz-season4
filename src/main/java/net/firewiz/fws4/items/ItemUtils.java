package net.firewiz.fws4.items;

import java.util.LinkedList;
import java.util.List;

import net.firewiz.fws4.FWS4;

import org.bukkit.Material;
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
		if (itemType.toString().contains("WOOD"))
			q += 0;
		else if (itemType.toString().contains("STONE"))
			q += 10;
		else if (itemType.toString().contains("IRON"))
			q += 20;
		else if (itemType.toString().contains("GOLD"))
			q += 20;
		else if (itemType.toString().contains("DIAMOND")) q += 50;

		int q_final = (int) ((Math.log(q) * q) / (3 * Math.log(300))
				+ FWS4.rand.nextInt(25));
		if (q_final < 0) q_final = 0;

		ItemQuality iq;
		if (q_final < 11)
			iq = ItemQuality.POOR;
		else if (q_final < 21)
			iq = ItemQuality.COMMON;
		else if (q_final < 41)
			iq = ItemQuality.UNCOMMON;
		else if (q_final < 76)
			iq = ItemQuality.RARE;
		else if (q_final < 91)
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

		return i;
	}

	static double triangular(double a, double b, double c) {
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
		switch (q) {
		case POOR:
			hasEnchant1 = FWS4.rand.nextInt(1000) < 1;
			percent = 1;
			break;
		case COMMON:
			hasEnchant1 = FWS4.rand.nextInt(100) < 10;
			percent = FWS4.rand.nextInt(1) + 1;
			break;
		case UNCOMMON:
			hasEnchant1 = FWS4.rand.nextInt(100) < 50;
			percent = (int) triangular(1, 3, 2);
			break;
		case RARE:
			hasEnchant1 = FWS4.rand.nextInt(100) < 75;
			percent = (int) triangular(2, 4, 3);
			break;
		case EPIC:
			percent = (int) triangular(3, 5, 6);
			hasEnchant1 = true;
			break;
		case LEGENDARY:
			hasEnchant1 = true;
			percent = (int) triangular(4, 7, 10);
			break;
		}
		if (!hasEnchant1) return;
		switch (q) {
		case POOR:
			hasEnchant2 = FWS4.rand.nextInt(1000) < 1;
			break;
		case COMMON:
			hasEnchant2 = FWS4.rand.nextInt(1000) < 1;
			break;
		case UNCOMMON:
			hasEnchant2 = FWS4.rand.nextInt(100) < 1;
			break;
		case RARE:
			hasEnchant2 = FWS4.rand.nextInt(100) < 20;
			break;
		case EPIC:
			hasEnchant2 = FWS4.rand.nextInt(100) < 50;
			break;
		case LEGENDARY:
			hasEnchant2 = true;
			break;
		}

		List<String> lore = im.getLore();
		if (lore == null) lore = new LinkedList<String>();

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
}
