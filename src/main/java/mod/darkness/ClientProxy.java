package mod.darkness;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import mod.darkness.client.renderers.RendererFirepit;
import mod.darkness.tileentities.TileEntityFirepit;

public class ClientProxy extends CommonProxy {

    @Override
    public void postinit(FMLPostInitializationEvent event) {
        super.postinit(event);

        // register TESRs
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFirepit.class, new RendererFirepit());
    }
}
