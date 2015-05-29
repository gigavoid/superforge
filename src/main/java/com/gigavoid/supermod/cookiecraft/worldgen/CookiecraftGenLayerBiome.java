package com.gigavoid.supermod.cookiecraft.worldgen;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.BiomeManager;

import java.util.ArrayList;
import java.util.List;

public class CookiecraftGenLayerBiome extends GenLayer {
    private List<BiomeManager.BiomeEntry>[] biomes = new ArrayList[BiomeManager.BiomeType.values().length];

    private static final String __OBFID = "CL_00000555";

    public CookiecraftGenLayerBiome(long p_i2122_1_, GenLayer p_i2122_3_, net.minecraft.world.WorldType p_i2122_4_)
    {
        super(p_i2122_1_);
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint1 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i1 = 0; i1 < areaHeight; ++i1)
        {
            for (int j1 = 0; j1 < areaWidth; ++j1)
            {
                this.initChunkSeed((long)(j1 + areaX), (long)(i1 + areaY));
                aint1[j1 + i1 * areaWidth] = CookiecraftWorldChunkManager.allowedBiomes.get(0).biomeID;
            }
        }
        return aint1;
    }

    public static GenLayer[] func_180781_a(long p_75901_0_)  {
        CookiecraftGenLayerBiome genLayerBiomeCookiecraft = new CookiecraftGenLayerBiome(1000, null, null);
        GenLayer genLayer = GenLayerZoom.magnify(1000L, genLayerBiomeCookiecraft, 5);

        GenLayerVoronoiZoom zoom = new GenLayerVoronoiZoom(10L, genLayer);

        zoom.initWorldGenSeed(p_75901_0_);
        genLayer.initWorldGenSeed(p_75901_0_);

        return new GenLayer[] {genLayer, zoom, genLayer};
    }
}
