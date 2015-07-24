package darklib.smelting;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

public class FuelUtils {
    public static int hasValidFuel(IInventory inventory) {
        for (int i = 0; i < inventory.getSizeInventory(); i++) {
            ItemStack x = inventory.getStackInSlot(i);
            if (TileEntityFurnace.isItemFuel(x)) {
                return i;
            }
        }
        return -1;
    }
}
