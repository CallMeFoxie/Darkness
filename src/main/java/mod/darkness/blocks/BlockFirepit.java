package mod.darkness.blocks;

import mod.darkness.tileentities.TileEntityFirepit;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockFirepit extends BlockContainer {
    public BlockFirepit() {
        super(Material.ground);
        setBlockName("firepit");
        setCreativeTab(CreativeTabs.tabBlock);
        setTickRandomly(true);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityFirepit();
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
        return false;
    }

    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        super.randomDisplayTick(world, x, y, z, random);
        if (world.getBlockMetadata(x, y, z) == 0) {
            // show random fire
            world.spawnParticle("flame", x + 0.55, y + 0.1, z + 0.55, 0, 0, 0);
            world.spawnParticle("smoke", x + 0.55, y + 0.8, z + 0.55, 0, 0.01, 0);
        }
    }
}
