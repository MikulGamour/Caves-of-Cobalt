package net.mcreator.coc.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.potion.EffectInstance;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.coc.potion.ToadstoolTreatmentPotion;
import net.mcreator.coc.CocModElements;
import net.mcreator.coc.CocMod;

import java.util.Map;

@CocModElements.ModElement.Tag
public class ShroomilkDrinkProcedure extends CocModElements.ModElement {
	public ShroomilkDrinkProcedure(CocModElements instance) {
		super(instance, 394);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CocMod.LOGGER.warn("Failed to load dependency entity for procedure ShroomilkDrink!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(ToadstoolTreatmentPotion.potion, (int) 2400, (int) 0));
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
			_setstack.setCount((int) 1);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
	}
}
