package com.gigavoid.supermod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

public class SaxeliumOreBlock extends Block {
    public SaxeliumOreBlock(){
        super(Material.rock);
        this.setHardness(1.0f);
        this.setBlockTextureName("supermod:op_ore");
        this.setHarvestLevel("pickaxe", 4);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockName("saxeliumOre");
        this.setStepSound(soundTypeMetal);
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(this);
    }
}