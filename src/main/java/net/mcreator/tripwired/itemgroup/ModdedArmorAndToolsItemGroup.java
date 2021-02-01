
package net.mcreator.tripwired.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.tripwired.item.Ruby1ArmorItem;
import net.mcreator.tripwired.TripwiredModElements;

@TripwiredModElements.ModElement.Tag
public class ModdedArmorAndToolsItemGroup extends TripwiredModElements.ModElement {
	public ModdedArmorAndToolsItemGroup(TripwiredModElements instance) {
		super(instance, 276);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmodded_armor_and_tools") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Ruby1ArmorItem.body, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
