
package net.mcreator.tripwired.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.tripwired.itemgroup.ModdedArmorAndToolsItemGroup;
import net.mcreator.tripwired.TripwiredModElements;

@TripwiredModElements.ModElement.Tag
public class RubyDaggerItem extends TripwiredModElements.ModElement {
	@ObjectHolder("tripwired:ruby_dagger")
	public static final Item block = null;
	public RubyDaggerItem(TripwiredModElements instance) {
		super(instance, 41);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1906;
			}

			public float getEfficiency() {
				return 5f;
			}

			public float getAttackDamage() {
				return 3f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 18;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -0.6f, new Item.Properties().group(ModdedArmorAndToolsItemGroup.tab)) {
			@Override
			public boolean hasContainerItem() {
				return true;
			}

			@Override
			public ItemStack getContainerItem(ItemStack itemstack) {
				ItemStack retval = new ItemStack(this);
				retval.setDamage(itemstack.getDamage() + 1);
				if (retval.getDamage() >= retval.getMaxDamage()) {
					return ItemStack.EMPTY;
				}
				return retval;
			}
		}.setRegistryName("ruby_dagger"));
	}
}
