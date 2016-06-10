package com.gigavoid.supermod.northrend.biome;

import com.gigavoid.supermod.northrend.block.BlockNorthBlight;
import com.gigavoid.supermod.northrend.block.BlockNorthGlacialIce;
import com.gigavoid.supermod.northrend.block.BlockNorthStone;
import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import com.gigavoid.supermod.northrend.entity.EntityIzrr;
import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NorthrendBiomeGenBase extends BiomeGenBase {
    int weight = 0;
    private ArrayList<? extends Block> specialBlocks = Lists.newArrayList(BlockNorthBlight.instance);

    public NorthrendBiomeGenBase(int p_i1971_1_, int weight)
    {
        super(p_i1971_1_, true);
        this.weight = weight;
        this.setEnableSnow();
        spawnableCaveCreatureList.clear();
        spawnableCreatureList.clear();
        spawnableMonsterList.clear();
        spawnableWaterCreatureList.clear();
        //spawnableMonsterList.add(new SpawnListEntry(EntityYeti.class, 2, 1, 1));
        spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 2, 1, 1));
        spawnableMonsterList.add(new SpawnListEntry(EntityIzrr.class, 2, 1, 1));
        temperature = 0.0f;
        rainfall = 1.0f;
        enableRain = true;
        setTemperatureRainfall(.0f, 1.0f);
        waterColorMultiplier = 0xFFFFFF;
    }

    public int getWeight(){
        return weight;
    }

    @Override
    public int getSkyColorByTemp(float p_76731_1_) {
        return 0x000044;
    }

    @Override
    public final void genTerrainBlocks(World worldIn, Random p_180628_2_, ChunkPrimer p_180628_3_, int p_180628_4_, int p_180628_5_, double p_180628_6_)
    {
        boolean flag = true;
        IBlockState iblockstate = this.topBlock;
        IBlockState iblockstate1 = this.fillerBlock;
        int k = -1;
        int l = (int)(p_180628_6_ / 3.0D + 3.0D + p_180628_2_.nextDouble() * 0.25D);
        int i1 = p_180628_4_ & 15;
        int j1 = p_180628_5_ & 15;
        int specialBlockHeightLimit = p_180628_2_.nextInt(3) + 78;

        for (int k1 = 255; k1 >= 0; --k1)
        {
            if (k1 <= p_180628_2_.nextInt(5))
            {
                p_180628_3_.setBlockState(j1, k1, i1, Blocks.bedrock.getDefaultState());
            }
            else
            {
                IBlockState iblockstate2 = p_180628_3_.getBlockState(j1, k1, i1);

                if (iblockstate2.getBlock().getMaterial() == Material.air)
                {
                    k = -1;
                }
                else if (iblockstate2.getBlock() == BlockNorthStone.instance)
                {
                    if (k == -1)
                    {
                        if (l <= 0)
                        {
                            iblockstate = null;
                            iblockstate1 = BlockNorthStone.instance.getDefaultState();
                        }
                        else if (k1 >= 59 && k1 <= 64)
                        {
                            iblockstate = this.topBlock;
                            iblockstate1 = this.fillerBlock;
                        }

                        if (k1 < 63 && (iblockstate == null || iblockstate.getBlock().getMaterial() == Material.air))
                        {
                            iblockstate = Blocks.ice.getDefaultState();
                        }

                        k = l;

                        if (k1 >= 62)
                        {
                            p_180628_3_.setBlockState(j1, k1, i1, iblockstate);
                        }
                        else if (k1 < 56 - l)
                        {
                            iblockstate = null;
                            iblockstate1 = BlockNorthStone.instance.getDefaultState();
                        }
                        else
                        {
                            p_180628_3_.setBlockState(j1, k1, i1, iblockstate1);
                        }
                    }
                    else if (k > 0){
                        --k;
                        p_180628_3_.setBlockState(j1, k1, i1, iblockstate1);
                    }
                }
            }
            if (k1 < 62 && p_180628_3_.getBlockState(j1, k1, i1).getBlock() == Blocks.snow) {
                p_180628_3_.setBlockState(j1, k1, i1, BlockNorthGlacialIce.instance.getDefaultState());
            } else if (k1 == 62 && p_180628_3_.getBlockState(j1, k1, i1).getBlock() == Blocks.snow && .5f < p_180628_2_.nextFloat()) {
                p_180628_3_.setBlockState(j1, k1, i1, BlockNorthGlacialIce.instance.getDefaultState());
            }
            if (k1 > specialBlockHeightLimit && specialBlocks.contains(p_180628_3_.getBlockState(j1, k1, i1).getBlock())) {
                p_180628_3_.setBlockState(j1, k1, i1, Blocks.snow.getDefaultState());
            }
        }
    }
}
