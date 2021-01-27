
package net.mcreator.tripwired.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.tripwired.TripwiredModElements;

@TripwiredModElements.ModElement.Tag
public class KiroStoneBlock extends TripwiredModElements.ModElement {
	@ObjectHolder("tripwired:kiro_stone")
	public static final Block block = null;
	public KiroStoneBlock(TripwiredModElements instance) {
		super(instance, 242);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4f, 10f).lightValue(0).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE));
			setRegistryName("kiro_stone");
		}
	}
}
