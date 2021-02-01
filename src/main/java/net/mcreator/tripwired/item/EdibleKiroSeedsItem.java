
package net.mcreator.tripwired.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.tripwired.TripwiredModElements;

@TripwiredModElements.ModElement.Tag
public class EdibleKiroSeedsItem extends TripwiredModElements.ModElement {
	@ObjectHolder("tripwired:edible_kiro_seeds")
	public static final Item block = null;
	public EdibleKiroSeedsItem(TripwiredModElements instance) {
		super(instance, 271);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(2).saturation(0.4f).build()));
			setRegistryName("edible_kiro_seeds");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 4;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
