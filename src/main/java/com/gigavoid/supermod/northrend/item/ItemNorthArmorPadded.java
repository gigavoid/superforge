package com.gigavoid.supermod.northrend.item;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import net.minecraft.item.ItemArmor;

public class ItemNorthArmorPadded extends ItemArmor {
    public ItemNorthArmorPadded(ItemArmor.ArmorMaterial material, int renderIndex, int armorType){
        super(material, renderIndex, armorType);
        this.setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
    }
}
