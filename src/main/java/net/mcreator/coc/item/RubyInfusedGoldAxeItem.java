
package net.mcreator.coc.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.coc.itemgroup.JewelingItemGroup;
import net.mcreator.coc.CocModElements;

import java.util.List;

@CocModElements.ModElement.Tag
public class RubyInfusedGoldAxeItem extends CocModElements.ModElement {
	@ObjectHolder("coc:gold_axe_ruby")
	public static final Item block = null;
	public RubyInfusedGoldAxeItem(CocModElements instance) {
		super(instance, 246);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 600;
			}

			public float getEfficiency() {
				return 14f;
			}

			public float getAttackDamage() {
				return 8f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 22;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(RubyItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(JewelingItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A74Ruby\u00A7r"));
			}
		}.setRegistryName("gold_axe_ruby"));
	}
}
