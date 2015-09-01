package com.fuzzypickles14.CrystalSorcery.blocks.Crux;

import com.fuzzypickles14.CrystalSorcery.CrystalSorcery;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

/**
 * Created by toomz_000 on 5/15/2015.
 */
public abstract class BlockCrux extends BlockContainer
{
    protected BlockCrux(Material p_i45386_1_)
    {
        super(p_i45386_1_);
        this.setLightLevel(5.0F);
        this.setCreativeTab(CrystalSorcery.tabCrystal);
        this.setHardness(2.0F);
        this.setHarvestLevel("pickaxe", 2);
    }





}
