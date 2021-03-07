
package net.mcreator.tripwired.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.tripwired.itemgroup.ModdedArmorAndToolsItemGroup;
import net.mcreator.tripwired.TripwiredModElements;

import java.util.List;

@TripwiredModElements.ModElement.Tag
public class Tier1ElectifiedActiveItem extends TripwiredModElements.ModElement {
	@ObjectHolder("tripwired:tier_1_electified_active_helmet")
	public static final Item helmet = null;
	@ObjectHolder("tripwired:tier_1_electified_active_chestplate")
	public static final Item body = null;
	@ObjectHolder("tripwired:tier_1_electified_active_leggings")
	public static final Item legs = null;
	@ObjectHolder("tripwired:tier_1_electified_active_boots")
	public static final Item boots = null;
	public Tier1ElectifiedActiveItem(TripwiredModElements instance) {
		super(instance, 299);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 1001;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 6, 8, 3}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 0;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tripwired:firebloodentitysound"));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "tier_1_electified_active";
			}

			public float getToughness() {
				return 4f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ModdedArmorAndToolsItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("*Must be charged to have any use* Auto repairs"));
				list.add(new StringTextComponent("but requires charge. Can have special abilities when upgraded."));
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "tripwired:textures/models/armor/tier1electrified_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("tier_1_electified_active_helmet"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ModdedArmorAndToolsItemGroup.tab)) {
					@Override
					public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
						super.addInformation(itemstack, world, list, flag);
						list.add(new StringTextComponent("*Must be charged to have any use* Auto repairs"));
						list.add(new StringTextComponent("but requires charge. Can have special abilities when upgraded."));
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "tripwired:textures/models/armor/tier1electrified_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}
				}.setRegistryName("tier_1_electified_active_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(ModdedArmorAndToolsItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("*Must be charged to have any use* Auto repairs"));
				list.add(new StringTextComponent("but requires charge. Can have special abilities when upgraded."));
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "tripwired:textures/models/armor/tier1electrified_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("tier_1_electified_active_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(ModdedArmorAndToolsItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("*Must be charged to have any use* Auto repairs"));
				list.add(new StringTextComponent("but requires charge. Can have special abilities when upgraded."));
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "tripwired:textures/models/armor/tier1electrified_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("tier_1_electified_active_boots"));
	}
}
