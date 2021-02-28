package net.mcreator.coc.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.coc.CocModVariables;
import net.mcreator.coc.CocModElements;
import net.mcreator.coc.CocMod;

import java.util.Map;

@CocModElements.ModElement.Tag
public class CaveCrawlerAlertLocationProcedure extends CocModElements.ModElement {
	public CaveCrawlerAlertLocationProcedure(CocModElements instance) {
		super(instance, 482);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CocMod.LOGGER.warn("Failed to load dependency x for procedure CaveCrawlerAlertLocation!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CocMod.LOGGER.warn("Failed to load dependency y for procedure CaveCrawlerAlertLocation!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CocMod.LOGGER.warn("Failed to load dependency z for procedure CaveCrawlerAlertLocation!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CocMod.LOGGER.warn("Failed to load dependency world for procedure CaveCrawlerAlertLocation!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		CocModVariables.WorldVariables.get(world).CrabHurtX = (double) x;
		CocModVariables.WorldVariables.get(world).syncData(world);
		CocModVariables.WorldVariables.get(world).CrabHurtY = (double) y;
		CocModVariables.WorldVariables.get(world).syncData(world);
		CocModVariables.WorldVariables.get(world).CrabHurtZ = (double) z;
		CocModVariables.WorldVariables.get(world).syncData(world);
	}
}
