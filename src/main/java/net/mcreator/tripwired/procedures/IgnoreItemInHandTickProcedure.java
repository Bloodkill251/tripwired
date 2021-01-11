package net.mcreator.tripwired.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.Hand;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;

import net.mcreator.tripwired.TripwiredModElements;

import java.util.Random;
import java.util.Map;

@TripwiredModElements.ModElement.Tag
public class IgnoreItemInHandTickProcedure extends TripwiredModElements.ModElement {
	public IgnoreItemInHandTickProcedure(TripwiredModElements instance) {
		super(instance, 209);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure IgnoreItemInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			ItemStack _setstack = new ItemStack(Items.BOW, (int) (1));
			_setstack.setCount((int) 1);
			((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
		{
			ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
			if (_ist.attemptDamageItem((int) 379, new Random(), null)) {
				_ist.shrink(1);
				_ist.setDamage(0);
			}
		}
		(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).addEnchantment(Enchantments.POWER,
				(int) 7);
		(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).addEnchantment(Enchantments.INFINITY,
				(int) 1);
		(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).addEnchantment(Enchantments.FLAME,
				(int) 11);
		(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
				.setDisplayName(new StringTextComponent("Furies Bow"));
	}
}
