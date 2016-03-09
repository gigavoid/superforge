package com.gigavoid.supermod.ropeway.worldgen.tree;

import com.gigavoid.supermod.northrend.block.BlockNorthLeaves;
import com.gigavoid.supermod.northrend.block.BlockNorthSapling;
import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class RopewayWorldGenTree extends WorldGenAbstractTree {
    public static final PropertyEnum AXIS_PROP = PropertyEnum.create("axis", BlockLog.EnumAxis.class);

    public RopewayWorldGenTree(boolean p_i45448_1_) {
        super(p_i45448_1_);
    }

    @Override
    public boolean generate(World world, Random random, BlockPos pos) {
        boolean ret = false, noTreesNear = true;
        int size = random.nextInt(4) + 1;
        int height = 20 * size + random.nextInt(5) * size;
        for (int y = -1 * size; y < size; y++) {
            for (int x = size > 2 ? -1 : 0; x < 3; x++) {
                for (int z = size > 2 ? -1 : 0; z < 3; z++) {
                    if (y < 0){
                        //world.setBlockState(pos.add(x, y, z));
                    }
                }
            }
        }
        return ret;
    }
}
