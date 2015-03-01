package net.firewiz.fws4.items;

import java.util.HashMap;

import org.bukkit.Material;

public class ItemLookup {
	static HashMap<Material, ItemData> lt;
	static {
		lt = new HashMap<Material, ItemData>();
		lt.put(Material.ACACIA_DOOR, new ItemData("Acacia Door (block)"));
		lt.put(Material.ACACIA_DOOR_ITEM, new ItemData("Acacia Door"));
		lt.put(Material.ACACIA_FENCE, new ItemData("Acacia Fence"));
		lt.put(Material.ACACIA_FENCE_GATE, new ItemData("Acacia Fence Gate"));
		lt.put(Material.ACACIA_STAIRS, new ItemData("Acacia Stairs"));
		lt.put(Material.ACTIVATOR_RAIL, new ItemData("Activator Rail"));
		lt.put(Material.AIR, new ItemData("Air"));
		lt.put(Material.ANVIL, new ItemData("Anvil"));
		lt.put(Material.APPLE, new ItemData("Apple"));
		lt.put(Material.ARMOR_STAND, new ItemData("Armor Stand"));
		lt.put(Material.ARROW, new ItemData("Arrow"));
		lt.put(Material.BAKED_POTATO, new ItemData("Baked Potato"));
		lt.put(Material.BANNER, new ItemData("Banner"));
		lt.put(Material.BARRIER, new ItemData("Barrier"));
		lt.put(Material.BEACON, new ItemData("Beacon"));
		lt.put(Material.BED, new ItemData("Bed"));
		lt.put(Material.BED_BLOCK, new ItemData("Bed (block)"));
		lt.put(Material.BEDROCK, new ItemData("Bedrock"));
		lt.put(Material.BIRCH_DOOR, new ItemData("Birch Door (block)"));
		lt.put(Material.BIRCH_DOOR_ITEM, new ItemData("Birch Door"));
		lt.put(Material.BIRCH_FENCE, new ItemData("Birch Fence"));
		lt.put(Material.BIRCH_FENCE_GATE, new ItemData("Birch Fence Gate"));
		lt.put(Material.BIRCH_WOOD_STAIRS, new ItemData("Birch Stairs"));
		lt.put(Material.BLAZE_POWDER, new ItemData("Blaze Powder"));
		lt.put(Material.BLAZE_ROD, new ItemData("Blaze Rod"));
		lt.put(Material.BOAT, new ItemData("Boat"));
		lt.put(Material.BONE, new ItemData("Bone"));
		lt.put(Material.BOOK, new ItemData("Book"));
		lt.put(Material.BOOK_AND_QUILL, new ItemData("Book and Quill"));
		lt.put(Material.BOOKSHELF, new ItemData("Bookshelf"));
		lt.put(Material.BOW, new ItemData("Bow"));
		lt.put(Material.BOWL, new ItemData("Bowl"));
		lt.put(Material.BREAD, new ItemData("Bread"));
		lt.put(Material.BREWING_STAND, new ItemData("Brewing Stand (block)"));
		lt.put(Material.BREWING_STAND_ITEM, new ItemData("Brewing Stand"));
		lt.put(Material.BRICK, new ItemData("Brick"));
		lt.put(Material.BRICK_STAIRS, new ItemData("Brick Stairs"));
		lt.put(Material.BROWN_MUSHROOM, new ItemData("Mushroom"));
		lt.put(Material.BUCKET, new ItemData("Bucket"));
		lt.put(Material.BURNING_FURNACE, new ItemData("Furnace (lit)"));
		lt.put(Material.CACTUS, new ItemData("Cactus"));
		lt.put(Material.CAKE, new ItemData("Cake"));
		lt.put(Material.CAKE_BLOCK, new ItemData("Cake (block)"));
		lt.put(Material.CARPET, new ItemData("Carpet"));
		lt.put(Material.CARROT, new ItemData("Carrot (block)"));
		lt.put(Material.CARROT_ITEM, new ItemData("Carrot"));
		lt.put(Material.CARROT_STICK, new ItemData("Carrot on a Stick"));
		lt.put(Material.CAULDRON, new ItemData("Cauldron (block)"));
		lt.put(Material.CAULDRON_ITEM, new ItemData("Cauldron"));
		lt.put(Material.CHAINMAIL_BOOTS, new ItemData("Chain Boots", false,
				true));
		lt.put(Material.CHAINMAIL_CHESTPLATE, new ItemData("Chain Chestplate",
				false, true));
		lt.put(Material.CHAINMAIL_HELMET, new ItemData("Chain Helmet", false,
				true));
		lt.put(Material.CHAINMAIL_LEGGINGS, new ItemData("Chain Leggings",
				false, true));
		lt.put(Material.CHEST, new ItemData("Chest"));
		lt.put(Material.CLAY, new ItemData("Clay"));
		lt.put(Material.CLAY_BALL, new ItemData("Clay Ball"));
		lt.put(Material.CLAY_BRICK, new ItemData("Brick"));
		lt.put(Material.COAL, new ItemData("Coal"));
		lt.put(Material.COAL_BLOCK, new ItemData("Block of Coal"));
		lt.put(Material.COAL_ORE, new ItemData("Coal Ore"));
		lt.put(Material.COBBLESTONE, new ItemData("Cobblestone"));
		lt.put(Material.COBBLESTONE_STAIRS, new ItemData("Cobblestone Stairs"));
		lt.put(Material.COBBLE_WALL, new ItemData("Cobblestone Wall"));
		lt.put(Material.COCOA, new ItemData("Cocoa"));
		lt.put(Material.COMMAND, new ItemData("Command Block"));
		lt.put(Material.COMMAND_MINECART,
				new ItemData("Command Block Minecart"));
		lt.put(Material.COMPASS, new ItemData("Compass"));
		lt.put(Material.COOKED_BEEF, new ItemData("Cooked Beef"));
		lt.put(Material.COOKED_CHICKEN, new ItemData("Cooked Chicken"));
		lt.put(Material.COOKED_FISH, new ItemData("Cooked Fish"));
		lt.put(Material.COOKED_MUTTON, new ItemData("Cooked Mutton"));
		lt.put(Material.COOKED_RABBIT, new ItemData("Cooked Rabbit"));
		lt.put(Material.COOKIE, new ItemData("Cookie"));
		lt.put(Material.CROPS, new ItemData("Wheat (block)"));
		lt.put(Material.DARK_OAK_DOOR, new ItemData("Dark Oak Door (block)"));
		lt.put(Material.DARK_OAK_DOOR_ITEM, new ItemData("Dark Oak Door"));
		lt.put(Material.DARK_OAK_FENCE, new ItemData("Dark Oak Fence"));
		lt.put(Material.DARK_OAK_FENCE_GATE,
				new ItemData("Dark Oak Fence Gate"));
		lt.put(Material.DARK_OAK_STAIRS, new ItemData("Dark Oak Stairs"));
		lt.put(Material.DAYLIGHT_DETECTOR, new ItemData("Daylight Detector"));
		lt.put(Material.DAYLIGHT_DETECTOR_INVERTED, new ItemData(
				"Daylight Detector (inverted)"));
		lt.put(Material.DEAD_BUSH, new ItemData("Dead Bush"));
		lt.put(Material.DETECTOR_RAIL, new ItemData("Detector Rail"));
		lt.put(Material.DIAMOND, new ItemData("Diamond"));
		lt.put(Material.DIAMOND_AXE, new ItemData("Diamond Axe", true, false));
		lt.put(Material.DIAMOND_BARDING, new ItemData("Diamond Horse Armor"));
		lt.put(Material.DIAMOND_BLOCK, new ItemData("Block of Diamond"));
		lt.put(Material.DIAMOND_BOOTS, new ItemData("Diamond Boots", false,
				true));
		lt.put(Material.DIAMOND_CHESTPLATE, new ItemData("Diamond Chestplate",
				false, true));
		lt.put(Material.DIAMOND_HELMET, new ItemData("Diamond Helmet", false,
				true));
		lt.put(Material.DIAMOND_HOE, new ItemData("Diamond Hoe"));
		lt.put(Material.DIAMOND_LEGGINGS, new ItemData("Diamond Leggings",
				false, true));
		lt.put(Material.DIAMOND_ORE, new ItemData("Diamond Ore"));
		lt.put(Material.DIAMOND_PICKAXE, new ItemData("Diamond Pickaxe", true,
				false));
		lt.put(Material.DIAMOND_SPADE, new ItemData("Diamond Shovel", true,
				false));
		lt.put(Material.DIAMOND_SWORD, new ItemData("Diamond Sword", true,
				false));
		lt.put(Material.DIODE, new ItemData("Redstone Repeater"));
		lt.put(Material.DIODE_BLOCK_OFF,
				new ItemData("Redstone Repeater (off)"));
		lt.put(Material.DIODE_BLOCK_ON, new ItemData("Redstone Repeater (on)"));
		lt.put(Material.DIRT, new ItemData("Dirt"));
		lt.put(Material.DISPENSER, new ItemData("Dispenser"));
		lt.put(Material.DOUBLE_PLANT, new ItemData("Tall Plant"));
		lt.put(Material.DOUBLE_STEP, new ItemData("Double Slab"));
		lt.put(Material.DOUBLE_STONE_SLAB2, new ItemData("Double Stone Slab"));
		lt.put(Material.DRAGON_EGG, new ItemData("Dragon Egg"));
		lt.put(Material.DROPPER, new ItemData("Dropper"));
		lt.put(Material.EGG, new ItemData("Egg"));
		lt.put(Material.EMERALD, new ItemData("Emerald"));
		lt.put(Material.EMERALD_BLOCK, new ItemData("Block of Emerald"));
		lt.put(Material.EMERALD_ORE, new ItemData("Emerald Ore"));
		lt.put(Material.EMPTY_MAP, new ItemData("Empty Map"));
		lt.put(Material.ENCHANTED_BOOK, new ItemData("Enchanted Book"));
		lt.put(Material.ENCHANTMENT_TABLE, new ItemData("Enchantment Table"));
		lt.put(Material.ENDER_CHEST, new ItemData("Ender Chest"));
		lt.put(Material.ENDER_PEARL, new ItemData("Ender Pearl"));
		lt.put(Material.ENDER_PORTAL, new ItemData("End Portal"));
		lt.put(Material.ENDER_PORTAL_FRAME, new ItemData("End Portal Frame"));
		lt.put(Material.ENDER_STONE, new ItemData("End Stone"));
		lt.put(Material.EXP_BOTTLE, new ItemData("Bottle o' Enchanting"));
		lt.put(Material.EXPLOSIVE_MINECART, new ItemData("Minecart with TNT"));
		lt.put(Material.EYE_OF_ENDER, new ItemData("Eye of Ender"));
		lt.put(Material.FEATHER, new ItemData("Feather"));
		lt.put(Material.FENCE, new ItemData("Fence"));
		lt.put(Material.FENCE_GATE, new ItemData("Fence Gate"));
		lt.put(Material.FERMENTED_SPIDER_EYE, new ItemData(
				"Fermented Spider Eye"));
		lt.put(Material.FIRE, new ItemData("Fire"));
		lt.put(Material.FIREBALL, new ItemData("Fire Charge"));
		lt.put(Material.FIREWORK, new ItemData("Firework"));
		lt.put(Material.FIREWORK_CHARGE, new ItemData("Firework Star"));
		lt.put(Material.FISHING_ROD, new ItemData("Fishing Rod"));
		lt.put(Material.FLINT, new ItemData("Flint"));
		lt.put(Material.FLINT_AND_STEEL, new ItemData("Flint and Steel"));
		lt.put(Material.FLOWER_POT, new ItemData("Flowerpot (block)"));
		lt.put(Material.FLOWER_POT_ITEM, new ItemData("Flowerpot"));
		lt.put(Material.FURNACE, new ItemData("Furnace"));
		lt.put(Material.GHAST_TEAR, new ItemData("Ghast Tear"));
		lt.put(Material.GLASS, new ItemData("Glass"));
		lt.put(Material.GLASS_BOTTLE, new ItemData("Glass Bottle"));
		lt.put(Material.GLOWING_REDSTONE_ORE,
				new ItemData("Redstone Ore (lit)"));
		lt.put(Material.GLOWSTONE, new ItemData("Glowstone"));
		lt.put(Material.GLOWSTONE_DUST, new ItemData("Glowstone Dust"));
		lt.put(Material.GOLD_AXE, new ItemData("Golden Axe", true, false));
		lt.put(Material.GOLD_BARDING, new ItemData("Golden Horse Armor"));
		lt.put(Material.GOLD_BLOCK, new ItemData("Golden Block"));
		lt.put(Material.GOLD_BOOTS, new ItemData("Golden Boots", false, true));
		lt.put(Material.GOLD_CHESTPLATE, new ItemData("Golden Chestplate",
				false, true));
		lt.put(Material.GOLDEN_APPLE, new ItemData("Golden Apple"));
		lt.put(Material.GOLDEN_CARROT, new ItemData("Golden Carrot"));
		lt.put(Material.GOLD_HELMET, new ItemData("Golden Helmet", false, true));
		lt.put(Material.GOLD_HOE, new ItemData("Golden Hoe"));
		lt.put(Material.GOLD_INGOT, new ItemData("Gold Ingot"));
		lt.put(Material.GOLD_LEGGINGS, new ItemData("Golden Leggings", false,
				true));
		lt.put(Material.GOLD_NUGGET, new ItemData("Gold Nugget"));
		lt.put(Material.GOLD_ORE, new ItemData("Gold Ore"));
		lt.put(Material.GOLD_PICKAXE, new ItemData("Golden Pickaxe", true,
				false));
		lt.put(Material.GOLD_PLATE, new ItemData("Gold Pressure Plate"));
		lt.put(Material.GOLD_RECORD, new ItemData("Gold Record"));
		lt.put(Material.GOLD_SPADE, new ItemData("Golden Shovel", true, false));
		lt.put(Material.GOLD_SWORD, new ItemData("Golden Sword", true, false));
		lt.put(Material.GRASS, new ItemData("Grass"));
		lt.put(Material.GRAVEL, new ItemData("Gravel"));
		lt.put(Material.GREEN_RECORD, new ItemData("Green Record"));
		lt.put(Material.GRILLED_PORK, new ItemData("Cooked Pork"));
		lt.put(Material.HARD_CLAY, new ItemData("Hardened Clay"));
		lt.put(Material.HAY_BLOCK, new ItemData("Hay Bale"));
		lt.put(Material.HOPPER, new ItemData("Hopper"));
		lt.put(Material.HOPPER_MINECART, new ItemData("Minecart with Hopper"));
		lt.put(Material.HUGE_MUSHROOM_1, new ItemData("Huge Mushroom"));
		lt.put(Material.HUGE_MUSHROOM_2, new ItemData("Huge Mushroom"));
		lt.put(Material.ICE, new ItemData("Ice"));
		lt.put(Material.INK_SACK, new ItemData("Ink Sac"));
		lt.put(Material.IRON_AXE, new ItemData("Iron Axe", true, false));
		lt.put(Material.IRON_BARDING, new ItemData("Iron Horse Armor"));
		lt.put(Material.IRON_BLOCK, new ItemData("Block of Iron"));
		lt.put(Material.IRON_BOOTS, new ItemData("Iron Boots", false, true));
		lt.put(Material.IRON_CHESTPLATE, new ItemData("Iron Chestplate", false,
				true));
		lt.put(Material.IRON_DOOR, new ItemData("Iron Door"));
		lt.put(Material.IRON_DOOR_BLOCK, new ItemData("Iron Door (block)"));
		lt.put(Material.IRON_FENCE, new ItemData("Iron Bars"));
		lt.put(Material.IRON_HELMET, new ItemData("Iron Helmet", false, true));
		lt.put(Material.IRON_HOE, new ItemData("Iron Hoe"));
		lt.put(Material.IRON_INGOT, new ItemData("Iron Ingot"));
		lt.put(Material.IRON_LEGGINGS, new ItemData("Iron Leggings", false,
				true));
		lt.put(Material.IRON_ORE, new ItemData("Iron Ore"));
		lt.put(Material.IRON_PICKAXE, new ItemData("Iron Pickaxe", true, false));
		lt.put(Material.IRON_PLATE, new ItemData("Iron Pressure Plate"));
		lt.put(Material.IRON_SPADE, new ItemData("Iron Shovel", true, false));
		lt.put(Material.IRON_SWORD, new ItemData("Iron Sword", true, false));
		lt.put(Material.IRON_TRAPDOOR, new ItemData("Iron Trapdoor"));
		lt.put(Material.ITEM_FRAME, new ItemData("Item Frame"));
		lt.put(Material.JACK_O_LANTERN, new ItemData("Jack o' Lantern"));
		lt.put(Material.JUKEBOX, new ItemData("Jukebox"));
		lt.put(Material.JUNGLE_DOOR, new ItemData("Jungle Wood Door (block)"));
		lt.put(Material.JUNGLE_DOOR_ITEM, new ItemData("Jungle Wood Door"));
		lt.put(Material.JUNGLE_FENCE, new ItemData("Jungle Wood Fence"));
		lt.put(Material.JUNGLE_FENCE_GATE, new ItemData(
				"Jungle Wood Fence Gate"));
		lt.put(Material.JUNGLE_WOOD_STAIRS, new ItemData("Jungle Wood Stairs"));
		lt.put(Material.LADDER, new ItemData("Ladder"));
		lt.put(Material.LAPIS_BLOCK, new ItemData("Block of Lapis"));
		lt.put(Material.LAPIS_ORE, new ItemData("Lapis Ore"));
		lt.put(Material.LAVA, new ItemData("Lava"));
		lt.put(Material.LAVA_BUCKET, new ItemData("Lava Bucket"));
		lt.put(Material.LEASH, new ItemData("Leash"));
		lt.put(Material.LEATHER, new ItemData("Leather"));
		lt.put(Material.LEATHER_BOOTS, new ItemData("Leather Boots", false,
				true));
		lt.put(Material.LEATHER_CHESTPLATE, new ItemData("Leather Chestplate",
				false, true));
		lt.put(Material.LEATHER_HELMET,
				new ItemData("Leather Hat", false, true));
		lt.put(Material.LEATHER_LEGGINGS, new ItemData("Leather Pants", false,
				true));
		lt.put(Material.LEAVES, new ItemData("Leaves"));
		lt.put(Material.LEAVES_2, new ItemData("Leaves"));
		lt.put(Material.LEVER, new ItemData("Lever"));
		lt.put(Material.LOG, new ItemData("Log"));
		lt.put(Material.LOG_2, new ItemData("Log"));
		lt.put(Material.LONG_GRASS, new ItemData("Long Grass"));
		lt.put(Material.MAGMA_CREAM, new ItemData("Magma Cream"));
		lt.put(Material.MAP, new ItemData("Map"));
		lt.put(Material.MELON, new ItemData("Melon"));
		lt.put(Material.MELON_BLOCK, new ItemData("Melon Block"));
		lt.put(Material.MELON_SEEDS, new ItemData("Melon Seeds"));
		lt.put(Material.MELON_STEM, new ItemData("Melon Stem"));
		lt.put(Material.MILK_BUCKET, new ItemData("Milk Bucket"));
		lt.put(Material.MINECART, new ItemData("Minecart"));
		lt.put(Material.MOB_SPAWNER, new ItemData("Mob Spawner"));
		lt.put(Material.MONSTER_EGG, new ItemData("Monster Egg"));
		lt.put(Material.MONSTER_EGGS, new ItemData("Monster Eggs"));
		lt.put(Material.MOSSY_COBBLESTONE, new ItemData("Mossy Cobblestone"));
		lt.put(Material.MUSHROOM_SOUP, new ItemData("Mushroom Soup"));
		lt.put(Material.MUTTON, new ItemData("Mutton"));
		lt.put(Material.MYCEL, new ItemData("Mycelium"));
		lt.put(Material.NAME_TAG, new ItemData("Name Tag"));
		lt.put(Material.NETHER_BRICK, new ItemData("Nether Bricks"));
		lt.put(Material.NETHER_BRICK_ITEM, new ItemData("Nether Brick"));
		lt.put(Material.NETHER_BRICK_STAIRS,
				new ItemData("Nether Brick Stairs"));
		lt.put(Material.NETHER_FENCE, new ItemData("Nether Brick Fence"));
		lt.put(Material.NETHERRACK, new ItemData("Netherrack"));
		lt.put(Material.NETHER_STALK, new ItemData("Nether Wart"));
		lt.put(Material.NETHER_STAR, new ItemData("Nether Star"));
		lt.put(Material.NETHER_WARTS, new ItemData("Nether Wart"));
		lt.put(Material.NOTE_BLOCK, new ItemData("Note Block"));
		lt.put(Material.OBSIDIAN, new ItemData("Obsidian"));
		lt.put(Material.PACKED_ICE, new ItemData("Packed Ice"));
		lt.put(Material.PAINTING, new ItemData("Painting"));
		lt.put(Material.PAPER, new ItemData("Paper"));
		lt.put(Material.PISTON_BASE, new ItemData("Piston"));
		lt.put(Material.PISTON_EXTENSION, new ItemData("Piston"));
		lt.put(Material.PISTON_MOVING_PIECE, new ItemData("Piston"));
		lt.put(Material.PISTON_STICKY_BASE, new ItemData("Sticky Piston"));
		lt.put(Material.POISONOUS_POTATO, new ItemData("Poisonous Potato"));
		lt.put(Material.PORK, new ItemData("Pork"));
		lt.put(Material.PORTAL, new ItemData("Nether Portal"));
		lt.put(Material.POTATO, new ItemData("Potato (block)"));
		lt.put(Material.POTATO_ITEM, new ItemData("Potato"));
		lt.put(Material.POTION, new ItemData("Potion"));
		lt.put(Material.POWERED_MINECART, new ItemData("Minecart with Furnace"));
		lt.put(Material.POWERED_RAIL, new ItemData("Powered Rail"));
		lt.put(Material.PRISMARINE, new ItemData("Prismarine"));
		lt.put(Material.PRISMARINE_CRYSTALS,
				new ItemData("Prismarine Crystals"));
		lt.put(Material.PRISMARINE_SHARD, new ItemData("Prismarine Shard"));
		lt.put(Material.PUMPKIN, new ItemData("Pumpkin"));
		lt.put(Material.PUMPKIN_PIE, new ItemData("Pumpkin Pie"));
		lt.put(Material.PUMPKIN_SEEDS, new ItemData("Pumpkin Seeds"));
		lt.put(Material.PUMPKIN_STEM, new ItemData("Pumpkin Stem"));
		lt.put(Material.QUARTZ, new ItemData("Nether Quartz"));
		lt.put(Material.QUARTZ_BLOCK, new ItemData("Nether Quartz Block"));
		lt.put(Material.QUARTZ_ORE, new ItemData("Nether Quartz Ore"));
		lt.put(Material.QUARTZ_STAIRS, new ItemData("Nether Quartz Stairs"));
		lt.put(Material.RABBIT, new ItemData("Rabbit"));
		lt.put(Material.RABBIT_FOOT, new ItemData("Rabbit's Foot"));
		lt.put(Material.RABBIT_HIDE, new ItemData("Rabbit Hide"));
		lt.put(Material.RABBIT_STEW, new ItemData("Rabbit Stew"));
		lt.put(Material.RAILS, new ItemData("Rails"));
		lt.put(Material.RAW_BEEF, new ItemData("Raw Beef"));
		lt.put(Material.RAW_CHICKEN, new ItemData("Raw Chicken"));
		lt.put(Material.RAW_FISH, new ItemData("Raw Fish"));
		lt.put(Material.RECORD_10, new ItemData("Record 10"));
		lt.put(Material.RECORD_11, new ItemData("Record 11"));
		lt.put(Material.RECORD_12, new ItemData("Record 12"));
		lt.put(Material.RECORD_3, new ItemData("Record 3"));
		lt.put(Material.RECORD_4, new ItemData("Record 4"));
		lt.put(Material.RECORD_5, new ItemData("Record 5"));
		lt.put(Material.RECORD_6, new ItemData("Record 6"));
		lt.put(Material.RECORD_7, new ItemData("Record 7"));
		lt.put(Material.RECORD_8, new ItemData("Record 8"));
		lt.put(Material.RECORD_9, new ItemData("Record 9"));
		lt.put(Material.RED_MUSHROOM, new ItemData("Mushroom"));
		lt.put(Material.RED_ROSE, new ItemData("Poppy"));
		lt.put(Material.RED_SANDSTONE, new ItemData("Red Sandstone"));
		lt.put(Material.RED_SANDSTONE_STAIRS, new ItemData(
				"Red Sandstone Stairs"));
		lt.put(Material.REDSTONE, new ItemData("Redstone Dust"));
		lt.put(Material.REDSTONE_BLOCK, new ItemData("Block of Redstone"));
		lt.put(Material.REDSTONE_COMPARATOR, new ItemData("Comparator"));
		lt.put(Material.REDSTONE_COMPARATOR_OFF, new ItemData(
				"Comparator (off)"));
		lt.put(Material.REDSTONE_COMPARATOR_ON, new ItemData("Comparator (on)"));
		lt.put(Material.REDSTONE_LAMP_OFF, new ItemData("Redstone Lamp"));
		lt.put(Material.REDSTONE_LAMP_ON, new ItemData("Redstone Lamp (on)"));
		lt.put(Material.REDSTONE_ORE, new ItemData("Redstone Ore"));
		lt.put(Material.REDSTONE_TORCH_OFF,
				new ItemData("Redstone Torch (off)"));
		lt.put(Material.REDSTONE_TORCH_ON, new ItemData("Redstone Torch"));
		lt.put(Material.REDSTONE_WIRE, new ItemData("Redstone (block)"));
		lt.put(Material.ROTTEN_FLESH, new ItemData("Rotten Flesh"));
		lt.put(Material.SADDLE, new ItemData("Saddle"));
		lt.put(Material.SAND, new ItemData("Sand"));
		lt.put(Material.SANDSTONE, new ItemData("Sandstone"));
		lt.put(Material.SANDSTONE_STAIRS, new ItemData("Sandstone Stairs"));
		lt.put(Material.SAPLING, new ItemData("Sapling"));
		lt.put(Material.SEA_LANTERN, new ItemData("Sea Lantern"));
		lt.put(Material.SEEDS, new ItemData("Seeds"));
		lt.put(Material.SHEARS, new ItemData("Shears"));
		lt.put(Material.SIGN, new ItemData("Sign"));
		lt.put(Material.SIGN_POST, new ItemData("Floor Sign"));
		lt.put(Material.SKULL, new ItemData("Head"));
		lt.put(Material.SKULL_ITEM, new ItemData("Head"));
		lt.put(Material.SLIME_BALL, new ItemData("Slime Ball"));
		lt.put(Material.SLIME_BLOCK, new ItemData("Slime Block"));
		lt.put(Material.SMOOTH_BRICK, new ItemData("Stone Brick"));
		lt.put(Material.SMOOTH_STAIRS, new ItemData("Stone Brick Stairs"));
		lt.put(Material.SNOW, new ItemData("Snow"));
		lt.put(Material.SNOW_BALL, new ItemData("Snowball"));
		lt.put(Material.SNOW_BLOCK, new ItemData("Snow Block"));
		lt.put(Material.SOIL, new ItemData("Soil"));
		lt.put(Material.SOUL_SAND, new ItemData("Soul Sand"));
		lt.put(Material.SPECKLED_MELON, new ItemData("Glistening Melon"));
		lt.put(Material.SPIDER_EYE, new ItemData("Spider Eye"));
		lt.put(Material.SPONGE, new ItemData("Sponge"));
		lt.put(Material.SPRUCE_DOOR, new ItemData("Spruce Door (block)"));
		lt.put(Material.SPRUCE_DOOR_ITEM, new ItemData("Spruce Door"));
		lt.put(Material.SPRUCE_FENCE, new ItemData("Spruce Fence"));
		lt.put(Material.SPRUCE_FENCE_GATE, new ItemData("Spruce Fence Gate"));
		lt.put(Material.SPRUCE_WOOD_STAIRS, new ItemData("Spruce Wood Stairs"));
		lt.put(Material.STAINED_CLAY, new ItemData("Stained Clay"));
		lt.put(Material.STAINED_GLASS, new ItemData("Stained Glass"));
		lt.put(Material.STAINED_GLASS_PANE, new ItemData("Stained Glass Pane"));
		lt.put(Material.STANDING_BANNER, new ItemData("Banner"));
		lt.put(Material.STATIONARY_LAVA, new ItemData("Lava"));
		lt.put(Material.STATIONARY_WATER, new ItemData("Water"));
		lt.put(Material.STEP, new ItemData("Slab"));
		lt.put(Material.STICK, new ItemData("Stick"));
		lt.put(Material.STONE, new ItemData("Stone"));
		lt.put(Material.STONE_AXE, new ItemData("Stone Axe", true, false));
		lt.put(Material.STONE_BUTTON, new ItemData("Stone Button"));
		lt.put(Material.STONE_HOE, new ItemData("Stone Hoe"));
		lt.put(Material.STONE_PICKAXE, new ItemData("Stone Pickaxe", true,
				false));
		lt.put(Material.STONE_PLATE, new ItemData("Stone Pressure Plate"));
		lt.put(Material.STONE_SLAB2, new ItemData("Stone Slab"));
		lt.put(Material.STONE_SPADE, new ItemData("Stone Shovel", true, false));
		lt.put(Material.STONE_SWORD, new ItemData("Stone Sword", true, false));
		lt.put(Material.STORAGE_MINECART, new ItemData("Minecart with Chest"));
		lt.put(Material.STRING, new ItemData("String"));
		lt.put(Material.SUGAR, new ItemData("Sugar"));
		lt.put(Material.SUGAR_CANE, new ItemData("Sugar Cane"));
		lt.put(Material.SUGAR_CANE_BLOCK, new ItemData("Sugar Cane (block)"));
		lt.put(Material.SULPHUR, new ItemData("Gunpowder"));
		lt.put(Material.THIN_GLASS, new ItemData("Glass Pane"));
		lt.put(Material.TNT, new ItemData("TNT"));
		lt.put(Material.TORCH, new ItemData("Torch"));
		lt.put(Material.TRAP_DOOR, new ItemData("Trapdoor"));
		lt.put(Material.TRAPPED_CHEST, new ItemData("Trapped Chest"));
		lt.put(Material.TRIPWIRE, new ItemData("Tripwire"));
		lt.put(Material.TRIPWIRE_HOOK, new ItemData("Tripwire Hook"));
		lt.put(Material.VINE, new ItemData("Vine"));
		lt.put(Material.WALL_BANNER, new ItemData("Banner"));
		lt.put(Material.WALL_SIGN, new ItemData("Wall Sign"));
		lt.put(Material.WATCH, new ItemData("Clock"));
		lt.put(Material.WATER, new ItemData("Water"));
		lt.put(Material.WATER_BUCKET, new ItemData("Water Bucket"));
		lt.put(Material.WATER_LILY, new ItemData("Lily Pad"));
		lt.put(Material.WEB, new ItemData("Web"));
		lt.put(Material.WHEAT, new ItemData("Wheat"));
		lt.put(Material.WOOD, new ItemData("Wood"));
		lt.put(Material.WOOD_AXE, new ItemData("Wooden Axe", true, false));
		lt.put(Material.WOOD_BUTTON, new ItemData("Wooden Button"));
		lt.put(Material.WOOD_DOOR, new ItemData("Wooden Door"));
		lt.put(Material.WOOD_DOUBLE_STEP, new ItemData("Wooden Slab"));
		lt.put(Material.WOODEN_DOOR, new ItemData("Wooden Door"));
		lt.put(Material.WOOD_HOE, new ItemData("Wooden Hoe"));
		lt.put(Material.WOOD_PICKAXE, new ItemData("Wooden Pickaxe", true,
				false));
		lt.put(Material.WOOD_PLATE, new ItemData("Wooden Pressure Plate"));
		lt.put(Material.WOOD_SPADE, new ItemData("Wooden Shovel", true, false));
		lt.put(Material.WOOD_STAIRS, new ItemData("Wooden Stairs"));
		lt.put(Material.WOOD_STEP, new ItemData("Wooden Slab"));
		lt.put(Material.WOOD_SWORD, new ItemData("Wooden Sword", true, false));
		lt.put(Material.WOOL, new ItemData("Wool"));
		lt.put(Material.WORKBENCH, new ItemData("Crafting Table"));
		lt.put(Material.WRITTEN_BOOK, new ItemData("Written Book"));
		lt.put(Material.YELLOW_FLOWER, new ItemData("Dandelion"));
	}

	static class ItemData {
		String name;
		boolean isTool;
		boolean isArmor;

		ItemData(String n) {
			name = n;
			isTool = isArmor = false;
		}

		ItemData(String n, boolean iT, boolean iA) {
			name = n;
			isTool = iT;
			isArmor = iA;
		}
	}
}
