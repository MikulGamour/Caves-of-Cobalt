package net.mcreator.coc.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.coc.CocModElements;
import net.mcreator.coc.CocMod;

import java.util.Map;

@CocModElements.ModElement.Tag
public class StalagmetCrabResetTimeProcedure extends CocModElements.ModElement {
	public StalagmetCrabResetTimeProcedure(CocModElements instance) {
		super(instance, 481);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CocMod.LOGGER.warn("Failed to load dependency entity for procedure StalagmetCrabResetTime!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("time", 0);
	}
}
