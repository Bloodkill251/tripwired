
package net.mcreator.tripwired.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.tripwired.itemgroup.ModdedArmorAndToolsItemGroup;
import net.mcreator.tripwired.TripwiredModElements;

@TripwiredModElements.ModElement.Tag
public class ARubyPickaxeItem extends TripwiredModElements.ModElement {
	@ObjectHolder("tripwired:a_ruby_pickaxe")
	public static final Item block = null;
	public ARubyPickaxeItem(TripwiredModElements instance) {
		super(instance, 35);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 3111;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 3f;
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
		}, 1, -3f, new Item.Properties().group(ModdedArmorAndToolsItemGroup.tab)) {
		}.setRegistryName("a_ruby_pickaxe"));
	}
}
