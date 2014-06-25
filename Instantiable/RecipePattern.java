package Reika.DragonAPI.Instantiable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import Reika.DragonAPI.Libraries.Registry.ReikaItemHelper;

public final class RecipePattern extends InventoryCrafting {

	private static final BlankContainer craft = new BlankContainer();

	private static final class BlankContainer extends Container {
		@Override
		public final void onCraftMatrixChanged(IInventory inventory) {}
		@Override
		public final boolean canInteractWith(EntityPlayer player) {return false;}
		@Override
		public final void onContainerClosed(EntityPlayer par1EntityPlayer) {}
	}

	public RecipePattern(ItemStack... items) {
		super(craft, 3, 3);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.setInventorySlotContents(i+j*3, items[i*3+j]); //since will otherwise add vertically
			}
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof RecipePattern) {
			for (int i = 0; i < 9; i++) {
				if (!ReikaItemHelper.matchStacks(this.getStackInSlot(i), ((RecipePattern) o).getStackInSlot(i)))
					return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public final void openChest() {}
	@Override
	public final void closeChest() {}
}