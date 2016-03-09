package com.gigavoid.supermod.northrend.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidNorthPoison extends Fluid {

    public static final String name = "poison_fluid";
    public static final FluidNorthPoison instance = new FluidNorthPoison();

    private FluidNorthPoison()
    {
        super(name, new ResourceLocation("supermod:blocks/poison_fluid_still"), new ResourceLocation("supermod:blocks/poison_fluid_flow"));
    }
}

