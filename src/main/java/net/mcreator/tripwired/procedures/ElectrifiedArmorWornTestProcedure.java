package net.mcreator.tripwired.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.tripwired.item.Tier1ElectifiedActiveItem;
import net.mcreator.tripwired.TripwiredModVariables;
import net.mcreator.tripwired.TripwiredModElements;

import java.util.Map;
import java.util.HashMap;

@TripwiredModElements.ModElement.Tag
public class ElectrifiedArmorWornTestProcedure extends TripwiredModElements.ModElement {
	public ElectrifiedArmorWornTestProcedure(TripwiredModElements instance) {
		super(instance, 300);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ElectrifiedArmorWornTest!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 3) : ItemStack.EMPTY)
				.getItem() == new ItemStack(Tier1ElectifiedActiveItem.helmet, (int) (1)).getItem())) {
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(TripwiredModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ElectrifiedT1HelmetWorn = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(TripwiredModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ElectrifiedT1HelmetWorn = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2) : ItemStack.EMPTY)
				.getItem() == new ItemStack(Tier1ElectifiedActiveItem.body, (int) (1)).getItem())) {
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(TripwiredModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ElectrifiedT1ChestplateWorn = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(TripwiredModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ElectrifiedT1ChestplateWorn = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 1) : ItemStack.EMPTY)
				.getItem() == new ItemStack(Tier1ElectifiedActiveItem.legs, (int) (1)).getItem())) {
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(TripwiredModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ElectrifiedT1LeggingsWorn = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(TripwiredModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ElectrifiedT1LeggingsWorn = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 0) : ItemStack.EMPTY)
				.getItem() == new ItemStack(Tier1ElectifiedActiveItem.boots, (int) (1)).getItem())) {
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(TripwiredModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ElectrifiedT1BootsWorn = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(TripwiredModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ElectrifiedT1BootsWorn = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
