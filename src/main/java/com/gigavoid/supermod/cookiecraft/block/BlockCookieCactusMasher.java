package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieUpgrade;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockCookieCactusMasher extends BlockCookieUpgradeBase implements ICookieUpgrade {
    protected BlockCookieCactusMasher() {
        super(Material.rock);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
    }

    @Override
    public double getCPS(World world, BlockPos pos, IBlockState state) {
        return 1/4d;
    }

	@Override
	public int getGuiId() {
		return GuiCookieUpgrade.GUI_ID;
	}

	@Override
	public boolean hasImportantUI() {
		return false;
	}
}