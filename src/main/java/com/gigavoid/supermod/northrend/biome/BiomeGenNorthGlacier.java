package com.gigavoid.supermod.northrend.biome;

import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import com.gigavoid.supermod.northrend.worldgen.tree.SuperWorldGenIgloo;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeGenNorthGlacier extends NorthrendBiomeGenBase {
    SuperWorldGenIgloo iglooGen = new SuperWorldGenIgloo(true);

    public BiomeGenNorthGlacier(int id) {
        super(id);

        setBiomeName("Northrend Glacier");
        setHeight(new Height(-1f, 0.1f));
        topBlock = NorthrendBlocks.northStone.getDefaultState();
        fillerBlock = NorthrendBlocks.northStone.getDefaultState();
        theBiomeDecorator.treesPerChunk = 1;
    }

    @Override
    public WorldGenAbstractTree genBigTreeChance(Random r) {
        return iglooGen;
    }
}