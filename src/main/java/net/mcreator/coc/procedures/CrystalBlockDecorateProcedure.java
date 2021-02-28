package net.mcreator.coc.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;

import net.mcreator.coc.block.CrystalSpikes2Block;
import net.mcreator.coc.block.CrystalSpikes1Block;
import net.mcreator.coc.CocModElements;
import net.mcreator.coc.CocMod;

import java.util.Map;

@CocModElements.ModElement.Tag
public class CrystalBlockDecorateProcedure extends CocModElements.ModElement {
	public CrystalBlockDecorateProcedure(CocModElements instance) {
		super(instance, 537);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CocMod.LOGGER.warn("Failed to load dependency x for procedure CrystalBlockDecorate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CocMod.LOGGER.warn("Failed to load dependency y for procedure CrystalBlockDecorate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CocMod.LOGGER.warn("Failed to load dependency z for procedure CrystalBlockDecorate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CocMod.LOGGER.warn("Failed to load dependency world for procedure CrystalBlockDecorate!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!(new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "player")))) {
			if (((Math.random() < 0.75) && (world.isAirBlock(new BlockPos((int) x, (int) (y + 1), (int) z))))) {
				if ((Math.random() < 0.5)) {
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), CrystalSpikes1Block.block.getDefaultState(), 3);
				} else {
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), CrystalSpikes2Block.block.getDefaultState(), 3);
				}
			}
			if (((Math.random() < 0.75) && (world.isAirBlock(new BlockPos((int) (x + 1), (int) y, (int) z))))) {
				if ((Math.random() < 0.5)) {
					world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), CrystalSpikes1Block.block.getDefaultState(), 3);
				} else {
					world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), CrystalSpikes2Block.block.getDefaultState(), 3);
				}
			}
			if (((Math.random() < 0.75) && (world.isAirBlock(new BlockPos((int) (x - 1), (int) y, (int) z))))) {
				if ((Math.random() < 0.5)) {
					world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), CrystalSpikes1Block.block.getDefaultState(), 3);
				} else {
					world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), CrystalSpikes2Block.block.getDefaultState(), 3);
				}
			}
			if (((Math.random() < 0.75) && (world.isAirBlock(new BlockPos((int) x, (int) y, (int) (z + 1)))))) {
				if ((Math.random() < 0.5)) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), CrystalSpikes1Block.block.getDefaultState(), 3);
				} else {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), CrystalSpikes2Block.block.getDefaultState(), 3);
				}
			}
			if (((Math.random() < 0.75) && (world.isAirBlock(new BlockPos((int) x, (int) y, (int) (z - 1)))))) {
				if ((Math.random() < 0.5)) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), CrystalSpikes1Block.block.getDefaultState(), 3);
				} else {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), CrystalSpikes2Block.block.getDefaultState(), 3);
				}
			}
		}
	}
}
