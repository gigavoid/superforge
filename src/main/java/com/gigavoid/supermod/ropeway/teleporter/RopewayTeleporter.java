package com.gigavoid.supermod.ropeway.teleporter;

import com.gigavoid.supermod.ropeway.block.BlockRopewayPortal;
import com.gigavoid.supermod.ropeway.block.RopewayBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.WorldServer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RopewayTeleporter extends net.minecraft.world.Teleporter
{

    private final LongHashMap destinationCoordinateCache = new LongHashMap();
    private final List destinationCoordinateKeys = new ArrayList();
    private final Random random;

    private WorldServer worldServerInstance;

    public RopewayTeleporter(WorldServer worldServer) {
        super(worldServer);
        this.worldServerInstance = worldServer;
        this.random = new Random(worldServer.getSeed());
    }

    @Override
    public void placeInPortal(Entity p_180266_1_, float p_180266_2_) {
        if (this.worldServerInstance.provider.getDimensionId() != 1)
        {
            if (!this.func_180620_b(p_180266_1_, p_180266_2_))
            {
                this.makePortal(p_180266_1_);
                this.func_180620_b(p_180266_1_, p_180266_2_);
            }
        }
        else
        {
            int i = MathHelper.floor_double(p_180266_1_.posX);
            int j = MathHelper.floor_double(p_180266_1_.posY) - 1;
            int k = MathHelper.floor_double(p_180266_1_.posZ);
            byte b0 = 1;
            byte b1 = 0;

            for (int l = -2; l <= 2; ++l)
            {
                for (int i1 = -2; i1 <= 2; ++i1)
                {
                    for (int j1 = -1; j1 < 3; ++j1)
                    {
                        int k1 = i + i1 * b0 + l * b1;
                        int l1 = j + j1;
                        int i2 = k + i1 * b1 - l * b0;
                        boolean flag = j1 < 0;
                        this.worldServerInstance.setBlockState(new BlockPos(k1, l1, i2), flag ? Blocks.quartz_block.getDefaultState() : Blocks.air.getDefaultState());
                    }
                }
            }

            p_180266_1_.setLocationAndAngles((double)i, (double)j, (double)k, p_180266_1_.rotationYaw, 0.0F);
            p_180266_1_.motionX = p_180266_1_.motionY = p_180266_1_.motionZ = 0.0D;
        }
    }

    public boolean func_180620_b(Entity p_180620_1_, float p_180620_2_)
    {
        boolean flag = true;
        double d0 = -1.0D;
        int i = MathHelper.floor_double(p_180620_1_.posX);
        int j = MathHelper.floor_double(p_180620_1_.posZ);
        boolean flag1 = true;
        Object object = BlockPos.ORIGIN;
        long k = ChunkCoordIntPair.chunkXZ2Int(i, j);

        if (this.destinationCoordinateCache.containsItem(k))
        {
            PortalPosition portalposition = (PortalPosition)this.destinationCoordinateCache.getValueByKey(k);
            d0 = 0.0D;
            object = portalposition;
            portalposition.lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
            flag1 = false;
        }
        else
        {
            BlockPos blockpos4 = new BlockPos(p_180620_1_);

            for (int l = -128; l <= 128; ++l)
            {
                BlockPos blockpos1;

                for (int i1 = -128; i1 <= 128; ++i1)
                {
                    for (BlockPos blockpos = blockpos4.add(l, this.worldServerInstance.getActualHeight() - 1 - blockpos4.getY(), i1); blockpos.getY() >= 0; blockpos = blockpos1)
                    {
                        blockpos1 = blockpos.down();

                        if (this.worldServerInstance.getBlockState(blockpos).getBlock() == RopewayBlocks.portalRopeway)
                        {
                            while (this.worldServerInstance.getBlockState(blockpos1 = blockpos.down()).getBlock() == RopewayBlocks.portalRopeway)
                            {
                                blockpos = blockpos1;
                            }

                            double d1 = blockpos.distanceSq(blockpos4);

                            if (d0 < 0.0D || d1 < d0)
                            {
                                d0 = d1;
                                object = blockpos;
                            }
                        }
                    }
                }
            }
        }

        if (d0 >= 0.0D)
        {
            if (flag1)
            {
                this.destinationCoordinateCache.add(k, new PortalPosition((BlockPos)object, this.worldServerInstance.getTotalWorldTime()));
                this.destinationCoordinateKeys.add(Long.valueOf(k));
            }

            double d4 = (double)((BlockPos)object).getX() + 0.5D;
            double d5 = (double)((BlockPos)object).getY() + 0.5D;
            double d6 = (double)((BlockPos)object).getZ() + 0.5D;
            EnumFacing enumfacing = null;

            if (this.worldServerInstance.getBlockState(((BlockPos)object).west()).getBlock() == RopewayBlocks.portalRopeway)
            {
                enumfacing = EnumFacing.NORTH;
            }

            if (this.worldServerInstance.getBlockState(((BlockPos)object).east()).getBlock() == RopewayBlocks.portalRopeway)
            {
                enumfacing = EnumFacing.SOUTH;
            }

            if (this.worldServerInstance.getBlockState(((BlockPos)object).north()).getBlock() == RopewayBlocks.portalRopeway)
            {
                enumfacing = EnumFacing.EAST;
            }

            if (this.worldServerInstance.getBlockState(((BlockPos)object).south()).getBlock() == RopewayBlocks.portalRopeway)
            {
                enumfacing = EnumFacing.WEST;
            }

            EnumFacing enumfacing1 = EnumFacing.getHorizontal(p_180620_1_.getTeleportDirection());

            if (enumfacing != null)
            {
                EnumFacing enumfacing2 = enumfacing.rotateYCCW();
                BlockPos blockpos2 = ((BlockPos)object).offset(enumfacing);
                boolean flag2 = this.func_180265_a(blockpos2);
                boolean flag3 = this.func_180265_a(blockpos2.offset(enumfacing2));

                if (flag3 && flag2)
                {
                    object = ((BlockPos)object).offset(enumfacing2);
                    enumfacing = enumfacing.getOpposite();
                    enumfacing2 = enumfacing2.getOpposite();
                    BlockPos blockpos3 = ((BlockPos)object).offset(enumfacing);
                    flag2 = this.func_180265_a(blockpos3);
                    flag3 = this.func_180265_a(blockpos3.offset(enumfacing2));
                }

                float f6 = 0.5F;
                float f1 = 0.5F;

                if (!flag3 && flag2)
                {
                    f6 = 1.0F;
                }
                else if (flag3 && !flag2)
                {
                    f6 = 0.0F;
                }
                else if (flag3)
                {
                    f1 = 0.0F;
                }

                d4 = (double)((BlockPos)object).getX() + 0.5D;
                d5 = (double)((BlockPos)object).getY() + 0.5D;
                d6 = (double)((BlockPos)object).getZ() + 0.5D;
                d4 += (double)((float)enumfacing2.getFrontOffsetX() * f6 + (float)enumfacing.getFrontOffsetX() * f1);
                d6 += (double)((float)enumfacing2.getFrontOffsetZ() * f6 + (float)enumfacing.getFrontOffsetZ() * f1);
                float f2 = 0.0F;
                float f3 = 0.0F;
                float f4 = 0.0F;
                float f5 = 0.0F;

                if (enumfacing == enumfacing1)
                {
                    f2 = 1.0F;
                    f3 = 1.0F;
                }
                else if (enumfacing == enumfacing1.getOpposite())
                {
                    f2 = -1.0F;
                    f3 = -1.0F;
                }
                else if (enumfacing == enumfacing1.rotateY())
                {
                    f4 = 1.0F;
                    f5 = -1.0F;
                }
                else
                {
                    f4 = -1.0F;
                    f5 = 1.0F;
                }

                double d2 = p_180620_1_.motionX;
                double d3 = p_180620_1_.motionZ;
                p_180620_1_.motionX = d2 * (double)f2 + d3 * (double)f5;
                p_180620_1_.motionZ = d2 * (double)f4 + d3 * (double)f3;
                p_180620_1_.rotationYaw = p_180620_2_ - (float)(enumfacing1.getHorizontalIndex() * 90) + (float)(enumfacing.getHorizontalIndex() * 90);
            }
            else
            {
                p_180620_1_.motionX = p_180620_1_.motionY = p_180620_1_.motionZ = 0.0D;
            }

            p_180620_1_.setLocationAndAngles(d4, d5, d6, p_180620_1_.rotationYaw, p_180620_1_.rotationPitch);
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean func_180265_a(BlockPos p_180265_1_)
    {
        return !this.worldServerInstance.isAirBlock(p_180265_1_) || !this.worldServerInstance.isAirBlock(p_180265_1_.up());
    }

    @Override
    public void removeStalePortalLocations(long p_85189_1_)
    {
        if (p_85189_1_ % 100L == 0L)
        {
            Iterator iterator = this.destinationCoordinateKeys.iterator();
            long j = p_85189_1_ - 600L;

            while (iterator.hasNext())
            {
                Long olong = (Long)iterator.next();
                PortalPosition portalposition = (PortalPosition)this.destinationCoordinateCache.getValueByKey(olong.longValue());

                if (portalposition == null || portalposition.lastUpdateTime < j)
                {
                    iterator.remove();
                    this.destinationCoordinateCache.remove(olong.longValue());
                }
            }
        }
    }

    @Override
    public boolean makePortal(Entity p_85188_1_)
    {
        byte b0 = 16;
        double d0 = -1.0D;
        int i = MathHelper.floor_double(p_85188_1_.posX);
        int j = MathHelper.floor_double(p_85188_1_.posY);
        int k = MathHelper.floor_double(p_85188_1_.posZ);
        int l = i;
        int i1 = j;
        int j1 = k;
        int k1 = 0;
        int l1 = this.random.nextInt(4);
        int i2;
        double d1;
        int k2;
        double d2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        int k4;
        int l4;
        int i5;
        double d3;
        double d4;

        for (i2 = i - b0; i2 <= i + b0; ++i2)
        {
            d1 = (double)i2 + 0.5D - p_85188_1_.posX;

            for (k2 = k - b0; k2 <= k + b0; ++k2)
            {
                d2 = (double)k2 + 0.5D - p_85188_1_.posZ;
                label271:

                for (i3 = this.worldServerInstance.getActualHeight() - 1; i3 >= 0; --i3)
                {
                    if (this.worldServerInstance.isAirBlock(new BlockPos(i2, i3, k2)))
                    {
                        while (i3 > 0 && this.worldServerInstance.isAirBlock(new BlockPos(i2, i3 - 1, k2)))
                        {
                            --i3;
                        }

                        for (j3 = l1; j3 < l1 + 4; ++j3)
                        {
                            k3 = j3 % 2;
                            l3 = 1 - k3;

                            if (j3 % 4 >= 2)
                            {
                                k3 = -k3;
                                l3 = -l3;
                            }

                            for (i4 = 0; i4 < 3; ++i4)
                            {
                                for (j4 = 0; j4 < 4; ++j4)
                                {
                                    for (k4 = -1; k4 < 4; ++k4)
                                    {
                                        l4 = i2 + (j4 - 1) * k3 + i4 * l3;
                                        i5 = i3 + k4;
                                        int j5 = k2 + (j4 - 1) * l3 - i4 * k3;

                                        if (k4 < 0 && !this.worldServerInstance.getBlockState(new BlockPos(l4, i5, j5)).getBlock().getMaterial().isSolid() || k4 >= 0 && !this.worldServerInstance.isAirBlock(new BlockPos(l4, i5, j5)))
                                        {
                                            continue label271;
                                        }
                                    }
                                }
                            }

                            d3 = (double)i3 + 0.5D - p_85188_1_.posY;
                            d4 = d1 * d1 + d3 * d3 + d2 * d2;

                            if (d0 < 0.0D || d4 < d0)
                            {
                                d0 = d4;
                                l = i2;
                                i1 = i3;
                                j1 = k2;
                                k1 = j3 % 4;
                            }
                        }
                    }
                }
            }
        }

        if (d0 < 0.0D)
        {
            for (i2 = i - b0; i2 <= i + b0; ++i2)
            {
                d1 = (double)i2 + 0.5D - p_85188_1_.posX;

                for (k2 = k - b0; k2 <= k + b0; ++k2)
                {
                    d2 = (double)k2 + 0.5D - p_85188_1_.posZ;
                    label219:

                    for (i3 = this.worldServerInstance.getActualHeight() - 1; i3 >= 0; --i3)
                    {
                        if (this.worldServerInstance.isAirBlock(new BlockPos(i2, i3, k2)))
                        {
                            while (i3 > 0 && this.worldServerInstance.isAirBlock(new BlockPos(i2, i3 - 1, k2)))
                            {
                                --i3;
                            }

                            for (j3 = l1; j3 < l1 + 2; ++j3)
                            {
                                k3 = j3 % 2;
                                l3 = 1 - k3;

                                for (i4 = 0; i4 < 4; ++i4)
                                {
                                    for (j4 = -1; j4 < 4; ++j4)
                                    {
                                        k4 = i2 + (i4 - 1) * k3;
                                        l4 = i3 + j4;
                                        i5 = k2 + (i4 - 1) * l3;

                                        if (j4 < 0 && !this.worldServerInstance.getBlockState(new BlockPos(k4, l4, i5)).getBlock().getMaterial().isSolid() || j4 >= 0 && !this.worldServerInstance.isAirBlock(new BlockPos(k4, l4, i5)))
                                        {
                                            continue label219;
                                        }
                                    }
                                }

                                d3 = (double)i3 + 0.5D - p_85188_1_.posY;
                                d4 = d1 * d1 + d3 * d3 + d2 * d2;

                                if (d0 < 0.0D || d4 < d0)
                                {
                                    d0 = d4;
                                    l = i2;
                                    i1 = i3;
                                    j1 = k2;
                                    k1 = j3 % 2;
                                }
                            }
                        }
                    }
                }
            }
        }

        int k5 = l;
        int j2 = i1;
        k2 = j1;
        int l5 = k1 % 2;
        int l2 = 1 - l5;

        if (k1 % 4 >= 2)
        {
            l5 = -l5;
            l2 = -l2;
        }

        if (d0 < 0.0D)
        {
            i1 = MathHelper.clamp_int(i1, 70, this.worldServerInstance.getActualHeight() - 10);
            j2 = i1;

            for (i3 = -1; i3 <= 1; ++i3)
            {
                for (j3 = 1; j3 < 3; ++j3)
                {
                    for (k3 = -1; k3 < 3; ++k3)
                    {
                        l3 = k5 + (j3 - 1) * l5 + i3 * l2;
                        i4 = j2 + k3;
                        j4 = k2 + (j3 - 1) * l2 - i3 * l5;
                        boolean flag = k3 < 0;
                        this.worldServerInstance.setBlockState(new BlockPos(l3, i4, j4), flag ? Blocks.quartz_block.getDefaultState() : Blocks.air.getDefaultState());
                    }
                }
            }
        }

        IBlockState iblockstate = RopewayBlocks.portalRopeway.getDefaultState().withProperty(BlockRopewayPortal.field_176550_a, l5 != 0 ? EnumFacing.Axis.X : EnumFacing.Axis.Z);

        for (j3 = 0; j3 < 4; ++j3)
        {
            for (k3 = 0; k3 < 4; ++k3)
            {
                for (l3 = -1; l3 < 4; ++l3)
                {
                    i4 = k5 + (k3 - 1) * l5;
                    j4 = j2 + l3;
                    k4 = k2 + (k3 - 1) * l2;
                    boolean flag1 = k3 == 0 || k3 == 3 || l3 == -1 || l3 == 3;
                    this.worldServerInstance.setBlockState(new BlockPos(i4, j4, k4), flag1 ? Blocks.quartz_block.getDefaultState() : iblockstate, 2);
                }
            }

            for (k3 = 0; k3 < 4; ++k3)
            {
                for (l3 = -1; l3 < 4; ++l3)
                {
                    i4 = k5 + (k3 - 1) * l5;
                    j4 = j2 + l3;
                    k4 = k2 + (k3 - 1) * l2;
                    this.worldServerInstance.notifyNeighborsOfStateChange(new BlockPos(i4, j4, k4), this.worldServerInstance.getBlockState(new BlockPos(i4, j4, k4)).getBlock());
                }
            }
        }

        return true;
    }
}