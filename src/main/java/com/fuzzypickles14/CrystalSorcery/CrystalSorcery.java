package com.fuzzypickles14.CrystalSorcery;

import com.fuzzypickles14.CrystalSorcery.init.ModBlocks;
import com.fuzzypickles14.CrystalSorcery.init.ModItems;
import com.fuzzypickles14.CrystalSorcery.proxy.ClientProxy;
import com.fuzzypickles14.CrystalSorcery.proxy.CommonProxy;
import com.fuzzypickles14.CrystalSorcery.worldgen.ModWorldRegister;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by toomz_000 on 5/14/2015.
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class CrystalSorcery
{
    public static final int guiIDFireReceptacle = 1;
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static ClientProxy proxy;

    @Mod.Instance(Reference.MOD_ID)
    public static CrystalSorcery instance;

    public static final CrystalSorceryTab tabCrystal = new CrystalSorceryTab("tabCrystal");




    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModItems.init();
        ModItems.register();
        ModBlocks.init();
        ModBlocks.register();
        ModWorldRegister.MainRegistry();

    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {

        proxy.registerTileEntities();
        proxy.initRenders();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
