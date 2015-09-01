package com.fuzzypickles14.CrystalSorcery.render;

import com.fuzzypickles14.CrystalSorcery.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

/**
 * Created by toomz_000 on 5/18/2015.
 */
public class fireCruxModelRender
{
    private IModelCustom model;
    private String obj = Reference.MOD_ID + ":models/fireCruxTest.obj";
    public fireCruxModelRender()
    {
        model = AdvancedModelLoader.loadModel(new ResourceLocation(obj));
    }

    public void renderCrystal()
    {
        model.renderPart("Cube");
    }
}
