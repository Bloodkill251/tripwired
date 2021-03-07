package net.mcreator.tripwired.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.tripwired.TripwiredModVariables;
import net.mcreator.tripwired.TripwiredModElements;

import java.util.Map;
import java.util.HashMap;

@TripwiredModElements.ModElement.Tag
public class Tier1ElectrifiedAbilitiesProcedure extends TripwiredModElements.ModElement {
	public Tier1ElectrifiedAbilitiesProcedure(TripwiredModElements instance) {
		super(instance, 301);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Tier1ElectrifiedAbilities!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Tier1ElectrifiedAbilities!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity.getCapability(TripwiredModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TripwiredModVariables.PlayerVariables())).ElectrifiedT1HelmetWorn) == (true))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) 200, (int) 1));
		}
		if ((((entity.getCapability(TripwiredModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TripwiredModVariables.PlayerVariables())).ElectrifiedT1ChestplateWorn) == (true))) {
			if ((5 == Math.round((Math.random() * 1199)))) {
				world.getPendingBlockTicks().scheduleTick(
						new BlockPos(
								(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100,
												entity.getLook(1f).z * 100),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
								(int) (entity.world
										.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100,
														entity.getLook(1f).z * 100),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getY()),
								(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100,
												entity.getLook(1f).z * 100),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())),
						world.getBlockState(new BlockPos(
								(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100,
												entity.getLook(1f).z * 100),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
								(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100,
												entity.getLook(1f).z * 100),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
								(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100,
												entity.getLook(1f).z * 100),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
								.getBlock(),
						(int) 0);
			}
		}
		if ((((entity.getCapability(TripwiredModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TripwiredModVariables.PlayerVariables())).ElectrifiedT1LeggingsWorn) == (true))) {
			if ((5 == Math.round((Math.random() * 199)))) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).giveExperiencePoints((int) (Math.round((Math.random() * 8)) + 1));
			}
		}
		if ((((entity.getCapability(TripwiredModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TripwiredModVariables.PlayerVariables())).ElectrifiedT1BootsWorn) == (true))) {
			if (((entity.getMotion().getY()) >= 2)) {
				entity.fallDistance = (float) (0);
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
