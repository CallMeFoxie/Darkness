package mod.darkness;


import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import darklib.DarkLib;
import mod.darkness.blocks.BlockManager;
import mod.darkness.items.ItemManager;
import mod.darkness.logic.InvisibilityCloak;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Darkness.MODID, version = Darkness.VERSION, name = Darkness.MODNAME)
public class Darkness {
    public static final String MODID   = "darkness";
    public static final String VERSION = "@VERSION@";
    public static final String MODNAME = "Darkness";

    @Mod.Instance(MODNAME)
    public static Darkness INSTANCE;

    @SidedProxy(serverSide = "mod.darkness.CommonProxy", clientSide = "mod.darkness.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        BlockManager.preinit(event);
        ItemManager.preinint(event);
        DarkLib.preinit(event);
        proxy.preinit(event);

        new InvisibilityCloak();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        BlockManager.init(event);
        ItemManager.init(event);
        DarkLib.init(event);
        proxy.init(event);

        MinecraftForge.EVENT_BUS.register(InvisibilityCloak.INSTANCE);
        FMLCommonHandler.instance().bus().register(InvisibilityCloak.INSTANCE);
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        BlockManager.postinit(event);
        ItemManager.postinit(event);
        DarkLib.postinit(event);
        proxy.postinit(event);
    }
}
