package net.mcreator.tripwired.procedures;

import net.minecraft.util.Hand;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.tripwired.enchantment.InstaBreakEnchantment;
import net.mcreator.tripwired.enchantment.InfiniteRegenerationEnchantment;
import net.mcreator.tripwired.enchantment.BonusHealthEnchantment;
import net.mcreator.tripwired.TripwiredModElements;

import java.util.Map;

@TripwiredModElements.ModElement.Tag
public class Book1ItemInHandTickProcedure extends TripwiredModElements.ModElement {
	public Book1ItemInHandTickProcedure(TripwiredModElements instance) {
		super(instance, 232);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Book1ItemInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double tfhtft = 0;
		double ttt = 0;
		ttt = (double) 10;
		tfhtft = (double) Math.round((Math.random() * 8));
		if (entity instanceof LivingEntity) {
			ItemStack _setstack = new ItemStack(Items.ENCHANTED_BOOK, (int) (1));
			_setstack.setCount((int) 1);
			((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
		if ((5 >= (tfhtft))) {
			if (((tfhtft) == 0)) {
				(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
						.addEnchantment(BonusHealthEnchantment.enchantment, (int) 1);
			} else {
				(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
						.addEnchantment(BonusHealthEnchantment.enchantment, (int) (tfhtft));
				ttt = (double) ((ttt) - (tfhtft));
			}
			tfhtft = (double) Math.round((Math.random() * 4));
			if (((tfhtft) == 1)) {
				tfhtft = (double) Math.round((Math.random() * 3));
				if (((tfhtft) == 0)) {
					(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
							.addEnchantment(InfiniteRegenerationEnchantment.enchantment, (int) 1);
				} else {
					(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
							.addEnchantment(InfiniteRegenerationEnchantment.enchantment, (int) (tfhtft));
					ttt = (double) ((ttt) - (tfhtft));
				}
			}
		} else {
			if ((((tfhtft) - 5) == 0)) {
				(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
						.addEnchantment(InfiniteRegenerationEnchantment.enchantment, (int) 1);
			} else {
				(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
						.addEnchantment(InfiniteRegenerationEnchantment.enchantment, (int) ((tfhtft) - 5));
				ttt = (double) ((ttt) - ((tfhtft) - 5));
			}
			tfhtft = (double) Math.round((Math.random() * 4));
			if (((tfhtft) == 1)) {
				tfhtft = (double) Math.round((Math.random() * 5));
				if (((tfhtft) == 0)) {
					(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
							.addEnchantment(BonusHealthEnchantment.enchantment, (int) 1);
				} else {
					(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
							.addEnchantment(BonusHealthEnchantment.enchantment, (int) (tfhtft));
					ttt = (double) ((ttt) - (tfhtft));
				}
			}
		}
		tfhtft = (double) Math.round((Math.random() * (ttt)));
		if (((tfhtft) == 1)) {
			(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
					.addEnchantment(InstaBreakEnchantment.enchantment, (int) 1);
		}
	}
}
