package com.gigavoid.supermod.northrend.block;

import com.gigavoid.supermod.common.Register;
import com.gigavoid.supermod.northrend.handler.ModelBakeHandler;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class NorthrendBlocks {

    public static void registerBlocks(Register register){
        register.registerBlock(BlockNorthGlacialIce.instance, "north_ice");
        register.registerBlock(BlockNorthDirt.instance, "north_dirt");
        register.registerBlock(BlockNorthStone.instance, "north_stone");
        register.registerBlock(BlockNorthLog.instance, "north_log");
        register.registerBlock(BlockNorthLeaves.instance, "north_leaves");
        register.registerBlock(BlockNorthPortal.instance, "north_portal");
        register.registerBlock(BlockNorthPlanks.instance, "north_planks");
        register.registerBlock(BlockNorthStairs.instance, "north_stairs");
        register.registerBlock(BlockNorthCobblestone.instance, "north_cobblestone");
        register.registerBlock(BlockNorthStoneStairs.instance, "north_cobble_stairs");
        register.registerBlock(BlockNorthFence.instance, "north_fence");
        register.registerBlock(BlockNorthFenceGate.instance, "north_fence_gate");
        register.registerBlock(BlockNorthGlaciemPlant.instance, "north_glaciem_plant");
        register.registerBlock(BlockNorthBlight.instance, "north_blight");
        register.registerBlock(BlockNorthSnowModded.instance, "snow_layer");
        register.registerBlock(BlockNorthCoalOre.instance, "north_coal_ore");
        register.registerBlock(BlockNorthDiamondOre.instance, "north_diamond_ore");
        register.registerBlock(BlockNorthEmeraldOre.instance, "north_emerald_ore");
        register.registerBlock(BlockNorthFrostGemOre.instance, "north_frost_gem_ore");
        register.registerBlock(BlockNorthGoldOre.instance, "north_gold_ore");
        register.registerBlock(BlockNorthIronOre.instance, "north_iron_ore");
        register.registerBlock(BlockNorthLapisOre.instance, "north_lapis_ore");
        register.registerBlock(BlockNorthMithrilOre.instance, "north_mithril_ore");
        register.registerBlock(BlockNorthRedstoneOre.instance, "north_red_stone_ore");
        register.registerBlock(BlockNorthRedstoneOre.instance_lit, "north_lit_red_stone_ore", "north_red_stone_ore");
        register.registerBlock(BlockNorthDragonBone.instance, "north_dragon_bone");
        register.registerBlock(BlockNorthDragonHead.instance, "north_dragonhead");
        register.registerBlock(BlockNorthSapling.instance_pine, "north_pine_sapling", "north_sapling");
        register.registerBlock(BlockNorthSapling.instance_fir, "north_fir_sapling", "north_sapling");
        register.registerBlock(BlockNorthSapling.instance_birch, "north_birch_sapling", "north_sapling");
        //register.registerBlock(northBloodBeechLog, "north_blood_beech_log");
        //register.registerBlock(northBloodBeechLeaves, "north_blood_beech_leaves");
    }
}
