package com.gigavoid.supermod.northrend.block;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by Rasmus on 2014-11-23.
 */
public class BlockNorthStoneStairs extends BlockStairs {
    public static BlockNorthStoneStairs instance = new BlockNorthStoneStairs();

    private BlockNorthStoneStairs()
    {
        super(BlockNorthCobblestone.instance.getDefaultState());
        this.setHardness(.75f);
        this.setResistance(2.0f);
        this.setStepSound(BlockNorthCobblestone.instance.stepSound);
        this.setLightOpacity(255);
        this.setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock(this);
    }
}
