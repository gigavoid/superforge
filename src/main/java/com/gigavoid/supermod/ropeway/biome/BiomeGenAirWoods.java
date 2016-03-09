package com.gigavoid.supermod.ropeway.biome;

import net.minecraft.init.Blocks;

public class BiomeGenAirWoods extends RopewayBiomeGenBase {

    public BiomeGenAirWoods(int id, int weight){
        super(id, weight);

        setBiomeName("Aeriwoods");
        setHeight(new Height(-1.0f, 0.3f));
        topBlock = Blocks.grass.getDefaultState();
        fillerBlock = Blocks.dirt.getDefaultState();
        theBiomeDecorator.treesPerChunk = 6;
    }
}
