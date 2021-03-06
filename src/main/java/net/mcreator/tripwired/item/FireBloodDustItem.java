
package net.mcreator.tripwired.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.tripwired.itemgroup.DimensionalItemsItemGroup;
import net.mcreator.tripwired.TripwiredModElements;

@TripwiredModElements.ModElement.Tag
public class FireBloodDustItem extends TripwiredModElements.ModElement {
	@ObjectHolder("tripwired:fire_blood_dust")
	public static final Item block = null;
	public FireBloodDustItem(TripwiredModElements instance) {
		super(instance, 198);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(DimensionalItemsItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON));
			setRegistryName("fire_blood_dust");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
