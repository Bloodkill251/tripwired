
package net.mcreator.tripwired.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.mcreator.tripwired.TripwiredModElements;

@TripwiredModElements.ModElement.Tag
public class TrueProtectionEnchantment extends TripwiredModElements.ModElement {
	@ObjectHolder("tripwired:true_protection")
	public static final Enchantment enchantment = null;
	public TrueProtectionEnchantment(TripwiredModElements instance) {
		super(instance, 294);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("true_protection"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.VERY_RARE, EnchantmentType.ARMOR, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 1;
		}

		@Override
		protected boolean canApplyTogether(Enchantment ench) {
			if (ench == InstaBreakEnchantment.enchantment)
				return true;
			if (ench == InfiniteRegenerationEnchantment.enchantment)
				return true;
			if (ench == BonusHealthEnchantment.enchantment)
				return true;
			if (ench == Enchantments.FEATHER_FALLING)
				return true;
			if (ench == Enchantments.RESPIRATION)
				return true;
			if (ench == Enchantments.AQUA_AFFINITY)
				return true;
			if (ench == Enchantments.AQUA_AFFINITY)
				return true;
			if (ench == Enchantments.THORNS)
				return true;
			if (ench == Enchantments.DEPTH_STRIDER)
				return true;
			if (ench == Enchantments.FROST_WALKER)
				return true;
			if (ench == Enchantments.BINDING_CURSE)
				return true;
			if (ench == Enchantments.VANISHING_CURSE)
				return true;
			if (ench == Enchantments.UNBREAKING)
				return true;
			if (ench == Enchantments.MENDING)
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
