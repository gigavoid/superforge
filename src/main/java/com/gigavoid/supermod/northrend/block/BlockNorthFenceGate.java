package com.gigavoid.supermod.northrend.block;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.creativetab.CreativeTabs;

import javax.annotation.OverridingMethodsMustInvokeSuper;

public class BlockNorthFenceGate extends BlockFenceGate {
    public static BlockNorthFenceGate instance = new BlockNorthFenceGate();

    private BlockNorthFenceGate(){
        super();
        this.setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, FACING, OPEN, POWERED, IN_WALL);
    }
}
