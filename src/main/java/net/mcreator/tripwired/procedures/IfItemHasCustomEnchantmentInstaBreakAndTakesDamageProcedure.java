package net.mcreator.tripwired.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.tripwired.enchantment.InstaBreakEnchantment;
import net.mcreator.tripwired.TripwiredModElements;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

@TripwiredModElements.ModElement.Tag
public class IfItemHasCustomEnchantmentInstaBreakAndTakesDamageProcedure extends TripwiredModElements.ModElement {
	public IfItemHasCustomEnchantmentInstaBreakAndTakesDamageProcedure(TripwiredModElements instance) {
		super(instance, 119);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure IfItemHasCustomEnchantmentInstaBreakAndTakesDamage!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double a = 0;
		if (((EnchantmentHelper.getEnchantmentLevel(InstaBreakEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0))) {
			if ((!(((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
					.getDamage()) == (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
							.getMaxDamage()) - 1)))) {
				if ((51 < (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getMaxDamage())
						- ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getDamage())))) {
					{
						ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 50, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				} else {
					{
						ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				}
			}
		} else if (((EnchantmentHelper.getEnchantmentLevel(InstaBreakEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)) != 0))) {
			if ((!(((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY))
					.getDamage()) == (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY))
							.getMaxDamage()) - 1)))) {
				if ((51 < (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).getMaxDamage())
						- ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).getDamage())))) {
					{
						ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 50, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				} else {
					{
						ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				}
			}
		} else if (((EnchantmentHelper.getEnchantmentLevel(InstaBreakEnchantment.enchantment,
				((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 0) : ItemStack.EMPTY)) != 0))) {
			if ((!(((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 0) : ItemStack.EMPTY))
					.getDamage()) == (((((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.armorInventory.get((int) 0)
							: ItemStack.EMPTY)).getMaxDamage()) - 1)))) {
				if ((51 < (((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 0) : ItemStack.EMPTY))
						.getMaxDamage())
						- ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 0) : ItemStack.EMPTY))
								.getDamage())))) {
					{
						ItemStack _ist = ((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.armorInventory.get((int) 0)
								: ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 50, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				} else {
					{
						ItemStack _ist = ((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.armorInventory.get((int) 0)
								: ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				}
			}
		} else if (((EnchantmentHelper.getEnchantmentLevel(InstaBreakEnchantment.enchantment,
				((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 1) : ItemStack.EMPTY)) != 0))) {
			if ((!(((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 1) : ItemStack.EMPTY))
					.getDamage()) == (((((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.armorInventory.get((int) 1)
							: ItemStack.EMPTY)).getMaxDamage()) - 1)))) {
				if ((51 < (((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 1) : ItemStack.EMPTY))
						.getMaxDamage())
						- ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 1) : ItemStack.EMPTY))
								.getDamage())))) {
					{
						ItemStack _ist = ((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.armorInventory.get((int) 1)
								: ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 50, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				} else {
					{
						ItemStack _ist = ((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.armorInventory.get((int) 1)
								: ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				}
			}
		} else if (((EnchantmentHelper.getEnchantmentLevel(InstaBreakEnchantment.enchantment,
				((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2) : ItemStack.EMPTY)) != 0))) {
			if ((!(((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2) : ItemStack.EMPTY))
					.getDamage()) == (((((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2)
							: ItemStack.EMPTY)).getMaxDamage()) - 1)))) {
				if ((51 < (((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2) : ItemStack.EMPTY))
						.getMaxDamage())
						- ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2) : ItemStack.EMPTY))
								.getDamage())))) {
					{
						ItemStack _ist = ((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2)
								: ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 50, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				} else {
					{
						ItemStack _ist = ((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2)
								: ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				}
			}
		} else if (((EnchantmentHelper.getEnchantmentLevel(InstaBreakEnchantment.enchantment,
				((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 3) : ItemStack.EMPTY)) != 0))) {
			if ((!(((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 3) : ItemStack.EMPTY))
					.getDamage()) == (((((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.armorInventory.get((int) 3)
							: ItemStack.EMPTY)).getMaxDamage()) - 1)))) {
				if ((51 < (((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 3) : ItemStack.EMPTY))
						.getMaxDamage())
						- ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 3) : ItemStack.EMPTY))
								.getDamage())))) {
					{
						ItemStack _ist = ((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.armorInventory.get((int) 3)
								: ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 50, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				} else {
					{
						ItemStack _ist = ((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.armorInventory.get((int) 3)
								: ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				}
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
