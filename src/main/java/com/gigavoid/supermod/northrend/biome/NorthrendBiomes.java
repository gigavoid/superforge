package com.gigavoid.supermod.northrend.biome;

import net.minecraftforge.common.BiomeManager;

public class NorthrendBiomes {

    public static final BiomeGenNorthForest northForest = new BiomeGenNorthForest(40);
    public static final BiomeGenNorthFirForest northFirForest = new BiomeGenNorthFirForest(41);
    public static final BiomeGenNorthMountains northMountains = new BiomeGenNorthMountains(42);
    public static final BiomeGenNorthPlains northPlains = new BiomeGenNorthPlains(43);
    public static final BiomeGenNorthGlacier northGlacier = new BiomeGenNorthGlacier(44);
    public static final BiomeGenNorthHighlands northHighlands = new BiomeGenNorthHighlands(45);
    public static final BiomeGenNorthHugeMountains northHugeMountains = new BiomeGenNorthHugeMountains(46);
    public static final BiomeGenNorthSmallMountains northSmallMountains = new BiomeGenNorthSmallMountains(47);

    public static void registerBiomes(){
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northForest, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northFirForest, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northMountains, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northPlains, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northGlacier, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northHighlands, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northHugeMountains, 0));
    }
}