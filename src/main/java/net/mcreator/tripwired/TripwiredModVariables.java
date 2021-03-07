package net.mcreator.tripwired;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class TripwiredModVariables {
	public TripwiredModVariables(TripwiredModElements elements) {
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}
	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;
	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("tripwired", "player_variables"), new PlayerVariablesProvider());
	}
	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);
		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putBoolean("ElectrifiedT1HelmetWorn", instance.ElectrifiedT1HelmetWorn);
			nbt.putBoolean("ElectrifiedT1ChestplateWorn", instance.ElectrifiedT1ChestplateWorn);
			nbt.putBoolean("ElectrifiedT1LeggingsWorn", instance.ElectrifiedT1LeggingsWorn);
			nbt.putBoolean("ElectrifiedT1BootsWorn", instance.ElectrifiedT1BootsWorn);
			nbt.putDouble("ET1HCharge", instance.ET1HCharge);
			nbt.putDouble("ET1CCharge", instance.ET1CCharge);
			nbt.putDouble("ET1LCharge", instance.ET1LCharge);
			nbt.putDouble("ET1BCharge", instance.ET1BCharge);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.ElectrifiedT1HelmetWorn = nbt.getBoolean("ElectrifiedT1HelmetWorn");
			instance.ElectrifiedT1ChestplateWorn = nbt.getBoolean("ElectrifiedT1ChestplateWorn");
			instance.ElectrifiedT1LeggingsWorn = nbt.getBoolean("ElectrifiedT1LeggingsWorn");
			instance.ElectrifiedT1BootsWorn = nbt.getBoolean("ElectrifiedT1BootsWorn");
			instance.ET1HCharge = nbt.getDouble("ET1HCharge");
			instance.ET1CCharge = nbt.getDouble("ET1CCharge");
			instance.ET1LCharge = nbt.getDouble("ET1LCharge");
			instance.ET1BCharge = nbt.getDouble("ET1BCharge");
		}
	}

	public static class PlayerVariables {
		public boolean ElectrifiedT1HelmetWorn = false;
		public boolean ElectrifiedT1ChestplateWorn = false;
		public boolean ElectrifiedT1LeggingsWorn = false;
		public boolean ElectrifiedT1BootsWorn = false;
		public double ET1HCharge = 0;
		public double ET1CCharge = 0;
		public double ET1LCharge = 0;
		public double ET1BCharge = 0;
		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				TripwiredMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity),
						new PlayerVariablesSyncMessage(this));
		}
	}
	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote)
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote)
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote)
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PlayerVariables()));
		PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
		clone.ElectrifiedT1HelmetWorn = original.ElectrifiedT1HelmetWorn;
		clone.ElectrifiedT1ChestplateWorn = original.ElectrifiedT1ChestplateWorn;
		clone.ElectrifiedT1LeggingsWorn = original.ElectrifiedT1LeggingsWorn;
		clone.ElectrifiedT1BootsWorn = original.ElectrifiedT1BootsWorn;
		clone.ET1HCharge = original.ET1HCharge;
		clone.ET1CCharge = original.ET1CCharge;
		clone.ET1LCharge = original.ET1LCharge;
		clone.ET1BCharge = original.ET1BCharge;
		if (!event.isWasDeath()) {
		}
	}
	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;
		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.ElectrifiedT1HelmetWorn = message.data.ElectrifiedT1HelmetWorn;
					variables.ElectrifiedT1ChestplateWorn = message.data.ElectrifiedT1ChestplateWorn;
					variables.ElectrifiedT1LeggingsWorn = message.data.ElectrifiedT1LeggingsWorn;
					variables.ElectrifiedT1BootsWorn = message.data.ElectrifiedT1BootsWorn;
					variables.ET1HCharge = message.data.ET1HCharge;
					variables.ET1CCharge = message.data.ET1CCharge;
					variables.ET1LCharge = message.data.ET1LCharge;
					variables.ET1BCharge = message.data.ET1BCharge;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
