package net.mcreator.tripwired.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.tripwired.TripwiredModElements;

import java.util.Map;

@TripwiredModElements.ModElement.Tag
public class HealCommandExecutedProcedure extends TripwiredModElements.ModElement {
	public HealCommandExecutedProcedure(TripwiredModElements instance) {
		super(instance, 253);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure HealCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
	}
}
