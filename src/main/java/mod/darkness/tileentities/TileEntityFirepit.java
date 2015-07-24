package mod.darkness.tileentities;

import darklib.DarkTE;
import darklib.SimpleInventory;
import darklib.smelting.FuelTemperature;
import darklib.smelting.FuelUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityFurnace;

public class TileEntityFirepit extends DarkTE {
    private static final float WARMING_MULT = 4f;

    SimpleInventory inventory;
    ItemStack       currentlyBurning;
    private float temperature, fuelRemaining;

    private FuelTemperature.FuelEntry fuelEntry;

    public TileEntityFirepit() {
        inventory = new SimpleInventory(9);
    }

    @Override
    public void updateEntity() {
        if (fuelRemaining > 0) {
            if (fuelEntry.temperature > temperature)
                fuelRemaining -= WARMING_MULT - 1;
            else
                fuelRemaining--; // eat just 1 heat value if we are on temp

            if (fuelRemaining < 0)
                fuelRemaining = 0;

        } else if (fuelRemaining == 0) {
            int slot = FuelUtils.hasValidFuel(inventory);
            if (slot >= 0) {
                currentlyBurning = inventory.decrStackSize(slot, 1);
                fuelRemaining = TileEntityFurnace.getItemBurnTime(currentlyBurning);
                fuelEntry = FuelTemperature.getFuelEntry(currentlyBurning);
            }
        }

        // retry to adjust temperature
        if (fuelRemaining > 0) {
            temperature = Math.min(fuelEntry.temperature, temperature + 1);
        } else if (temperature > 20) { // 20 = ambient temperature...
            temperature--;
        }

        // TODO actual burning process ... different metals requiring different temperatures? Would make sense..
    }

    @Override
    public void save(NBTTagCompound tag) {
        inventory.save(tag);
        tag.setFloat("temperature", temperature);
        tag.setFloat("fuelRemaining", fuelRemaining);
        if (currentlyBurning != null)
            tag.setTag("currentlyBurning", currentlyBurning.writeToNBT(new NBTTagCompound()));
        else
            tag.setTag("currentlyBurning", null);
    }

    @Override
    public void load(NBTTagCompound tag) {
        inventory.load(tag);
        temperature = tag.getFloat("temperature");
        fuelRemaining = tag.getFloat("fuelRemaining");
        if (tag.getTag("currentlyBurning") != null) {
            currentlyBurning = ItemStack.loadItemStackFromNBT((NBTTagCompound) tag.getTag("currentlyBurning"));
            fuelEntry = FuelTemperature.getFuelEntry(currentlyBurning);
        } else {
            currentlyBurning = null;
        }

    }
}
