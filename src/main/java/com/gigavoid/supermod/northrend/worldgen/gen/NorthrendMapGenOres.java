package com.gigavoid.supermod.northrend.worldgen.gen;

import java.util.Random;

import com.gigavoid.supermod.northrend.ModuleNorthrend;
import com.gigavoid.supermod.northrend.biome.NorthrendBiomes;
import com.gigavoid.supermod.northrend.block.*;
import com.gigavoid.supermod.northrend.worldgen.custom.NorthrendWorldGenMinable;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class NorthrendMapGenOres implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if(world.provider.getDimensionId() == ModuleNorthrend.dimensionId)
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
    }

    private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
        int x = chunkX + random.nextInt(16);
        int y = 5 + random.nextInt(50);
        int z = chunkZ + random.nextInt(16);
        BlockPos pos = new BlockPos(x, y, z);
        if (world.getBiomeGenForCoords(pos) == NorthrendBiomes.northHugeMountains) {
            (new NorthrendWorldGenMinable(BlockNorthFrostGemOre.instance.getDefaultState(), 1, BlockNorthStone.instance)).generate(world, random, pos);
        }
        int rn = 95 + random.nextInt(15);
        for(int k = 0; k < rn; k++) {
            x = chunkX + random.nextInt(16);
            y = random.nextInt(255);
            z = chunkZ + random.nextInt(16);
            pos = new BlockPos(x, y, z);
            (new NorthrendWorldGenMinable(BlockNorthCoalOre.instance.getDefaultState(), 4 + random.nextInt(13), BlockNorthStone.instance)).generate(world, random, pos);
        }
        rn = 70 + random.nextInt(20);
        for(int k = 0; k < rn; k++) {
            x = chunkX + random.nextInt(16);
            y = random.nextInt(128);
            z = chunkZ + random.nextInt(16);
            pos = new BlockPos(x, y, z);
            (new NorthrendWorldGenMinable(BlockNorthIronOre.instance.getDefaultState(), 3 + random.nextInt(7), BlockNorthStone.instance)).generate(world, random, pos);
        }
        rn = 17 + random.nextInt(6);
        for(int k = 0; k < rn; k++) {
            x = chunkX + random.nextInt(16);
            y = random.nextInt(45);
            z = chunkZ + random.nextInt(16);
            pos = new BlockPos(x, y, z);
            (new NorthrendWorldGenMinable(BlockNorthGoldOre.instance.getDefaultState(), 2 + random.nextInt(7), BlockNorthStone.instance)).generate(world, random, pos);
        }
        rn = 8 + random.nextInt(4);
        for(int k = 0; k < rn; k++) {
            x = chunkX + random.nextInt(16);
            y = random.nextInt(35);
            z = chunkZ + random.nextInt(16);
            pos = new BlockPos(x, y, z);
            (new NorthrendWorldGenMinable(BlockNorthMithrilOre.instance.getDefaultState(), 2 + random.nextInt(2), BlockNorthStone.instance)).generate(world, random, pos);
        }
        rn = 4 + random.nextInt(4);
        for(int k = 0; k < rn; k++) {
            x = chunkX + random.nextInt(16);
            y = random.nextInt(16);
            z = chunkZ + random.nextInt(16);
            pos = new BlockPos(x, y, z);
            (new NorthrendWorldGenMinable(BlockNorthDiamondOre.instance.getDefaultState(), 2 + random.nextInt(3), BlockNorthStone.instance)).generate(world, random, pos);
        }
        rn = 2 + random.nextInt(2);
        for(int k = 0; k < rn; k++) {
            x = chunkX + random.nextInt(16);
            y = random.nextInt(40);
            z = chunkZ + random.nextInt(16);
            pos = new BlockPos(x, y, z);
            (new NorthrendWorldGenMinable(BlockNorthEmeraldOre.instance.getDefaultState(), 1 + random.nextInt(3), BlockNorthStone.instance)).generate(world, random, pos);
        }
        rn = 12 + random.nextInt(6);
        for(int k = 0; k < rn; k++) {
            x = chunkX + random.nextInt(16);
            y = random.nextInt(25);
            z = chunkZ + random.nextInt(16);
            pos = new BlockPos(x, y, z);
            (new NorthrendWorldGenMinable(BlockNorthLapisOre.instance.getDefaultState(), 2 + random.nextInt(5), BlockNorthStone.instance)).generate(world, random, pos);
        }
        rn = random.nextInt(3);
        for(int k = 0; k < rn; k++) {
            x = chunkX + random.nextInt(16);
            y = 45 + random.nextInt(10);
            z = chunkZ + random.nextInt(16);
            pos = new BlockPos(x, y, z);
            (new NorthrendWorldGenMinable(BlockNorthDragonBone.instance.getDefaultState(), 6 + random.nextInt(5), BlockNorthGlacialIce.instance)).generate(world, random, pos);
        }
    }
}
