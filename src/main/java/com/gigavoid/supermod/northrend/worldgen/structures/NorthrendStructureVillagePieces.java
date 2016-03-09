package com.gigavoid.supermod.northrend.worldgen.structures;

import com.gigavoid.supermod.northrend.block.*;
import com.gigavoid.supermod.northrend.worldgen.gen.NorthrendMapGenVillage;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraftforge.common.ChestGenHooks;
import static net.minecraftforge.common.ChestGenHooks.*;

public class NorthrendStructureVillagePieces
{
    public static final PropertyEnum AXIS_PROP = PropertyEnum.create("axis", BlockLog.EnumAxis.class);

    private static final String __OBFID = "CL_00000516";
    public static Block stone = BlockNorthCobblestone.instance;
    public static Block stoneStairs = BlockNorthStoneStairs.instance;
    public static Block wood = BlockNorthPlanks.instance;
    public static Block woodStairs = BlockNorthStairs.instance;
    public static Block fence = BlockNorthFence.instance;
    public static Block log = BlockNorthLog.instance;
    public static Block path = BlockNorthDirt.instance;
    public static Block farm = BlockNorthDirt.instance;
    public static Block plant = BlockNorthGlaciemPlant.instance;

    public static void registerVillagePieces()
    {
        MapGenStructureIO.registerStructureComponent(NorthrendStructureVillagePieces.House1.class, "NViBH");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureVillagePieces.Field1.class, "NViDF");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureVillagePieces.Field2.class, "NViF");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureVillagePieces.Torch.class, "NViL");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureVillagePieces.Hall.class, "NViPH");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureVillagePieces.House4Garden.class, "NViSH");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureVillagePieces.WoodHut.class, "NViSmH");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureVillagePieces.Church.class, "NViST");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureVillagePieces.House2.class, "NViS");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureVillagePieces.Start.class, "NViStart");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureVillagePieces.Path.class, "NViSR");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureVillagePieces.House3.class, "NViTRH");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureVillagePieces.Well.class, "NViW");
    }

    public static List getStructureVillageWeightedPieceList(Random p_75084_0_, int p_75084_1_)
    {
        ArrayList arraylist = Lists.newArrayList();
        arraylist.add(new NorthrendStructureVillagePieces.PieceWeight(NorthrendStructureVillagePieces.House4Garden.class, 4, MathHelper.getRandomIntegerInRange(p_75084_0_, 2 + p_75084_1_, 4 + p_75084_1_ * 2)));
        arraylist.add(new NorthrendStructureVillagePieces.PieceWeight(NorthrendStructureVillagePieces.Church.class, 20, MathHelper.getRandomIntegerInRange(p_75084_0_, 0 + p_75084_1_, 1 + p_75084_1_)));
        arraylist.add(new NorthrendStructureVillagePieces.PieceWeight(NorthrendStructureVillagePieces.House1.class, 20, MathHelper.getRandomIntegerInRange(p_75084_0_, 0 + p_75084_1_, 2 + p_75084_1_)));
        arraylist.add(new NorthrendStructureVillagePieces.PieceWeight(NorthrendStructureVillagePieces.WoodHut.class, 3, MathHelper.getRandomIntegerInRange(p_75084_0_, 2 + p_75084_1_, 5 + p_75084_1_ * 3)));
        arraylist.add(new NorthrendStructureVillagePieces.PieceWeight(NorthrendStructureVillagePieces.Hall.class, 15, MathHelper.getRandomIntegerInRange(p_75084_0_, 0 + p_75084_1_, 2 + p_75084_1_)));
        arraylist.add(new NorthrendStructureVillagePieces.PieceWeight(NorthrendStructureVillagePieces.Field1.class, 3, MathHelper.getRandomIntegerInRange(p_75084_0_, 1 + p_75084_1_, 4 + p_75084_1_)));
        arraylist.add(new NorthrendStructureVillagePieces.PieceWeight(NorthrendStructureVillagePieces.Field2.class, 3, MathHelper.getRandomIntegerInRange(p_75084_0_, 2 + p_75084_1_, 4 + p_75084_1_ * 2)));
        arraylist.add(new NorthrendStructureVillagePieces.PieceWeight(NorthrendStructureVillagePieces.House2.class, 15, MathHelper.getRandomIntegerInRange(p_75084_0_, 0, 1 + p_75084_1_)));
        arraylist.add(new NorthrendStructureVillagePieces.PieceWeight(NorthrendStructureVillagePieces.House3.class, 8, MathHelper.getRandomIntegerInRange(p_75084_0_, 0 + p_75084_1_, 3 + p_75084_1_ * 2)));
        net.minecraftforge.fml.common.registry.VillagerRegistry.addExtraVillageComponents(arraylist, p_75084_0_, p_75084_1_);

        Iterator iterator = arraylist.iterator();

        while (iterator.hasNext())
        {
            if (((NorthrendStructureVillagePieces.PieceWeight)iterator.next()).villagePiecesLimit == 0)
            {
                iterator.remove();
            }
        }

        return arraylist;
    }

    private static int func_75079_a(List p_75079_0_)
    {
        boolean flag = false;
        int i = 0;
        NorthrendStructureVillagePieces.PieceWeight pieceweight;

        for (Iterator iterator = p_75079_0_.iterator(); iterator.hasNext(); i += pieceweight.villagePieceWeight)
        {
            pieceweight = (NorthrendStructureVillagePieces.PieceWeight)iterator.next();

            if (pieceweight.villagePiecesLimit > 0 && pieceweight.villagePiecesSpawned < pieceweight.villagePiecesLimit)
            {
                flag = true;
            }
        }

        return flag ? i : -1;
    }

    private static NorthrendStructureVillagePieces.Village func_176065_a(NorthrendStructureVillagePieces.Start p_176065_0_, NorthrendStructureVillagePieces.PieceWeight p_176065_1_, List p_176065_2_, Random p_176065_3_, int p_176065_4_, int p_176065_5_, int p_176065_6_, EnumFacing p_176065_7_, int p_176065_8_)
    {
        Class oclass = p_176065_1_.villagePieceClass;
        Object object = null;

        if (oclass == NorthrendStructureVillagePieces.House4Garden.class)
        {
            object = NorthrendStructureVillagePieces.House4Garden.func_175858_a(p_176065_0_, p_176065_2_, p_176065_3_, p_176065_4_, p_176065_5_, p_176065_6_, p_176065_7_, p_176065_8_);
        }
        else if (oclass == NorthrendStructureVillagePieces.Church.class)
        {
            object = NorthrendStructureVillagePieces.Church.func_175854_a(p_176065_0_, p_176065_2_, p_176065_3_, p_176065_4_, p_176065_5_, p_176065_6_, p_176065_7_, p_176065_8_);
        }
        else if (oclass == NorthrendStructureVillagePieces.House1.class)
        {
            object = NorthrendStructureVillagePieces.House1.func_175850_a(p_176065_0_, p_176065_2_, p_176065_3_, p_176065_4_, p_176065_5_, p_176065_6_, p_176065_7_, p_176065_8_);
        }
        else if (oclass == NorthrendStructureVillagePieces.WoodHut.class)
        {
            object = NorthrendStructureVillagePieces.WoodHut.func_175853_a(p_176065_0_, p_176065_2_, p_176065_3_, p_176065_4_, p_176065_5_, p_176065_6_, p_176065_7_, p_176065_8_);
        }
        else if (oclass == NorthrendStructureVillagePieces.Hall.class)
        {
            object = NorthrendStructureVillagePieces.Hall.func_175857_a(p_176065_0_, p_176065_2_, p_176065_3_, p_176065_4_, p_176065_5_, p_176065_6_, p_176065_7_, p_176065_8_);
        }
        else if (oclass == NorthrendStructureVillagePieces.Field1.class)
        {
            object = NorthrendStructureVillagePieces.Field1.func_175851_a(p_176065_0_, p_176065_2_, p_176065_3_, p_176065_4_, p_176065_5_, p_176065_6_, p_176065_7_, p_176065_8_);
        }
        else if (oclass == NorthrendStructureVillagePieces.Field2.class)
        {
            object = NorthrendStructureVillagePieces.Field2.func_175852_a(p_176065_0_, p_176065_2_, p_176065_3_, p_176065_4_, p_176065_5_, p_176065_6_, p_176065_7_, p_176065_8_);
        }
        else if (oclass == NorthrendStructureVillagePieces.House2.class)
        {
            object = NorthrendStructureVillagePieces.House2.func_175855_a(p_176065_0_, p_176065_2_, p_176065_3_, p_176065_4_, p_176065_5_, p_176065_6_, p_176065_7_, p_176065_8_);
        }
        else if (oclass == NorthrendStructureVillagePieces.House3.class)
        {
            object = NorthrendStructureVillagePieces.House3.func_175849_a(p_176065_0_, p_176065_2_, p_176065_3_, p_176065_4_, p_176065_5_, p_176065_6_, p_176065_7_, p_176065_8_);
        }
        /*else
        {
            object = net.minecraftforge.fml.common.registry.VillagerRegistry.getVillageComponent(p_176065_1_, p_176065_0_, p_176065_2_, p_176065_3_, p_176065_4_, p_176065_5_, p_176065_6_, p_176065_7_, p_176065_8_);
        }*/

        return (NorthrendStructureVillagePieces.Village)object;
    }

    private static NorthrendStructureVillagePieces.Village func_176067_c(NorthrendStructureVillagePieces.Start p_176067_0_, List p_176067_1_, Random p_176067_2_, int p_176067_3_, int p_176067_4_, int p_176067_5_, EnumFacing p_176067_6_, int p_176067_7_)
    {
        int i1 = func_75079_a(p_176067_0_.structureVillageWeightedPieceList);

        if (i1 <= 0)
        {
            return null;
        }
        else
        {
            int j1 = 0;

            while (j1 < 5)
            {
                ++j1;
                int k1 = p_176067_2_.nextInt(i1);
                Iterator iterator = p_176067_0_.structureVillageWeightedPieceList.iterator();

                while (iterator.hasNext())
                {
                    NorthrendStructureVillagePieces.PieceWeight pieceweight = (NorthrendStructureVillagePieces.PieceWeight)iterator.next();
                    k1 -= pieceweight.villagePieceWeight;

                    if (k1 < 0)
                    {
                        if (!pieceweight.canSpawnMoreVillagePiecesOfType(p_176067_7_) || pieceweight == p_176067_0_.structVillagePieceWeight && p_176067_0_.structureVillageWeightedPieceList.size() > 1)
                        {
                            break;
                        }

                        NorthrendStructureVillagePieces.Village village = func_176065_a(p_176067_0_, pieceweight, p_176067_1_, p_176067_2_, p_176067_3_, p_176067_4_, p_176067_5_, p_176067_6_, p_176067_7_);

                        if (village != null)
                        {
                            ++pieceweight.villagePiecesSpawned;
                            p_176067_0_.structVillagePieceWeight = pieceweight;

                            if (!pieceweight.canSpawnMoreVillagePieces())
                            {
                                p_176067_0_.structureVillageWeightedPieceList.remove(pieceweight);
                            }

                            return village;
                        }
                    }
                }
            }

            StructureBoundingBox structureboundingbox = NorthrendStructureVillagePieces.Torch.func_175856_a(p_176067_0_, p_176067_1_, p_176067_2_, p_176067_3_, p_176067_4_, p_176067_5_, p_176067_6_);

            if (structureboundingbox != null)
            {
                return new NorthrendStructureVillagePieces.Torch(p_176067_0_, p_176067_7_, p_176067_2_, structureboundingbox, p_176067_6_);
            }
            else
            {
                return null;
            }
        }
    }

    private static NorthrendStructureComponent func_176066_d(NorthrendStructureVillagePieces.Start p_176066_0_, List p_176066_1_, Random p_176066_2_, int p_176066_3_, int p_176066_4_, int p_176066_5_, EnumFacing p_176066_6_, int p_176066_7_)
    {
        if (p_176066_7_ > 50)
        {
            return null;
        }
        else if (Math.abs(p_176066_3_ - p_176066_0_.getBoundingBox().minX) <= 112 && Math.abs(p_176066_5_ - p_176066_0_.getBoundingBox().minZ) <= 112)
        {
            NorthrendStructureVillagePieces.Village village = func_176067_c(p_176066_0_, p_176066_1_, p_176066_2_, p_176066_3_, p_176066_4_, p_176066_5_, p_176066_6_, p_176066_7_ + 1);

            if (village != null)
            {
                int i1 = (village.getBoundingBox().minX + village.getBoundingBox().maxX) / 2;
                int j1 = (village.getBoundingBox().minZ + village.getBoundingBox().maxZ) / 2;
                int k1 = village.getBoundingBox().maxX - village.getBoundingBox().minX;
                int l1 = village.getBoundingBox().maxZ - village.getBoundingBox().minZ;
                int i2 = k1 > l1 ? k1 : l1;

                if (p_176066_0_.getWorldChunkManager().areBiomesViable(i1, j1, i2 / 2 + 4, NorthrendMapGenVillage.villageSpawnBiomes))
                {
                    p_176066_1_.add(village);
                    p_176066_0_.field_74932_i.add(village);
                    return village;
                }
            }

            return null;
        }
        else
        {
            return null;
        }
    }

    private static NorthrendStructureComponent func_176069_e(NorthrendStructureVillagePieces.Start p_176069_0_, List p_176069_1_, Random p_176069_2_, int p_176069_3_, int p_176069_4_, int p_176069_5_, EnumFacing p_176069_6_, int p_176069_7_)
    {
        if (p_176069_7_ > 3 + p_176069_0_.terrainType)
        {
            return null;
        }
        else if (Math.abs(p_176069_3_ - p_176069_0_.getBoundingBox().minX) <= 112 && Math.abs(p_176069_5_ - p_176069_0_.getBoundingBox().minZ) <= 112)
        {
            StructureBoundingBox structureboundingbox = NorthrendStructureVillagePieces.Path.func_175848_a(p_176069_0_, p_176069_1_, p_176069_2_, p_176069_3_, p_176069_4_, p_176069_5_, p_176069_6_);

            if (structureboundingbox != null && structureboundingbox.minY > 10)
            {
                NorthrendStructureVillagePieces.Path path = new NorthrendStructureVillagePieces.Path(p_176069_0_, p_176069_7_, p_176069_2_, structureboundingbox, p_176069_6_);
                int i1 = (path.getBoundingBox().minX + path.getBoundingBox().maxX) / 2;
                int j1 = (path.getBoundingBox().minZ + path.getBoundingBox().maxZ) / 2;
                int k1 = path.getBoundingBox().maxX - path.getBoundingBox().minX;
                int l1 = path.getBoundingBox().maxZ - path.getBoundingBox().minZ;
                int i2 = k1 > l1 ? k1 : l1;

                if (p_176069_0_.getWorldChunkManager().areBiomesViable(i1, j1, i2 / 2 + 4, NorthrendMapGenVillage.villageSpawnBiomes))
                {
                    p_176069_1_.add(path);
                    p_176069_0_.field_74930_j.add(path);
                    return path;
                }
            }

            return null;
        }
        else
        {
            return null;
        }
    }

    public static class Church extends NorthrendStructureVillagePieces.Village
    {
        private static final String __OBFID = "CL_00000525";

        public Church() {}

        public Church(NorthrendStructureVillagePieces.Start p_i45564_1_, int p_i45564_2_, Random p_i45564_3_, StructureBoundingBox p_i45564_4_, EnumFacing p_i45564_5_)
        {
            super(p_i45564_1_, p_i45564_2_);
            this.coordBaseMode = p_i45564_5_;
            this.boundingBox = p_i45564_4_;
        }

        public static NorthrendStructureVillagePieces.Church func_175854_a(NorthrendStructureVillagePieces.Start p_175854_0_, List p_175854_1_, Random p_175854_2_, int p_175854_3_, int p_175854_4_, int p_175854_5_, EnumFacing p_175854_6_, int p_175854_7_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175854_3_, p_175854_4_, p_175854_5_, 0, 0, 0, 5, 12, 9, p_175854_6_);
            return canVillageGoDeeper(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175854_1_, structureboundingbox) == null ? new NorthrendStructureVillagePieces.Church(p_175854_0_, p_175854_7_, p_175854_2_, structureboundingbox, p_175854_6_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.field_143015_k < 0)
            {
                this.field_143015_k = this.getAverageGroundLevel(worldIn, p_74875_3_);

                if (this.field_143015_k < 0)
                {
                    return true;
                }

                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 12 - 1, 0);
            }

            this.func_175804_a(worldIn, p_74875_3_, 1, 1, 1, 3, 3, 7, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 5, 1, 3, 9, 3, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 0, 0, 3, 0, 8, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 1, 0, 3, 10, 0, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 1, 1, 0, 10, 3, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 1, 1, 4, 10, 3, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 4, 0, 4, 7, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 0, 4, 4, 4, 7, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 1, 8, 3, 4, 8, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 5, 4, 3, 10, 4, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 5, 5, 3, 5, 7, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 9, 0, 4, 9, 4, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 4, 0, 4, 4, 4, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175811_a(worldIn, stone.getDefaultState(), 0, 11, 2, p_74875_3_);
            this.func_175811_a(worldIn, stone.getDefaultState(), 4, 11, 2, p_74875_3_);
            this.func_175811_a(worldIn, stone.getDefaultState(), 2, 11, 0, p_74875_3_);
            this.func_175811_a(worldIn, stone.getDefaultState(), 2, 11, 4, p_74875_3_);
            this.func_175811_a(worldIn, stone.getDefaultState(), 1, 1, 6, p_74875_3_);
            this.func_175811_a(worldIn, stone.getDefaultState(), 1, 1, 7, p_74875_3_);
            this.func_175811_a(worldIn, stone.getDefaultState(), 2, 1, 7, p_74875_3_);
            this.func_175811_a(worldIn, stone.getDefaultState(), 3, 1, 6, p_74875_3_);
            this.func_175811_a(worldIn, stone.getDefaultState(), 3, 1, 7, p_74875_3_);
            this.func_175811_a(worldIn, stoneStairs.getStateFromMeta(this.getMetadataWithOffset(stoneStairs, 3)), 1, 1, 5, p_74875_3_);
            this.func_175811_a(worldIn, stoneStairs.getStateFromMeta(this.getMetadataWithOffset(stoneStairs, 3)), 2, 1, 6, p_74875_3_);
            this.func_175811_a(worldIn, stoneStairs.getStateFromMeta(this.getMetadataWithOffset(stoneStairs, 3)), 3, 1, 5, p_74875_3_);
            this.func_175811_a(worldIn, stoneStairs.getStateFromMeta(this.getMetadataWithOffset(stoneStairs, 1)), 1, 2, 7, p_74875_3_);
            this.func_175811_a(worldIn, stoneStairs.getStateFromMeta(this.getMetadataWithOffset(stoneStairs, 0)), 3, 2, 7, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 0, 2, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 0, 3, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 4, 2, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 4, 3, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 0, 6, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 0, 7, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 4, 6, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 4, 7, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 2, 6, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 2, 7, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 2, 6, 4, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 2, 7, 4, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 0, 3, 6, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 4, 3, 6, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 2, 3, 8, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode.getOpposite()), 2, 4, 7, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode.rotateY()), 1, 4, 6, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode.rotateYCCW()), 3, 4, 6, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode), 2, 4, 5, p_74875_3_);
            int i = this.getMetadataWithOffset(Blocks.ladder, 4);
            int j;

            for (j = 1; j <= 9; ++j)
            {
                this.func_175811_a(worldIn, Blocks.ladder.getStateFromMeta(i), 3, j, 3, p_74875_3_);
            }

            this.func_175811_a(worldIn, Blocks.air.getDefaultState(), 2, 1, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.air.getDefaultState(), 2, 2, 0, p_74875_3_);
            this.func_175810_a(worldIn, p_74875_3_, p_74875_2_, 2, 1, 0, EnumFacing.getHorizontal(this.getMetadataWithOffset(Blocks.oak_door, 1)));

            if (this.func_175807_a(worldIn, 2, 0, -1, p_74875_3_).getBlock().getMaterial() == Material.air && this.func_175807_a(worldIn, 2, -1, -1, p_74875_3_).getBlock().getMaterial() != Material.air)
            {
                this.func_175811_a(worldIn, stoneStairs.getStateFromMeta(this.getMetadataWithOffset(stoneStairs, 3)), 2, 0, -1, p_74875_3_);
            }

            for (j = 0; j < 9; ++j)
            {
                for (int k = 0; k < 5; ++k)
                {
                    this.clearCurrentPositionBlocksUpwards(worldIn, k, 12, j, p_74875_3_);
                    this.func_175808_b(worldIn, stone.getDefaultState(), k, -1, j, p_74875_3_);
                }
            }

            this.spawnVillagers(worldIn, p_74875_3_, 2, 1, 2, 1);
            return true;
        }

        protected int func_180779_c(int p_180779_1_, int p_180779_2_)
        {
            return 2;
        }
    }

    public static class Field1 extends NorthrendStructureVillagePieces.Village
    {
        /** First crop type for this field. */
        private Block cropTypeA;
        /** Second crop type for this field. */
        private Block cropTypeB;
        /** Third crop type for this field. */
        private Block cropTypeC;
        /** Fourth crop type for this field. */
        private Block cropTypeD;
        private static final String __OBFID = "CL_00000518";

        public Field1() {}

        public Field1(NorthrendStructureVillagePieces.Start p_i45570_1_, int p_i45570_2_, Random p_i45570_3_, StructureBoundingBox p_i45570_4_, EnumFacing p_i45570_5_)
        {
            super(p_i45570_1_, p_i45570_2_);
            this.coordBaseMode = p_i45570_5_;
            this.boundingBox = p_i45570_4_;
            this.cropTypeA = this.func_151559_a(p_i45570_3_);
            this.cropTypeB = this.func_151559_a(p_i45570_3_);
            this.cropTypeC = this.func_151559_a(p_i45570_3_);
            this.cropTypeD = this.func_151559_a(p_i45570_3_);
        }

        /**
         * (abstract) Helper method to write subclass data to NBT
         */
        protected void writeStructureToNBT(NBTTagCompound p_143012_1_)
        {
            super.writeStructureToNBT(p_143012_1_);
            p_143012_1_.setInteger("CA", Block.blockRegistry.getIDForObject(this.cropTypeA));
            p_143012_1_.setInteger("CB", Block.blockRegistry.getIDForObject(this.cropTypeB));
            p_143012_1_.setInteger("CC", Block.blockRegistry.getIDForObject(this.cropTypeC));
            p_143012_1_.setInteger("CD", Block.blockRegistry.getIDForObject(this.cropTypeD));
        }

        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        protected void readStructureFromNBT(NBTTagCompound p_143011_1_)
        {
            super.readStructureFromNBT(p_143011_1_);
            this.cropTypeA = Block.getBlockById(p_143011_1_.getInteger("CA"));
            this.cropTypeB = Block.getBlockById(p_143011_1_.getInteger("CB"));
            this.cropTypeC = Block.getBlockById(p_143011_1_.getInteger("CC"));
            this.cropTypeD = Block.getBlockById(p_143011_1_.getInteger("CD"));
        }

        private Block func_151559_a(Random p_151559_1_)
        {
            return plant;
        }

        public static NorthrendStructureVillagePieces.Field1 func_175851_a(NorthrendStructureVillagePieces.Start p_175851_0_, List p_175851_1_, Random p_175851_2_, int p_175851_3_, int p_175851_4_, int p_175851_5_, EnumFacing p_175851_6_, int p_175851_7_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175851_3_, p_175851_4_, p_175851_5_, 0, 0, 0, 13, 4, 9, p_175851_6_);
            return canVillageGoDeeper(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175851_1_, structureboundingbox) == null ? new NorthrendStructureVillagePieces.Field1(p_175851_0_, p_175851_7_, p_175851_2_, structureboundingbox, p_175851_6_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.field_143015_k < 0)
            {
                this.field_143015_k = this.getAverageGroundLevel(worldIn, p_74875_3_);

                if (this.field_143015_k < 0)
                {
                    return true;
                }

                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 4 - 1, 0);
            }

            this.func_175804_a(worldIn, p_74875_3_, 0, 1, 0, 12, 4, 8, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 0, 1, 2, 0, 7, farm.getDefaultState(), farm.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 0, 1, 5, 0, 7, farm.getDefaultState(), farm.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 7, 0, 1, 8, 0, 7, farm.getDefaultState(), farm.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 10, 0, 1, 11, 0, 7, farm.getDefaultState(), farm.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 0, 0, 0, 8, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), false);
            this.func_175804_a(worldIn, p_74875_3_, 6, 0, 0, 6, 0, 8, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), false);
            this.func_175804_a(worldIn, p_74875_3_, 12, 0, 0, 12, 0, 8, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 0, 0, 11, 0, 0, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 0, 8, 11, 0, 8, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), false);
            this.func_175804_a(worldIn, p_74875_3_, 3, 0, 1, 3, 0, 7, Blocks.water.getDefaultState(), Blocks.water.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 9, 0, 1, 9, 0, 7, Blocks.water.getDefaultState(), Blocks.water.getDefaultState(), false);
            int i;

            for (i = 1; i <= 7; ++i)
            {
                this.func_175811_a(worldIn, this.cropTypeA.getStateFromMeta(MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 6)), 1, 1, i, p_74875_3_);
                this.func_175811_a(worldIn, this.cropTypeA.getStateFromMeta(MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 6)), 2, 1, i, p_74875_3_);
                this.func_175811_a(worldIn, this.cropTypeB.getStateFromMeta(MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 6)), 4, 1, i, p_74875_3_);
                this.func_175811_a(worldIn, this.cropTypeB.getStateFromMeta(MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 6)), 5, 1, i, p_74875_3_);
                this.func_175811_a(worldIn, this.cropTypeC.getStateFromMeta(MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 6)), 7, 1, i, p_74875_3_);
                this.func_175811_a(worldIn, this.cropTypeC.getStateFromMeta(MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 6)), 8, 1, i, p_74875_3_);
                this.func_175811_a(worldIn, this.cropTypeD.getStateFromMeta(MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 6)), 10, 1, i, p_74875_3_);
                this.func_175811_a(worldIn, this.cropTypeD.getStateFromMeta(MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 6)), 11, 1, i, p_74875_3_);
            }

            for (i = 0; i < 9; ++i)
            {
                for (int j = 0; j < 13; ++j)
                {
                    this.clearCurrentPositionBlocksUpwards(worldIn, j, 4, i, p_74875_3_);
                    this.func_175808_b(worldIn, path.getDefaultState(), j, -1, i, p_74875_3_);
                }
            }

            return true;
        }
    }

    public static class Field2 extends NorthrendStructureVillagePieces.Village
    {
        /** First crop type for this field. */
        private Block cropTypeA;
        /** Second crop type for this field. */
        private Block cropTypeB;
        private static final String __OBFID = "CL_00000519";

        public Field2() {}

        public Field2(NorthrendStructureVillagePieces.Start p_i45569_1_, int p_i45569_2_, Random p_i45569_3_, StructureBoundingBox p_i45569_4_, EnumFacing p_i45569_5_)
        {
            super(p_i45569_1_, p_i45569_2_);
            this.coordBaseMode = p_i45569_5_;
            this.boundingBox = p_i45569_4_;
            this.cropTypeA = this.func_151560_a(p_i45569_3_);
            this.cropTypeB = this.func_151560_a(p_i45569_3_);
        }

        /**
         * (abstract) Helper method to write subclass data to NBT
         */
        protected void writeStructureToNBT(NBTTagCompound p_143012_1_)
        {
            super.writeStructureToNBT(p_143012_1_);
            p_143012_1_.setInteger("CA", Block.blockRegistry.getIDForObject(this.cropTypeA));
            p_143012_1_.setInteger("CB", Block.blockRegistry.getIDForObject(this.cropTypeB));
        }

        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        protected void readStructureFromNBT(NBTTagCompound p_143011_1_)
        {
            super.readStructureFromNBT(p_143011_1_);
            this.cropTypeA = Block.getBlockById(p_143011_1_.getInteger("CA"));
            this.cropTypeB = Block.getBlockById(p_143011_1_.getInteger("CB"));
        }

        private Block func_151560_a(Random p_151560_1_)
        {
            return plant;
        }

        public static NorthrendStructureVillagePieces.Field2 func_175852_a(NorthrendStructureVillagePieces.Start p_175852_0_, List p_175852_1_, Random p_175852_2_, int p_175852_3_, int p_175852_4_, int p_175852_5_, EnumFacing p_175852_6_, int p_175852_7_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175852_3_, p_175852_4_, p_175852_5_, 0, 0, 0, 7, 4, 9, p_175852_6_);
            return canVillageGoDeeper(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175852_1_, structureboundingbox) == null ? new NorthrendStructureVillagePieces.Field2(p_175852_0_, p_175852_7_, p_175852_2_, structureboundingbox, p_175852_6_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.field_143015_k < 0)
            {
                this.field_143015_k = this.getAverageGroundLevel(worldIn, p_74875_3_);

                if (this.field_143015_k < 0)
                {
                    return true;
                }

                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 4 - 1, 0);
            }

            this.func_175804_a(worldIn, p_74875_3_, 0, 1, 0, 6, 4, 8, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 0, 1, 2, 0, 7, farm.getDefaultState(), farm.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 0, 1, 5, 0, 7, farm.getDefaultState(), farm.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 0, 0, 0, 8, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), false);
            this.func_175804_a(worldIn, p_74875_3_, 6, 0, 0, 6, 0, 8, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 0, 0, 5, 0, 0, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 0, 8, 5, 0, 8, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), false);
            this.func_175804_a(worldIn, p_74875_3_, 3, 0, 1, 3, 0, 7, Blocks.water.getDefaultState(), Blocks.water.getDefaultState(), false);
            int i;

            for (i = 1; i <= 7; ++i)
            {
                this.func_175811_a(worldIn, this.cropTypeA.getStateFromMeta(MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 6)), 1, 1, i, p_74875_3_);
                this.func_175811_a(worldIn, this.cropTypeA.getStateFromMeta(MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 6)), 2, 1, i, p_74875_3_);
                this.func_175811_a(worldIn, this.cropTypeB.getStateFromMeta(MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 6)), 4, 1, i, p_74875_3_);
                this.func_175811_a(worldIn, this.cropTypeB.getStateFromMeta(MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 6)), 5, 1, i, p_74875_3_);
            }

            for (i = 0; i < 9; ++i)
            {
                for (int j = 0; j < 7; ++j)
                {
                    this.clearCurrentPositionBlocksUpwards(worldIn, j, 4, i, p_74875_3_);
                    this.func_175808_b(worldIn, path.getDefaultState(), j, -1, i, p_74875_3_);
                }
            }

            return true;
        }
    }

    public static class Hall extends NorthrendStructureVillagePieces.Village
    {
        private static final String __OBFID = "CL_00000522";

        public Hall() {}

        public Hall(NorthrendStructureVillagePieces.Start p_i45567_1_, int p_i45567_2_, Random p_i45567_3_, StructureBoundingBox p_i45567_4_, EnumFacing p_i45567_5_)
        {
            super(p_i45567_1_, p_i45567_2_);
            this.coordBaseMode = p_i45567_5_;
            this.boundingBox = p_i45567_4_;
        }

        public static NorthrendStructureVillagePieces.Hall func_175857_a(NorthrendStructureVillagePieces.Start p_175857_0_, List p_175857_1_, Random p_175857_2_, int p_175857_3_, int p_175857_4_, int p_175857_5_, EnumFacing p_175857_6_, int p_175857_7_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175857_3_, p_175857_4_, p_175857_5_, 0, 0, 0, 9, 7, 11, p_175857_6_);
            return canVillageGoDeeper(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175857_1_, structureboundingbox) == null ? new NorthrendStructureVillagePieces.Hall(p_175857_0_, p_175857_7_, p_175857_2_, structureboundingbox, p_175857_6_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.field_143015_k < 0)
            {
                this.field_143015_k = this.getAverageGroundLevel(worldIn, p_74875_3_);

                if (this.field_143015_k < 0)
                {
                    return true;
                }

                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 7 - 1, 0);
            }

            this.func_175804_a(worldIn, p_74875_3_, 1, 1, 1, 7, 4, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 1, 6, 8, 4, 10, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 0, 6, 8, 0, 10, path.getDefaultState(), path.getDefaultState(), false);
            this.func_175811_a(worldIn, stone.getDefaultState(), 6, 0, 6, p_74875_3_);
            this.func_175804_a(worldIn, p_74875_3_, 2, 1, 6, 2, 1, 10, fence.getDefaultState(), fence.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 8, 1, 6, 8, 1, 10, fence.getDefaultState(), fence.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 3, 1, 10, 7, 1, 10, fence.getDefaultState(), fence.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 0, 1, 7, 0, 4, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 0, 0, 3, 5, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 8, 0, 0, 8, 3, 5, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 0, 0, 7, 1, 0, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 0, 5, 7, 1, 5, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 2, 0, 7, 3, 0, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 2, 5, 7, 3, 5, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 4, 1, 8, 4, 1, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 4, 4, 8, 4, 4, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 5, 2, 8, 5, 3, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175811_a(worldIn, wood.getDefaultState(), 0, 4, 2, p_74875_3_);
            this.func_175811_a(worldIn, wood.getDefaultState(), 0, 4, 3, p_74875_3_);
            this.func_175811_a(worldIn, wood.getDefaultState(), 8, 4, 2, p_74875_3_);
            this.func_175811_a(worldIn, wood.getDefaultState(), 8, 4, 3, p_74875_3_);
            int i = this.getMetadataWithOffset(woodStairs, 3);
            int j = this.getMetadataWithOffset(woodStairs, 2);
            int k;
            int l;

            for (k = -1; k <= 2; ++k)
            {
                for (l = 0; l <= 8; ++l)
                {
                    this.func_175811_a(worldIn, woodStairs.getStateFromMeta(i), l, 4 + k, k, p_74875_3_);
                    this.func_175811_a(worldIn, woodStairs.getStateFromMeta(j), l, 4 + k, 5 - k, p_74875_3_);
                }
            }

            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 0, 2, 1, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 0, 2, 4, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 8, 2, 1, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 8, 2, 4, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 0, 2, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 0, 2, 3, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 8, 2, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 8, 2, 3, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 2, 2, 5, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 3, 2, 5, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 5, 2, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 6, 2, 5, p_74875_3_);
            this.func_175811_a(worldIn, fence.getDefaultState(), 2, 1, 3, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.wooden_pressure_plate.getDefaultState(), 2, 2, 3, p_74875_3_);
            this.func_175811_a(worldIn, wood.getDefaultState(), 1, 1, 4, p_74875_3_);
            this.func_175811_a(worldIn, woodStairs.getStateFromMeta(this.getMetadataWithOffset(woodStairs, 3)), 2, 1, 4, p_74875_3_);
            this.func_175811_a(worldIn, woodStairs.getStateFromMeta(this.getMetadataWithOffset(woodStairs, 1)), 1, 1, 3, p_74875_3_);
            this.func_175804_a(worldIn, p_74875_3_, 5, 0, 1, 7, 0, 3, Blocks.double_stone_slab.getDefaultState(), Blocks.double_stone_slab.getDefaultState(), false);
            this.func_175811_a(worldIn, Blocks.double_stone_slab.getDefaultState(), 6, 1, 1, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.double_stone_slab.getDefaultState(), 6, 1, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.air.getDefaultState(), 2, 1, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.air.getDefaultState(), 2, 2, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode), 2, 3, 1, p_74875_3_);
            this.func_175810_a(worldIn, p_74875_3_, p_74875_2_, 2, 1, 0, EnumFacing.getHorizontal(this.getMetadataWithOffset(Blocks.oak_door, 1)));

            if (this.func_175807_a(worldIn, 2, 0, -1, p_74875_3_).getBlock().getMaterial() == Material.air && this.func_175807_a(worldIn, 2, -1, -1, p_74875_3_).getBlock().getMaterial() != Material.air)
            {
                this.func_175811_a(worldIn, stoneStairs.getStateFromMeta(this.getMetadataWithOffset(stoneStairs, 3)), 2, 0, -1, p_74875_3_);
            }

            this.func_175811_a(worldIn, Blocks.air.getDefaultState(), 6, 1, 5, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.air.getDefaultState(), 6, 2, 5, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode.getOpposite()), 6, 3, 4, p_74875_3_);
            this.func_175810_a(worldIn, p_74875_3_, p_74875_2_, 6, 1, 5, EnumFacing.getHorizontal(this.getMetadataWithOffset(Blocks.oak_door, 1)));

            for (k = 0; k < 5; ++k)
            {
                for (l = 0; l < 9; ++l)
                {
                    this.clearCurrentPositionBlocksUpwards(worldIn, l, 7, k, p_74875_3_);
                    this.func_175808_b(worldIn, stone.getDefaultState(), l, -1, k, p_74875_3_);
                }
            }

            this.spawnVillagers(worldIn, p_74875_3_, 4, 1, 2, 2);
            return true;
        }

        protected int func_180779_c(int p_180779_1_, int p_180779_2_)
        {
            return p_180779_1_ == 0 ? 4 : super.func_180779_c(p_180779_1_, p_180779_2_);
        }
    }

    public static class House1 extends NorthrendStructureVillagePieces.Village
    {
        private static final String __OBFID = "CL_00000517";

        public House1() {}

        public House1(NorthrendStructureVillagePieces.Start p_i45571_1_, int p_i45571_2_, Random p_i45571_3_, StructureBoundingBox p_i45571_4_, EnumFacing p_i45571_5_)
        {
            super(p_i45571_1_, p_i45571_2_);
            this.coordBaseMode = p_i45571_5_;
            this.boundingBox = p_i45571_4_;
        }

        public static NorthrendStructureVillagePieces.House1 func_175850_a(NorthrendStructureVillagePieces.Start p_175850_0_, List p_175850_1_, Random p_175850_2_, int p_175850_3_, int p_175850_4_, int p_175850_5_, EnumFacing p_175850_6_, int p_175850_7_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175850_3_, p_175850_4_, p_175850_5_, 0, 0, 0, 9, 9, 6, p_175850_6_);
            return canVillageGoDeeper(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175850_1_, structureboundingbox) == null ? new NorthrendStructureVillagePieces.House1(p_175850_0_, p_175850_7_, p_175850_2_, structureboundingbox, p_175850_6_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.field_143015_k < 0)
            {
                this.field_143015_k = this.getAverageGroundLevel(worldIn, p_74875_3_);

                if (this.field_143015_k < 0)
                {
                    return true;
                }

                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 9 - 1, 0);
            }

            this.func_175804_a(worldIn, p_74875_3_, 1, 1, 1, 7, 5, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 0, 8, 0, 5, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 5, 0, 8, 5, 5, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 6, 1, 8, 6, 4, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 7, 2, 8, 7, 3, stone.getDefaultState(), stone.getDefaultState(), false);
            int i = this.getMetadataWithOffset(woodStairs, 3);
            int j = this.getMetadataWithOffset(woodStairs, 2);
            int k;
            int l;

            for (k = -1; k <= 2; ++k)
            {
                for (l = 0; l <= 8; ++l)
                {
                    this.func_175811_a(worldIn, woodStairs.getStateFromMeta(i), l, 6 + k, k, p_74875_3_);
                    this.func_175811_a(worldIn, woodStairs.getStateFromMeta(j), l, 6 + k, 5 - k, p_74875_3_);
                }
            }

            this.func_175804_a(worldIn, p_74875_3_, 0, 1, 0, 0, 1, 5, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 1, 5, 8, 1, 5, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 8, 1, 0, 8, 1, 4, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 1, 0, 7, 1, 0, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 0, 0, 4, 0, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 5, 0, 4, 5, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 8, 2, 5, 8, 4, 5, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 8, 2, 0, 8, 4, 0, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 1, 0, 4, 4, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 2, 5, 7, 4, 5, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 8, 2, 1, 8, 4, 4, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 2, 0, 7, 4, 0, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 4, 2, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 5, 2, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 6, 2, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 4, 3, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 5, 3, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 6, 3, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 0, 2, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 0, 2, 3, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 0, 3, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 0, 3, 3, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 8, 2, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 8, 2, 3, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 8, 3, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 8, 3, 3, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 2, 2, 5, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 3, 2, 5, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 5, 2, 5, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 6, 2, 5, p_74875_3_);
            this.func_175804_a(worldIn, p_74875_3_, 1, 4, 1, 7, 4, 1, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 4, 4, 7, 4, 4, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 3, 4, 7, 3, 4, Blocks.bookshelf.getDefaultState(), Blocks.bookshelf.getDefaultState(), false);
            this.func_175811_a(worldIn, wood.getDefaultState(), 7, 1, 4, p_74875_3_);
            this.func_175811_a(worldIn, woodStairs.getStateFromMeta(this.getMetadataWithOffset(woodStairs, 0)), 7, 1, 3, p_74875_3_);
            k = this.getMetadataWithOffset(woodStairs, 3);
            this.func_175811_a(worldIn, woodStairs.getStateFromMeta(k), 6, 1, 4, p_74875_3_);
            this.func_175811_a(worldIn, woodStairs.getStateFromMeta(k), 5, 1, 4, p_74875_3_);
            this.func_175811_a(worldIn, woodStairs.getStateFromMeta(k), 4, 1, 4, p_74875_3_);
            this.func_175811_a(worldIn, woodStairs.getStateFromMeta(k), 3, 1, 4, p_74875_3_);
            this.func_175811_a(worldIn, fence.getDefaultState(), 6, 1, 3, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.wooden_pressure_plate.getDefaultState(), 6, 2, 3, p_74875_3_);
            this.func_175811_a(worldIn, fence.getDefaultState(), 4, 1, 3, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.wooden_pressure_plate.getDefaultState(), 4, 2, 3, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.crafting_table.getDefaultState(), 7, 1, 1, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.air.getDefaultState(), 1, 1, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.air.getDefaultState(), 1, 2, 0, p_74875_3_);
            this.func_175810_a(worldIn, p_74875_3_, p_74875_2_, 1, 1, 0, EnumFacing.getHorizontal(this.getMetadataWithOffset(Blocks.oak_door, 1)));

            if (this.func_175807_a(worldIn, 1, 0, -1, p_74875_3_).getBlock().getMaterial() == Material.air && this.func_175807_a(worldIn, 1, -1, -1, p_74875_3_).getBlock().getMaterial() != Material.air)
            {
                this.func_175811_a(worldIn, stoneStairs.getStateFromMeta(this.getMetadataWithOffset(stoneStairs, 3)), 1, 0, -1, p_74875_3_);
            }

            for (l = 0; l < 6; ++l)
            {
                for (int i1 = 0; i1 < 9; ++i1)
                {
                    this.clearCurrentPositionBlocksUpwards(worldIn, i1, 9, l, p_74875_3_);
                    this.func_175808_b(worldIn, stone.getDefaultState(), i1, -1, l, p_74875_3_);
                }
            }

            this.spawnVillagers(worldIn, p_74875_3_, 2, 1, 2, 1);
            return true;
        }

        protected int func_180779_c(int p_180779_1_, int p_180779_2_)
        {
            return 1;
        }
    }

    public static class House2 extends NorthrendStructureVillagePieces.Village
    {
        /** List of items that Village's Blacksmith chest can contain. */
        private static final List villageBlacksmithChestContents = Lists.newArrayList(new WeightedRandomChestContent[] {new WeightedRandomChestContent(Items.diamond, 0, 1, 3, 3), new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 3, 5), new WeightedRandomChestContent(Items.bread, 0, 1, 3, 15), new WeightedRandomChestContent(Items.apple, 0, 1, 3, 15), new WeightedRandomChestContent(Items.iron_pickaxe, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_sword, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_chestplate, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_helmet, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_leggings, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_boots, 0, 1, 1, 5), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.obsidian), 0, 3, 7, 5), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.sapling), 0, 3, 7, 5), new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 3), new WeightedRandomChestContent(Items.iron_horse_armor, 0, 1, 1, 1), new WeightedRandomChestContent(Items.golden_horse_armor, 0, 1, 1, 1), new WeightedRandomChestContent(Items.diamond_horse_armor, 0, 1, 1, 1)});
        private boolean hasMadeChest;
        private static final String __OBFID = "CL_00000526";

        public House2() {}

        static
        {
            ChestGenHooks.init(VILLAGE_BLACKSMITH, villageBlacksmithChestContents, 3, 8);
        }

        public House2(NorthrendStructureVillagePieces.Start p_i45563_1_, int p_i45563_2_, Random p_i45563_3_, StructureBoundingBox p_i45563_4_, EnumFacing p_i45563_5_)
        {
            super(p_i45563_1_, p_i45563_2_);
            this.coordBaseMode = p_i45563_5_;
            this.boundingBox = p_i45563_4_;
        }

        public static NorthrendStructureVillagePieces.House2 func_175855_a(NorthrendStructureVillagePieces.Start p_175855_0_, List p_175855_1_, Random p_175855_2_, int p_175855_3_, int p_175855_4_, int p_175855_5_, EnumFacing p_175855_6_, int p_175855_7_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175855_3_, p_175855_4_, p_175855_5_, 0, 0, 0, 10, 6, 7, p_175855_6_);
            return canVillageGoDeeper(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175855_1_, structureboundingbox) == null ? new NorthrendStructureVillagePieces.House2(p_175855_0_, p_175855_7_, p_175855_2_, structureboundingbox, p_175855_6_) : null;
        }

        /**
         * (abstract) Helper method to write subclass data to NBT
         */
        protected void writeStructureToNBT(NBTTagCompound p_143012_1_)
        {
            super.writeStructureToNBT(p_143012_1_);
            p_143012_1_.setBoolean("Chest", this.hasMadeChest);
        }

        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        protected void readStructureFromNBT(NBTTagCompound p_143011_1_)
        {
            super.readStructureFromNBT(p_143011_1_);
            this.hasMadeChest = p_143011_1_.getBoolean("Chest");
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.field_143015_k < 0)
            {
                this.field_143015_k = this.getAverageGroundLevel(worldIn, p_74875_3_);

                if (this.field_143015_k < 0)
                {
                    return true;
                }

                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 6 - 1, 0);
            }

            this.func_175804_a(worldIn, p_74875_3_, 0, 1, 0, 9, 4, 6, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 0, 9, 0, 6, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 4, 0, 9, 4, 6, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 5, 0, 9, 5, 6, Blocks.stone_slab.getDefaultState(), Blocks.stone_slab.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 5, 1, 8, 5, 5, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 1, 0, 2, 3, 0, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 1, 0, 0, 4, 0, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), false);
            this.func_175804_a(worldIn, p_74875_3_, 3, 1, 0, 3, 4, 0, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 1, 6, 0, 4, 6, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), false);
            this.func_175811_a(worldIn, wood.getDefaultState(), 3, 3, 1, p_74875_3_);
            this.func_175804_a(worldIn, p_74875_3_, 3, 1, 2, 3, 3, 2, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 1, 3, 5, 3, 3, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 1, 1, 0, 3, 5, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 1, 6, 5, 3, 6, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 5, 1, 0, 5, 3, 0, fence.getDefaultState(), fence.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 9, 1, 0, 9, 3, 0, fence.getDefaultState(), fence.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 6, 1, 4, 9, 4, 6, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175811_a(worldIn, Blocks.flowing_lava.getDefaultState(), 7, 1, 5, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.flowing_lava.getDefaultState(), 8, 1, 5, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.iron_bars.getDefaultState(), 9, 2, 5, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.iron_bars.getDefaultState(), 9, 2, 4, p_74875_3_);
            this.func_175804_a(worldIn, p_74875_3_, 7, 2, 4, 8, 2, 5, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175811_a(worldIn, stone.getDefaultState(), 6, 1, 3, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.furnace.getDefaultState(), 6, 2, 3, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.furnace.getDefaultState(), 6, 3, 3, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.double_stone_slab.getDefaultState(), 8, 1, 1, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 0, 2, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 0, 2, 4, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 2, 2, 6, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 4, 2, 6, p_74875_3_);
            this.func_175811_a(worldIn, fence.getDefaultState(), 2, 1, 4, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.wooden_pressure_plate.getDefaultState(), 2, 2, 4, p_74875_3_);
            this.func_175811_a(worldIn, wood.getDefaultState(), 1, 1, 5, p_74875_3_);
            this.func_175811_a(worldIn, woodStairs.getStateFromMeta(this.getMetadataWithOffset(woodStairs, 3)), 2, 1, 5, p_74875_3_);
            this.func_175811_a(worldIn, woodStairs.getStateFromMeta(this.getMetadataWithOffset(woodStairs, 1)), 1, 1, 4, p_74875_3_);

            if (!this.hasMadeChest && p_74875_3_.func_175898_b(new BlockPos(this.getXWithOffset(5, 5), this.getYWithOffset(1), this.getZWithOffset(5, 5))))
            {
                this.hasMadeChest = true;
                this.func_180778_a(worldIn, p_74875_3_, p_74875_2_, 5, 1, 5, ChestGenHooks.getItems(VILLAGE_BLACKSMITH, p_74875_2_), ChestGenHooks.getCount(VILLAGE_BLACKSMITH, p_74875_2_));
            }

            int i;

            for (i = 6; i <= 8; ++i)
            {
                if (this.func_175807_a(worldIn, i, 0, -1, p_74875_3_).getBlock().getMaterial() == Material.air && this.func_175807_a(worldIn, i, -1, -1, p_74875_3_).getBlock().getMaterial() != Material.air)
                {
                    this.func_175811_a(worldIn, stoneStairs.getStateFromMeta(this.getMetadataWithOffset(stoneStairs, 3)), i, 0, -1, p_74875_3_);
                }
            }

            for (i = 0; i < 7; ++i)
            {
                for (int j = 0; j < 10; ++j)
                {
                    this.clearCurrentPositionBlocksUpwards(worldIn, j, 6, i, p_74875_3_);
                    this.func_175808_b(worldIn, stone.getDefaultState(), j, -1, i, p_74875_3_);
                }
            }

            this.spawnVillagers(worldIn, p_74875_3_, 7, 1, 1, 1);
            return true;
        }

        protected int func_180779_c(int p_180779_1_, int p_180779_2_)
        {
            return 3;
        }
    }

    public static class House3 extends NorthrendStructureVillagePieces.Village
    {
        private static final String __OBFID = "CL_00000530";

        public House3() {}

        public House3(NorthrendStructureVillagePieces.Start p_i45561_1_, int p_i45561_2_, Random p_i45561_3_, StructureBoundingBox p_i45561_4_, EnumFacing p_i45561_5_)
        {
            super(p_i45561_1_, p_i45561_2_);
            this.coordBaseMode = p_i45561_5_;
            this.boundingBox = p_i45561_4_;
        }

        public static NorthrendStructureVillagePieces.House3 func_175849_a(NorthrendStructureVillagePieces.Start p_175849_0_, List p_175849_1_, Random p_175849_2_, int p_175849_3_, int p_175849_4_, int p_175849_5_, EnumFacing p_175849_6_, int p_175849_7_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175849_3_, p_175849_4_, p_175849_5_, 0, 0, 0, 9, 7, 12, p_175849_6_);
            return canVillageGoDeeper(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175849_1_, structureboundingbox) == null ? new NorthrendStructureVillagePieces.House3(p_175849_0_, p_175849_7_, p_175849_2_, structureboundingbox, p_175849_6_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.field_143015_k < 0)
            {
                this.field_143015_k = this.getAverageGroundLevel(worldIn, p_74875_3_);

                if (this.field_143015_k < 0)
                {
                    return true;
                }

                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 7 - 1, 0);
            }

            this.func_175804_a(worldIn, p_74875_3_, 1, 1, 1, 7, 4, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 1, 6, 8, 4, 10, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 0, 5, 8, 0, 10, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 0, 1, 7, 0, 4, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 0, 0, 3, 5, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 8, 0, 0, 8, 3, 10, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 0, 0, 7, 2, 0, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 0, 5, 2, 1, 5, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 0, 6, 2, 3, 10, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 3, 0, 10, 7, 3, 10, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 2, 0, 7, 3, 0, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 2, 5, 2, 3, 5, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 4, 1, 8, 4, 1, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 4, 4, 3, 4, 4, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 5, 2, 8, 5, 3, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175811_a(worldIn, wood.getDefaultState(), 0, 4, 2, p_74875_3_);
            this.func_175811_a(worldIn, wood.getDefaultState(), 0, 4, 3, p_74875_3_);
            this.func_175811_a(worldIn, wood.getDefaultState(), 8, 4, 2, p_74875_3_);
            this.func_175811_a(worldIn, wood.getDefaultState(), 8, 4, 3, p_74875_3_);
            this.func_175811_a(worldIn, wood.getDefaultState(), 8, 4, 4, p_74875_3_);
            int i = this.getMetadataWithOffset(woodStairs, 3);
            int j = this.getMetadataWithOffset(woodStairs, 2);
            int k;
            int l;

            for (k = -1; k <= 2; ++k)
            {
                for (l = 0; l <= 8; ++l)
                {
                    this.func_175811_a(worldIn, woodStairs.getStateFromMeta(i), l, 4 + k, k, p_74875_3_);

                    if ((k > -1 || l <= 1) && (k > 0 || l <= 3) && (k > 1 || l <= 4 || l >= 6))
                    {
                        this.func_175811_a(worldIn, woodStairs.getStateFromMeta(j), l, 4 + k, 5 - k, p_74875_3_);
                    }
                }
            }

            this.func_175804_a(worldIn, p_74875_3_, 3, 4, 5, 3, 4, 10, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 7, 4, 2, 7, 4, 10, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 5, 4, 4, 5, 10, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 6, 5, 4, 6, 5, 10, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 5, 6, 3, 5, 6, 10, wood.getDefaultState(), wood.getDefaultState(), false);
            k = this.getMetadataWithOffset(woodStairs, 0);
            int i1;

            for (l = 4; l >= 1; --l)
            {
                this.func_175811_a(worldIn, wood.getDefaultState(), l, 2 + l, 7 - l, p_74875_3_);

                for (i1 = 8 - l; i1 <= 10; ++i1)
                {
                    this.func_175811_a(worldIn, woodStairs.getStateFromMeta(k), l, 2 + l, i1, p_74875_3_);
                }
            }

            l = this.getMetadataWithOffset(woodStairs, 1);
            this.func_175811_a(worldIn, wood.getDefaultState(), 6, 6, 3, p_74875_3_);
            this.func_175811_a(worldIn, wood.getDefaultState(), 7, 5, 4, p_74875_3_);
            this.func_175811_a(worldIn, woodStairs.getStateFromMeta(l), 6, 6, 4, p_74875_3_);
            int j1;

            for (i1 = 6; i1 <= 8; ++i1)
            {
                for (j1 = 5; j1 <= 10; ++j1)
                {
                    this.func_175811_a(worldIn, woodStairs.getStateFromMeta(l), i1, 12 - i1, j1, p_74875_3_);
                }
            }

            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 0, 2, 1, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 0, 2, 4, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 0, 2, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 0, 2, 3, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 4, 2, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 5, 2, 0, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 6, 2, 0, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 8, 2, 1, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 8, 2, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 8, 2, 3, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 8, 2, 4, p_74875_3_);
            this.func_175811_a(worldIn, wood.getDefaultState(), 8, 2, 5, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 8, 2, 6, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 8, 2, 7, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 8, 2, 8, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 8, 2, 9, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 2, 2, 6, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 2, 2, 7, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 2, 2, 8, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 2, 2, 9, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 4, 4, 10, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 5, 4, 10, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 6, 4, 10, p_74875_3_);
            this.func_175811_a(worldIn, wood.getDefaultState(), 5, 5, 10, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.air.getDefaultState(), 2, 1, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.air.getDefaultState(), 2, 2, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode), 2, 3, 1, p_74875_3_);
            this.func_175810_a(worldIn, p_74875_3_, p_74875_2_, 2, 1, 0, EnumFacing.getHorizontal(this.getMetadataWithOffset(Blocks.oak_door, 1)));
            this.func_175804_a(worldIn, p_74875_3_, 1, 0, -1, 3, 2, -1, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);

            if (this.func_175807_a(worldIn, 2, 0, -1, p_74875_3_).getBlock().getMaterial() == Material.air && this.func_175807_a(worldIn, 2, -1, -1, p_74875_3_).getBlock().getMaterial() != Material.air)
            {
                this.func_175811_a(worldIn, stoneStairs.getStateFromMeta(this.getMetadataWithOffset(stoneStairs, 3)), 2, 0, -1, p_74875_3_);
            }

            for (i1 = 0; i1 < 5; ++i1)
            {
                for (j1 = 0; j1 < 9; ++j1)
                {
                    this.clearCurrentPositionBlocksUpwards(worldIn, j1, 7, i1, p_74875_3_);
                    this.func_175808_b(worldIn, stone.getDefaultState(), j1, -1, i1, p_74875_3_);
                }
            }

            for (i1 = 5; i1 < 11; ++i1)
            {
                for (j1 = 2; j1 < 9; ++j1)
                {
                    this.clearCurrentPositionBlocksUpwards(worldIn, j1, 7, i1, p_74875_3_);
                    this.func_175808_b(worldIn, stone.getDefaultState(), j1, -1, i1, p_74875_3_);
                }
            }

            this.spawnVillagers(worldIn, p_74875_3_, 4, 1, 2, 2);
            return true;
        }
    }

    public static class House4Garden extends NorthrendStructureVillagePieces.Village
    {
        private boolean isRoofAccessible;
        private static final String __OBFID = "CL_00000523";

        public House4Garden() {}

        public House4Garden(NorthrendStructureVillagePieces.Start p_i45566_1_, int p_i45566_2_, Random p_i45566_3_, StructureBoundingBox p_i45566_4_, EnumFacing p_i45566_5_)
        {
            super(p_i45566_1_, p_i45566_2_);
            this.coordBaseMode = p_i45566_5_;
            this.boundingBox = p_i45566_4_;
            this.isRoofAccessible = p_i45566_3_.nextBoolean();
        }

        /**
         * (abstract) Helper method to write subclass data to NBT
         */
        protected void writeStructureToNBT(NBTTagCompound p_143012_1_)
        {
            super.writeStructureToNBT(p_143012_1_);
            p_143012_1_.setBoolean("Terrace", this.isRoofAccessible);
        }

        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        protected void readStructureFromNBT(NBTTagCompound p_143011_1_)
        {
            super.readStructureFromNBT(p_143011_1_);
            this.isRoofAccessible = p_143011_1_.getBoolean("Terrace");
        }

        public static NorthrendStructureVillagePieces.House4Garden func_175858_a(NorthrendStructureVillagePieces.Start p_175858_0_, List p_175858_1_, Random p_175858_2_, int p_175858_3_, int p_175858_4_, int p_175858_5_, EnumFacing p_175858_6_, int p_175858_7_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175858_3_, p_175858_4_, p_175858_5_, 0, 0, 0, 5, 6, 5, p_175858_6_);
            return NorthrendStructureComponent.findIntersecting(p_175858_1_, structureboundingbox) != null ? null : new NorthrendStructureVillagePieces.House4Garden(p_175858_0_, p_175858_7_, p_175858_2_, structureboundingbox, p_175858_6_);
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.field_143015_k < 0)
            {
                this.field_143015_k = this.getAverageGroundLevel(worldIn, p_74875_3_);

                if (this.field_143015_k < 0)
                {
                    return true;
                }

                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 6 - 1, 0);
            }

            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 0, 4, 0, 4, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 4, 0, 4, 4, 4, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 4, 1, 3, 4, 3, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175811_a(worldIn, stone.getDefaultState(), 0, 1, 0, p_74875_3_);
            this.func_175811_a(worldIn, stone.getDefaultState(), 0, 2, 0, p_74875_3_);
            this.func_175811_a(worldIn, stone.getDefaultState(), 0, 3, 0, p_74875_3_);
            this.func_175811_a(worldIn, stone.getDefaultState(), 4, 1, 0, p_74875_3_);
            this.func_175811_a(worldIn, stone.getDefaultState(), 4, 2, 0, p_74875_3_);
            this.func_175811_a(worldIn, stone.getDefaultState(), 4, 3, 0, p_74875_3_);
            this.func_175811_a(worldIn, stone.getDefaultState(), 0, 1, 4, p_74875_3_);
            this.func_175811_a(worldIn, stone.getDefaultState(), 0, 2, 4, p_74875_3_);
            this.func_175811_a(worldIn, stone.getDefaultState(), 0, 3, 4, p_74875_3_);
            this.func_175811_a(worldIn, stone.getDefaultState(), 4, 1, 4, p_74875_3_);
            this.func_175811_a(worldIn, stone.getDefaultState(), 4, 2, 4, p_74875_3_);
            this.func_175811_a(worldIn, stone.getDefaultState(), 4, 3, 4, p_74875_3_);
            this.func_175804_a(worldIn, p_74875_3_, 0, 1, 1, 0, 3, 3, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 1, 1, 4, 3, 3, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 1, 4, 3, 3, 4, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 0, 2, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 2, 2, 4, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 4, 2, 2, p_74875_3_);
            this.func_175811_a(worldIn, wood.getDefaultState(), 1, 1, 0, p_74875_3_);
            this.func_175811_a(worldIn, wood.getDefaultState(), 1, 2, 0, p_74875_3_);
            this.func_175811_a(worldIn, wood.getDefaultState(), 1, 3, 0, p_74875_3_);
            this.func_175811_a(worldIn, wood.getDefaultState(), 2, 3, 0, p_74875_3_);
            this.func_175811_a(worldIn, wood.getDefaultState(), 3, 3, 0, p_74875_3_);
            this.func_175811_a(worldIn, wood.getDefaultState(), 3, 2, 0, p_74875_3_);
            this.func_175811_a(worldIn, wood.getDefaultState(), 3, 1, 0, p_74875_3_);

            if (this.func_175807_a(worldIn, 2, 0, -1, p_74875_3_).getBlock().getMaterial() == Material.air && this.func_175807_a(worldIn, 2, -1, -1, p_74875_3_).getBlock().getMaterial() != Material.air)
            {
                this.func_175811_a(worldIn, stoneStairs.getStateFromMeta(this.getMetadataWithOffset(stoneStairs, 3)), 2, 0, -1, p_74875_3_);
            }

            this.func_175804_a(worldIn, p_74875_3_, 1, 1, 1, 3, 3, 3, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);

            if (this.isRoofAccessible)
            {
                this.func_175811_a(worldIn, fence.getDefaultState(), 0, 5, 0, p_74875_3_);
                this.func_175811_a(worldIn, fence.getDefaultState(), 1, 5, 0, p_74875_3_);
                this.func_175811_a(worldIn, fence.getDefaultState(), 2, 5, 0, p_74875_3_);
                this.func_175811_a(worldIn, fence.getDefaultState(), 3, 5, 0, p_74875_3_);
                this.func_175811_a(worldIn, fence.getDefaultState(), 4, 5, 0, p_74875_3_);
                this.func_175811_a(worldIn, fence.getDefaultState(), 0, 5, 4, p_74875_3_);
                this.func_175811_a(worldIn, fence.getDefaultState(), 1, 5, 4, p_74875_3_);
                this.func_175811_a(worldIn, fence.getDefaultState(), 2, 5, 4, p_74875_3_);
                this.func_175811_a(worldIn, fence.getDefaultState(), 3, 5, 4, p_74875_3_);
                this.func_175811_a(worldIn, fence.getDefaultState(), 4, 5, 4, p_74875_3_);
                this.func_175811_a(worldIn, fence.getDefaultState(), 4, 5, 1, p_74875_3_);
                this.func_175811_a(worldIn, fence.getDefaultState(), 4, 5, 2, p_74875_3_);
                this.func_175811_a(worldIn, fence.getDefaultState(), 4, 5, 3, p_74875_3_);
                this.func_175811_a(worldIn, fence.getDefaultState(), 0, 5, 1, p_74875_3_);
                this.func_175811_a(worldIn, fence.getDefaultState(), 0, 5, 2, p_74875_3_);
                this.func_175811_a(worldIn, fence.getDefaultState(), 0, 5, 3, p_74875_3_);
            }

            int i;

            if (this.isRoofAccessible)
            {
                i = this.getMetadataWithOffset(Blocks.ladder, 3);
                this.func_175811_a(worldIn, Blocks.ladder.getStateFromMeta(i), 3, 1, 3, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.ladder.getStateFromMeta(i), 3, 2, 3, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.ladder.getStateFromMeta(i), 3, 3, 3, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.ladder.getStateFromMeta(i), 3, 4, 3, p_74875_3_);
            }

            this.func_175811_a(worldIn, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode), 2, 3, 1, p_74875_3_);

            for (i = 0; i < 5; ++i)
            {
                for (int j = 0; j < 5; ++j)
                {
                    this.clearCurrentPositionBlocksUpwards(worldIn, j, 6, i, p_74875_3_);
                    this.func_175808_b(worldIn, stone.getDefaultState(), j, -1, i, p_74875_3_);
                }
            }

            this.spawnVillagers(worldIn, p_74875_3_, 1, 1, 2, 1);
            return true;
        }
    }

    public static class Path extends NorthrendStructureVillagePieces.Road
    {
        private int averageGroundLevel;
        private static final String __OBFID = "CL_00000528";

        public Path() {}

        public Path(NorthrendStructureVillagePieces.Start p_i45562_1_, int p_i45562_2_, Random p_i45562_3_, StructureBoundingBox p_i45562_4_, EnumFacing p_i45562_5_)
        {
            super(p_i45562_1_, p_i45562_2_);
            this.coordBaseMode = p_i45562_5_;
            this.boundingBox = p_i45562_4_;
            this.averageGroundLevel = Math.max(p_i45562_4_.getXSize(), p_i45562_4_.getZSize());
        }

        /**
         * (abstract) Helper method to write subclass data to NBT
         */
        protected void writeStructureToNBT(NBTTagCompound p_143012_1_)
        {
            super.writeStructureToNBT(p_143012_1_);
            p_143012_1_.setInteger("Length", this.averageGroundLevel);
        }

        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        protected void readStructureFromNBT(NBTTagCompound p_143011_1_)
        {
            super.readStructureFromNBT(p_143011_1_);
            this.averageGroundLevel = p_143011_1_.getInteger("Length");
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(NorthrendStructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            boolean flag = false;
            int i;
            NorthrendStructureComponent structurecomponent1;

            for (i = p_74861_3_.nextInt(5); i < this.averageGroundLevel - 8; i += 2 + p_74861_3_.nextInt(5))
            {
                structurecomponent1 = this.getNextComponentNN((NorthrendStructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, i);

                if (structurecomponent1 != null)
                {
                    i += Math.max(structurecomponent1.getBoundingBox().getXSize(), structurecomponent1.getBoundingBox().getZSize());
                    flag = true;
                }
            }

            for (i = p_74861_3_.nextInt(5); i < this.averageGroundLevel - 8; i += 2 + p_74861_3_.nextInt(5))
            {
                structurecomponent1 = this.getNextComponentPP((NorthrendStructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, i);

                if (structurecomponent1 != null)
                {
                    i += Math.max(structurecomponent1.getBoundingBox().getXSize(), structurecomponent1.getBoundingBox().getZSize());
                    flag = true;
                }
            }

            if (flag && p_74861_3_.nextInt(3) > 0 && this.coordBaseMode != null)
            {
                switch (NorthrendStructureVillagePieces.SwitchEnumFacing.field_176064_a[this.coordBaseMode.ordinal()])
                {
                    case 1:
                        NorthrendStructureVillagePieces.func_176069_e((NorthrendStructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ, EnumFacing.WEST, this.getComponentType());
                        break;
                    case 2:
                        NorthrendStructureVillagePieces.func_176069_e((NorthrendStructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.maxZ - 2, EnumFacing.WEST, this.getComponentType());
                        break;
                    case 3:
                        NorthrendStructureVillagePieces.func_176069_e((NorthrendStructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                        break;
                    case 4:
                        NorthrendStructureVillagePieces.func_176069_e((NorthrendStructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.maxX - 2, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                }
            }

            if (flag && p_74861_3_.nextInt(3) > 0 && this.coordBaseMode != null)
            {
                switch (NorthrendStructureVillagePieces.SwitchEnumFacing.field_176064_a[this.coordBaseMode.ordinal()])
                {
                    case 1:
                        NorthrendStructureVillagePieces.func_176069_e((NorthrendStructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ, EnumFacing.EAST, this.getComponentType());
                        break;
                    case 2:
                        NorthrendStructureVillagePieces.func_176069_e((NorthrendStructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.maxZ - 2, EnumFacing.EAST, this.getComponentType());
                        break;
                    case 3:
                        NorthrendStructureVillagePieces.func_176069_e((NorthrendStructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                        break;
                    case 4:
                        NorthrendStructureVillagePieces.func_176069_e((NorthrendStructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.maxX - 2, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                }
            }
        }

        public static StructureBoundingBox func_175848_a(NorthrendStructureVillagePieces.Start p_175848_0_, List p_175848_1_, Random p_175848_2_, int p_175848_3_, int p_175848_4_, int p_175848_5_, EnumFacing p_175848_6_)
        {
            for (int l = 7 * MathHelper.getRandomIntegerInRange(p_175848_2_, 3, 5); l >= 7; l -= 7)
            {
                StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175848_3_, p_175848_4_, p_175848_5_, 0, 0, 0, 3, 3, l, p_175848_6_);

                if (NorthrendStructureComponent.findIntersecting(p_175848_1_, structureboundingbox) == null)
                {
                    return structureboundingbox;
                }
            }

            return null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            IBlockState iblockstate = path.getDefaultState();
            IBlockState iblockstate1 = stone.getDefaultState();

            for (int i = this.boundingBox.minX; i <= this.boundingBox.maxX; ++i)
            {
                for (int j = this.boundingBox.minZ; j <= this.boundingBox.maxZ; ++j)
                {
                    BlockPos blockpos = new BlockPos(i, 64, j);

                    if (p_74875_3_.func_175898_b(blockpos))
                    {
                        blockpos = worldIn.getTopSolidOrLiquidBlock(blockpos).down();
                        worldIn.setBlockState(blockpos, iblockstate, 2);
                        worldIn.setBlockState(blockpos.down(), iblockstate1, 2);
                    }
                }
            }

            return true;
        }
    }

    public static class PieceWeight extends StructureVillagePieces.PieceWeight
    {
        private static final String __OBFID = "CL_00000521";

        public PieceWeight(Class p_i2098_1_, int p_i2098_2_, int p_i2098_3_)
        {
            super(p_i2098_1_, p_i2098_2_, p_i2098_3_);
        }
    }

    public abstract static class Road extends NorthrendStructureVillagePieces.Village
    {
        private static final String __OBFID = "CL_00000532";

        public Road() {}

        protected Road(NorthrendStructureVillagePieces.Start p_i2108_1_, int p_i2108_2_)
        {
            super(p_i2108_1_, p_i2108_2_);
        }
    }

    public static class Start extends NorthrendStructureVillagePieces.Well
    {
        public WorldChunkManager worldChunkMngr;
        /** Boolean that determines if the village is in a desert or not. */
        public boolean inDesert;
        /** World terrain type, 0 for normal, 1 for flap map */
        public int terrainType;
        public NorthrendStructureVillagePieces.PieceWeight structVillagePieceWeight;
        /**
         * Contains List of all spawnable Structure Piece Weights. If no more Pieces of a type can be spawned, they
         * are removed from this list
         */
        public List structureVillageWeightedPieceList;
        public List field_74932_i = Lists.newArrayList();
        public List field_74930_j = Lists.newArrayList();
        private static final String __OBFID = "CL_00000527";
        public BiomeGenBase biome;

        public Start() {}

        public Start(WorldChunkManager p_i2104_1_, int p_i2104_2_, Random p_i2104_3_, int p_i2104_4_, int p_i2104_5_, List p_i2104_6_, int p_i2104_7_)
        {
            super(null, p_i2104_2_, p_i2104_3_, p_i2104_4_, p_i2104_5_);
            this.worldChunkMngr = p_i2104_1_;
            this.structureVillageWeightedPieceList = p_i2104_6_;
            this.terrainType = p_i2104_7_;
            BiomeGenBase biomegenbase = p_i2104_1_.func_180300_a(new BlockPos(p_i2104_4_, 0, p_i2104_5_), BiomeGenBase.field_180279_ad);
            this.inDesert = biomegenbase == BiomeGenBase.desert || biomegenbase == BiomeGenBase.desertHills;
            this.biome = biomegenbase;
            this.func_175846_a(this.inDesert);
        }

        public WorldChunkManager getWorldChunkManager()
        {
            return this.worldChunkMngr;
        }
    }

    static final class SwitchEnumFacing
    {
        static final int[] field_176064_a = new int[EnumFacing.values().length];
        private static final String __OBFID = "CL_00001968";

        static
        {
            try
            {
                field_176064_a[EnumFacing.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError var4)
            {
                ;
            }

            try
            {
                field_176064_a[EnumFacing.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }

            try
            {
                field_176064_a[EnumFacing.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                field_176064_a[EnumFacing.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }

    public static class Torch extends NorthrendStructureVillagePieces.Village
    {
        private static final String __OBFID = "CL_00000520";

        public Torch() {}

        public Torch(NorthrendStructureVillagePieces.Start p_i45568_1_, int p_i45568_2_, Random p_i45568_3_, StructureBoundingBox p_i45568_4_, EnumFacing p_i45568_5_)
        {
            super(p_i45568_1_, p_i45568_2_);
            this.coordBaseMode = p_i45568_5_;
            this.boundingBox = p_i45568_4_;
        }

        public static StructureBoundingBox func_175856_a(NorthrendStructureVillagePieces.Start p_175856_0_, List p_175856_1_, Random p_175856_2_, int p_175856_3_, int p_175856_4_, int p_175856_5_, EnumFacing p_175856_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175856_3_, p_175856_4_, p_175856_5_, 0, 0, 0, 3, 4, 2, p_175856_6_);
            return NorthrendStructureComponent.findIntersecting(p_175856_1_, structureboundingbox) != null ? null : structureboundingbox;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.field_143015_k < 0)
            {
                this.field_143015_k = this.getAverageGroundLevel(worldIn, p_74875_3_);

                if (this.field_143015_k < 0)
                {
                    return true;
                }

                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 4 - 1, 0);
            }

            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 0, 2, 3, 1, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175811_a(worldIn, fence.getDefaultState(), 1, 0, 0, p_74875_3_);
            this.func_175811_a(worldIn, fence.getDefaultState(), 1, 1, 0, p_74875_3_);
            this.func_175811_a(worldIn, fence.getDefaultState(), 1, 2, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.wool.getStateFromMeta(EnumDyeColor.WHITE.getDyeDamage()), 1, 3, 0, p_74875_3_);
            boolean flag = this.coordBaseMode == EnumFacing.EAST || this.coordBaseMode == EnumFacing.NORTH;
            this.func_175811_a(worldIn, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode.rotateY()), flag ? 2 : 0, 3, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode), 1, 3, 1, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode.rotateYCCW()), flag ? 0 : 2, 3, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode.getOpposite()), 1, 3, -1, p_74875_3_);
            return true;
        }
    }

    public abstract static class Village extends NorthrendStructureComponent
    {
        protected int field_143015_k = -1;
        /** The number of villagers that have been spawned in this component. */
        private int villagersSpawned;
        private boolean field_143014_b;
        private static final String __OBFID = "CL_00000531";
        private NorthrendStructureVillagePieces.Start startPiece;

        public Village() {}

        protected Village(NorthrendStructureVillagePieces.Start p_i2107_1_, int p_i2107_2_)
        {
            super(p_i2107_2_);

            if (p_i2107_1_ != null)
            {
                this.field_143014_b = p_i2107_1_.inDesert;
                startPiece = p_i2107_1_;
            }
        }

        /**
         * (abstract) Helper method to write subclass data to NBT
         */
        protected void writeStructureToNBT(NBTTagCompound p_143012_1_)
        {
            p_143012_1_.setInteger("HPos", this.field_143015_k);
            p_143012_1_.setInteger("VCount", this.villagersSpawned);
            p_143012_1_.setBoolean("Desert", this.field_143014_b);
        }

        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        protected void readStructureFromNBT(NBTTagCompound p_143011_1_)
        {
            this.field_143015_k = p_143011_1_.getInteger("HPos");
            this.villagersSpawned = p_143011_1_.getInteger("VCount");
            this.field_143014_b = p_143011_1_.getBoolean("Desert");
        }

        /**
         * Gets the next village component, with the bounding box shifted -1 in the X and Z direction.
         */
        protected NorthrendStructureComponent getNextComponentNN(NorthrendStructureVillagePieces.Start p_74891_1_, List p_74891_2_, Random p_74891_3_, int p_74891_4_, int p_74891_5_)
        {
            if (this.coordBaseMode != null)
            {
                switch (NorthrendStructureVillagePieces.SwitchEnumFacing.field_176064_a[this.coordBaseMode.ordinal()])
                {
                    case 1:
                        return NorthrendStructureVillagePieces.func_176066_d(p_74891_1_, p_74891_2_, p_74891_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74891_4_, this.boundingBox.minZ + p_74891_5_, EnumFacing.WEST, this.getComponentType());
                    case 2:
                        return NorthrendStructureVillagePieces.func_176066_d(p_74891_1_, p_74891_2_, p_74891_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74891_4_, this.boundingBox.minZ + p_74891_5_, EnumFacing.WEST, this.getComponentType());
                    case 3:
                        return NorthrendStructureVillagePieces.func_176066_d(p_74891_1_, p_74891_2_, p_74891_3_, this.boundingBox.minX + p_74891_5_, this.boundingBox.minY + p_74891_4_, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                    case 4:
                        return NorthrendStructureVillagePieces.func_176066_d(p_74891_1_, p_74891_2_, p_74891_3_, this.boundingBox.minX + p_74891_5_, this.boundingBox.minY + p_74891_4_, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                }
            }

            return null;
        }

        /**
         * Gets the next village component, with the bounding box shifted +1 in the X and Z direction.
         */
        protected NorthrendStructureComponent getNextComponentPP(NorthrendStructureVillagePieces.Start p_74894_1_, List p_74894_2_, Random p_74894_3_, int p_74894_4_, int p_74894_5_)
        {
            if (this.coordBaseMode != null)
            {
                switch (NorthrendStructureVillagePieces.SwitchEnumFacing.field_176064_a[this.coordBaseMode.ordinal()])
                {
                    case 1:
                        return NorthrendStructureVillagePieces.func_176066_d(p_74894_1_, p_74894_2_, p_74894_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74894_4_, this.boundingBox.minZ + p_74894_5_, EnumFacing.EAST, this.getComponentType());
                    case 2:
                        return NorthrendStructureVillagePieces.func_176066_d(p_74894_1_, p_74894_2_, p_74894_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74894_4_, this.boundingBox.minZ + p_74894_5_, EnumFacing.EAST, this.getComponentType());
                    case 3:
                        return NorthrendStructureVillagePieces.func_176066_d(p_74894_1_, p_74894_2_, p_74894_3_, this.boundingBox.minX + p_74894_5_, this.boundingBox.minY + p_74894_4_, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                    case 4:
                        return NorthrendStructureVillagePieces.func_176066_d(p_74894_1_, p_74894_2_, p_74894_3_, this.boundingBox.minX + p_74894_5_, this.boundingBox.minY + p_74894_4_, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                }
            }

            return null;
        }

        /**
         * Discover the y coordinate that will serve as the ground level of the supplied BoundingBox. (A median of
         * all the levels in the BB's horizontal rectangle).
         */
        protected int getAverageGroundLevel(World worldIn, StructureBoundingBox p_74889_2_)
        {
            int i = 0;
            int j = 0;

            for (int k = this.boundingBox.minZ; k <= this.boundingBox.maxZ; ++k)
            {
                for (int l = this.boundingBox.minX; l <= this.boundingBox.maxX; ++l)
                {
                    BlockPos blockpos = new BlockPos(l, 64, k);

                    if (p_74889_2_.func_175898_b(blockpos))
                    {
                        i += Math.max(worldIn.getTopSolidOrLiquidBlock(blockpos).getY(), worldIn.provider.getAverageGroundLevel());
                        ++j;
                    }
                }
            }

            if (j == 0)
            {
                return -1;
            }
            else
            {
                return i / j;
            }
        }

        protected static boolean canVillageGoDeeper(StructureBoundingBox p_74895_0_)
        {
            return p_74895_0_ != null && p_74895_0_.minY > 10;
        }

        /**
         * Spawns a number of villagers in this component. Parameters: worldgen, component bounding box, x offset, y
         * offset, z offset, number of villagers
         */
        protected void spawnVillagers(World worldIn, StructureBoundingBox p_74893_2_, int p_74893_3_, int p_74893_4_, int p_74893_5_, int p_74893_6_)
        {
            if (this.villagersSpawned < p_74893_6_)
            {
                for (int i1 = this.villagersSpawned; i1 < p_74893_6_; ++i1)
                {
                    int j1 = this.getXWithOffset(p_74893_3_ + i1, p_74893_5_);
                    int k1 = this.getYWithOffset(p_74893_4_);
                    int l1 = this.getZWithOffset(p_74893_3_ + i1, p_74893_5_);

                    if (!p_74893_2_.func_175898_b(new BlockPos(j1, k1, l1)))
                    {
                        break;
                    }

                    ++this.villagersSpawned;
                    EntityVillager entityvillager = new EntityVillager(worldIn);
                    entityvillager.setLocationAndAngles((double)j1 + 0.5D, (double)k1, (double)l1 + 0.5D, 0.0F, 0.0F);
                    entityvillager.func_180482_a(worldIn.getDifficultyForLocation(new BlockPos(entityvillager)), (IEntityLivingData)null);
                    entityvillager.setProfession(this.func_180779_c(i1, entityvillager.getProfession()));
                    worldIn.spawnEntityInWorld(entityvillager);
                }
            }
        }

        protected int func_180779_c(int p_180779_1_, int p_180779_2_)
        {
            return p_180779_2_;
        }

        protected void func_175811_a(World worldIn, IBlockState p_175811_2_, int p_175811_3_, int p_175811_4_, int p_175811_5_, StructureBoundingBox p_175811_6_)
        {
            super.func_175811_a(worldIn, p_175811_2_, p_175811_3_, p_175811_4_, p_175811_5_, p_175811_6_);
        }

        protected void func_175804_a(World worldIn, StructureBoundingBox p_175804_2_, int p_175804_3_, int p_175804_4_, int p_175804_5_, int p_175804_6_, int p_175804_7_, int p_175804_8_, IBlockState p_175804_9_, IBlockState p_175804_10_, boolean p_175804_11_)
        {
            super.func_175804_a(worldIn, p_175804_2_, p_175804_3_, p_175804_4_, p_175804_5_, p_175804_6_, p_175804_7_, p_175804_8_, p_175804_9_, p_175804_10_, p_175804_11_);
        }

        protected void func_175808_b(World worldIn, IBlockState p_175808_2_, int p_175808_3_, int p_175808_4_, int p_175808_5_, StructureBoundingBox p_175808_6_)
        {
            super.func_175808_b(worldIn, p_175808_2_, p_175808_3_, p_175808_4_, p_175808_5_, p_175808_6_);
        }

        protected void func_175846_a(boolean p_175846_1_)
        {
            this.field_143014_b = p_175846_1_;
        }
    }

    public static class Well extends NorthrendStructureVillagePieces.Village
    {
        private static final String __OBFID = "CL_00000533";

        public Well() {}

        public Well(NorthrendStructureVillagePieces.Start p_i2109_1_, int p_i2109_2_, Random p_i2109_3_, int p_i2109_4_, int p_i2109_5_)
        {
            super(p_i2109_1_, p_i2109_2_);
            this.coordBaseMode = EnumFacing.Plane.HORIZONTAL.random(p_i2109_3_);

            switch (NorthrendStructureVillagePieces.SwitchEnumFacing.field_176064_a[this.coordBaseMode.ordinal()])
            {
                case 1:
                case 2:
                    this.boundingBox = new StructureBoundingBox(p_i2109_4_, 64, p_i2109_5_, p_i2109_4_ + 6 - 1, 78, p_i2109_5_ + 6 - 1);
                    break;
                default:
                    this.boundingBox = new StructureBoundingBox(p_i2109_4_, 64, p_i2109_5_, p_i2109_4_ + 6 - 1, 78, p_i2109_5_ + 6 - 1);
            }
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(NorthrendStructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            NorthrendStructureVillagePieces.func_176069_e((NorthrendStructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.minX - 1, this.boundingBox.maxY - 4, this.boundingBox.minZ + 1, EnumFacing.WEST, this.getComponentType());
            NorthrendStructureVillagePieces.func_176069_e((NorthrendStructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.maxX + 1, this.boundingBox.maxY - 4, this.boundingBox.minZ + 1, EnumFacing.EAST, this.getComponentType());
            NorthrendStructureVillagePieces.func_176069_e((NorthrendStructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.minX + 1, this.boundingBox.maxY - 4, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
            NorthrendStructureVillagePieces.func_176069_e((NorthrendStructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.minX + 1, this.boundingBox.maxY - 4, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.field_143015_k < 0)
            {
                this.field_143015_k = this.getAverageGroundLevel(worldIn, p_74875_3_);

                if (this.field_143015_k < 0)
                {
                    return true;
                }

                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 3, 0);
            }

            this.func_175804_a(worldIn, p_74875_3_, 1, 0, 1, 4, 12, 4, stone.getDefaultState(), Blocks.flowing_water.getDefaultState(), false);
            this.func_175811_a(worldIn, Blocks.air.getDefaultState(), 2, 12, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.air.getDefaultState(), 3, 12, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.air.getDefaultState(), 2, 12, 3, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.air.getDefaultState(), 3, 12, 3, p_74875_3_);
            this.func_175811_a(worldIn, fence.getDefaultState(), 1, 13, 1, p_74875_3_);
            this.func_175811_a(worldIn, fence.getDefaultState(), 1, 14, 1, p_74875_3_);
            this.func_175811_a(worldIn, fence.getDefaultState(), 4, 13, 1, p_74875_3_);
            this.func_175811_a(worldIn, fence.getDefaultState(), 4, 14, 1, p_74875_3_);
            this.func_175811_a(worldIn, fence.getDefaultState(), 1, 13, 4, p_74875_3_);
            this.func_175811_a(worldIn, fence.getDefaultState(), 1, 14, 4, p_74875_3_);
            this.func_175811_a(worldIn, fence.getDefaultState(), 4, 13, 4, p_74875_3_);
            this.func_175811_a(worldIn, fence.getDefaultState(), 4, 14, 4, p_74875_3_);
            this.func_175804_a(worldIn, p_74875_3_, 1, 15, 1, 4, 15, 4, stone.getDefaultState(), stone.getDefaultState(), false);

            for (int i = 0; i <= 5; ++i)
            {
                for (int j = 0; j <= 5; ++j)
                {
                    if (j == 0 || j == 5 || i == 0 || i == 5)
                    {
                        this.func_175811_a(worldIn, path.getDefaultState(), j, 11, i, p_74875_3_);
                        this.clearCurrentPositionBlocksUpwards(worldIn, j, 12, i, p_74875_3_);
                    }
                }
            }

            return true;
        }
    }

    public static class WoodHut extends NorthrendStructureVillagePieces.Village
    {
        private boolean isTallHouse;
        private int tablePosition;
        private static final String __OBFID = "CL_00000524";

        public WoodHut() {}

        public WoodHut(NorthrendStructureVillagePieces.Start p_i45565_1_, int p_i45565_2_, Random p_i45565_3_, StructureBoundingBox p_i45565_4_, EnumFacing p_i45565_5_)
        {
            super(p_i45565_1_, p_i45565_2_);
            this.coordBaseMode = p_i45565_5_;
            this.boundingBox = p_i45565_4_;
            this.isTallHouse = p_i45565_3_.nextBoolean();
            this.tablePosition = p_i45565_3_.nextInt(3);
        }

        /**
         * (abstract) Helper method to write subclass data to NBT
         */
        protected void writeStructureToNBT(NBTTagCompound p_143012_1_)
        {
            super.writeStructureToNBT(p_143012_1_);
            p_143012_1_.setInteger("T", this.tablePosition);
            p_143012_1_.setBoolean("C", this.isTallHouse);
        }

        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        protected void readStructureFromNBT(NBTTagCompound p_143011_1_)
        {
            super.readStructureFromNBT(p_143011_1_);
            this.tablePosition = p_143011_1_.getInteger("T");
            this.isTallHouse = p_143011_1_.getBoolean("C");
        }

        public static NorthrendStructureVillagePieces.WoodHut func_175853_a(NorthrendStructureVillagePieces.Start p_175853_0_, List p_175853_1_, Random p_175853_2_, int p_175853_3_, int p_175853_4_, int p_175853_5_, EnumFacing p_175853_6_, int p_175853_7_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175853_3_, p_175853_4_, p_175853_5_, 0, 0, 0, 4, 6, 5, p_175853_6_);
            return canVillageGoDeeper(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175853_1_, structureboundingbox) == null ? new NorthrendStructureVillagePieces.WoodHut(p_175853_0_, p_175853_7_, p_175853_2_, structureboundingbox, p_175853_6_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.field_143015_k < 0)
            {
                this.field_143015_k = this.getAverageGroundLevel(worldIn, p_74875_3_);

                if (this.field_143015_k < 0)
                {
                    return true;
                }

                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 6 - 1, 0);
            }

            this.func_175804_a(worldIn, p_74875_3_, 1, 1, 1, 3, 5, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 0, 3, 0, 4, stone.getDefaultState(), stone.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 0, 1, 2, 0, 3, path.getDefaultState(), path.getDefaultState(), false);

            if (this.isTallHouse)
            {
                this.func_175804_a(worldIn, p_74875_3_, 1, 4, 1, 2, 4, 3, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), false);
            }
            else
            {
                this.func_175804_a(worldIn, p_74875_3_, 1, 5, 1, 2, 5, 3, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), false);
            }

            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 1, 4, 0, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 2, 4, 0, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 1, 4, 4, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 2, 4, 4, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 0, 4, 1, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 0, 4, 2, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 0, 4, 3, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 3, 4, 1, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 3, 4, 2, p_74875_3_);
            this.func_175811_a(worldIn, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), 3, 4, 3, p_74875_3_);
            this.func_175804_a(worldIn, p_74875_3_, 0, 1, 0, 0, 3, 0, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), false);
            this.func_175804_a(worldIn, p_74875_3_, 3, 1, 0, 3, 3, 0, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 1, 4, 0, 3, 4, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), false);
            this.func_175804_a(worldIn, p_74875_3_, 3, 1, 4, 3, 3, 4, log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), log.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.Y)), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 1, 1, 0, 3, 3, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 3, 1, 1, 3, 3, 3, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 1, 0, 2, 3, 0, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 1, 4, 2, 3, 4, wood.getDefaultState(), wood.getDefaultState(), false);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 0, 2, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 3, 2, 2, p_74875_3_);

            if (this.tablePosition > 0)
            {
                this.func_175811_a(worldIn, fence.getDefaultState(), this.tablePosition, 1, 3, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.wooden_pressure_plate.getDefaultState(), this.tablePosition, 2, 3, p_74875_3_);
            }

            this.func_175811_a(worldIn, Blocks.air.getDefaultState(), 1, 1, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.air.getDefaultState(), 1, 2, 0, p_74875_3_);
            this.func_175810_a(worldIn, p_74875_3_, p_74875_2_, 1, 1, 0, EnumFacing.getHorizontal(this.getMetadataWithOffset(Blocks.oak_door, 1)));

            if (this.func_175807_a(worldIn, 1, 0, -1, p_74875_3_).getBlock().getMaterial() == Material.air && this.func_175807_a(worldIn, 1, -1, -1, p_74875_3_).getBlock().getMaterial() != Material.air)
            {
                this.func_175811_a(worldIn, stoneStairs.getStateFromMeta(this.getMetadataWithOffset(stoneStairs, 3)), 1, 0, -1, p_74875_3_);
            }

            for (int i = 0; i < 5; ++i)
            {
                for (int j = 0; j < 4; ++j)
                {
                    this.clearCurrentPositionBlocksUpwards(worldIn, j, 6, i, p_74875_3_);
                    this.func_175808_b(worldIn, stone.getDefaultState(), j, -1, i, p_74875_3_);
                }
            }

            this.spawnVillagers(worldIn, p_74875_3_, 1, 1, 2, 1);
            return true;
        }
    }
}