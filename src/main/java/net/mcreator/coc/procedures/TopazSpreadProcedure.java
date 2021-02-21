package net.mcreator.coc.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.coc.block.TopazoreBlock;
import net.mcreator.coc.block.DeadRadiantOreBlock;
import net.mcreator.coc.CocModElements;
import net.mcreator.coc.CocMod;

import java.util.Map;

@CocModElements.ModElement.Tag
public class TopazSpreadProcedure extends CocModElements.ModElement {
	public TopazSpreadProcedure(CocModElements instance) {
		super(instance, 328);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CocMod.LOGGER.warn("Failed to load dependency x for procedure TopazSpread!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CocMod.LOGGER.warn("Failed to load dependency y for procedure TopazSpread!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CocMod.LOGGER.warn("Failed to load dependency z for procedure TopazSpread!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CocMod.LOGGER.warn("Failed to load dependency world for procedure TopazSpread!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.LAVA.getDefaultState().getBlock())) {
			if ((Math.random() < 0.001)) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), TopazoreBlock.block.getDefaultState(), 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.LAVA.getDefaultState().getBlock())) {
			if ((Math.random() < 0.001)) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), TopazoreBlock.block.getDefaultState(), 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.LAVA.getDefaultState().getBlock())) {
			if ((Math.random() < 0.001)) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), TopazoreBlock.block.getDefaultState(), 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.LAVA.getDefaultState().getBlock())) {
			if ((Math.random() < 0.001)) {
				world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), TopazoreBlock.block.getDefaultState(), 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.LAVA.getDefaultState().getBlock())) {
			if ((Math.random() < 0.001)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), TopazoreBlock.block.getDefaultState(), 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.LAVA.getDefaultState().getBlock())) {
			if ((Math.random() < 0.001)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), TopazoreBlock.block.getDefaultState(), 3);
			}
		}
		if ((Math.random() < 0.008)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DeadRadiantOreBlock.block.getDefaultState(), 3);
		}
	}
}
