package com.gigavoid.supermod.northrend.worldgen.gen;

import com.gigavoid.supermod.northrend.block.BlockNorthGlacialIce;
import com.gigavoid.supermod.northrend.block.BlockNorthPoisonFluid;
import com.gigavoid.supermod.northrend.block.BlockNorthStone;
import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.MapGenCaves;

import java.util.Random;

public class NorthrendMapGenCaves extends MapGenCaves
{
    private Random random;

    public NorthrendMapGenCaves(Random r){
        super();
        random = r;
    }

    @Override
    protected void digBlock(ChunkPrimer data, int x, int y, int z, int chunkX, int chunkZ, boolean foundTop, IBlockState state, IBlockState up)
    {
        net.minecraft.world.biome.BiomeGenBase biome = worldObj.getBiomeGenForCoords(new BlockPos(x + chunkX * 16, 0, z + chunkZ * 16));
        IBlockState top = biome.topBlock;
        IBlockState filler = biome.fillerBlock;

        if (this.func_175793_a(state, up) || state.getBlock() == top.getBlock() || state.getBlock() == filler.getBlock() || state.getBlock() == BlockNorthStone.instance || state.getBlock() == BlockNorthGlacialIce.instance)
        {
            if (y < 10)
            {
                Block block = random.nextInt(6) == 0 ? BlockNorthPoisonFluid.instance : Blocks.obsidian;
                data.setBlockState(x, y, z, block.getDefaultState());
            }
            else if (y < 11){
                data.setBlockState(x, y, z, BlockNorthPoisonFluid.instance.getDefaultState());
            }
            else
            {
                data.setBlockState(x, y, z, Blocks.air.getDefaultState());

                if (up.getBlock() == Blocks.sand)
                {
                    data.setBlockState(x, y + 1, z, up.getValue(BlockSand.VARIANT) == BlockSand.EnumType.RED_SAND ? Blocks.red_sandstone.getDefaultState() : Blocks.sandstone.getDefaultState());
                }

                if (foundTop && data.getBlockState(x, y - 1, z).getBlock() == filler.getBlock())
                {
                    data.setBlockState(x, y - 1, z, top.getBlock().getDefaultState());
                }
            }
        }
    }
}