
package net.mcreator.tripwired.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.Block;

import net.mcreator.tripwired.TripwiredModElements;

@TripwiredModElements.ModElement.Tag
public class DeathPlankDoorBlock extends TripwiredModElements.ModElement {
	@ObjectHolder("tripwired:death_plank_door")
	public static final Block block = null;
	public DeathPlankDoorBlock(TripwiredModElements instance) {
		super(instance, 24);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends DoorBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 10f).lightValue(0).harvestLevel(0)
					.harvestTool(ToolType.AXE));
			setRegistryName("death_plank_door");
		}
	}
}
