
package net.mcreator.coc.world.structure;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.coc.procedures.FinishGenerationProcedure;
import net.mcreator.coc.CocModElements;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

@CocModElements.ModElement.Tag
public class PopulateUnderground10Structure extends CocModElements.ModElement {
	private static final Feature<NoFeatureConfig> feature = new Feature<NoFeatureConfig>(NoFeatureConfig::deserialize) {
		@Override
		public boolean place(IWorld world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
			int ci = (pos.getX() >> 4) << 4;
			int ck = (pos.getZ() >> 4) << 4;
			DimensionType dimensionType = world.getDimension().getType();
			boolean dimensionCriteria = false;
			if (dimensionType == DimensionType.OVERWORLD)
				dimensionCriteria = true;
			if (!dimensionCriteria)
				return false;
			if ((random.nextInt(1000000) + 1) <= 50000) {
				int count = random.nextInt(2) + 1;
				for (int a = 0; a < count; a++) {
					int i = ci + random.nextInt(16);
					int k = ck + random.nextInt(16);
					int j = world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, i, k);
					j = Math.abs(random.nextInt(Math.max(1, j)) - 24);
					BlockState blockAt = world.getBlockState(new BlockPos(i, j, k));
					boolean blockCriteria = false;
					if (blockAt.getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())
						blockCriteria = true;
					if (!blockCriteria)
						continue;
					Rotation rotation = Rotation.NONE;
					Mirror mirror = Mirror.NONE;
					BlockPos spawnTo = new BlockPos(i + 0, j + 0, k + 0);
					int x = spawnTo.getX();
					int y = spawnTo.getY();
					int z = spawnTo.getZ();
					Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("coc", "cave_feature"));
					if (template == null)
						return false;
					template.addBlocksToWorld(world, spawnTo, new PlacementSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
							.addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK).setChunk(null).setIgnoreEntities(false));
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						$_dependencies.put("world", world);
						FinishGenerationProcedure.executeProcedure($_dependencies);
					}
				}
			}
			return true;
		}
	};
	public PopulateUnderground10Structure(CocModElements instance) {
		super(instance, 728);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerFeature(RegistryEvent.Register<Feature<?>> event) {
		event.getRegistry().register(feature.setRegistryName("populateunderground10"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, feature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
					.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		}
	}
}
