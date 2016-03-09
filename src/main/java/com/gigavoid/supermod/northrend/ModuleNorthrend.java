package com.gigavoid.supermod.northrend;

import com.gigavoid.supermod.common.Register;
import com.gigavoid.supermod.common.module.Module;
import com.gigavoid.supermod.common.util.Reflection;
import com.gigavoid.supermod.northrend.biome.NorthrendBiomes;
import com.gigavoid.supermod.northrend.block.BlockNorthPoisonFluid;
import com.gigavoid.supermod.northrend.block.BlockNorthSnowModded;
import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import com.gigavoid.supermod.northrend.entity.NorthrendEntities;
import com.gigavoid.supermod.northrend.fluids.FluidNorthPoison;
import com.gigavoid.supermod.northrend.handler.ModelBakeHandler;
import com.gigavoid.supermod.northrend.handler.NorthrendEventHandler;
import com.gigavoid.supermod.northrend.item.NorthrendItems;
import com.gigavoid.supermod.northrend.recipe.NorthrendRecipies;
import com.gigavoid.supermod.northrend.renderer.NorthrendRenderers;
import com.gigavoid.supermod.northrend.worldgen.custom.NorthrendWorldProvider;
import com.gigavoid.supermod.northrend.worldgen.gen.NorthrendMapGenFortress;
import com.gigavoid.supermod.northrend.worldgen.gen.NorthrendMapGenOres;
import com.gigavoid.supermod.northrend.worldgen.gen.NorthrendMapGenVillage;
import com.gigavoid.supermod.northrend.worldgen.structures.NorthrendStructureFortressPieces;
import com.gigavoid.supermod.northrend.worldgen.structures.NorthrendStructureMineshaftPieces;
import com.gigavoid.supermod.northrend.worldgen.structures.NorthrendStructureMineshaftStart;
import com.gigavoid.supermod.northrend.worldgen.structures.NorthrendStructureVillagePieces;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.RegistryNamespacedDefaultedByKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class ModuleNorthrend extends Module {
    @SidedProxy(serverSide = "com.gigavoid.supermod.northrend.ModuleNorthrend$CommonProxy", clientSide = "com.gigavoid.supermod.northrend.ModuleNorthrend$ClientProxy")
    public static CommonProxy proxy;

    public static int dimensionId;
    public static final DamageSource freeze = (new DamageSource("freeze")).setDamageBypassesArmor();
    public static final DamageSource frostattack = (new DamageSource("frostattack")).setDamageBypassesArmor();

    @Override
    public void preInit(FMLPreInitializationEvent e) {proxy.preInit(e, getRegister(e.getSide()));}

    public static class CommonProxy {
        public void preInit(FMLPreInitializationEvent e, Register register) {
            if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
                MinecraftForge.EVENT_BUS.register(new ModelBakeHandler());
            }

            FluidRegistry.registerFluid(FluidNorthPoison.instance);
            GameRegistry.registerBlock(BlockNorthPoisonFluid.instance, BlockNorthPoisonFluid.name);

            NorthrendEventHandler northendEventHandler = new NorthrendEventHandler();
            FMLCommonHandler.instance().bus().register(northendEventHandler);
            MinecraftForge.EVENT_BUS.register(northendEventHandler);

            NorthrendEntities.registerEntities(register);
            NorthrendBiomes.registerBiomes(register);

            dimensionId = register.registerDimension(NorthrendWorldProvider.class, false);
            register.registerWorldGenerator(new NorthrendMapGenOres(), 20);
        }
    }

    public static class ClientProxy extends CommonProxy {
        private static ModelResourceLocation fluidLocation = new ModelResourceLocation("supermod:" + BlockNorthPoisonFluid.name, "fluid");

        @Override
        public void preInit(FMLPreInitializationEvent e, Register register){
            super.preInit(e, register);
            Item fluid = Item.getItemFromBlock(BlockNorthPoisonFluid.instance);
            ModelBakery.addVariantName(fluid);

            ModelLoader.setCustomMeshDefinition(fluid, new ItemMeshDefinition() {
                public ModelResourceLocation getModelLocation(ItemStack stack) {
                    return fluidLocation;
                }
            });
            ModelLoader.setCustomStateMapper(BlockNorthPoisonFluid.instance, new StateMapperBase() {
                protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                    return fluidLocation;
                }
            });
        }
    }

    @Override
    public void init(FMLInitializationEvent e){
        NorthrendBlocks.registerBlocks(getRegister(e.getSide()));
        NorthrendItems.registerItems(e, getRegister(e.getSide()));
        NorthrendRecipies.registerRecipies();

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            NorthrendRenderers.registerRenderers();
        }

        MapGenStructureIO.registerStructure(NorthrendMapGenFortress.Start.class, "Northrend Fortress");
        MapGenStructureIO.registerStructure(NorthrendMapGenVillage.Start.class, "Northrend Village");
        MapGenStructureIO.registerStructure(NorthrendStructureMineshaftStart.class, "Northrend Mineshaft");
        NorthrendStructureFortressPieces.registerNetherFortressPieces();
        NorthrendStructureVillagePieces.registerVillagePieces();
        NorthrendStructureMineshaftPieces.registerStructurePieces();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        /*RegistryNamespacedDefaultedByKey moddedBlockRegistry = net.minecraftforge.fml.common.registry.GameData.getBlockRegistry();
        Reflection.getFieldValue("blockRegistry", Block.class, moddedBlockRegistry);
        moddedBlockRegistry.register(78, new ResourceLocation("snow_layer"), BlockNorthSnowModded.instance);
        Reflection.setFieldValue("blockRegistry", Block.class, moddedBlockRegistry);*/
    }
}
