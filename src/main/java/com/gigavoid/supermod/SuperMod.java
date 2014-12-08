package com.gigavoid.supermod;

import com.gigavoid.supermod.biome.SuperBiomes;
import com.gigavoid.supermod.block.SuperBlocks;
import com.gigavoid.supermod.entity.SuperEntities;
import com.gigavoid.supermod.events.SuperWorldEvents;
import com.gigavoid.supermod.gui.SuperGuiHandler;
import com.gigavoid.supermod.item.SuperItems;
import com.gigavoid.supermod.keybinding.SuperKeyBinds;
import com.gigavoid.supermod.recepies.SuperRecipie;
import com.gigavoid.supermod.recepies.SuperSmeltingRecipie;
import com.gigavoid.supermod.renderer.SuperRenderer;
import com.gigavoid.supermod.tileentity.SuperTileEntities;
import com.gigavoid.supermod.worldgen.SuperWorldGens;
import com.gigavoid.supermod.worldgen.northrend.WorldProviderNorthrend;
import com.gigavoid.supermod.worldgen.northrend.WorldTypeNorthrend;

import net.minecraft.client.Minecraft;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = SuperMod.MODID, version = SuperMod.VERSION)
public class SuperMod
{
    @Mod.Instance("supermod")
    public static SuperMod instance;

    public static final String MODID = "supermod";
    public static final String VERSION = "1.0";

    public static final int northrendDimID = 2;
    public static final WorldType northrend  = new WorldTypeNorthrend(7, "northrend");

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        SuperItems.initializeItems();
        SuperBiomes.registerBiomes();

        DimensionManager.registerProviderType(northrendDimID, WorldProviderNorthrend.class, false);
        DimensionManager.registerDimension(northrendDimID, northrendDimID);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        SuperBlocks.initializeBlocks();
        SuperRenderer.registerRenderers();
        SuperWorldGens.initializeWorldGens();
        SuperKeyBinds.registerKeybinds();
        SuperGuiHandler.initializeGuis();
        SuperRecipie.initializeRecipes();
        SuperSmeltingRecipie.InitializeSmektingRecipes();
        SuperEntities.registerEntities();
        SuperTileEntities.initializeEntities();
        MinecraftForge.EVENT_BUS.register(new SuperWorldEvents());
    }
}
