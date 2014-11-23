package com.gigavoid.supermod.biome;

import com.gigavoid.supermod.block.SuperBlocks;
import com.gigavoid.supermod.entity.EntityYeti;
import com.gigavoid.supermod.worldgen.trees.SuperWorldGenGlacierCrack;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.world.biome.BiomeGenBase;

/**
 * Created by Rasmus on 2014-11-03.
 */
public class BiomeGenNorthGlacier extends SuperBiomeGenBaseNorthrend {
    SuperWorldGenGlacierCrack crackGen = new SuperWorldGenGlacierCrack(true);

    public BiomeGenNorthGlacier(int id) {
        super(id);

        setBiomeName("Northrend Glacier");
        setHeight(new BiomeGenBase.Height(-1f, 0.1f));
        topBlock = SuperBlocks.northStone;
        fillerBlock = SuperBlocks.northStone;
        theBiomeDecorator.treesPerChunk = 1;
    }

    /*
    Not to be used.
    @Override
    public WorldGenAbstractTree func_150567_a(Random r) {
        return crackGen;
    }
    */
}
