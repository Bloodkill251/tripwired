
package net.mcreator.tripwired.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.tripwired.item.RubyItem;
import net.mcreator.tripwired.TripwiredModElements;

@TripwiredModElements.ModElement.Tag
public class ModdedOreResultsItemGroup extends TripwiredModElements.ModElement {
	public ModdedOreResultsItemGroup(TripwiredModElements instance) {
		super(instance, 279);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmodded_ore_results") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(RubyItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
