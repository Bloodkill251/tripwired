package net.mcreator.tripwired.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.tripwired.enchantment.InfiniteRegenerationEnchantment;
import net.mcreator.tripwired.TripwiredModElements;

import java.util.Map;
import java.util.HashMap;

@TripwiredModElements.ModElement.Tag
public class IfPlayerChestplateHasEnchantmentInfiniteRegenerationProcedure extends TripwiredModElements.ModElement {
	public IfPlayerChestplateHasEnchantmentInfiniteRegenerationProcedure(TripwiredModElements instance) {
		super(instance, 163);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure IfPlayerChestplateHasEnchantmentInfiniteRegeneration!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double number = 0;
		String dwd = "";
		if ((!((EnchantmentHelper.getEnchantmentLevel(InfiniteRegenerationEnchantment.enchantment,
				((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2) : ItemStack.EMPTY))) == 0))) {
			entity.getPersistentData().putDouble("a", ((entity.getPersistentData().getDouble("a")) + 1));
			if ((((entity.getPersistentData().getDouble("a")) % 100) == 0)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 101,
							(int) ((EnchantmentHelper.getEnchantmentLevel(InfiniteRegenerationEnchantment.enchantment,
									((entity instanceof PlayerEntity)
											? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2)
											: ItemStack.EMPTY)))
									- 1),
							(true), (false)));
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
