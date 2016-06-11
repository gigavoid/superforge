package com.gigavoid.supermod.northrend.item;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;

import java.util.Set;

public class ItemNorthShovel extends ItemNorthTool {
    private static final Set EFFECTIVE_ON = Sets.newHashSet(new Block[]{Blocks.clay, Blocks.dirt, Blocks.farmland, Blocks.grass, Blocks.gravel, Blocks.mycelium, Blocks.sand, Blocks.snow, Blocks.snow_layer, Blocks.soul_sand});
    private static final String __OBFID = "CL_00000063";

    public ItemNorthShovel(ItemNorthTool.ToolMaterial material)
    {
        super(1.0F, material, EFFECTIVE_ON);
        setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
    }

    /**
     * Check whether this Item can harvest the given Block
     */
    public boolean canHarvestBlock(Block blockIn)
    {
        return blockIn == Blocks.snow_layer ? true : blockIn == Blocks.snow;
    }
}
