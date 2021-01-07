
package net.mcreator.tripwired.item;

@TripwiredModElements.ModElement.Tag
public class DaggerItem extends TripwiredModElements.ModElement {

	@ObjectHolder("tripwired:dagger")
	public static final Item block = null;

	public DaggerItem(TripwiredModElements instance) {
		super(instance, 135);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3f, new Item.Properties().group(ItemGroup.COMBAT)) {

		}.setRegistryName("dagger"));
	}

}
