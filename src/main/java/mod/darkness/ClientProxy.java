package mod.darkness;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import mod.darkness.blocks.BlockCrystal;
import mod.darkness.blocks.BlockManager;
import mod.darkness.client.renderers.RendererFirepit;
import mod.darkness.tileentities.TileEntityFirepit;

public class ClientProxy extends CommonProxy {

    @Override
    public void postinit(FMLPostInitializationEvent event) {
        super.postinit(event);

        // register TESRs
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFirepit.class, new RendererFirepit());

        ((BlockCrystal) BlockManager.blockCrystal).setRenderID(RenderingRegistry.getNextAvailableRenderId());
        RenderingRegistry.registerBlockHandler((BlockCrystal) BlockManager.blockCrystal);
    }
}
