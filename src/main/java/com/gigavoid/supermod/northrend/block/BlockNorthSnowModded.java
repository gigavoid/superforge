package com.gigavoid.supermod.northrend.block;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockNorthSnowModded extends BlockSnow {
    public static BlockNorthSnowModded instance = new BlockNorthSnowModded();

    private BlockNorthSnowModded(){
        super();
        setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        IBlockState iblockstate = worldIn.getBlockState(pos.down());
        Block block = iblockstate.getBlock();
        // && block != BlockNorthGlacialIce.instance && block != BlockNorthDragonBone.instance
        return block != Blocks.ice && block != Blocks.packed_ice && block != BlockNorthBlight.instance
                && (block.isLeaves(worldIn, pos.down())
                || (block == this && (Integer) iblockstate.getValue(LAYERS) == 7
                || block.isOpaqueCube() && block.getMaterial().blocksMovement()));
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if (worldIn.provider.getDimensionId() < 0 || !BlockNorthPortal.instance.func_176548_d(worldIn, pos)) {
            if(!canPlaceBlockAt(worldIn, pos)){
                worldIn.setBlockToAir(pos);
            }
        }
    }
}
