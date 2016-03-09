package com.gigavoid.supermod.northrend.block;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import com.gigavoid.supermod.northrend.item.NorthrendItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockNorthFrostGemOre extends Block {
    public static BlockNorthFrostGemOre instance = new BlockNorthFrostGemOre();

    private BlockNorthFrostGemOre() {
        super(Material.rock);
        this.setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
        this.setHardness(7.0f);
        this.setHarvestLevel("pickaxe", 2);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return NorthrendItems.frostGem;
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 1;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return 1;
    }

    @Override
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
    }

    @Override
    public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        return MathHelper.getRandomIntegerInRange(rand, 8, 15);
    }

    @Override
    public int getDamageValue(World worldIn, BlockPos pos)
    {
        return 0;
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return 0;
    }
}
