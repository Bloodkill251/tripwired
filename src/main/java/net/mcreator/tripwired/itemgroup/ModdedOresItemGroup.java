
package net.mcreator.tripwired.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.tripwired.block.RubyOreBlock;
import net.mcreator.tripwired.TripwiredModElements;

@TripwiredModElements.ModElement.Tag
public class ModdedOresItemGroup extends TripwiredModElements.ModElement {
	public ModdedOresItemGroup(TripwiredModElements instance) {
		super(instance, 275);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmodded_ores") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(RubyOreBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
