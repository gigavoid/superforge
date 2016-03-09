package com.gigavoid.supermod.northrend.block;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import com.gigavoid.supermod.northrend.fluids.FluidNorthPoison;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockNorthPoisonFluid extends BlockFluidClassic {
    public static final BlockNorthPoisonFluid instance = new BlockNorthPoisonFluid();
    public static final String name = "block_poison_fluid";

    private BlockNorthPoisonFluid(){
        super(FluidNorthPoison.instance, Material.water);
        setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
    }

    @Override
    public boolean canDisplace(IBlockAccess world, BlockPos pos) {
        return !world.getBlockState(pos).getBlock().getMaterial().isLiquid() && super.canDisplace(world, pos);
    }

    @Override
    public boolean displaceIfPossible(World world, BlockPos pos) {
        return !world.getBlockState(pos).getBlock().getMaterial().isLiquid() && super.displaceIfPossible(world, pos);
    }

    @Override
    public int getRenderType() {
        return 3;
    }

    @Override
    protected void flowIntoBlock(World world, BlockPos pos, int meta)
    {
        if (meta < 0) return;
        if (displaceIfPossible(world, pos))
        {
            world.setBlockState(pos, this.getBlockState().getBaseState().withProperty(LEVEL, meta), 3);
        }
    }
}
