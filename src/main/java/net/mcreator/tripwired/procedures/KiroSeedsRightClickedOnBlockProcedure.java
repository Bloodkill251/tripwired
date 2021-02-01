package net.mcreator.tripwired.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.tripwired.TripwiredModElements;

import java.util.Map;

@TripwiredModElements.ModElement.Tag
public class KiroSeedsRightClickedOnBlockProcedure extends TripwiredModElements.ModElement {
	public KiroSeedsRightClickedOnBlockProcedure(TripwiredModElements instance) {
		super(instance, 272);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure KiroSeedsRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure KiroSeedsRightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Blocks.FARMLAND.getDefaultState()
				.getBlock() == (world
						.getBlockState(
								new BlockPos(
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 4, entity.getLook(1f).y * 4,
														entity.getLook(1f).z * 4),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 4, entity.getLook(1f).y * 4,
														entity.getLook(1f).z * 4),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 4, entity.getLook(1f).y * 4,
														entity.getLook(1f).z * 4),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()))))
														.getBlock())) {
			if ((Blocks.AIR.getDefaultState()
					.getBlock() == (world.getBlockState(
							new BlockPos(
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(
											entity.getEyePosition(1f),
											entity.getEyePosition(1f)
													.add(entity.getLook(1f).x * 4, entity.getLook(1f).y * 4, entity.getLook(1f).z * 4),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
									(int) ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 4, entity.getLook(1f).y * 4,
													entity.getLook(1f).z * 4),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()) - 1),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 4, entity.getLook(1f).y * 4,
													entity.getLook(1f).z * 4),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()))))
													.getBlock())) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Blocks.AIR, (int) (1));
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
				world.setBlockState(
						new BlockPos(
								(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 4, entity.getLook(1f).y * 4, entity.getLook(1f).z * 4),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
								(int) ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 4, entity.getLook(1f).y * 4, entity.getLook(1f).z * 4),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()) - 1),
								(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 4, entity.getLook(1f).y * 4, entity.getLook(1f).z * 4),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())),
						Blocks.AIR.getDefaultState(), 3);
			}
		}
	}
}
