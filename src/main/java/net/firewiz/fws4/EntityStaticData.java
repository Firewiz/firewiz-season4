package net.firewiz.fws4;

import java.util.HashMap;

import org.bukkit.entity.EntityType;

public class EntityStaticData {
	public static class StaticData {
		char healthBarColor;
		StaticData(char hBC) {
			healthBarColor = hBC;
		}
	}

	static HashMap<EntityType, StaticData> map;
	static {
		map = new HashMap<EntityType, StaticData>();
		map.put(EntityType.BAT, new StaticData('a'));
		map.put(EntityType.BLAZE, new StaticData('c'));
		map.put(EntityType.CAVE_SPIDER, new StaticData('c'));
		map.put(EntityType.CHICKEN, new StaticData('a'));
		map.put(EntityType.COW, new StaticData('a'));
		map.put(EntityType.CREEPER, new StaticData('c'));
		map.put(EntityType.ENDERMAN, new StaticData('e'));
		map.put(EntityType.ENDERMITE, new StaticData('c'));
		map.put(EntityType.GHAST, new StaticData('c'));
		map.put(EntityType.GUARDIAN, new StaticData('c'));
		map.put(EntityType.HORSE, new StaticData('a'));
		map.put(EntityType.IRON_GOLEM, new StaticData('e'));
		map.put(EntityType.MAGMA_CUBE, new StaticData('c'));
		map.put(EntityType.MUSHROOM_COW, new StaticData('a'));
		map.put(EntityType.OCELOT, new StaticData('a'));
		map.put(EntityType.PIG, new StaticData('a'));
		map.put(EntityType.PIG_ZOMBIE, new StaticData('e'));
		map.put(EntityType.PLAYER, new StaticData('9'));
		map.put(EntityType.RABBIT, new StaticData('a'));
		map.put(EntityType.SHEEP, new StaticData('a'));
		map.put(EntityType.SILVERFISH, new StaticData('c'));
		map.put(EntityType.SKELETON, new StaticData('c'));
		map.put(EntityType.SLIME, new StaticData('c'));
		map.put(EntityType.SNOWMAN, new StaticData('a'));
		map.put(EntityType.SPIDER, new StaticData('c'));
		map.put(EntityType.SQUID, new StaticData('a'));
		map.put(EntityType.VILLAGER, new StaticData('a'));
		map.put(EntityType.WITCH, new StaticData('c'));
		map.put(EntityType.WOLF, new StaticData('a'));
		map.put(EntityType.ZOMBIE, new StaticData('c'));
		
		map.put(EntityType.UNKNOWN, new StaticData('b'));
	}
	
	static StaticData getData(EntityType e) {
		if(map.get(e) != null) return map.get(e);
		return map.get(EntityType.UNKNOWN);
	}
}
