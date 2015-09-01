package com.fuzzypickles14.CrystalSorcery.init;

import com.fuzzypickles14.CrystalSorcery.CrystalSorcery;
import com.fuzzypickles14.CrystalSorcery.EnergySystem.Battery.Lvl1Battery;
import com.fuzzypickles14.CrystalSorcery.Reference;
import com.fuzzypickles14.CrystalSorcery.KnowledgeSystem.Codex;
import com.fuzzypickles14.CrystalSorcery.items.Wands.wandOfFlames;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by toomz_000 on 5/14/2015.
 */
public class ModItems
{
    public static Item nullCrystal;
    public static Item fireCrystal;
    public static Item waterCrystal;
    public static Item earthCrystal;
    public static Item airCrystal;
    public static Item lightCrystal;
    public static Item darkCrystal;
    public static Item lifeCrystal;
    public static Item deathCrystal;
    public static Lvl1Battery lvl1Battery;
    public static wandOfFlames WandOfFlames;
    public static Codex codex;

    public static void init()
    {
        nullCrystal = new Item().setUnlocalizedName("nullCrystal").setCreativeTab(CrystalSorcery.tabCrystal).setTextureName(Reference.MOD_ID + ":" + "nullCrystal");
        fireCrystal = new Item().setUnlocalizedName("fireCrystal").setCreativeTab(CrystalSorcery.tabCrystal).setTextureName(Reference.MOD_ID + ":" + "fireCrystal");
        waterCrystal = new Item().setUnlocalizedName("waterCrystal").setCreativeTab(CrystalSorcery.tabCrystal).setTextureName(Reference.MOD_ID + ":" + "waterCrystal");
        earthCrystal = new Item().setUnlocalizedName("earthCrystal").setCreativeTab(CrystalSorcery.tabCrystal).setTextureName(Reference.MOD_ID + ":" + "earthCrystal");
        airCrystal = new Item().setUnlocalizedName("airCrystal").setCreativeTab(CrystalSorcery.tabCrystal).setTextureName(Reference.MOD_ID + ":" + "airCrystal");
        lifeCrystal = new Item().setUnlocalizedName("lifeCrystal").setCreativeTab(CrystalSorcery.tabCrystal).setTextureName(Reference.MOD_ID + ":" + "lifeCrystal");
        deathCrystal = new Item().setUnlocalizedName("deathCrystal").setCreativeTab(CrystalSorcery.tabCrystal).setTextureName(Reference.MOD_ID + ":" + "deathCrystal");
        lightCrystal = new Item().setUnlocalizedName("lightCrystal").setCreativeTab(CrystalSorcery.tabCrystal).setTextureName(Reference.MOD_ID + ":" + "lightCrystal");
        darkCrystal = new Item().setUnlocalizedName("darkCrystal").setCreativeTab(CrystalSorcery.tabCrystal).setTextureName(Reference.MOD_ID + ":" + "darkCrystal");
        lvl1Battery = new Lvl1Battery();
        WandOfFlames = new wandOfFlames();
        codex = new Codex();
    }

    public static void register()
    {
        GameRegistry.registerItem(nullCrystal, "nullCrystal");
        GameRegistry.registerItem(fireCrystal, "fireCrystal");
        GameRegistry.registerItem(waterCrystal, "waterCrystal");
        GameRegistry.registerItem(earthCrystal, "earthCrystal");
        GameRegistry.registerItem(airCrystal, "airCrystal");
        GameRegistry.registerItem(lightCrystal, "lightCrystal");
        GameRegistry.registerItem(darkCrystal, "darkCrytsal");
        GameRegistry.registerItem(lifeCrystal, "lifeCrystal");
        GameRegistry.registerItem(deathCrystal, "deathCrystal");
        GameRegistry.registerItem(lvl1Battery, "lvl1Battery");
        GameRegistry.registerItem(WandOfFlames, "wandOfFlames");
        GameRegistry.registerItem(codex, "Summoner'sCodex");
    }
}
