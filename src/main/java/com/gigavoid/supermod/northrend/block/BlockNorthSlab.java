package com.gigavoid.supermod.northrend.block;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class BlockNorthSlab extends BlockSlab {
    public static BlockNorthSlab instance = new BlockNorthSlab();

    private BlockNorthSlab()
    {
        super(Material.wood);
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

    @Override
    public Object getVariant(ItemStack p_176553_1_) {
        return null;
    }

    @Override
    public IProperty getVariantProperty() {
        return null;
    }

    @Override
    public String getUnlocalizedName(int meta) {
        return "north_slab";
    }

    @Override
    public boolean isDouble() {
        return false;
    }
}
