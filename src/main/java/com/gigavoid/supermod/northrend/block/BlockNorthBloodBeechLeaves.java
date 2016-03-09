package com.gigavoid.supermod.northrend.block;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockNorthBloodBeechLeaves extends BlockLeaves {
    public static BlockNorthBloodBeechLeaves instance = new BlockNorthBloodBeechLeaves();

    private BlockNorthBloodBeechLeaves(){
        super();
        this.setHardness(1.0f);
        this.setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
        this.setStepSound(soundTypeGrass);
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 1;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(BlockNorthSapling.instance_birch); // Fixa något coolt
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        super.updateTick(worldIn, pos, state, rand);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }

    @Override
    public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        List<ItemStack> list = new ArrayList<ItemStack>();
        list.add(new ItemStack(Item.getItemFromBlock(this)));
        return list;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getBlockColor() {
        return 0xFFFFFF;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderColor(IBlockState state) {
        return 0xFFFFFF;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass) {
        return 0xFFFFFF;
    }

    @Override
    public BlockPlanks.EnumType getWoodType(int p_176233_1_) {
        return BlockPlanks.EnumType.SPRUCE;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
        return true;
    }

    @Override
    public boolean isVisuallyOpaque() { return false; }

    @Override
    public int getMetaFromState(IBlockState state) { return 0; }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, CHECK_DECAY, DECAYABLE);
    }

    @Override
    public boolean isOpaqueCube() { return false; }
}
