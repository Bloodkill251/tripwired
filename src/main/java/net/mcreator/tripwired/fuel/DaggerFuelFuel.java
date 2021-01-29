
package net.mcreator.tripwired.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.tripwired.item.DaggerItem;
import net.mcreator.tripwired.TripwiredModElements;

@TripwiredModElements.ModElement.Tag
public class DaggerFuelFuel extends TripwiredModElements.ModElement {
	public DaggerFuelFuel(TripwiredModElements instance) {
		super(instance, 266);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(DaggerItem.block, (int) (1)).getItem())
			event.setBurnTime(160);
	}
}
