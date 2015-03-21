package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockCookieBlock extends Block {
    public BlockCookieBlock() {
        super(Material.ground);
        this.setHardness(2.0f);
        this.setHarvestLevel("pickaxe", 0);
        this.setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        this.setStepSound(soundTypeCloth);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }
}
