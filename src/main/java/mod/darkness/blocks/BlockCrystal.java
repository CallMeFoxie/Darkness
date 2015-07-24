package mod.darkness.blocks;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockCrystal extends Block implements ISimpleBlockRenderingHandler {

    public int renderID;
    IIcon icon;

    protected BlockCrystal() {
        super(Material.glass);
    }

    public void setRenderID(int newId) {
        renderID = newId;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
        return true;
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        super.registerBlockIcons(register);
        icon = register.registerIcon("crystal");
        setCreativeTab(CreativeTabs.tabBlock);
        setBlockName("crystal");
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        //System.out.println("renderInventory");
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        //System.out.println("renderWorld");
        final float offset = 0.3f;
        Tessellator tessellator = Tessellator.instance;
        tessellator.addTranslation(x, y, z);

        // bottom front half
        tessellator.addVertex(0.5, 0, 0.5); // bottom
        tessellator.addVertex(offset, 0.5, 0.5); // left
        tessellator.addVertex(0.5, 0.5, offset); // front
        tessellator.addVertex(1 - offset, 0.5, 0.5); // right

        // top front half
        tessellator.addVertex(0.5, 1, 0.5); // top
        tessellator.addVertex(1 - offset, 0.5, 0.5); // right
        tessellator.addVertex(0.5, 0.5, offset); // front
        tessellator.addVertex(offset, 0.5, 0.5); // left

        // bottom rear half
        tessellator.addVertex(0.5, 0, 0.5); // bottom
        tessellator.addVertex(1 - offset, 0.5, 0.5); // left
        tessellator.addVertex(0.5, 0.5, 1 - offset); // front
        tessellator.addVertex(offset, 0.5, 0.5); // right

        // top rear half
        tessellator.addVertex(0.5, 1, 0.5); // top
        tessellator.addVertex(offset, 0.5, 0.5); // right
        tessellator.addVertex(0.5, 0.5, 1 - offset); // front
        tessellator.addVertex(1 - offset, 0.5, 0.5); // left

        tessellator.addTranslation(-x, -y, -z);

        return true;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderType() {
        return renderID;
    }

    @Override
    public int getRenderId() {
        return renderID;
    }
}
