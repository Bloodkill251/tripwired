
package net.mcreator.tripwired.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.tripwired.itemgroup.OtherModItemsItemGroup;
import net.mcreator.tripwired.TripwiredModElements;

import java.util.List;

@TripwiredModElements.ModElement.Tag
public class VoidFlintItem extends TripwiredModElements.ModElement {
	@ObjectHolder("tripwired:void_flint")
	public static final Item block = null;
	public VoidFlintItem(TripwiredModElements instance) {
		super(instance, 62);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(OtherModItemsItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("void_flint");
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

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Flint"));
			list.add(new StringTextComponent("crafted with the life of 4 void blocks."));
		}
	}
}
