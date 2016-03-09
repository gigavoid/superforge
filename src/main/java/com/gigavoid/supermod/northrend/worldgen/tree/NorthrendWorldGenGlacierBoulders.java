package com.gigavoid.supermod.northrend.worldgen.tree;

import com.gigavoid.supermod.northrend.block.BlockNorthGlacialIce;
import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class NorthrendWorldGenGlacierBoulders extends WorldGenAbstractTree {
    public NorthrendWorldGenGlacierBoulders(boolean b){
        super(b);
    }

    @Override
    public boolean generate(World world, Random random, BlockPos blockPos) {
        int size = random.nextInt(3) + 3;

        return true;
    }
}
