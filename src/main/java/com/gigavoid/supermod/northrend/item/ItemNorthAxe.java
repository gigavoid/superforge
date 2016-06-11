package com.gigavoid.supermod.northrend.item;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.Set;

public class ItemNorthAxe extends ItemNorthTool{
    private static final Set EFFECTIVE_ON = Sets.newHashSet(new Block[]{Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.melon_block, Blocks.ladder});
    private static final String __OBFID = "CL_00001770";

    protected ItemNorthAxe(ItemNorthTool.ToolMaterial material)
    {
        super(3.0F, material, EFFECTIVE_ON);
        setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
    }

    public float getStrVsBlock(ItemStack stack, Block block)
    {
        return block.getMaterial() != Material.wood && block.getMaterial() != Material.plants && block.getMaterial() != Material.vine ? super.getStrVsBlock(stack, block) : this.efficiencyOnProperMaterial;
    }
}
