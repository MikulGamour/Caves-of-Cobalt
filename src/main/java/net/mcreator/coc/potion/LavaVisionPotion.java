
package net.mcreator.coc.potion;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Potion;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effect;

import net.mcreator.coc.CocModElements;

@CocModElements.ModElement.Tag
public class LavaVisionPotion extends CocModElements.ModElement {
	@ObjectHolder("coc:lavavision")
	public static final Effect potion = null;
	@ObjectHolder("coc:lavavision")
	public static final Potion potionType = null;
	public LavaVisionPotion(CocModElements instance) {
		super(instance, 655);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerEffect(RegistryEvent.Register<Effect> event) {
		event.getRegistry().register(new EffectCustom());
	}

	@SubscribeEvent
	public void registerPotion(RegistryEvent.Register<Potion> event) {
		event.getRegistry().register(new PotionCustom());
	}
	public static class PotionCustom extends Potion {
		public PotionCustom() {
			super(new EffectInstance(potion, 3600));
			setRegistryName("lavavision");
		}
	}

	public static class EffectCustom extends Effect {
		private final ResourceLocation potionIcon;
		public EffectCustom() {
			super(EffectType.BENEFICIAL, -39322);
			setRegistryName("lavavision");
			potionIcon = new ResourceLocation("coc:textures/lava_vision.png");
		}

		@Override
		public String getName() {
			return "effect.lavavision";
		}

		@Override
		public boolean isBeneficial() {
			return true;
		}

		@Override
		public boolean isInstant() {
			return false;
		}

		@Override
		public boolean shouldRenderInvText(EffectInstance effect) {
			return true;
		}

		@Override
		public boolean shouldRender(EffectInstance effect) {
			return true;
		}

		@Override
		public boolean shouldRenderHUD(EffectInstance effect) {
			return true;
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}
	}
}
