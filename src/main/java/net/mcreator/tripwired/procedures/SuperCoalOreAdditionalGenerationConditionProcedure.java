package net.mcreator.tripwired.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.tripwired.TripwiredModElements;

import java.util.Map;

@TripwiredModElements.ModElement.Tag
public class SuperCoalOreAdditionalGenerationConditionProcedure extends TripwiredModElements.ModElement {
	public SuperCoalOreAdditionalGenerationConditionProcedure(TripwiredModElements instance) {
		super(instance, 290);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure SuperCoalOreAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure SuperCoalOreAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure SuperCoalOreAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure SuperCoalOreAdditionalGenerationCondition!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Blocks.COAL_ORE.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())) {
			return (true);
		}
		return (false);
	}
}