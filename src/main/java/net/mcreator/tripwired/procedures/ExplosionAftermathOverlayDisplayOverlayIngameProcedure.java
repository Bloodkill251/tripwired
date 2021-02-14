package net.mcreator.tripwired.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.tripwired.potion.AcidImmunityPotion;
import net.mcreator.tripwired.TripwiredModElements;

import java.util.Map;
import java.util.Collection;

@TripwiredModElements.ModElement.Tag
public class ExplosionAftermathOverlayDisplayOverlayIngameProcedure extends TripwiredModElements.ModElement {
	public ExplosionAftermathOverlayDisplayOverlayIngameProcedure(TripwiredModElements instance) {
		super(instance, 293);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ExplosionAftermathOverlayDisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((true) == (new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == AcidImmunityPotion.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity)))) {
			return (true);
		}
		return (false);
	}
}
