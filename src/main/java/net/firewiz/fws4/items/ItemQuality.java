package net.firewiz.fws4.items;

public enum ItemQuality {
	POOR('7'), COMMON('f'), UNCOMMON('2'), RARE('1'), EPIC('5'), LEGENDARY('6');

	char colorCode;

	ItemQuality(char c) {
		colorCode = c;
	}
}
