
package net.mcreator.tripwired.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.tripwired.itemgroup.MachineryItemGroup;
import net.mcreator.tripwired.TripwiredModElements;

@TripwiredModElements.ModElement.Tag
public class TankCenterPieceItem extends TripwiredModElements.ModElement {
	@ObjectHolder("tripwired:tank_center_piece")
	public static final Item block = null;
	public TankCenterPieceItem(TripwiredModElements instance) {
		super(instance, 306);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(MachineryItemGroup.tab).maxStackSize(32).rarity(Rarity.COMMON));
			setRegistryName("tank_center_piece");
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
