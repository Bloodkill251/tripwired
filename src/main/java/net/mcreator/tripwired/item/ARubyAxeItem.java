
package net.mcreator.tripwired.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.tripwired.TripwiredModElements;

@TripwiredModElements.ModElement.Tag
public class ARubyAxeItem extends TripwiredModElements.ModElement {
	@ObjectHolder("tripwired:a_ruby_axe")
	public static final Item block = null;
	public ARubyAxeItem(TripwiredModElements instance) {
		super(instance, 36);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 3111;
			}

			public float getEfficiency() {
				return 11f;
			}

			public float getAttackDamage() {
				return 12f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(RubyItem.block, (int) (1)));
			}
		}, 1, -2.9f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("a_ruby_axe"));
	}
}
