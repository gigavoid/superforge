package com.gigavoid.supermod.block;

import com.gigavoid.supermod.SuperMod;
import com.gigavoid.supermod.teleport.TeleporterNorthrend;
import com.gigavoid.supermod.util.SuperReflection;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Direction;
import net.minecraft.world.World;

public class BlockPortalNorthrend extends BlockPortal {
    public BlockPortalNorthrend() {
        super();
        setBlockName("portalNorthrend");
        setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
        if ((par5Entity.ridingEntity == null) && (par5Entity.riddenByEntity == null) && ((par5Entity instanceof EntityPlayerMP))) {
            EntityPlayerMP player = (EntityPlayerMP) par5Entity;

            MinecraftServer mServer = MinecraftServer.getServer();

            if (player.timeUntilPortal > 0) {
                player.timeUntilPortal = 10;
            } else if (player.dimension != SuperMod.northrendDimID) {
                player.timeUntilPortal = 10;

                player.mcServer.getConfigurationManager().transferPlayerToDimension(player, SuperMod.northrendDimID, new TeleporterNorthrend(mServer.worldServerForDimension(SuperMod.northrendDimID)));
            } else {
                player.timeUntilPortal = 10;
                player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new TeleporterNorthrend(mServer.worldServerForDimension(1)));
            }
        }
    }


    @Override
    public boolean func_150000_e(World p_150000_1_, int p_150000_2_, int p_150000_3_, int p_150000_4_)
    {
        BlockPortal.Size size = new BlockPortal.Size(p_150000_1_, p_150000_2_, p_150000_3_, p_150000_4_, 1);
        BlockPortal.Size size1 = new BlockPortal.Size(p_150000_1_, p_150000_2_, p_150000_3_, p_150000_4_, 2);


        int sizeVal = (Integer)SuperReflection.getFieldValue("field_150864_e", Size.class, size);
        int size1Val = (Integer)SuperReflection.getFieldValue("field_150864_e", Size.class, size1);


        if (size.func_150860_b() && sizeVal == 0)
        {
            size.func_150859_c();
            return true;
        }
        else if (size1.func_150860_b() && size1Val == 0)
        {
            size1.func_150859_c();
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5) {
        byte b0 = 0;
        byte b1 = 1;

        if (par1World.getBlock(par2 - 1, par3, par4) == this || par1World.getBlock(par2 + 1, par3, par4) == this) {
            b0 = 1;
            b1 = 0;
        }

        int i1;

        for (i1 = par3; par1World.getBlock(par2, i1 - 1, par4) == this; --i1) {
            ;
        }

        if (par1World.getBlock(par2, i1 - 1, par4) != Blocks.packed_ice) {
            par1World.setBlockToAir(par2, par3, par4);
        } else {
            int j1;

            for (j1 = 1; j1 < 4 && par1World.getBlock(par2, i1 + j1, par4) == this; ++j1) {
                ;
            }

            if (j1 == 3 && par1World.getBlock(par2, i1 + j1, par4) == Blocks.packed_ice) {
                boolean flag = par1World.getBlock(par2 - 1, par3, par4) == this || par1World.getBlock(par2 + 1, par3, par4) == this;
                boolean flag1 = par1World.getBlock(par2, par3, par4 - 1) == this || par1World.getBlock(par2, par3, par4 + 1) == this;

                if (flag && flag1) {
                    par1World.setBlockToAir(par2, par3, par4);
                } else {
                    if ((par1World.getBlock(par2 + b0, par3, par4 + b1) != Blocks.packed_ice || par1World.getBlock(par2 - b0, par3, par4 - b1) != this) && (par1World.getBlock(par2 - b0, par3, par4 - b1) != Blocks.packed_ice || par1World.getBlock(par2 + b0, par3, par4 + b1) != this)) {
                        par1World.setBlockToAir(par2, par3, par4);
                    }
                }
            } else {
                par1World.setBlockToAir(par2, par3, par4);
            }
        }
    }

    @Override
    public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
        if (p_149726_1_.provider.dimensionId > 0 || !SuperBlocks.portalNorthrend.func_150000_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_))
        {
            p_149726_1_.setBlockToAir(p_149726_2_, p_149726_3_, p_149726_4_);
        }
    }

    public static class Size
    {
        private final World field_150867_a;
        private final int field_150865_b;
        private final int field_150866_c;
        private final int field_150863_d;
        private int field_150864_e = 0;
        private ChunkCoordinates field_150861_f;
        private int field_150862_g;
        private int field_150868_h;
        private static final String __OBFID = "CL_00000285";

        public Size(World p_i45415_1_, int p_i45415_2_, int p_i45415_3_, int p_i45415_4_, int p_i45415_5_)
        {
            this.field_150867_a = p_i45415_1_;
            this.field_150865_b = p_i45415_5_;
            this.field_150863_d = BlockPortalNorthrend.field_150001_a[p_i45415_5_][0];
            this.field_150866_c = BlockPortalNorthrend.field_150001_a[p_i45415_5_][1];

            for (int i1 = p_i45415_3_; p_i45415_3_ > i1 - 21 && p_i45415_3_ > 0 && this.func_150857_a(p_i45415_1_.getBlock(p_i45415_2_, p_i45415_3_ - 1, p_i45415_4_)); --p_i45415_3_)
            {
                ;
            }

            int j1 = this.func_150853_a(p_i45415_2_, p_i45415_3_, p_i45415_4_, this.field_150863_d) - 1;

            if (j1 >= 0)
            {
                this.field_150861_f = new ChunkCoordinates(p_i45415_2_ + j1 * Direction.offsetX[this.field_150863_d], p_i45415_3_, p_i45415_4_ + j1 * Direction.offsetZ[this.field_150863_d]);
                this.field_150868_h = this.func_150853_a(this.field_150861_f.posX, this.field_150861_f.posY, this.field_150861_f.posZ, this.field_150866_c);

                if (this.field_150868_h < 2 || this.field_150868_h > 21)
                {
                    this.field_150861_f = null;
                    this.field_150868_h = 0;
                }
            }

            if (this.field_150861_f != null)
            {
                this.field_150862_g = this.func_150858_a();
            }
        }

        protected int func_150853_a(int p_150853_1_, int p_150853_2_, int p_150853_3_, int p_150853_4_)
        {
            int j1 = Direction.offsetX[p_150853_4_];
            int k1 = Direction.offsetZ[p_150853_4_];
            int i1;
            Block block;

            for (i1 = 0; i1 < 22; ++i1)
            {
                block = this.field_150867_a.getBlock(p_150853_1_ + j1 * i1, p_150853_2_, p_150853_3_ + k1 * i1);

                if (!this.func_150857_a(block))
                {
                    break;
                }

                Block block1 = this.field_150867_a.getBlock(p_150853_1_ + j1 * i1, p_150853_2_ - 1, p_150853_3_ + k1 * i1);

                if (block1 != Blocks.packed_ice)
                {
                    break;
                }
            }

            block = this.field_150867_a.getBlock(p_150853_1_ + j1 * i1, p_150853_2_, p_150853_3_ + k1 * i1);
            return block == Blocks.packed_ice ? i1 : 0;
        }

        protected int func_150858_a()
        {
            int i;
            int j;
            int k;
            int l;
            label56:

            for (this.field_150862_g = 0; this.field_150862_g < 21; ++this.field_150862_g)
            {
                i = this.field_150861_f.posY + this.field_150862_g;

                for (j = 0; j < this.field_150868_h; ++j)
                {
                    k = this.field_150861_f.posX + j * Direction.offsetX[BlockPortal.field_150001_a[this.field_150865_b][1]];
                    l = this.field_150861_f.posZ + j * Direction.offsetZ[BlockPortal.field_150001_a[this.field_150865_b][1]];
                    Block block = this.field_150867_a.getBlock(k, i, l);

                    if (!this.func_150857_a(block))
                    {
                        break label56;
                    }

                    if (block == SuperBlocks.portalNorthrend)
                    {
                        ++this.field_150864_e;
                    }

                    if (j == 0)
                    {
                        block = this.field_150867_a.getBlock(k + Direction.offsetX[BlockPortal.field_150001_a[this.field_150865_b][0]], i, l + Direction.offsetZ[BlockPortal.field_150001_a[this.field_150865_b][0]]);

                        if (block != Blocks.packed_ice)
                        {
                            break label56;
                        }
                    }
                    else if (j == this.field_150868_h - 1)
                    {
                        block = this.field_150867_a.getBlock(k + Direction.offsetX[BlockPortal.field_150001_a[this.field_150865_b][1]], i, l + Direction.offsetZ[BlockPortal.field_150001_a[this.field_150865_b][1]]);

                        if (block != Blocks.packed_ice)
                        {
                            break label56;
                        }
                    }
                }
            }

            for (i = 0; i < this.field_150868_h; ++i)
            {
                j = this.field_150861_f.posX + i * Direction.offsetX[BlockPortal.field_150001_a[this.field_150865_b][1]];
                k = this.field_150861_f.posY + this.field_150862_g;
                l = this.field_150861_f.posZ + i * Direction.offsetZ[BlockPortal.field_150001_a[this.field_150865_b][1]];

                if (this.field_150867_a.getBlock(j, k, l) != Blocks.packed_ice)
                {
                    this.field_150862_g = 0;
                    break;
                }
            }

            if (this.field_150862_g <= 21 && this.field_150862_g >= 3)
            {
                return this.field_150862_g;
            }
            else
            {
                this.field_150861_f = null;
                this.field_150868_h = 0;
                this.field_150862_g = 0;
                return 0;
            }
        }

        protected boolean func_150857_a(Block block)
        {
            Material mat = (Material)SuperReflection.getFieldValue("blockMaterial", Block.class, block);
            return mat == Material.air || block == SuperBlocks.portalNorthrend;
        }

        public boolean func_150860_b()
        {
            return this.field_150861_f != null && this.field_150868_h >= 2 && this.field_150868_h <= 21 && this.field_150862_g >= 3 && this.field_150862_g <= 21;
        }

        public void func_150859_c()
        {
            for (int i = 0; i < this.field_150868_h; ++i)
            {
                int j = this.field_150861_f.posX + Direction.offsetX[this.field_150866_c] * i;
                int k = this.field_150861_f.posZ + Direction.offsetZ[this.field_150866_c] * i;

                for (int l = 0; l < this.field_150862_g; ++l)
                {
                    int i1 = this.field_150861_f.posY + l;
                    this.field_150867_a.setBlock(j, i1, k, SuperBlocks.portalNorthrend, this.field_150865_b, 2);
                }
            }
        }
    }


}