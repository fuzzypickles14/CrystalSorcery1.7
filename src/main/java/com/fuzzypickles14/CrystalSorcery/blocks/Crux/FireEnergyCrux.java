package com.fuzzypickles14.CrystalSorcery.blocks.Crux;

import com.fuzzypickles14.CrystalSorcery.Reference;
import com.fuzzypickles14.CrystalSorcery.tileentity.Crux.FireCruxEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by toomz_000 on 5/15/2015.
 */
public class FireEnergyCrux extends BlockCrux
{

    public FireEnergyCrux(Material p_i45386_1_)
    {
        super(p_i45386_1_);
        this.setBlockName("fireEnergyCrux");

    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new FireCruxEntity();
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }


}
