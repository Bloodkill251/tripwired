
package net.mcreator.tripwired.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.block.Blocks;

import net.mcreator.tripwired.block.KiroGrassBlock;
import net.mcreator.tripwired.TripwiredModElements;

import com.google.common.collect.ImmutableList;

@TripwiredModElements.ModElement.Tag
public class KiroBiome extends TripwiredModElements.ModElement {
	@ObjectHolder("tripwired:kiro")
	public static final CustomBiome biome = null;
	public KiroBiome(TripwiredModElements instance) {
		super(instance, 197);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}
	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder().downfall(0f).depth(10f).scale(2f).temperature(2f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.NONE).waterColor(-16777216).waterFogColor(-16777216)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(KiroGrassBlock.block.getDefaultState(),
							Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())));
			setRegistryName("kiro");
			DefaultBiomeFeatures.addCarvers(this);
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
					Feature.RANDOM_SELECTOR
							.withConfiguration(new MultipleRandomFeatureConfig(
									ImmutableList.of(Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.field_230129_h_).withChance(0.2F),
											Feature.FANCY_TREE.withConfiguration(DefaultBiomeFeatures.field_230131_m_).withChance(0.1F)),
									Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.field_230132_o_)))
							.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getGrassColor(double posX, double posZ) {
			return -8519936;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getFoliageColor() {
			return -8519936;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getSkyColor() {
			return -8585216;
		}
	}
}
