
package net.mcreator.tripwired.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.tripwired.item.SapphireAppleItem;
import net.mcreator.tripwired.TripwiredModElements;

@TripwiredModElements.ModElement.Tag
public class ModdedApplesItemGroup extends TripwiredModElements.ModElement {
	public ModdedApplesItemGroup(TripwiredModElements instance) {
		super(instance, 278);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmodded_apples") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SapphireAppleItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
