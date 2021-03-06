package net.mcreator.coc.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

import net.mcreator.coc.CocModElements;
import net.mcreator.coc.CocMod;

import java.util.Map;

@CocModElements.ModElement.Tag
public class MushroomTestProcedure extends CocModElements.ModElement {
	public MushroomTestProcedure(CocModElements instance) {
		super(instance, 337);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CocMod.LOGGER.warn("Failed to load dependency x for procedure MushroomTest!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CocMod.LOGGER.warn("Failed to load dependency y for procedure MushroomTest!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CocMod.LOGGER.warn("Failed to load dependency z for procedure MushroomTest!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CocMod.LOGGER.warn("Failed to load dependency world for procedure MushroomTest!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!(BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:mushroom_placeable").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock())))) {
			world.playEvent(2001, new BlockPos((int) x, (int) y, (int) z),
					Block.getStateId(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))));
			Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), world.getWorld(), new BlockPos((int) x, (int) y, (int) z));
			world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
		}
		if (((world.canBlockSeeSky(new BlockPos((int) x, (int) y, (int) z)))
				&& (!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.MYCELIUM.getDefaultState()
						.getBlock())))) {
			if ((Math.random() < 0.005)) {
				world.playEvent(2001, new BlockPos((int) x, (int) y, (int) z),
						Block.getStateId(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))));
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), world.getWorld(),
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
			}
		}
	}
}
