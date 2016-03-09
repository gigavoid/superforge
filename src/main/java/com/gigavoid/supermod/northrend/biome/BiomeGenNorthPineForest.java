package com.gigavoid.supermod.northrend.biome;

import com.gigavoid.supermod.northrend.block.BlockNorthDirt;
import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import com.gigavoid.supermod.northrend.worldgen.tree.NorthrendWorldGenTree;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeGenNorthPineForest extends NorthrendBiomeGenBase {
    NorthrendWorldGenTree treeGen = new NorthrendWorldGenTree(true, NorthrendWorldGenTree.TreeType.PINE);

    public BiomeGenNorthPineForest(int id, int weight){
        super(id, weight);
        setBiomeName("Northrend Pine Forest");
        setHeight(new Height(0.2f, 0.15f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = BlockNorthDirt.instance.getDefaultState();
        theBiomeDecorator.treesPerChunk = 14;
    }

    @Override
    public WorldGenAbstractTree genBigTreeChance(Random r) {
        return treeGen;
    }
}