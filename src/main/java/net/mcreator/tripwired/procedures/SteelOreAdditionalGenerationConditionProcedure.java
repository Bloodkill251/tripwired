package net.mcreator.tripwired.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.tripwired.TripwiredModElements;

import java.util.Map;

@TripwiredModElements.ModElement.Tag
public class SteelOreAdditionalGenerationConditionProcedure extends TripwiredModElements.ModElement {
	public SteelOreAdditionalGenerationConditionProcedure(TripwiredModElements instance) {
		super(instance, 267);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure SteelOreAdditionalGenerationCondition!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return (Blocks.NETHERRACK.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) 0, (int) 100, (int) 0))).getBlock());
	}
}
