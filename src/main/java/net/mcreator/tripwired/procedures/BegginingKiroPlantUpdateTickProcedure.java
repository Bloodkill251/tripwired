package net.mcreator.tripwired.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;

import net.mcreator.tripwired.block.KiroplantBlock;
import net.mcreator.tripwired.TripwiredModElements;

import java.util.Map;

@TripwiredModElements.ModElement.Tag
public class BegginingKiroPlantUpdateTickProcedure extends TripwiredModElements.ModElement {
	public BegginingKiroPlantUpdateTickProcedure(TripwiredModElements instance) {
		super(instance, 281);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure BegginingKiroPlantUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure BegginingKiroPlantUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure BegginingKiroPlantUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure BegginingKiroPlantUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Math.round((Math.random() * 999)) == 7)) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = KiroplantBlock.block.getDefaultState();
				world.setBlockState(_bp, _bs, 3);
			}
		}
	}
}
