package mod.darkness.items;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import mod.darkness.Registrator;
import net.minecraft.item.Item;

public class ItemManager {
    public static Item itemAsh;
    public static Item itemCloak;

    public static void preinint(FMLPreInitializationEvent event) {
        itemAsh = new Item().setUnlocalizedName("ashes").setTextureName("ashes");
        itemCloak = new ItemCloak();

        Registrator.registerItem(itemAsh);
        Registrator.registerItem(itemCloak);
    }

    public static void init(FMLInitializationEvent event) {

    }

    public static void postinit(FMLPostInitializationEvent event) {

    }
}
