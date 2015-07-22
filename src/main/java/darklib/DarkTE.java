package darklib;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public abstract class DarkTE extends TileEntity {

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        save(tag);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        load(tag);
    }

    public void save(NBTTagCompound tag) {

    }

    public void load(NBTTagCompound tag) {

    }
}
