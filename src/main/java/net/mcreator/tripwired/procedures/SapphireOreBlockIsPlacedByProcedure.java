package net.mcreator.tripwired.procedures;

@TripwiredModElements.ModElement.Tag
public class SapphireOreBlockIsPlacedByProcedure extends TripwiredModElements.ModElement {

	public SapphireOreBlockIsPlacedByProcedure(TripwiredModElements instance) {
		super(instance, 135);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure SapphireOreBlockIsPlacedBy!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure SapphireOreBlockIsPlacedBy!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure SapphireOreBlockIsPlacedBy!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure SapphireOreBlockIsPlacedBy!");
			return;
		}

		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if ((AcidBlock.block.getDefaultState()
				.getBlock() == /*@BlockState*/(world.getFluidState(new BlockPos((int) x, (int) (y + 1), (int) z)).getBlockState()).getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.DIAMOND_ORE.getDefaultState(), 3);
		}

	}

}
