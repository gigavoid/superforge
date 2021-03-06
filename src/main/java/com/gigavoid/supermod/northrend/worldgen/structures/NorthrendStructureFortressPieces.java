package com.gigavoid.supermod.northrend.worldgen.structures;

import com.gigavoid.supermod.northrend.block.*;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class NorthrendStructureFortressPieces
{
    public static Block mainBlock = BlockNorthCobblestone.instance;
    public static Block fenceBlock = BlockNorthFence.instance;
    public static Block stairsBlock = BlockNorthStoneStairs.instance;
    public static Block dirtBlock = BlockNorthDirt.instance;
    public static Block plantBlock = BlockNorthGlaciemPlant.instance;
    
    private static final NorthrendStructureFortressPieces.PieceWeight[] primaryComponents = new NorthrendStructureFortressPieces.PieceWeight[] {new NorthrendStructureFortressPieces.PieceWeight(NorthrendStructureFortressPieces.Straight.class, 30, 0, true), new NorthrendStructureFortressPieces.PieceWeight(NorthrendStructureFortressPieces.Crossing3.class, 10, 4), new NorthrendStructureFortressPieces.PieceWeight(NorthrendStructureFortressPieces.Crossing.class, 10, 4), new NorthrendStructureFortressPieces.PieceWeight(NorthrendStructureFortressPieces.Stairs.class, 10, 3), new NorthrendStructureFortressPieces.PieceWeight(NorthrendStructureFortressPieces.Throne.class, 5, 2), new NorthrendStructureFortressPieces.PieceWeight(NorthrendStructureFortressPieces.Entrance.class, 5, 1)};
    private static final NorthrendStructureFortressPieces.PieceWeight[] secondaryComponents = new NorthrendStructureFortressPieces.PieceWeight[] {new NorthrendStructureFortressPieces.PieceWeight(NorthrendStructureFortressPieces.Corridor5.class, 25, 0, true), new NorthrendStructureFortressPieces.PieceWeight(NorthrendStructureFortressPieces.Crossing2.class, 15, 5), new NorthrendStructureFortressPieces.PieceWeight(NorthrendStructureFortressPieces.Corridor2.class, 5, 10), new NorthrendStructureFortressPieces.PieceWeight(NorthrendStructureFortressPieces.Corridor.class, 5, 10), new NorthrendStructureFortressPieces.PieceWeight(NorthrendStructureFortressPieces.Corridor3.class, 10, 3, true), new NorthrendStructureFortressPieces.PieceWeight(NorthrendStructureFortressPieces.Corridor4.class, 7, 2), new NorthrendStructureFortressPieces.PieceWeight(NorthrendStructureFortressPieces.NetherStalkRoom.class, 5, 2)};
    private static final String __OBFID = "CL_00000453";

    public static void registerNetherFortressPieces()
    {
        MapGenStructureIO.registerStructureComponent(NorthrendStructureFortressPieces.Crossing3.class, "NBCr");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureFortressPieces.End.class, "NBEF");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureFortressPieces.Straight.class, "NBS");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureFortressPieces.Corridor3.class, "NCCS");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureFortressPieces.Corridor4.class, "NCTB");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureFortressPieces.Entrance.class, "NCE");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureFortressPieces.Crossing2.class, "NSCSC");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureFortressPieces.Corridor.class, "NSCLT");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureFortressPieces.Corridor5.class, "NSC");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureFortressPieces.Corridor2.class, "NSCRT");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureFortressPieces.NetherStalkRoom.class, "NCSR");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureFortressPieces.Throne.class, "NMT");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureFortressPieces.Crossing.class, "NRC");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureFortressPieces.Stairs.class, "NSR");
        MapGenStructureIO.registerStructureComponent(NorthrendStructureFortressPieces.Start.class, "NStart");
    }

    private static NorthrendStructureFortressPieces.Piece func_175887_b(NorthrendStructureFortressPieces.PieceWeight p_175887_0_, List p_175887_1_, Random p_175887_2_, int p_175887_3_, int p_175887_4_, int p_175887_5_, EnumFacing p_175887_6_, int p_175887_7_)
    {
        Class oclass = p_175887_0_.weightClass;
        Object object = null;

        if (oclass == NorthrendStructureFortressPieces.Straight.class)
        {
            object = NorthrendStructureFortressPieces.Straight.func_175882_a(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }
        else if (oclass == NorthrendStructureFortressPieces.Crossing3.class)
        {
            object = NorthrendStructureFortressPieces.Crossing3.func_175885_a(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }
        else if (oclass == NorthrendStructureFortressPieces.Crossing.class)
        {
            object = NorthrendStructureFortressPieces.Crossing.func_175873_a(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }
        else if (oclass == NorthrendStructureFortressPieces.Stairs.class)
        {
            object = NorthrendStructureFortressPieces.Stairs.func_175872_a(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_7_, p_175887_6_);
        }
        else if (oclass == NorthrendStructureFortressPieces.Throne.class)
        {
            object = NorthrendStructureFortressPieces.Throne.func_175874_a(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_7_, p_175887_6_);
        }
        else if (oclass == NorthrendStructureFortressPieces.Entrance.class)
        {
            object = NorthrendStructureFortressPieces.Entrance.func_175881_a(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }
        else if (oclass == NorthrendStructureFortressPieces.Corridor5.class)
        {
            object = NorthrendStructureFortressPieces.Corridor5.func_175877_a(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }
        else if (oclass == NorthrendStructureFortressPieces.Corridor2.class)
        {
            object = NorthrendStructureFortressPieces.Corridor2.func_175876_a(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }
        else if (oclass == NorthrendStructureFortressPieces.Corridor.class)
        {
            object = NorthrendStructureFortressPieces.Corridor.func_175879_a(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }
        else if (oclass == NorthrendStructureFortressPieces.Corridor3.class)
        {
            object = NorthrendStructureFortressPieces.Corridor3.func_175883_a(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }
        else if (oclass == NorthrendStructureFortressPieces.Corridor4.class)
        {
            object = NorthrendStructureFortressPieces.Corridor4.func_175880_a(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }
        else if (oclass == NorthrendStructureFortressPieces.Crossing2.class)
        {
            object = NorthrendStructureFortressPieces.Crossing2.func_175878_a(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }
        else if (oclass == NorthrendStructureFortressPieces.NetherStalkRoom.class)
        {
            object = NorthrendStructureFortressPieces.NetherStalkRoom.func_175875_a(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }

        return (NorthrendStructureFortressPieces.Piece)object;
    }

    public static class Corridor extends NorthrendStructureFortressPieces.Piece
    {
        private boolean field_111021_b;
        private static final String __OBFID = "CL_00000461";

        public Corridor() {}

        public Corridor(int p_i45615_1_, Random p_i45615_2_, StructureBoundingBox p_i45615_3_, EnumFacing p_i45615_4_)
        {
            super(p_i45615_1_);
            this.coordBaseMode = p_i45615_4_;
            this.boundingBox = p_i45615_3_;
            this.field_111021_b = p_i45615_2_.nextInt(3) == 0;
        }

        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        protected void readStructureFromNBT(NBTTagCompound p_143011_1_)
        {
            super.readStructureFromNBT(p_143011_1_);
            this.field_111021_b = p_143011_1_.getBoolean("Chest");
        }

        /**
         * (abstract) Helper method to write subclass data to NBT
         */
        protected void writeStructureToNBT(NBTTagCompound p_143012_1_)
        {
            super.writeStructureToNBT(p_143012_1_);
            p_143012_1_.setBoolean("Chest", this.field_111021_b);
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(NorthrendStructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentX((NorthrendStructureFortressPieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, 1, true);
        }

        public static NorthrendStructureFortressPieces.Corridor func_175879_a(List p_175879_0_, Random p_175879_1_, int p_175879_2_, int p_175879_3_, int p_175879_4_, EnumFacing p_175879_5_, int p_175879_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175879_2_, p_175879_3_, p_175879_4_, -1, 0, 0, 5, 7, 5, p_175879_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175879_0_, structureboundingbox) == null ? new NorthrendStructureFortressPieces.Corridor(p_175879_6_, p_175879_1_, structureboundingbox, p_175879_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 0, 4, 1, 4, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 0, 4, 5, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 2, 0, 4, 5, 4, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 3, 1, 4, 4, 1, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 3, 3, 4, 4, 3, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 0, 0, 5, 0, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 4, 3, 5, 4, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 3, 4, 1, 4, 4, fenceBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 3, 3, 4, 3, 4, 4, fenceBlock.getDefaultState(), mainBlock.getDefaultState(), false);

            if (this.field_111021_b && p_74875_3_.func_175898_b(new BlockPos(this.getXWithOffset(3, 3), this.getYWithOffset(2), this.getZWithOffset(3, 3))))
            {
                this.field_111021_b = false;
                this.func_180778_a(worldIn, p_74875_3_, p_74875_2_, 3, 2, 3, field_111019_a, 2 + p_74875_2_.nextInt(4));
            }

            this.func_175804_a(worldIn, p_74875_3_, 0, 6, 0, 4, 6, 4, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);

            for (int i = 0; i <= 4; ++i)
            {
                for (int j = 0; j <= 4; ++j)
                {
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), i, -1, j, p_74875_3_);
                }
            }

            return true;
        }
    }

    public static class Corridor2 extends NorthrendStructureFortressPieces.Piece
    {
        private boolean field_111020_b;
        private static final String __OBFID = "CL_00000463";

        public Corridor2() {}

        public Corridor2(int p_i45613_1_, Random p_i45613_2_, StructureBoundingBox p_i45613_3_, EnumFacing p_i45613_4_)
        {
            super(p_i45613_1_);
            this.coordBaseMode = p_i45613_4_;
            this.boundingBox = p_i45613_3_;
            this.field_111020_b = p_i45613_2_.nextInt(3) == 0;
        }

        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        protected void readStructureFromNBT(NBTTagCompound p_143011_1_)
        {
            super.readStructureFromNBT(p_143011_1_);
            this.field_111020_b = p_143011_1_.getBoolean("Chest");
        }

        /**
         * (abstract) Helper method to write subclass data to NBT
         */
        protected void writeStructureToNBT(NBTTagCompound p_143012_1_)
        {
            super.writeStructureToNBT(p_143012_1_);
            p_143012_1_.setBoolean("Chest", this.field_111020_b);
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(NorthrendStructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentZ((NorthrendStructureFortressPieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, 1, true);
        }

        public static NorthrendStructureFortressPieces.Corridor2 func_175876_a(List p_175876_0_, Random p_175876_1_, int p_175876_2_, int p_175876_3_, int p_175876_4_, EnumFacing p_175876_5_, int p_175876_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175876_2_, p_175876_3_, p_175876_4_, -1, 0, 0, 5, 7, 5, p_175876_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175876_0_, structureboundingbox) == null ? new NorthrendStructureFortressPieces.Corridor2(p_175876_6_, p_175876_1_, structureboundingbox, p_175876_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 0, 4, 1, 4, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 0, 4, 5, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 0, 0, 5, 4, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 3, 1, 0, 4, 1, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 3, 3, 0, 4, 3, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 2, 0, 4, 5, 0, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 2, 4, 4, 5, 4, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 3, 4, 1, 4, 4, fenceBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 3, 3, 4, 3, 4, 4, fenceBlock.getDefaultState(), mainBlock.getDefaultState(), false);

            if (this.field_111020_b && p_74875_3_.func_175898_b(new BlockPos(this.getXWithOffset(1, 3), this.getYWithOffset(2), this.getZWithOffset(1, 3))))
            {
                this.field_111020_b = false;
                this.func_180778_a(worldIn, p_74875_3_, p_74875_2_, 1, 2, 3, field_111019_a, 2 + p_74875_2_.nextInt(4));
            }

            this.func_175804_a(worldIn, p_74875_3_, 0, 6, 0, 4, 6, 4, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);

            for (int i = 0; i <= 4; ++i)
            {
                for (int j = 0; j <= 4; ++j)
                {
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), i, -1, j, p_74875_3_);
                }
            }

            return true;
        }
    }

    public static class Corridor3 extends NorthrendStructureFortressPieces.Piece
    {
        private static final String __OBFID = "CL_00000457";

        public Corridor3() {}

        public Corridor3(int p_i45619_1_, Random p_i45619_2_, StructureBoundingBox p_i45619_3_, EnumFacing p_i45619_4_)
        {
            super(p_i45619_1_);
            this.coordBaseMode = p_i45619_4_;
            this.boundingBox = p_i45619_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(NorthrendStructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((NorthrendStructureFortressPieces.Start) p_74861_1_, p_74861_2_, p_74861_3_, 1, 0, true);
        }

        public static NorthrendStructureFortressPieces.Corridor3 func_175883_a(List p_175883_0_, Random p_175883_1_, int p_175883_2_, int p_175883_3_, int p_175883_4_, EnumFacing p_175883_5_, int p_175883_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175883_2_, p_175883_3_, p_175883_4_, -1, -7, 0, 5, 14, 10, p_175883_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175883_0_, structureboundingbox) == null ? new NorthrendStructureFortressPieces.Corridor3(p_175883_6_, p_175883_1_, structureboundingbox, p_175883_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            int i = this.getMetadataWithOffset(stairsBlock, 2);

            for (int j = 0; j <= 9; ++j)
            {
                int k = Math.max(1, 7 - j);
                int l = Math.min(Math.max(k + 5, 14 - j), 13);
                int i1 = j;
                this.func_175804_a(worldIn, p_74875_3_, 0, 0, j, 4, k, j, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
                this.func_175804_a(worldIn, p_74875_3_, 1, k + 1, j, 3, l - 1, j, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);

                if (j <= 6)
                {
                    this.func_175811_a(worldIn, stairsBlock.getStateFromMeta(i), 1, k + 1, j, p_74875_3_);
                    this.func_175811_a(worldIn, stairsBlock.getStateFromMeta(i), 2, k + 1, j, p_74875_3_);
                    this.func_175811_a(worldIn, stairsBlock.getStateFromMeta(i), 3, k + 1, j, p_74875_3_);
                }

                this.func_175804_a(worldIn, p_74875_3_, 0, l, j, 4, l, j, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
                this.func_175804_a(worldIn, p_74875_3_, 0, k + 1, j, 0, l - 1, j, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
                this.func_175804_a(worldIn, p_74875_3_, 4, k + 1, j, 4, l - 1, j, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);

                if ((j & 1) == 0)
                {
                    this.func_175804_a(worldIn, p_74875_3_, 0, k + 2, j, 0, k + 3, j, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
                    this.func_175804_a(worldIn, p_74875_3_, 4, k + 2, j, 4, k + 3, j, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
                }

                for (int j1 = 0; j1 <= 4; ++j1)
                {
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), j1, -1, i1, p_74875_3_);
                }
            }

            return true;
        }
    }

    public static class Corridor4 extends NorthrendStructureFortressPieces.Piece
    {
        private static final String __OBFID = "CL_00000458";

        public Corridor4() {}

        public Corridor4(int p_i45618_1_, Random p_i45618_2_, StructureBoundingBox p_i45618_3_, EnumFacing p_i45618_4_)
        {
            super(p_i45618_1_);
            this.coordBaseMode = p_i45618_4_;
            this.boundingBox = p_i45618_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(NorthrendStructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            byte b0 = 1;

            if (this.coordBaseMode == EnumFacing.WEST || this.coordBaseMode == EnumFacing.NORTH)
            {
                b0 = 5;
            }

            this.getNextComponentX((NorthrendStructureFortressPieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, b0, p_74861_3_.nextInt(8) > 0);
            this.getNextComponentZ((NorthrendStructureFortressPieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, b0, p_74861_3_.nextInt(8) > 0);
        }

        public static NorthrendStructureFortressPieces.Corridor4 func_175880_a(List p_175880_0_, Random p_175880_1_, int p_175880_2_, int p_175880_3_, int p_175880_4_, EnumFacing p_175880_5_, int p_175880_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175880_2_, p_175880_3_, p_175880_4_, -3, 0, 0, 9, 7, 9, p_175880_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175880_0_, structureboundingbox) == null ? new NorthrendStructureFortressPieces.Corridor4(p_175880_6_, p_175880_1_, structureboundingbox, p_175880_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 0, 8, 1, 8, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 0, 8, 5, 8, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 6, 0, 8, 6, 5, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 0, 2, 5, 0, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 6, 2, 0, 8, 5, 0, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 3, 0, 1, 4, 0, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 7, 3, 0, 7, 4, 0, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 4, 8, 2, 8, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 1, 4, 2, 2, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 6, 1, 4, 7, 2, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 3, 8, 8, 3, 8, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 3, 6, 0, 3, 7, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 8, 3, 6, 8, 3, 7, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 3, 4, 0, 5, 5, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 8, 3, 4, 8, 5, 5, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 3, 5, 2, 5, 5, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 6, 3, 5, 7, 5, 5, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 4, 5, 1, 5, 5, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 7, 4, 5, 7, 5, 5, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);

            for (int i = 0; i <= 5; ++i)
            {
                for (int j = 0; j <= 8; ++j)
                {
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), j, -1, i, p_74875_3_);
                }
            }

            return true;
        }
    }

    public static class Corridor5 extends NorthrendStructureFortressPieces.Piece
    {
        private static final String __OBFID = "CL_00000462";

        public Corridor5() {}

        public Corridor5(int p_i45614_1_, Random p_i45614_2_, StructureBoundingBox p_i45614_3_, EnumFacing p_i45614_4_)
        {
            super(p_i45614_1_);
            this.coordBaseMode = p_i45614_4_;
            this.boundingBox = p_i45614_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(NorthrendStructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((NorthrendStructureFortressPieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 1, 0, true);
        }

        public static NorthrendStructureFortressPieces.Corridor5 func_175877_a(List p_175877_0_, Random p_175877_1_, int p_175877_2_, int p_175877_3_, int p_175877_4_, EnumFacing p_175877_5_, int p_175877_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175877_2_, p_175877_3_, p_175877_4_, -1, 0, 0, 5, 7, 5, p_175877_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175877_0_, structureboundingbox) == null ? new NorthrendStructureFortressPieces.Corridor5(p_175877_6_, p_175877_1_, structureboundingbox, p_175877_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 0, 4, 1, 4, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 0, 4, 5, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 0, 0, 5, 4, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 2, 0, 4, 5, 4, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 3, 1, 0, 4, 1, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 3, 3, 0, 4, 3, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 3, 1, 4, 4, 1, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 3, 3, 4, 4, 3, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 6, 0, 4, 6, 4, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);

            for (int i = 0; i <= 4; ++i)
            {
                for (int j = 0; j <= 4; ++j)
                {
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), i, -1, j, p_74875_3_);
                }
            }

            return true;
        }
    }

    public static class Crossing extends NorthrendStructureFortressPieces.Piece
    {
        private static final String __OBFID = "CL_00000468";

        public Crossing() {}

        public Crossing(int p_i45610_1_, Random p_i45610_2_, StructureBoundingBox p_i45610_3_, EnumFacing p_i45610_4_)
        {
            super(p_i45610_1_);
            this.coordBaseMode = p_i45610_4_;
            this.boundingBox = p_i45610_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(NorthrendStructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((NorthrendStructureFortressPieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 2, 0, false);
            this.getNextComponentX((NorthrendStructureFortressPieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, 2, false);
            this.getNextComponentZ((NorthrendStructureFortressPieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, 2, false);
        }

        public static NorthrendStructureFortressPieces.Crossing func_175873_a(List p_175873_0_, Random p_175873_1_, int p_175873_2_, int p_175873_3_, int p_175873_4_, EnumFacing p_175873_5_, int p_175873_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175873_2_, p_175873_3_, p_175873_4_, -2, 0, 0, 7, 9, 7, p_175873_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175873_0_, structureboundingbox) == null ? new NorthrendStructureFortressPieces.Crossing(p_175873_6_, p_175873_1_, structureboundingbox, p_175873_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 0, 6, 1, 6, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 0, 6, 7, 6, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 0, 1, 6, 0, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 6, 1, 6, 6, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 5, 2, 0, 6, 6, 0, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 5, 2, 6, 6, 6, 6, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 0, 0, 6, 1, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 5, 0, 6, 6, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 6, 2, 0, 6, 6, 1, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 6, 2, 5, 6, 6, 6, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 6, 0, 4, 6, 0, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 5, 0, 4, 5, 0, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 6, 6, 4, 6, 6, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 5, 6, 4, 5, 6, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 6, 2, 0, 6, 4, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 5, 2, 0, 5, 4, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 6, 6, 2, 6, 6, 4, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 6, 5, 2, 6, 5, 4, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);

            for (int i = 0; i <= 6; ++i)
            {
                for (int j = 0; j <= 6; ++j)
                {
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), i, -1, j, p_74875_3_);
                }
            }

            return true;
        }
    }

    public static class Crossing2 extends NorthrendStructureFortressPieces.Piece
    {
        private static final String __OBFID = "CL_00000460";

        public Crossing2() {}

        public Crossing2(int p_i45616_1_, Random p_i45616_2_, StructureBoundingBox p_i45616_3_, EnumFacing p_i45616_4_)
        {
            super(p_i45616_1_);
            this.coordBaseMode = p_i45616_4_;
            this.boundingBox = p_i45616_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(NorthrendStructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((NorthrendStructureFortressPieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 1, 0, true);
            this.getNextComponentX((NorthrendStructureFortressPieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, 1, true);
            this.getNextComponentZ((NorthrendStructureFortressPieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, 1, true);
        }

        public static NorthrendStructureFortressPieces.Crossing2 func_175878_a(List p_175878_0_, Random p_175878_1_, int p_175878_2_, int p_175878_3_, int p_175878_4_, EnumFacing p_175878_5_, int p_175878_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175878_2_, p_175878_3_, p_175878_4_, -1, 0, 0, 5, 7, 5, p_175878_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175878_0_, structureboundingbox) == null ? new NorthrendStructureFortressPieces.Crossing2(p_175878_6_, p_175878_1_, structureboundingbox, p_175878_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 0, 4, 1, 4, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 0, 4, 5, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 0, 0, 5, 0, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 2, 0, 4, 5, 0, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 4, 0, 5, 4, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 2, 4, 4, 5, 4, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 6, 0, 4, 6, 4, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);

            for (int i = 0; i <= 4; ++i)
            {
                for (int j = 0; j <= 4; ++j)
                {
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), i, -1, j, p_74875_3_);
                }
            }

            return true;
        }
    }

    public static class Crossing3 extends NorthrendStructureFortressPieces.Piece
    {
        private static final String __OBFID = "CL_00000454";

        public Crossing3() {}

        public Crossing3(int p_i45622_1_, Random p_i45622_2_, StructureBoundingBox p_i45622_3_, EnumFacing p_i45622_4_)
        {
            super(p_i45622_1_);
            this.coordBaseMode = p_i45622_4_;
            this.boundingBox = p_i45622_3_;
        }

        protected Crossing3(Random p_i2042_1_, int p_i2042_2_, int p_i2042_3_)
        {
            super(0);
            this.coordBaseMode = EnumFacing.Plane.HORIZONTAL.random(p_i2042_1_);

            switch (NorthrendStructureFortressPieces.SwitchEnumFacing.field_175888_a[this.coordBaseMode.ordinal()])
            {
                case 1:
                case 2:
                    this.boundingBox = new StructureBoundingBox(p_i2042_2_, 64, p_i2042_3_, p_i2042_2_ + 19 - 1, 73, p_i2042_3_ + 19 - 1);
                    break;
                default:
                    this.boundingBox = new StructureBoundingBox(p_i2042_2_, 64, p_i2042_3_, p_i2042_2_ + 19 - 1, 73, p_i2042_3_ + 19 - 1);
            }
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(NorthrendStructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((NorthrendStructureFortressPieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 8, 3, false);
            this.getNextComponentX((NorthrendStructureFortressPieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 3, 8, false);
            this.getNextComponentZ((NorthrendStructureFortressPieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 3, 8, false);
        }

        public static NorthrendStructureFortressPieces.Crossing3 func_175885_a(List p_175885_0_, Random p_175885_1_, int p_175885_2_, int p_175885_3_, int p_175885_4_, EnumFacing p_175885_5_, int p_175885_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175885_2_, p_175885_3_, p_175885_4_, -8, -3, 0, 19, 10, 19, p_175885_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175885_0_, structureboundingbox) == null ? new NorthrendStructureFortressPieces.Crossing3(p_175885_6_, p_175885_1_, structureboundingbox, p_175885_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.func_175804_a(worldIn, p_74875_3_, 7, 3, 0, 11, 4, 18, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 3, 7, 18, 4, 11, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 8, 5, 0, 10, 7, 18, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 5, 8, 18, 7, 10, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 7, 5, 0, 7, 5, 7, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 7, 5, 11, 7, 5, 18, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 11, 5, 0, 11, 5, 7, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 11, 5, 11, 11, 5, 18, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 5, 7, 7, 5, 7, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 11, 5, 7, 18, 5, 7, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 5, 11, 7, 5, 11, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 11, 5, 11, 18, 5, 11, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 7, 2, 0, 11, 2, 5, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 7, 2, 13, 11, 2, 18, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 7, 0, 0, 11, 1, 3, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 7, 0, 15, 11, 1, 18, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            int i;
            int j;

            for (i = 7; i <= 11; ++i)
            {
                for (j = 0; j <= 2; ++j)
                {
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), i, -1, j, p_74875_3_);
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), i, -1, 18 - j, p_74875_3_);
                }
            }

            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 7, 5, 2, 11, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 13, 2, 7, 18, 2, 11, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 7, 3, 1, 11, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 15, 0, 7, 18, 1, 11, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);

            for (i = 0; i <= 2; ++i)
            {
                for (j = 7; j <= 11; ++j)
                {
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), i, -1, j, p_74875_3_);
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), 18 - i, -1, j, p_74875_3_);
                }
            }

            return true;
        }
    }

    public static class End extends NorthrendStructureFortressPieces.Piece
    {
        private int fillSeed;
        private static final String __OBFID = "CL_00000455";

        public End() {}

        public End(int p_i45621_1_, Random p_i45621_2_, StructureBoundingBox p_i45621_3_, EnumFacing p_i45621_4_)
        {
            super(p_i45621_1_);
            this.coordBaseMode = p_i45621_4_;
            this.boundingBox = p_i45621_3_;
            this.fillSeed = p_i45621_2_.nextInt();
        }

        public static NorthrendStructureFortressPieces.End func_175884_a(List p_175884_0_, Random p_175884_1_, int p_175884_2_, int p_175884_3_, int p_175884_4_, EnumFacing p_175884_5_, int p_175884_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175884_2_, p_175884_3_, p_175884_4_, -1, -3, 0, 5, 10, 8, p_175884_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175884_0_, structureboundingbox) == null ? new NorthrendStructureFortressPieces.End(p_175884_6_, p_175884_1_, structureboundingbox, p_175884_5_) : null;
        }

        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        protected void readStructureFromNBT(NBTTagCompound p_143011_1_)
        {
            super.readStructureFromNBT(p_143011_1_);
            this.fillSeed = p_143011_1_.getInteger("Seed");
        }

        /**
         * (abstract) Helper method to write subclass data to NBT
         */
        protected void writeStructureToNBT(NBTTagCompound p_143012_1_)
        {
            super.writeStructureToNBT(p_143012_1_);
            p_143012_1_.setInteger("Seed", this.fillSeed);
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            Random random1 = new Random((long)this.fillSeed);
            int i;
            int j;
            int k;

            for (i = 0; i <= 4; ++i)
            {
                for (j = 3; j <= 4; ++j)
                {
                    k = random1.nextInt(8);
                    this.func_175804_a(worldIn, p_74875_3_, i, j, 0, i, j, k, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
                }
            }

            i = random1.nextInt(8);
            this.func_175804_a(worldIn, p_74875_3_, 0, 5, 0, 0, 5, i, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            i = random1.nextInt(8);
            this.func_175804_a(worldIn, p_74875_3_, 4, 5, 0, 4, 5, i, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);

            for (i = 0; i <= 4; ++i)
            {
                j = random1.nextInt(5);
                this.func_175804_a(worldIn, p_74875_3_, i, 2, 0, i, 2, j, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            }

            for (i = 0; i <= 4; ++i)
            {
                for (j = 0; j <= 1; ++j)
                {
                    k = random1.nextInt(3);
                    this.func_175804_a(worldIn, p_74875_3_, i, j, 0, i, j, k, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
                }
            }

            return true;
        }
    }

    public static class Entrance extends NorthrendStructureFortressPieces.Piece
    {
        private static final String __OBFID = "CL_00000459";

        public Entrance() {}

        public Entrance(int p_i45617_1_, Random p_i45617_2_, StructureBoundingBox p_i45617_3_, EnumFacing p_i45617_4_)
        {
            super(p_i45617_1_);
            this.coordBaseMode = p_i45617_4_;
            this.boundingBox = p_i45617_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(NorthrendStructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((NorthrendStructureFortressPieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 5, 3, true);
        }

        public static NorthrendStructureFortressPieces.Entrance func_175881_a(List p_175881_0_, Random p_175881_1_, int p_175881_2_, int p_175881_3_, int p_175881_4_, EnumFacing p_175881_5_, int p_175881_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175881_2_, p_175881_3_, p_175881_4_, -5, -3, 0, 13, 14, 13, p_175881_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175881_0_, structureboundingbox) == null ? new NorthrendStructureFortressPieces.Entrance(p_175881_6_, p_175881_1_, structureboundingbox, p_175881_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.func_175804_a(worldIn, p_74875_3_, 0, 3, 0, 12, 4, 12, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 5, 0, 12, 13, 12, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 5, 0, 1, 12, 12, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 11, 5, 0, 12, 12, 12, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 5, 11, 4, 12, 12, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 8, 5, 11, 10, 12, 12, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 5, 9, 11, 7, 12, 12, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 5, 0, 4, 12, 1, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 8, 5, 0, 10, 12, 1, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 5, 9, 0, 7, 12, 1, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 11, 2, 10, 12, 10, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 5, 8, 0, 7, 8, 0, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            int i;

            for (i = 1; i <= 11; i += 2)
            {
                this.func_175804_a(worldIn, p_74875_3_, i, 10, 0, i, 11, 0, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
                this.func_175804_a(worldIn, p_74875_3_, i, 10, 12, i, 11, 12, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
                this.func_175804_a(worldIn, p_74875_3_, 0, 10, i, 0, 11, i, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
                this.func_175804_a(worldIn, p_74875_3_, 12, 10, i, 12, 11, i, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
                this.func_175811_a(worldIn, mainBlock.getDefaultState(), i, 13, 0, p_74875_3_);
                this.func_175811_a(worldIn, mainBlock.getDefaultState(), i, 13, 12, p_74875_3_);
                this.func_175811_a(worldIn, mainBlock.getDefaultState(), 0, 13, i, p_74875_3_);
                this.func_175811_a(worldIn, mainBlock.getDefaultState(), 12, 13, i, p_74875_3_);
                this.func_175811_a(worldIn, fenceBlock.getDefaultState(), i + 1, 13, 0, p_74875_3_);
                this.func_175811_a(worldIn, fenceBlock.getDefaultState(), i + 1, 13, 12, p_74875_3_);
                this.func_175811_a(worldIn, fenceBlock.getDefaultState(), 0, 13, i + 1, p_74875_3_);
                this.func_175811_a(worldIn, fenceBlock.getDefaultState(), 12, 13, i + 1, p_74875_3_);
            }

            this.func_175811_a(worldIn, fenceBlock.getDefaultState(), 0, 13, 0, p_74875_3_);
            this.func_175811_a(worldIn, fenceBlock.getDefaultState(), 0, 13, 12, p_74875_3_);
            this.func_175811_a(worldIn, fenceBlock.getDefaultState(), 0, 13, 0, p_74875_3_);
            this.func_175811_a(worldIn, fenceBlock.getDefaultState(), 12, 13, 0, p_74875_3_);

            for (i = 3; i <= 9; i += 2)
            {
                this.func_175804_a(worldIn, p_74875_3_, 1, 7, i, 1, 8, i, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
                this.func_175804_a(worldIn, p_74875_3_, 11, 7, i, 11, 8, i, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            }

            this.func_175804_a(worldIn, p_74875_3_, 4, 2, 0, 8, 2, 12, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 4, 12, 2, 8, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 0, 0, 8, 1, 3, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 0, 9, 8, 1, 12, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 4, 3, 1, 8, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 9, 0, 4, 12, 1, 8, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            int j;

            for (i = 4; i <= 8; ++i)
            {
                for (j = 0; j <= 2; ++j)
                {
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), i, -1, j, p_74875_3_);
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), i, -1, 12 - j, p_74875_3_);
                }
            }

            for (i = 0; i <= 2; ++i)
            {
                for (j = 4; j <= 8; ++j)
                {
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), i, -1, j, p_74875_3_);
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), 12 - i, -1, j, p_74875_3_);
                }
            }

            this.func_175804_a(worldIn, p_74875_3_, 5, 5, 5, 7, 5, 7, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 6, 1, 6, 6, 4, 6, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175811_a(worldIn, mainBlock.getDefaultState(), 6, 0, 6, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.obsidian.getDefaultState(), 6, 5, 6, p_74875_3_);
            BlockPos blockpos = new BlockPos(this.getXWithOffset(6, 6), this.getYWithOffset(5), this.getZWithOffset(6, 6));

            if (p_74875_3_.func_175898_b(blockpos))
            {
                worldIn.forceBlockUpdateTick(Blocks.obsidian, blockpos, p_74875_2_);
            }

            return true;
        }
    }

    public static class NetherStalkRoom extends NorthrendStructureFortressPieces.Piece
    {
        private static final String __OBFID = "CL_00000464";

        public NetherStalkRoom() {}

        public NetherStalkRoom(int p_i45612_1_, Random p_i45612_2_, StructureBoundingBox p_i45612_3_, EnumFacing p_i45612_4_)
        {
            super(p_i45612_1_);
            this.coordBaseMode = p_i45612_4_;
            this.boundingBox = p_i45612_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(NorthrendStructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((NorthrendStructureFortressPieces.Start) p_74861_1_, p_74861_2_, p_74861_3_, 5, 3, true);
            this.getNextComponentNormal((NorthrendStructureFortressPieces.Start) p_74861_1_, p_74861_2_, p_74861_3_, 5, 11, true);
        }

        public static NorthrendStructureFortressPieces.NetherStalkRoom func_175875_a(List p_175875_0_, Random p_175875_1_, int p_175875_2_, int p_175875_3_, int p_175875_4_, EnumFacing p_175875_5_, int p_175875_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175875_2_, p_175875_3_, p_175875_4_, -5, -3, 0, 13, 14, 13, p_175875_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175875_0_, structureboundingbox) == null ? new NorthrendStructureFortressPieces.NetherStalkRoom(p_175875_6_, p_175875_1_, structureboundingbox, p_175875_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.func_175804_a(worldIn, p_74875_3_, 0, 3, 0, 12, 4, 12, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 5, 0, 12, 13, 12, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 5, 0, 1, 12, 12, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 11, 5, 0, 12, 12, 12, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 5, 11, 4, 12, 12, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 8, 5, 11, 10, 12, 12, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 5, 9, 11, 7, 12, 12, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 5, 0, 4, 12, 1, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 8, 5, 0, 10, 12, 1, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 5, 9, 0, 7, 12, 1, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 11, 2, 10, 12, 10, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            int i;

            for (i = 1; i <= 11; i += 2)
            {
                this.func_175804_a(worldIn, p_74875_3_, i, 10, 0, i, 11, 0, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
                this.func_175804_a(worldIn, p_74875_3_, i, 10, 12, i, 11, 12, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
                this.func_175804_a(worldIn, p_74875_3_, 0, 10, i, 0, 11, i, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
                this.func_175804_a(worldIn, p_74875_3_, 12, 10, i, 12, 11, i, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
                this.func_175811_a(worldIn, mainBlock.getDefaultState(), i, 13, 0, p_74875_3_);
                this.func_175811_a(worldIn, mainBlock.getDefaultState(), i, 13, 12, p_74875_3_);
                this.func_175811_a(worldIn, mainBlock.getDefaultState(), 0, 13, i, p_74875_3_);
                this.func_175811_a(worldIn, mainBlock.getDefaultState(), 12, 13, i, p_74875_3_);
                this.func_175811_a(worldIn, fenceBlock.getDefaultState(), i + 1, 13, 0, p_74875_3_);
                this.func_175811_a(worldIn, fenceBlock.getDefaultState(), i + 1, 13, 12, p_74875_3_);
                this.func_175811_a(worldIn, fenceBlock.getDefaultState(), 0, 13, i + 1, p_74875_3_);
                this.func_175811_a(worldIn, fenceBlock.getDefaultState(), 12, 13, i + 1, p_74875_3_);
            }

            this.func_175811_a(worldIn, fenceBlock.getDefaultState(), 0, 13, 0, p_74875_3_);
            this.func_175811_a(worldIn, fenceBlock.getDefaultState(), 0, 13, 12, p_74875_3_);
            this.func_175811_a(worldIn, fenceBlock.getDefaultState(), 0, 13, 0, p_74875_3_);
            this.func_175811_a(worldIn, fenceBlock.getDefaultState(), 12, 13, 0, p_74875_3_);

            for (i = 3; i <= 9; i += 2)
            {
                this.func_175804_a(worldIn, p_74875_3_, 1, 7, i, 1, 8, i, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
                this.func_175804_a(worldIn, p_74875_3_, 11, 7, i, 11, 8, i, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            }

            i = this.getMetadataWithOffset(stairsBlock, 3);
            int j;
            int k;
            int l;

            for (j = 0; j <= 6; ++j)
            {
                k = j + 4;

                for (l = 5; l <= 7; ++l)
                {
                    this.func_175811_a(worldIn, stairsBlock.getStateFromMeta(i), l, 5 + j, k, p_74875_3_);
                }

                if (k >= 5 && k <= 8)
                {
                    this.func_175804_a(worldIn, p_74875_3_, 5, 5, k, 7, j + 4, k, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
                }
                else if (k >= 9 && k <= 10)
                {
                    this.func_175804_a(worldIn, p_74875_3_, 5, 8, k, 7, j + 4, k, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
                }

                if (j >= 1)
                {
                    this.func_175804_a(worldIn, p_74875_3_, 5, 6 + j, k, 7, 9 + j, k, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
                }
            }

            for (j = 5; j <= 7; ++j)
            {
                this.func_175811_a(worldIn, stairsBlock.getStateFromMeta(i), j, 12, 11, p_74875_3_);
            }

            this.func_175804_a(worldIn, p_74875_3_, 5, 6, 7, 5, 7, 7, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 7, 6, 7, 7, 7, 7, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 5, 13, 12, 7, 13, 12, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 5, 2, 3, 5, 3, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 5, 9, 3, 5, 10, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 5, 4, 2, 5, 8, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 9, 5, 2, 10, 5, 3, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 9, 5, 9, 10, 5, 10, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 10, 5, 4, 10, 5, 8, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            j = this.getMetadataWithOffset(stairsBlock, 0);
            k = this.getMetadataWithOffset(stairsBlock, 1);
            this.func_175811_a(worldIn, stairsBlock.getStateFromMeta(k), 4, 5, 2, p_74875_3_);
            this.func_175811_a(worldIn, stairsBlock.getStateFromMeta(k), 4, 5, 3, p_74875_3_);
            this.func_175811_a(worldIn, stairsBlock.getStateFromMeta(k), 4, 5, 9, p_74875_3_);
            this.func_175811_a(worldIn, stairsBlock.getStateFromMeta(k), 4, 5, 10, p_74875_3_);
            this.func_175811_a(worldIn, stairsBlock.getStateFromMeta(j), 8, 5, 2, p_74875_3_);
            this.func_175811_a(worldIn, stairsBlock.getStateFromMeta(j), 8, 5, 3, p_74875_3_);
            this.func_175811_a(worldIn, stairsBlock.getStateFromMeta(j), 8, 5, 9, p_74875_3_);
            this.func_175811_a(worldIn, stairsBlock.getStateFromMeta(j), 8, 5, 10, p_74875_3_);
            this.func_175804_a(worldIn, p_74875_3_, 3, 4, 4, 4, 4, 8, dirtBlock.getDefaultState(), dirtBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 8, 4, 4, 9, 4, 8, dirtBlock.getDefaultState(), dirtBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 3, 5, 4, 4, 5, 8, plantBlock.getDefaultState(), plantBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 8, 5, 4, 9, 5, 8, plantBlock.getDefaultState(), plantBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 2, 0, 8, 2, 12, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 4, 12, 2, 8, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 0, 0, 8, 1, 3, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 0, 9, 8, 1, 12, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 4, 3, 1, 8, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 9, 0, 4, 12, 1, 8, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            int i1;

            for (l = 4; l <= 8; ++l)
            {
                for (i1 = 0; i1 <= 2; ++i1)
                {
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), l, -1, i1, p_74875_3_);
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), l, -1, 12 - i1, p_74875_3_);
                }
            }

            for (l = 0; l <= 2; ++l)
            {
                for (i1 = 4; i1 <= 8; ++i1)
                {
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), l, -1, i1, p_74875_3_);
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), 12 - l, -1, i1, p_74875_3_);
                }
            }

            return true;
        }
    }

    abstract static class Piece extends NorthrendStructureComponent
    {
        protected static final List field_111019_a = Lists.newArrayList(new WeightedRandomChestContent[] {new WeightedRandomChestContent(Items.diamond, 0, 1, 3, 5), new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 5), new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 3, 15), new WeightedRandomChestContent(Items.golden_sword, 0, 1, 1, 5), new WeightedRandomChestContent(Items.golden_chestplate, 0, 1, 1, 5), new WeightedRandomChestContent(Items.flint_and_steel, 0, 1, 1, 5), new WeightedRandomChestContent(Items.nether_wart, 0, 3, 7, 5), new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 10), new WeightedRandomChestContent(Items.golden_horse_armor, 0, 1, 1, 8), new WeightedRandomChestContent(Items.iron_horse_armor, 0, 1, 1, 5), new WeightedRandomChestContent(Items.diamond_horse_armor, 0, 1, 1, 3), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.obsidian), 0, 2, 4, 2)});
        private static final String __OBFID = "CL_00000466";

        public Piece() {}

        protected Piece(int p_i2054_1_)
        {
            super(p_i2054_1_);
        }

        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        protected void readStructureFromNBT(NBTTagCompound p_143011_1_) {}

        /**
         * (abstract) Helper method to write subclass data to NBT
         */
        protected void writeStructureToNBT(NBTTagCompound p_143012_1_) {}

        private int getTotalWeight(List p_74960_1_)
        {
            boolean flag = false;
            int i = 0;
            NorthrendStructureFortressPieces.PieceWeight pieceweight;

            for (Iterator iterator = p_74960_1_.iterator(); iterator.hasNext(); i += pieceweight.field_78826_b)
            {
                pieceweight = (NorthrendStructureFortressPieces.PieceWeight)iterator.next();

                if (pieceweight.field_78824_d > 0 && pieceweight.field_78827_c < pieceweight.field_78824_d)
                {
                    flag = true;
                }
            }

            return flag ? i : -1;
        }

        private NorthrendStructureFortressPieces.Piece func_175871_a(NorthrendStructureFortressPieces.Start p_175871_1_, List p_175871_2_, List p_175871_3_, Random p_175871_4_, int p_175871_5_, int p_175871_6_, int p_175871_7_, EnumFacing p_175871_8_, int p_175871_9_)
        {
            int i1 = this.getTotalWeight(p_175871_2_);
            boolean flag = i1 > 0 && p_175871_9_ <= 30;
            int j1 = 0;

            while (j1 < 5 && flag)
            {
                ++j1;
                int k1 = p_175871_4_.nextInt(i1);
                Iterator iterator = p_175871_2_.iterator();

                while (iterator.hasNext())
                {
                    NorthrendStructureFortressPieces.PieceWeight pieceweight = (NorthrendStructureFortressPieces.PieceWeight)iterator.next();
                    k1 -= pieceweight.field_78826_b;

                    if (k1 < 0)
                    {
                        if (!pieceweight.func_78822_a(p_175871_9_) || pieceweight == p_175871_1_.theNetherBridgePieceWeight && !pieceweight.field_78825_e)
                        {
                            break;
                        }

                        NorthrendStructureFortressPieces.Piece piece = NorthrendStructureFortressPieces.func_175887_b(pieceweight, p_175871_3_, p_175871_4_, p_175871_5_, p_175871_6_, p_175871_7_, p_175871_8_, p_175871_9_);

                        if (piece != null)
                        {
                            ++pieceweight.field_78827_c;
                            p_175871_1_.theNetherBridgePieceWeight = pieceweight;

                            if (!pieceweight.func_78823_a())
                            {
                                p_175871_2_.remove(pieceweight);
                            }

                            return piece;
                        }
                    }
                }
            }

            return NorthrendStructureFortressPieces.End.func_175884_a(p_175871_3_, p_175871_4_, p_175871_5_, p_175871_6_, p_175871_7_, p_175871_8_, p_175871_9_);
        }

        private NorthrendStructureComponent func_175870_a(NorthrendStructureFortressPieces.Start p_175870_1_, List p_175870_2_, Random p_175870_3_, int p_175870_4_, int p_175870_5_, int p_175870_6_, EnumFacing p_175870_7_, int p_175870_8_, boolean p_175870_9_)
        {
            if (Math.abs(p_175870_4_ - p_175870_1_.getBoundingBox().minX) <= 112 && Math.abs(p_175870_6_ - p_175870_1_.getBoundingBox().minZ) <= 112)
            {
                List list1 = p_175870_1_.primaryWeights;

                if (p_175870_9_)
                {
                    list1 = p_175870_1_.secondaryWeights;
                }

                NorthrendStructureFortressPieces.Piece piece = this.func_175871_a(p_175870_1_, list1, p_175870_2_, p_175870_3_, p_175870_4_, p_175870_5_, p_175870_6_, p_175870_7_, p_175870_8_ + 1);

                if (piece != null)
                {
                    p_175870_2_.add(piece);
                    p_175870_1_.field_74967_d.add(piece);
                }

                return piece;
            }
            else
            {
                return NorthrendStructureFortressPieces.End.func_175884_a(p_175870_2_, p_175870_3_, p_175870_4_, p_175870_5_, p_175870_6_, p_175870_7_, p_175870_8_);
            }
        }

        /**
         * Gets the next component in any cardinal direction
         */
        protected NorthrendStructureComponent getNextComponentNormal(NorthrendStructureFortressPieces.Start p_74963_1_, List p_74963_2_, Random p_74963_3_, int p_74963_4_, int p_74963_5_, boolean p_74963_6_)
        {
            if (this.coordBaseMode != null)
            {
                switch (NorthrendStructureFortressPieces.SwitchEnumFacing.field_175888_a[this.coordBaseMode.ordinal()])
                {
                    case 1:
                        return this.func_175870_a(p_74963_1_, p_74963_2_, p_74963_3_, this.boundingBox.minX + p_74963_4_, this.boundingBox.minY + p_74963_5_, this.boundingBox.minZ - 1, this.coordBaseMode, this.getComponentType(), p_74963_6_);
                    case 2:
                        return this.func_175870_a(p_74963_1_, p_74963_2_, p_74963_3_, this.boundingBox.minX + p_74963_4_, this.boundingBox.minY + p_74963_5_, this.boundingBox.maxZ + 1, this.coordBaseMode, this.getComponentType(), p_74963_6_);
                    case 3:
                        return this.func_175870_a(p_74963_1_, p_74963_2_, p_74963_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74963_5_, this.boundingBox.minZ + p_74963_4_, this.coordBaseMode, this.getComponentType(), p_74963_6_);
                    case 4:
                        return this.func_175870_a(p_74963_1_, p_74963_2_, p_74963_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74963_5_, this.boundingBox.minZ + p_74963_4_, this.coordBaseMode, this.getComponentType(), p_74963_6_);
                }
            }

            return null;
        }

        /**
         * Gets the next component in the +/- X direction
         */
        protected NorthrendStructureComponent getNextComponentX(NorthrendStructureFortressPieces.Start p_74961_1_, List p_74961_2_, Random p_74961_3_, int p_74961_4_, int p_74961_5_, boolean p_74961_6_)
        {
            if (this.coordBaseMode != null)
            {
                switch (NorthrendStructureFortressPieces.SwitchEnumFacing.field_175888_a[this.coordBaseMode.ordinal()])
                {
                    case 1:
                        return this.func_175870_a(p_74961_1_, p_74961_2_, p_74961_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74961_4_, this.boundingBox.minZ + p_74961_5_, EnumFacing.WEST, this.getComponentType(), p_74961_6_);
                    case 2:
                        return this.func_175870_a(p_74961_1_, p_74961_2_, p_74961_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74961_4_, this.boundingBox.minZ + p_74961_5_, EnumFacing.WEST, this.getComponentType(), p_74961_6_);
                    case 3:
                        return this.func_175870_a(p_74961_1_, p_74961_2_, p_74961_3_, this.boundingBox.minX + p_74961_5_, this.boundingBox.minY + p_74961_4_, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType(), p_74961_6_);
                    case 4:
                        return this.func_175870_a(p_74961_1_, p_74961_2_, p_74961_3_, this.boundingBox.minX + p_74961_5_, this.boundingBox.minY + p_74961_4_, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType(), p_74961_6_);
                }
            }

            return null;
        }

        /**
         * Gets the next component in the +/- Z direction
         */
        protected NorthrendStructureComponent getNextComponentZ(NorthrendStructureFortressPieces.Start p_74965_1_, List p_74965_2_, Random p_74965_3_, int p_74965_4_, int p_74965_5_, boolean p_74965_6_)
        {
            if (this.coordBaseMode != null)
            {
                switch (NorthrendStructureFortressPieces.SwitchEnumFacing.field_175888_a[this.coordBaseMode.ordinal()])
                {
                    case 1:
                        return this.func_175870_a(p_74965_1_, p_74965_2_, p_74965_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74965_4_, this.boundingBox.minZ + p_74965_5_, EnumFacing.EAST, this.getComponentType(), p_74965_6_);
                    case 2:
                        return this.func_175870_a(p_74965_1_, p_74965_2_, p_74965_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74965_4_, this.boundingBox.minZ + p_74965_5_, EnumFacing.EAST, this.getComponentType(), p_74965_6_);
                    case 3:
                        return this.func_175870_a(p_74965_1_, p_74965_2_, p_74965_3_, this.boundingBox.minX + p_74965_5_, this.boundingBox.minY + p_74965_4_, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType(), p_74965_6_);
                    case 4:
                        return this.func_175870_a(p_74965_1_, p_74965_2_, p_74965_3_, this.boundingBox.minX + p_74965_5_, this.boundingBox.minY + p_74965_4_, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType(), p_74965_6_);
                }
            }

            return null;
        }

        /**
         * Checks if the bounding box's minY is > 10
         */
        protected static boolean isAboveGround(StructureBoundingBox p_74964_0_)
        {
            return p_74964_0_ != null && p_74964_0_.minY > 10;
        }
    }

    static class PieceWeight
    {
        /** The class of the StructureComponent to which this weight corresponds. */
        public Class weightClass;
        public final int field_78826_b;
        public int field_78827_c;
        public int field_78824_d;
        public boolean field_78825_e;
        private static final String __OBFID = "CL_00000467";

        public PieceWeight(Class p_i2055_1_, int p_i2055_2_, int p_i2055_3_, boolean p_i2055_4_)
        {
            this.weightClass = p_i2055_1_;
            this.field_78826_b = p_i2055_2_;
            this.field_78824_d = p_i2055_3_;
            this.field_78825_e = p_i2055_4_;
        }

        public PieceWeight(Class p_i2056_1_, int p_i2056_2_, int p_i2056_3_)
        {
            this(p_i2056_1_, p_i2056_2_, p_i2056_3_, false);
        }

        public boolean func_78822_a(int p_78822_1_)
        {
            return this.field_78824_d == 0 || this.field_78827_c < this.field_78824_d;
        }

        public boolean func_78823_a()
        {
            return this.field_78824_d == 0 || this.field_78827_c < this.field_78824_d;
        }
    }

    public static class Stairs extends NorthrendStructureFortressPieces.Piece
    {
        private static final String __OBFID = "CL_00000469";

        public Stairs() {}

        public Stairs(int p_i45609_1_, Random p_i45609_2_, StructureBoundingBox p_i45609_3_, EnumFacing p_i45609_4_)
        {
            super(p_i45609_1_);
            this.coordBaseMode = p_i45609_4_;
            this.boundingBox = p_i45609_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(NorthrendStructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentZ((NorthrendStructureFortressPieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 6, 2, false);
        }

        public static NorthrendStructureFortressPieces.Stairs func_175872_a(List p_175872_0_, Random p_175872_1_, int p_175872_2_, int p_175872_3_, int p_175872_4_, int p_175872_5_, EnumFacing p_175872_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175872_2_, p_175872_3_, p_175872_4_, -2, 0, 0, 7, 11, 7, p_175872_6_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175872_0_, structureboundingbox) == null ? new NorthrendStructureFortressPieces.Stairs(p_175872_5_, p_175872_1_, structureboundingbox, p_175872_6_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 0, 6, 1, 6, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 0, 6, 10, 6, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 0, 1, 8, 0, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 5, 2, 0, 6, 8, 0, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 1, 0, 8, 6, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 6, 2, 1, 6, 8, 6, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 2, 6, 5, 8, 6, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 3, 2, 0, 5, 4, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 6, 3, 2, 6, 5, 2, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 6, 3, 4, 6, 5, 4, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175811_a(worldIn, mainBlock.getDefaultState(), 5, 2, 5, p_74875_3_);
            this.func_175804_a(worldIn, p_74875_3_, 4, 2, 5, 4, 3, 5, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 3, 2, 5, 3, 4, 5, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 2, 5, 2, 5, 5, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 2, 5, 1, 6, 5, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 7, 1, 5, 7, 4, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 6, 8, 2, 6, 8, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 6, 0, 4, 8, 0, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 5, 0, 4, 5, 0, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);

            for (int i = 0; i <= 6; ++i)
            {
                for (int j = 0; j <= 6; ++j)
                {
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), i, -1, j, p_74875_3_);
                }
            }

            return true;
        }
    }

    public static class Start extends NorthrendStructureFortressPieces.Crossing3
    {
        /** Instance of StructureNetherBridgePieceWeight. */
        public NorthrendStructureFortressPieces.PieceWeight theNetherBridgePieceWeight;
        /** Contains the list of valid piece weights for the set of nether bridge structure pieces. */
        public List primaryWeights;
        /** Contains the list of valid piece weights for the secondary set of nether bridge structure pieces. */
        public List secondaryWeights;
        public List field_74967_d = Lists.newArrayList();
        private static final String __OBFID = "CL_00000470";

        public Start() {}

        public Start(Random p_i2059_1_, int p_i2059_2_, int p_i2059_3_)
        {
            super(p_i2059_1_, p_i2059_2_, p_i2059_3_);
            this.primaryWeights = Lists.newArrayList();
            NorthrendStructureFortressPieces.PieceWeight[] apieceweight = NorthrendStructureFortressPieces.primaryComponents;
            int k = apieceweight.length;
            int l;
            NorthrendStructureFortressPieces.PieceWeight pieceweight;

            for (l = 0; l < k; ++l)
            {
                pieceweight = apieceweight[l];
                pieceweight.field_78827_c = 0;
                this.primaryWeights.add(pieceweight);
            }

            this.secondaryWeights = Lists.newArrayList();
            apieceweight = NorthrendStructureFortressPieces.secondaryComponents;
            k = apieceweight.length;

            for (l = 0; l < k; ++l)
            {
                pieceweight = apieceweight[l];
                pieceweight.field_78827_c = 0;
                this.secondaryWeights.add(pieceweight);
            }
        }

        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        protected void readStructureFromNBT(NBTTagCompound p_143011_1_)
        {
            super.readStructureFromNBT(p_143011_1_);
        }

        /**
         * (abstract) Helper method to write subclass data to NBT
         */
        protected void writeStructureToNBT(NBTTagCompound p_143012_1_)
        {
            super.writeStructureToNBT(p_143012_1_);
        }
    }

    public static class Straight extends NorthrendStructureFortressPieces.Piece
    {
        private static final String __OBFID = "CL_00000456";

        public Straight() {}

        public Straight(int p_i45620_1_, Random p_i45620_2_, StructureBoundingBox p_i45620_3_, EnumFacing p_i45620_4_)
        {
            super(p_i45620_1_);
            this.coordBaseMode = p_i45620_4_;
            this.boundingBox = p_i45620_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(NorthrendStructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((NorthrendStructureFortressPieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 1, 3, false);
        }

        public static NorthrendStructureFortressPieces.Straight func_175882_a(List p_175882_0_, Random p_175882_1_, int p_175882_2_, int p_175882_3_, int p_175882_4_, EnumFacing p_175882_5_, int p_175882_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175882_2_, p_175882_3_, p_175882_4_, -1, -3, 0, 5, 10, 19, p_175882_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175882_0_, structureboundingbox) == null ? new NorthrendStructureFortressPieces.Straight(p_175882_6_, p_175882_1_, structureboundingbox, p_175882_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.func_175804_a(worldIn, p_74875_3_, 0, 3, 0, 4, 4, 18, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 5, 0, 3, 7, 18, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 5, 0, 0, 5, 18, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 5, 0, 4, 5, 18, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 0, 4, 2, 5, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 13, 4, 2, 18, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 0, 4, 1, 3, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 15, 4, 1, 18, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);

            for (int i = 0; i <= 4; ++i)
            {
                for (int j = 0; j <= 2; ++j)
                {
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), i, -1, j, p_74875_3_);
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), i, -1, 18 - j, p_74875_3_);
                }
            }

            this.func_175804_a(worldIn, p_74875_3_, 0, 1, 1, 0, 4, 1, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 3, 4, 0, 4, 4, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 3, 14, 0, 4, 14, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 1, 17, 0, 4, 17, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 1, 1, 4, 4, 1, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 3, 4, 4, 4, 4, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 3, 14, 4, 4, 14, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 1, 17, 4, 4, 17, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            return true;
        }
    }

    static final class SwitchEnumFacing
    {
        static final int[] field_175888_a = new int[EnumFacing.values().length];
        private static final String __OBFID = "CL_00001997";

        static
        {
            try
            {
                field_175888_a[EnumFacing.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError var4)
            {
                ;
            }

            try
            {
                field_175888_a[EnumFacing.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }

            try
            {
                field_175888_a[EnumFacing.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                field_175888_a[EnumFacing.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }

    public static class Throne extends NorthrendStructureFortressPieces.Piece
    {
        private boolean hasSpawner;
        private static final String __OBFID = "CL_00000465";

        public Throne() {}

        public Throne(int p_i45611_1_, Random p_i45611_2_, StructureBoundingBox p_i45611_3_, EnumFacing p_i45611_4_)
        {
            super(p_i45611_1_);
            this.coordBaseMode = p_i45611_4_;
            this.boundingBox = p_i45611_3_;
        }

        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        protected void readStructureFromNBT(NBTTagCompound p_143011_1_)
        {
            super.readStructureFromNBT(p_143011_1_);
            this.hasSpawner = p_143011_1_.getBoolean("Mob");
        }

        /**
         * (abstract) Helper method to write subclass data to NBT
         */
        protected void writeStructureToNBT(NBTTagCompound p_143012_1_)
        {
            super.writeStructureToNBT(p_143012_1_);
            p_143012_1_.setBoolean("Mob", this.hasSpawner);
        }

        public static NorthrendStructureFortressPieces.Throne func_175874_a(List p_175874_0_, Random p_175874_1_, int p_175874_2_, int p_175874_3_, int p_175874_4_, int p_175874_5_, EnumFacing p_175874_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175874_2_, p_175874_3_, p_175874_4_, -2, 0, 0, 7, 8, 9, p_175874_6_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && NorthrendStructureComponent.findIntersecting(p_175874_0_, structureboundingbox) == null ? new NorthrendStructureFortressPieces.Throne(p_175874_5_, p_175874_1_, structureboundingbox, p_175874_6_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.func_175804_a(worldIn, p_74875_3_, 0, 2, 0, 6, 7, 7, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 0, 0, 5, 1, 7, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 2, 1, 5, 2, 7, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 3, 2, 5, 3, 7, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 4, 3, 5, 4, 7, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 2, 0, 1, 4, 2, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 5, 2, 0, 5, 4, 2, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 5, 2, 1, 5, 3, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 5, 5, 2, 5, 5, 3, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 5, 3, 0, 5, 8, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 6, 5, 3, 6, 5, 8, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 5, 8, 5, 5, 8, mainBlock.getDefaultState(), mainBlock.getDefaultState(), false);
            this.func_175811_a(worldIn, fenceBlock.getDefaultState(), 1, 6, 3, p_74875_3_);
            this.func_175811_a(worldIn, fenceBlock.getDefaultState(), 5, 6, 3, p_74875_3_);
            this.func_175804_a(worldIn, p_74875_3_, 0, 6, 3, 0, 6, 8, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 6, 6, 3, 6, 6, 8, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 6, 8, 5, 7, 8, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 2, 8, 8, 4, 8, 8, fenceBlock.getDefaultState(), fenceBlock.getDefaultState(), false);

            if (!this.hasSpawner)
            {
                BlockPos blockpos = new BlockPos(this.getXWithOffset(3, 5), this.getYWithOffset(5), this.getZWithOffset(3, 5));

                if (p_74875_3_.func_175898_b(blockpos))
                {
                    this.hasSpawner = true;
                    worldIn.setBlockState(blockpos, Blocks.mob_spawner.getDefaultState(), 2);
                    TileEntity tileentity = worldIn.getTileEntity(blockpos);

                    if (tileentity instanceof TileEntityMobSpawner)
                    {
                        ((TileEntityMobSpawner)tileentity).getSpawnerBaseLogic().setEntityName("izrr");
                    }
                }
            }

            for (int i = 0; i <= 6; ++i)
            {
                for (int j = 0; j <= 6; ++j)
                {
                    this.func_175808_b(worldIn, mainBlock.getDefaultState(), i, -1, j, p_74875_3_);
                }
            }

            return true;
        }
    }
}