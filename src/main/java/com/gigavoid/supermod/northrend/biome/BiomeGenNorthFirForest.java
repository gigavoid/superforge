package com.gigavoid.supermod.northrend.biome;

import com.gigavoid.supermod.northrend.block.BlockNorthDirt;
import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import com.gigavoid.supermod.northrend.worldgen.tree.NorthrendWorldGenTree;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeGenNorthFirForest extends NorthrendBiomeGenBase {
    NorthrendWorldGenTree treeGen = new NorthrendWorldGenTree(true, NorthrendWorldGenTree.TreeType.FIR);

    public BiomeGenNorthFirForest(int id, int weight){
        super(id, weight);
        setBiomeName("Northrend Fir Forest");
        setHeight(new Height(0.15f, 0.1f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = BlockNorthDirt.instance.getDefaultState();
        theBiomeDecorator.treesPerChunk = 14;
    }

    @Override
    public WorldGenAbstractTree genBigTreeChance(Random r) {
        return treeGen;
    }
}