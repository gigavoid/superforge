package com.gigavoid.supermod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

public class BlockNorthPlanks extends Block {
    public BlockNorthPlanks(){
        super(Material.wood);
        this.setHardness(1.0f);
        this.setBlockTextureName("supermod:planks_north");
        this.setHarvestLevel("axe", 0);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockName("north planks");
        this.setStepSound(soundTypeWood);
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock(this);
    }

    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
        return true;
    }
}
