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

import net.mcreator.tripwired.enchantment.BonusHealthEnchantment;
import net.mcreator.tripwired.TripwiredModElements;

import java.util.Map;
import java.util.HashMap;

@TripwiredModElements.ModElement.Tag
public class BonusHealthEnchantmentOnArmorProcedure extends TripwiredModElements.ModElement {
	public BonusHealthEnchantmentOnArmorProcedure(TripwiredModElements instance) {
		super(instance, 227);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure BonusHealthEnchantmentOnArmor!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double ee = 0;
		if (((((EnchantmentHelper.getEnchantmentLevel(BonusHealthEnchantment.enchantment,
				((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 3) : ItemStack.EMPTY)))
				+ ((EnchantmentHelper.getEnchantmentLevel(BonusHealthEnchantment.enchantment,
						((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 1) : ItemStack.EMPTY)))
						+ (EnchantmentHelper.getEnchantmentLevel(BonusHealthEnchantment.enchantment,
								((entity instanceof PlayerEntity)
										? ((PlayerEntity) entity).inventory.armorInventory.get((int) 0)
										: ItemStack.EMPTY)))))
				+ (EnchantmentHelper.getEnchantmentLevel(BonusHealthEnchantment.enchantment,
						((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2)
								: ItemStack.EMPTY)))) != 0)) {
			entity.getPersistentData().putDouble("counter1", ((entity.getPersistentData().getDouble("counter1")) + 1));
			if ((((entity.getPersistentData().getDouble("counter1")) % 2000) == 0)) {
				ee = (double) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1);
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, (int) 2020,
							(int) ((((EnchantmentHelper.getEnchantmentLevel(BonusHealthEnchantment.enchantment,
									((entity instanceof PlayerEntity)
											? ((PlayerEntity) entity).inventory.armorInventory.get((int) 3)
											: ItemStack.EMPTY)))
									+ ((EnchantmentHelper.getEnchantmentLevel(BonusHealthEnchantment.enchantment,
											((entity instanceof PlayerEntity)
													? ((PlayerEntity) entity).inventory.armorInventory.get((int) 1)
													: ItemStack.EMPTY)))
											+ (EnchantmentHelper.getEnchantmentLevel(BonusHealthEnchantment.enchantment,
													((entity instanceof PlayerEntity)
															? ((PlayerEntity) entity).inventory.armorInventory.get((int) 0)
															: ItemStack.EMPTY)))))
									+ (EnchantmentHelper.getEnchantmentLevel(BonusHealthEnchantment.enchantment,
											((entity instanceof PlayerEntity)
													? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2)
													: ItemStack.EMPTY))))
									- 1),
							(false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).setHealth((float) (ee));
				entity.getPersistentData().putDouble("counter1", 0);
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
