package com.gigavoid.supermod.northrend.item;

import com.gigavoid.supermod.common.Register;
import com.gigavoid.supermod.northrend.block.BlockNorthGlacialIce;
import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class NorthrendItems {
    public static ItemNorthPickaxe dragonbonePickaxe = new ItemNorthPickaxe(ItemNorthTool.ToolMaterial.BONE);
    public static ItemNorthPickaxe mithrilPickaxe = new ItemNorthPickaxe(ItemNorthTool.ToolMaterial.MITHRIL);
    public static ItemNorthSword mithrilSword = new ItemNorthSword(ItemNorthTool.ToolMaterial.MITHRIL);
    public static ItemNorthAxe mithrilAxe = new ItemNorthAxe(ItemNorthTool.ToolMaterial.MITHRIL);
    public static ItemNorthHoe mithrilHoe = new ItemNorthHoe();
    public static ItemNorthShovel mithrilShovel = new ItemNorthShovel(ItemNorthTool.ToolMaterial.MITHRIL);
    public static ItemNorthDragonbone dragonbone = new ItemNorthDragonbone();
    public static ItemNorthFrostGem frostGem = new ItemNorthFrostGem();
    public static ItemNorthMithrilIngot mithrilIngot = new ItemNorthMithrilIngot();
    public static ItemNorthPearl northPearl = new ItemNorthPearl();
    public static ItemNorthArmorPadded northLeatherHelmet = new ItemNorthArmorPadded(ItemArmor.ArmorMaterial.LEATHER, 0, 0);
    public static ItemNorthArmorPadded northLeatherChestplate = new ItemNorthArmorPadded(ItemArmor.ArmorMaterial.LEATHER, 0, 1);
    public static ItemNorthArmorPadded northLeatherLeggins = new ItemNorthArmorPadded(ItemArmor.ArmorMaterial.LEATHER, 0, 2);
    public static ItemNorthArmorPadded northLeatherBoots = new ItemNorthArmorPadded(ItemArmor.ArmorMaterial.LEATHER, 0, 3);
    public static ItemNorthArmorPadded northChainmailHelmet = new ItemNorthArmorPadded(ItemArmor.ArmorMaterial.CHAIN, 1, 0);
    public static ItemNorthArmorPadded northChainmailChestplate = new ItemNorthArmorPadded(ItemArmor.ArmorMaterial.CHAIN, 1, 1);
    public static ItemNorthArmorPadded northChainmailLeggins = new ItemNorthArmorPadded(ItemArmor.ArmorMaterial.CHAIN, 1, 2);
    public static ItemNorthArmorPadded northChainmailBoots = new ItemNorthArmorPadded(ItemArmor.ArmorMaterial.CHAIN, 1, 3);
    public static ItemNorthArmorPadded northIronHelmet = new ItemNorthArmorPadded(ItemArmor.ArmorMaterial.IRON, 2, 0);
    public static ItemNorthArmorPadded northIronChestplate = new ItemNorthArmorPadded(ItemArmor.ArmorMaterial.IRON, 2, 1);
    public static ItemNorthArmorPadded northIronLeggins = new ItemNorthArmorPadded(ItemArmor.ArmorMaterial.IRON, 2, 2);
    public static ItemNorthArmorPadded northIronBoots = new ItemNorthArmorPadded(ItemArmor.ArmorMaterial.IRON, 2, 3);
    public static ItemNorthArmorPadded northDiamondHelmet = new ItemNorthArmorPadded(ItemArmor.ArmorMaterial.DIAMOND, 3, 0);
    public static ItemNorthArmorPadded northDiamondChestplate = new ItemNorthArmorPadded(ItemArmor.ArmorMaterial.DIAMOND, 3, 1);
    public static ItemNorthArmorPadded northDiamondLeggins = new ItemNorthArmorPadded(ItemArmor.ArmorMaterial.DIAMOND, 3, 2);
    public static ItemNorthArmorPadded northDiamondBoots = new ItemNorthArmorPadded(ItemArmor.ArmorMaterial.DIAMOND, 3, 3);
    public static ItemNorthArmorPadded northGoldHelmet = new ItemNorthArmorPadded(ItemArmor.ArmorMaterial.GOLD, 4, 0);
    public static ItemNorthArmorPadded northGoldChestplate = new ItemNorthArmorPadded(ItemArmor.ArmorMaterial.GOLD, 4, 1);
    public static ItemNorthArmorPadded northGoldLeggins = new ItemNorthArmorPadded(ItemArmor.ArmorMaterial.GOLD, 4, 2);
    public static ItemNorthArmorPadded northGoldBoots = new ItemNorthArmorPadded(ItemArmor.ArmorMaterial.GOLD, 4, 3);
    public static ItemFood glaciemStem = new ItemFood(0, 0, false).setPotionEffect(Potion.poison.id, 20, 0, 1.0F).setPotionEffect(Potion.hunger.id, 10, 0, 0.85F);
    public static ItemFood boiledGlaciemStem = new ItemFood(5, 0.7F, false);

    public static void registerItems(FMLInitializationEvent e, Register register){
        glaciemStem.setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
        boiledGlaciemStem.setCreativeTab(NorthrendCreativeTabs.tabNorthrend);

        register.registerItem(dragonbonePickaxe, "north_dragonbone_pickaxe", e);
        register.registerItem(mithrilPickaxe, "north_mithril_pickaxe", e);
        register.registerItem(mithrilSword, "north_mithril_sword", e);
        register.registerItem(mithrilAxe, "north_mithril_axe", e);
        register.registerItem(mithrilHoe, "north_mithril_hoe", e);
        register.registerItem(mithrilShovel, "north_mithril_shovel", e);
        register.registerItem(dragonbone, "north_dragonbone", e);
        register.registerItem(frostGem, "north_frost_gem", e);
        register.registerItem(mithrilIngot, "north_mithril_ingot", e);
        register.registerItem(northPearl, "north_pearl", e);
        register.registerItemWithTexture(northLeatherHelmet, "north_leather_helmet", "minecraft:leather_helmet", e);
        register.registerItemWithTexture(northLeatherChestplate, "north_leather_chestplate", "minecraft:leather_chestplate", e);
        register.registerItemWithTexture(northLeatherLeggins, "north_leather_leggins", "minecraft:leather_leggins", e);
        register.registerItemWithTexture(northLeatherBoots, "north_leather_boots", "minecraft:leather_boots", e);
        register.registerItemWithTexture(northChainmailHelmet, "north_chainmail_helmet", "minecraft:chainmail_helmet", e);
        register.registerItemWithTexture(northChainmailChestplate, "north_chainmail_chestplate", "minecraft:chainmail_chestplate", e);
        register.registerItemWithTexture(northChainmailLeggins, "north_chainmail_leggins", "minecraft:chainmail_leggins", e);
        register.registerItemWithTexture(northChainmailBoots, "north_chainmail_boots", "minecraft:chainmail_boots", e);
        register.registerItemWithTexture(northIronHelmet, "north_iron_helmet", "minecraft:iron_helmet", e);
        register.registerItemWithTexture(northIronChestplate, "north_iron_chestplate", "minecraft:iron_chestplate", e);
        register.registerItemWithTexture(northIronLeggins, "north_iron_leggins", "minecraft:iron_leggins", e);
        register.registerItemWithTexture(northIronBoots, "north_iron_boots", "minecraft:iron_boots", e);
        register.registerItemWithTexture(northDiamondHelmet, "north_diamond_helmet", "minecraft:diamond_helmet", e);
        register.registerItemWithTexture(northDiamondChestplate, "north_diamond_chestplate", "minecraft:diamond_chestplate", e);
        register.registerItemWithTexture(northDiamondLeggins, "north_diamond_leggins", "minecraft:diamond_leggins", e);
        register.registerItemWithTexture(northDiamondBoots, "north_diamond_boots", "minecraft:diamond_boots", e);
        register.registerItemWithTexture(northGoldHelmet, "north_gold_helmet", "minecraft:gold_helmet", e);
        register.registerItemWithTexture(northGoldChestplate, "north_gold_chestplate", "minecraft:gold_chestplate", e);
        register.registerItemWithTexture(northGoldLeggins, "north_gold_leggins", "minecraft:gold_leggins", e);
        register.registerItemWithTexture(northGoldBoots, "north_gold_boots", "minecraft:gold_boots", e);
        register.registerItem(glaciemStem, "north_glaciem_stem", e);
        register.registerItem(boiledGlaciemStem, "north_glaciem_stem_boiled", e);
    }
}
