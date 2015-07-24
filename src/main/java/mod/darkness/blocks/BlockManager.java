package mod.darkness.blocks;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import mod.darkness.Registrator;
import mod.darkness.tileentities.TileEntityFirepit;
import net.minecraft.block.Block;

public class BlockManager {
    public static Block blockFirepit;
    public static Block blockCrystal;

    public static void preinit(FMLPreInitializationEvent event) {
        blockFirepit = new BlockFirepit();

        Registrator.registerBlock(blockFirepit);
        Registrator.registerTileEntity(TileEntityFirepit.class, "te_firepit");

        blockCrystal = new BlockCrystal();
        Registrator.registerBlock(blockCrystal);
    }

    public static void init(FMLInitializationEvent event) {

    }

    public static void postinit(FMLPostInitializationEvent event) {

    }
}
