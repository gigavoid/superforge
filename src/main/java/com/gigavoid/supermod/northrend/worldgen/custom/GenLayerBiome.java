package com.gigavoid.supermod.northrend.worldgen.custom;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.BiomeManager;

import java.util.ArrayList;

public class GenLayerBiome extends GenLayer {
    private ArrayList[] biomes = new ArrayList[BiomeManager.BiomeType.values().length];

    private static final String __OBFID = "CL_00000555";

    public GenLayerBiome(long p_i2122_1_, GenLayer p_i2122_3_, net.minecraft.world.WorldType p_i2122_4_)
    {
        super(p_i2122_1_);
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    public int[] getInts(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_)
    {
        int[] aint1 = IntCache.getIntCache(p_75904_3_ * p_75904_4_);

        for (int i1 = 0; i1 < p_75904_4_; ++i1)
        {
            for (int j1 = 0; j1 < p_75904_3_; ++j1)
            {
                this.initChunkSeed((long)(j1 + p_75904_1_), (long)(i1 + p_75904_2_));
                aint1[j1 + i1 * p_75904_3_] = WorldChunkManager.allowedBiomes.get(this.nextInt(WorldChunkManager.allowedBiomes.size())).biomeID;
            }
        }
        return aint1;
    }

    public static GenLayer[] func_180781_a(long p_75901_0_)  {
        GenLayerBiome goodLayer = new GenLayerBiome(1000, null, null);
        GenLayer gen = GenLayerZoom.magnify(1000L, goodLayer, 5);


        GenLayerVoronoiZoom zoom = new GenLayerVoronoiZoom(10L, gen);

        zoom.initWorldGenSeed(p_75901_0_);
        gen.initWorldGenSeed(p_75901_0_);


        return new GenLayer[] {gen, zoom, gen};
    }
}