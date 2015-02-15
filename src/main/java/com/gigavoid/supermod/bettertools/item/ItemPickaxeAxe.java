package com.gigavoid.supermod.bettertools.item;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import java.util.Set;

/**
 * Created by Lukas on 2015-02-14.
 */
public class ItemPickaxeAxe extends ItemTool {
    private static final Set effectiveBlocks = Sets.newHashSet(Blocks.activator_rail, Blocks.coal_ore, Blocks.cobblestone, Blocks.detector_rail, Blocks.diamond_block, Blocks.diamond_ore, Blocks.double_stone_slab, Blocks.golden_rail, Blocks.gold_block, Blocks.gold_ore, Blocks.ice, Blocks.iron_block, Blocks.iron_ore, Blocks.lapis_block, Blocks.lapis_ore, Blocks.lit_redstone_ore, Blocks.mossy_cobblestone, Blocks.netherrack, Blocks.packed_ice, Blocks.rail, Blocks.redstone_ore, Blocks.sandstone, Blocks.red_sandstone, Blocks.stone, Blocks.stone_slab, Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.melon_block, Blocks.ladder);

    protected ItemPickaxeAxe() {
        super(8, ToolMaterial.EMERALD, effectiveBlocks);
    }

    public boolean canHarvestBlock(Block blockIn)
    {
        if (blockIn != Blocks.redstone_ore && blockIn != Blocks.lit_redstone_ore)
            if (blockIn != Blocks.diamond_block && blockIn != Blocks.diamond_ore)
                if (blockIn == Blocks.obsidian) return this.toolMaterial.getHarvestLevel() == 3;
                else if (blockIn != Blocks.emerald_ore && blockIn != Blocks.emerald_block)
                    if (blockIn != Blocks.gold_block && blockIn != Blocks.gold_ore)
                        if (blockIn != Blocks.iron_block && blockIn != Blocks.iron_ore)
                            if (blockIn != Blocks.lapis_block && blockIn != Blocks.lapis_ore)
                                return (blockIn.getMaterial() == Material.rock || (blockIn.getMaterial() == Material.iron || blockIn.getMaterial() == Material.anvil));
                            else return this.toolMaterial.getHarvestLevel() >= 1;
                        else return this.toolMaterial.getHarvestLevel() >= 1;
                    else return this.toolMaterial.getHarvestLevel() >= 2;
                else return this.toolMaterial.getHarvestLevel() >= 2;
            else if (blockIn == Blocks.obsidian) return this.toolMaterial.getHarvestLevel() == 3;
            else return this.toolMaterial.getHarvestLevel() >= 2;
        else if (blockIn != Blocks.diamond_block && blockIn != Blocks.diamond_ore)
            if (blockIn == Blocks.obsidian) return this.toolMaterial.getHarvestLevel() == 3;
            else if (blockIn != Blocks.emerald_ore && blockIn != Blocks.emerald_block)
                if (blockIn != Blocks.gold_block && blockIn != Blocks.gold_ore)
                    if (blockIn != Blocks.iron_block && blockIn != Blocks.iron_ore)
                        if (blockIn != Blocks.lapis_block && blockIn != Blocks.lapis_ore)
                            return this.toolMaterial.getHarvestLevel() >= 2;
                        else return this.toolMaterial.getHarvestLevel() >= 1;
                    else return this.toolMaterial.getHarvestLevel() >= 1;
                else return this.toolMaterial.getHarvestLevel() >= 2;
            else return this.toolMaterial.getHarvestLevel() >= 2;
        else if (blockIn == Blocks.obsidian) return this.toolMaterial.getHarvestLevel() == 3;
        else return this.toolMaterial.getHarvestLevel() >= 2;
    }

    public float getStrVsBlock(ItemStack stack, Block p_150893_2_)
    {
        if (p_150893_2_.getMaterial() != Material.iron && p_150893_2_.getMaterial() != Material.anvil && p_150893_2_.getMaterial() != Material.rock && p_150893_2_.getMaterial() != Material.wood && p_150893_2_.getMaterial() != Material.plants && p_150893_2_.getMaterial() != Material.vine)
            return super.getStrVsBlock(stack, p_150893_2_);
        else return this.efficiencyOnProperMaterial;
    }
}