
package net.mcreator.coc.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.coc.itemgroup.JewelingItemGroup;
import net.mcreator.coc.CocModElements;

import java.util.List;

@CocModElements.ModElement.Tag
public class GoldHoeRubyItem extends CocModElements.ModElement {
	@ObjectHolder("coc:gold_hoe_ruby")
	public static final Item block = null;
	public GoldHoeRubyItem(CocModElements instance) {
		super(instance, 248);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 800;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(RubyItem.block, (int) (1)));
			}
		}, -3f, new Item.Properties().group(JewelingItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A7cRuby\u00A7r"));
				list.add(new StringTextComponent("\u00A78Harvests a 3x3 of crops"));
			}
		}.setRegistryName("gold_hoe_ruby"));
	}
}
