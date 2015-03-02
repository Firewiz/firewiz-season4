package net.firewiz.fws4.nms;

import net.minecraft.server.v1_8_R1.NBTTagCompound;

import org.bukkit.craftbukkit.v1_8_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;

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
}
