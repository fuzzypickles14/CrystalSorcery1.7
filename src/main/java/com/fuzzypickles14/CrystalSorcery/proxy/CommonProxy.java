package com.fuzzypickles14.CrystalSorcery.proxy;

import com.fuzzypickles14.CrystalSorcery.tileentity.Crux.FireCruxEntity;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by toomz_000 on 5/14/2015.
 */
public class CommonProxy
{
    public void registerTileEntities()
    {
        GameRegistry.registerTileEntity(FireCruxEntity.class,"fireCruxEntity");
    }
}
