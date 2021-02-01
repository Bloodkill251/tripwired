
package net.mcreator.tripwired.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.tripwired.block.KiroPlanksBlock;
import net.mcreator.tripwired.TripwiredModElements;

@TripwiredModElements.ModElement.Tag
public class DimensionalItemsItemGroup extends TripwiredModElements.ModElement {
	public DimensionalItemsItemGroup(TripwiredModElements instance) {
		super(instance, 280);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabdimensional_items") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(KiroPlanksBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
