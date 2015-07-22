package darklib;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import darklib.fuel.FuelTemperature;

public class DarkLib {
    public static void preinit(FMLPreInitializationEvent event) {

    }

    public static void init(FMLInitializationEvent event) {

    }

    public static void postinit(FMLPostInitializationEvent event) {
        FuelTemperature.postinit();
    }
}
