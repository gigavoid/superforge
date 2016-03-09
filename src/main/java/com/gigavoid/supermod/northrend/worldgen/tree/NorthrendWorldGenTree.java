package com.gigavoid.supermod.northrend.worldgen.tree;

import com.gigavoid.supermod.northrend.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class NorthrendWorldGenTree extends WorldGenAbstractTree {
    private boolean northTreeHead[] = new boolean[5 * 5];

    public static final PropertyEnum AXIS_PROP = PropertyEnum.create("axis", BlockLog.EnumAxis.class);
    public static enum TreeType{ DEFAULT, PINE, FIR, BIRCH}

    TreeType type;

    public NorthrendWorldGenTree(boolean p_i45448_1_, TreeType type) {
        super(p_i45448_1_);
        this.type = type;
        setNorthTreeHead();
    }

    @Override
    public boolean generate(World world, Random random, BlockPos pos) {
        boolean ret = false, noTreesNear = true;
        for (int i = 0; i < 2; i++){
            for (int j = -1; j < 2; j++){
                for (int k = -1; k < 2; k++){
                    int i1 = i == 0 ? 0 : 4;
                    noTreesNear = world.getBlockState(pos.add(j, i1, k)).getBlock() != BlockNorthLog.instance;
                }
            }
        }
        if (noTreesNear && world.getBlockState(pos.down(2)) == BlockNorthDirt.instance.getDefaultState()) {
            if (type == TreeType.PINE)
                genPineTree(world, random, pos);
            else if (type == TreeType.FIR)
                genTreeFir(world, random, pos);
            else if (type == TreeType.BIRCH)
                genTreeBirch(world, random, pos);
            else
                genPineTree(world, random, pos);
            ret = true;
        }
        return ret;
    }

    private void genPineTree(World world, Random random, BlockPos pos) {
        if (pos.getY() < 80) {
            int height = 4 + random.nextInt(3);
            for (int k = - 1; k < height; k++) {
                world.setBlockState(pos.add(0, k, 0), BlockNorthLog.instance.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)));
            }
            genTreeHead(world, random, pos.add(0, height - 1, 0));
        }
    }

    private void genTreeHead(World world, Random r, BlockPos pos) {
        BlockNorthLeaves leaves = BlockNorthLeaves.instance;
        leaves.setDropType(BlockNorthSapling.EnumType.PINE);
        IBlockState block;
        world.setBlockState(pos.up(), leaves.getDefaultState());
        for (int i = -2; i < 3; i++) {
            for (int j = -2; j < 3; j++) {
                if ((world.getBlockState(pos.add(i, 0, j)).getBlock() == Blocks.air || world.getBlockState(pos.add(i, 0, j)).getBlock() == Blocks.snow_layer) && northTreeHead[(i + 2) + 5 * (j + 2)]) {
                    if (((i == -2 || i == 2) && (j == -1 || j == 1)) || ((i == -1 || i == 1) && (j == -2 || j == 2)))
                        block = .85f > r.nextFloat() ? leaves.getDefaultState() : Blocks.air.getDefaultState();
                    else
                        block = leaves.getDefaultState();
                    world.setBlockState(pos.add(i, 0, j), block);
                }
            }
        }
    }

    private void setNorthTreeHead() {
        northTreeHead[1] = northTreeHead[23] = true;
        northTreeHead[2] = northTreeHead[22] = true;
        northTreeHead[3] = northTreeHead[21] = true;

        for (int i = 5; i < 20; i++) {
            northTreeHead[i] = true;
        }
    }

    private void genTreeFir(World world, Random random, BlockPos pos) {
        if (pos.getY() < 80) {
            int height = 5 + random.nextInt(3);
            for (int k = - 1; k < height; k++) {
                world.setBlockState(pos.add(0, k, 0), BlockNorthLog.instance.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)));
            }
            genTreeHeadFir(world, random, pos, height);
        }
    }

    private void genTreeHeadFir(World world, Random r, BlockPos pos, int height) {
        BlockNorthLeaves leaves = BlockNorthLeaves.instance;
        leaves.setDropType(BlockNorthSapling.EnumType.FIR);
        IBlockState block;
        for (int i = -2; i < 3; i++) {
            for (int j = -2; j < 3; j++) {
                for (int k = -4; k < 2; k++) {
                    block = world.getBlockState(pos.add(i, k + height, j));
                    if ((world.getBlockState(pos.add(i, k + height, j)).getBlock() == Blocks.air || world.getBlockState(pos.add(i, 0, j)).getBlock() == Blocks.snow_layer)) {
                        block = Blocks.air.getDefaultState();
                        switch (k) {
                            case -4:
                                if ((i == -2 || i == 2) && (j != -2 && j != 2) || (i > -2 && i < 2))
                                    if (((i == -2 || i == 2) && (j == -1 || j == 1)) || ((i == -1 || i == 1) && (j == -2 || j == 2)))
                                        block = .95f > r.nextFloat() ? leaves.getDefaultState() : Blocks.air.getDefaultState();
                                    else
                                        block = leaves.getDefaultState();
                                break;
                            case -3:
                                if (((i == -2 || i == 2) && j == 0) || (i == -1 || i == 1) && (j != -2 && j != 2) || i == 0)
                                    block = leaves.getDefaultState();
                                break;
                            case -2:
                                if (i != -2 && i != 2 && j != -2 && j != 2)
                                    if (i == -1 && j == -1 || i == -1 && j == 1 || i == 1 && j == -1 || i == 1 && j == 1)
                                        block = .9f > r.nextFloat() ? leaves.getDefaultState() : Blocks.air.getDefaultState();
                                    else
                                        block = leaves.getDefaultState();
                                break;
                            case -1:
                                if (i > -2 && i < 2 && j > -2 && j < 2 && (i == 0 || j == 0))
                                    block = .95f > r.nextFloat() ? leaves.getDefaultState() : Blocks.air.getDefaultState();
                                break;
                            case 0:
                                if (i == 0 && j == 0)
                                    block = leaves.getDefaultState();
                                break;
                            case 1:
                                if (i == 0 && j == 0)
                                    block = .75f > r.nextFloat() ? leaves.getDefaultState() : Blocks.air.getDefaultState();
                                break;
                        }
                    }
                    world.setBlockState(pos.add(i, k + height, j), block);
                }
            }
        }
    }

    private void genTreeBirch(World world, Random random, BlockPos pos) {
        if (pos.getY() < 80) {
            int height = 4 + random.nextInt(3);
            for (int k = - 1; k < height; k++) {
                this.func_175905_a(world, pos.up(k), Blocks.log, 2);
            }
            genTreeHeadBirch(world, random, pos, height);
        }
    }

    private void genTreeHeadBirch(World world, Random r, BlockPos pos, int height){
        BlockNorthLeaves leaves = BlockNorthLeaves.instance;
        leaves.setDropType(BlockNorthSapling.EnumType.BIRCH);
        IBlockState block;
        //i = x, k = y, j = z
        for (int i = -2; i < 3; i++){
            for (int j = -2; j < 3; j++){
                for (int k = -3; k < 1; k++){
                    block = world.getBlockState(pos.add(i, k + height, j));
                    if ((world.getBlockState(pos.add(i, k + height, j)).getBlock() == Blocks.air || world.getBlockState(pos.add(i, 0, j)).getBlock() == Blocks.snow_layer)) {
                        block = Blocks.air.getDefaultState();
                        if (k == 0) {
                            if (i > -2 && i < 2 && j > -2 && j < 2) {
                                block = leaves.getDefaultState();
                            }
                        } else if (k != -3) {
                            if (j != -2 && j != 2) {
                                if (i == -2 || i == 2) {
                                    block = leaves.getDefaultState();
                                }
                            }
                            else if (i != -2 && i != 2) {
                                block = leaves.getDefaultState();
                            }
                        } else {
                            if (j != -2 && j != 2) {
                                if (i == -2 || i == 2) {
                                    block = .5f > r.nextFloat() ? leaves.getDefaultState() : Blocks.air.getDefaultState();
                                }
                            }
                            else if (i != -2 && i != 2) {
                                block = .5f > r.nextFloat() ? leaves.getDefaultState() : Blocks.air.getDefaultState();
                            }
                        }
                    }
                    world.setBlockState(pos.add(i, k + height, j), block);
                }
            }
        }
    }
}
