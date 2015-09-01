package com.fuzzypickles14.CrystalSorcery.worldgen;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by toomz_000 on 5/14/2015.
 */
public class ModWorldRegister
{
    public static void MainRegistry()
    {
        registerWorldGen(new ModOreGen(), 1);
    }

    public static void registerWorldGen(IWorldGenerator iWorldGenerator, int probability)
    {
        GameRegistry.registerWorldGenerator(iWorldGenerator, probability);
    }
}
