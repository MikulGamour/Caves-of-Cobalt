
package net.mcreator.coc.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.coc.CocModElements;

@CocModElements.ModElement.Tag
public class ShaleCoalOreBlock extends CocModElements.ModElement {
	@ObjectHolder("coc:shale_coal_ore")
	public static final Block block = null;
	public ShaleCoalOreBlock(CocModElements instance) {
		super(instance, 1025);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1f, 3f).lightValue(0).harvestLevel(0)
					.harvestTool(ToolType.PICKAXE));
			setRegistryName("shale_coal_ore");
		}
	}
}
