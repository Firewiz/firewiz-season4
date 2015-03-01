package net.firewiz.fws4;

import java.util.HashMap;

import org.bukkit.entity.EntityType;

public class EntityStaticData {
	public static class StaticData {
		public char healthBarColor;
		public boolean poorDrops;
		public boolean rareDrops;
		StaticData(char hBC, boolean pd, boolean rd) {
			healthBarColor = hBC;
			poorDrops = pd;
			rareDrops = rd;
		}
	}

	static HashMap<EntityType, StaticData> map;
	static {
		map = new HashMap<EntityType, StaticData>();
		map.put(EntityType.BAT, new StaticData('a', false, false));
		map.put(EntityType.BLAZE, new StaticData('c', false, true));
		map.put(EntityType.CAVE_SPIDER, new StaticData('c', true, true));
		map.put(EntityType.CHICKEN, new StaticData('a', true, false));
		map.put(EntityType.COW, new StaticData('a', true, false));
		map.put(EntityType.CREEPER, new StaticData('c', true, true));
		map.put(EntityType.ENDERMAN, new StaticData('e', true, true));
		map.put(EntityType.ENDERMITE, new StaticData('c', false, false));
		map.put(EntityType.GHAST, new StaticData('c', false, true));
		map.put(EntityType.GUARDIAN, new StaticData('c', true, true));
		map.put(EntityType.HORSE, new StaticData('a', false, false));
		map.put(EntityType.IRON_GOLEM, new StaticData('e', false, false));
		map.put(EntityType.MAGMA_CUBE, new StaticData('c', true, false));
		map.put(EntityType.MUSHROOM_COW, new StaticData('a', true, false));
		map.put(EntityType.OCELOT, new StaticData('a', true, false));
		map.put(EntityType.PIG, new StaticData('a', true, false));
		map.put(EntityType.PIG_ZOMBIE, new StaticData('e', true, true));
		map.put(EntityType.PLAYER, new StaticData('9', false, false));
		map.put(EntityType.RABBIT, new StaticData('a', true, false));
		map.put(EntityType.SHEEP, new StaticData('a', true, false));
		map.put(EntityType.SILVERFISH, new StaticData('c', false, false));
		map.put(EntityType.SKELETON, new StaticData('c', true, true));
		map.put(EntityType.SLIME, new StaticData('c', true, true));
		map.put(EntityType.SNOWMAN, new StaticData('a', false, false));
		map.put(EntityType.SPIDER, new StaticData('c', true, true));
		map.put(EntityType.SQUID, new StaticData('a', true, false));
		map.put(EntityType.VILLAGER, new StaticData('a', false, false));
		map.put(EntityType.WITCH, new StaticData('c', true, true));
		map.put(EntityType.WOLF, new StaticData('a', false, false));
		map.put(EntityType.ZOMBIE, new StaticData('c', true, true));
		
		map.put(EntityType.UNKNOWN, new StaticData('b', false, false));
	}
	
	public static StaticData getData(EntityType e) {
		if(map.get(e) != null) return map.get(e);
		return map.get(EntityType.UNKNOWN);
	}
}
