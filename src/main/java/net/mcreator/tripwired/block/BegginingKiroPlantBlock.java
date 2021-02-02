
package net.mcreator.tripwired.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.PushReaction;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.tripwired.procedures.BegginingKiroPlantUpdateTickProcedure;
import net.mcreator.tripwired.item.KiroSeedsItem;
import net.mcreator.tripwired.TripwiredModElements;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

@TripwiredModElements.ModElement.Tag
public class BegginingKiroPlantBlock extends TripwiredModElements.ModElement {
	@ObjectHolder("tripwired:beggining_kiro_plant")
	public static final Block block = null;
	public BegginingKiroPlantBlock(TripwiredModElements instance) {
		super(instance, 274);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.PLANTS).sound(SoundType.CROP).hardnessAndResistance(0f, 10f).lightValue(0).doesNotBlockMovement()
					.notSolid().tickRandomly());
			setRegistryName("beggining_kiro_plant");
		}

		@Override
		public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return false;
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
			return new ItemStack(KiroSeedsItem.block, (int) (1));
		}

		@Override
		public MaterialColor getMaterialColor(BlockState state, IBlockReader blockAccess, BlockPos pos) {
			return MaterialColor.AIR;
		}

		@Override
		public PushReaction getPushReaction(BlockState state) {
			return PushReaction.DESTROY;
		}

		@Override
		public void tick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
			super.tick(state, world, pos, random);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				BegginingKiroPlantUpdateTickProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
