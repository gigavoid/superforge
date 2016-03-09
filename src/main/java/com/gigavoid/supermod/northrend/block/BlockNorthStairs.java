package com.gigavoid.supermod.northrend.block;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by Rasmus on 2014-11-23.
 */
public class BlockNorthStairs extends BlockStairs {
    public static BlockNorthStairs instance = new BlockNorthStairs();

    private BlockNorthStairs()
    {
        super(BlockNorthPlanks.instance.getDefaultState());
        this.setHardness(.75f);
        this.setResistance(2.0f);
        this.setStepSound(BlockNorthPlanks.instance.stepSound);
        this.setLightOpacity(255);
        this.setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }
}
