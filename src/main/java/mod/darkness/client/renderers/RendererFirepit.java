package mod.darkness.client.renderers;

import mod.darkness.Darkness;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class RendererFirepit extends TileEntitySpecialRenderer {

    IModelCustom modelFirepit;

    public RendererFirepit() {
        modelFirepit = AdvancedModelLoader.loadModel(new ResourceLocation(Darkness.MODID, "models/firepit.obj"));
    }

    @Override
    public void renderTileEntityAt(TileEntity tileE, double x, double y, double z, float scale) {
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);

        // TODO bind texture
        modelFirepit.renderAll();

        GL11.glPopMatrix();
    }
}
