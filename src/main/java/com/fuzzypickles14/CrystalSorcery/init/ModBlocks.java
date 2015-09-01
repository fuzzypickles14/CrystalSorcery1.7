package com.fuzzypickles14.CrystalSorcery.init;

import com.fuzzypickles14.CrystalSorcery.CrystalSorcery;
import com.fuzzypickles14.CrystalSorcery.Reference;
import com.fuzzypickles14.CrystalSorcery.blocks.Crux.BlockCrux;
import com.fuzzypickles14.CrystalSorcery.blocks.Crux.FireEnergyCrux;
import com.fuzzypickles14.CrystalSorcery.blocks.Ores.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;

/**
 * Created by toomz_000 on 5/14/2015.
 */
public class ModBlocks
{
    public static BlockOre crystalOre;
    public static BlockOre fireCrystalOre;
    public static BlockOre waterCrystalOre;
    public static BlockOre earthCrystalOre;
    public static BlockOre airCrystalOre;
    public static BlockOre lightCrystalOre;
    public static BlockOre darkCrystalOre;
    public static BlockCrux fireCrux;

    public static void init()
    {
        crystalOre = (BlockOre)new CrystalOre().setCreativeTab(CrystalSorcery.tabCrystal).setBlockName("crystalOre").setBlockTextureName(Reference.MOD_ID + ":" + "crystalOre");
        fireCrystalOre = (BlockOre)new FireCrystalOre().setCreativeTab(CrystalSorcery.tabCrystal).setBlockName("fireCrystalOre").setBlockTextureName(Reference.MOD_ID + ":" + "fireCrystalOre");
        waterCrystalOre = (BlockOre)new WaterCrystalOre().setCreativeTab(CrystalSorcery.tabCrystal).setBlockName("waterCrystalOre").setBlockTextureName(Reference.MOD_ID + ":" + "waterCrystalOre");
        earthCrystalOre = (BlockOre)new EarthCrystalOre().setCreativeTab(CrystalSorcery.tabCrystal).setBlockName("earthCrystalOre").setBlockTextureName(Reference.MOD_ID + ":" + "earthCrystalOre");
        airCrystalOre = (BlockOre)new AirCrystalOre().setCreativeTab(CrystalSorcery.tabCrystal).setBlockName("airCrystalOre").setBlockTextureName(Reference.MOD_ID + ":" + "airCrystalOre");
        lightCrystalOre = (BlockOre)new LightCrystalOre().setCreativeTab(CrystalSorcery.tabCrystal).setBlockName("lightCrystalOre").setBlockTextureName(Reference.MOD_ID + ":" + "lightCrystalOre");
        darkCrystalOre = (BlockOre)new DarkCrystalOre().setCreativeTab(CrystalSorcery.tabCrystal).setBlockName("darkCrystalOre").setBlockTextureName(Reference.MOD_ID + ":" + "darkCrystalOre");
        fireCrux = new FireEnergyCrux(Material.anvil);

    }

    public static void register()
    {
        GameRegistry.registerBlock(crystalOre, "crystalOre");
        GameRegistry.registerBlock(fireCrystalOre, "fireCrystalOre");
        GameRegistry.registerBlock(earthCrystalOre, "earthCrystalOre");
        GameRegistry.registerBlock(waterCrystalOre, "waterCrystalOre");
        GameRegistry.registerBlock(airCrystalOre, "airCrystalOre");
        GameRegistry.registerBlock(lightCrystalOre, "lightCrystalOre");
        GameRegistry.registerBlock(darkCrystalOre, "darkCrystalOre");
        GameRegistry.registerBlock(fireCrux, "fireCrux");

    }
}
