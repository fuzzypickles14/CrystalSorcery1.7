package com.fuzzypickles14.CrystalSorcery.proxy;


import com.fuzzypickles14.CrystalSorcery.render.fireCruxBlockRender;
import com.fuzzypickles14.CrystalSorcery.render.fireCruxRender;
import com.fuzzypickles14.CrystalSorcery.tileentity.Crux.FireCruxEntity;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * Created by toomz_000 on 5/14/2015.
 */
public class ClientProxy extends CommonProxy
{
    public void initRenders()
    {
        RenderingRegistry.registerBlockHandler(new fireCruxBlockRender());
        ClientRegistry.bindTileEntitySpecialRenderer(FireCruxEntity.class, new fireCruxRender());
    }
}
