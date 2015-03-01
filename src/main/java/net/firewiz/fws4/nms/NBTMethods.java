package net.firewiz.fws4.nms;

import net.minecraft.server.v1_8_R1.NBTTagCompound;
import net.minecraft.server.v1_8_R1.NBTTagList;
import net.minecraft.server.v1_8_R1.NBTTagString;

import org.bukkit.craftbukkit.v1_8_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;

public class NBTMethods {
	public static <T extends Entity> NBTTagCompound getTag(T entity) {
		NBTTagCompound compound = new NBTTagCompound();

		if (!(entity instanceof Entity)) return null;

		net.minecraft.server.v1_8_R1.Entity nms = ((CraftEntity) entity)
				.getHandle();

		nms.c(compound);
		
		return compound;
	}

	public static void setTag(Entity object, NBTTagCompound t) {
		CraftEntity craft = ((CraftEntity) object);
		net.minecraft.server.v1_8_R1.Entity nms = craft.getHandle();
		nms.f(t);
		craft.setHandle(nms);
	}
	
	public static void setItemLore(Item i, String[] s) {
		NBTTagCompound root    = getTag(i);
		NBTTagCompound tag     = root.getCompound("tag");
		NBTTagCompound display = tag.getCompound("display");
		NBTTagList     lore    = new NBTTagList();
		for(String st : s) {
			lore.add(new NBTTagString(st));
		}
		display.set("Lore", lore);
		tag.set("display", display);
		root.set("tag", tag);
		setTag(i, root);
	}
}
