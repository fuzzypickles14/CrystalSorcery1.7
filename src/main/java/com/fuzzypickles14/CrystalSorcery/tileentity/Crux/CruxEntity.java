package com.fuzzypickles14.CrystalSorcery.tileentity.Crux;

import net.minecraft.tileentity.TileEntity;

/**
 * Created by toomz_000 on 5/16/2015.
 */
public abstract class CruxEntity extends TileEntity
{
    public abstract void setLevel(int level);

    public abstract int getLevel();

    public abstract double getEnergy();

    public abstract void setEnergy(double energy);

    public abstract void generateEnergy();

    public abstract void consumeEnergy(double energy);

    public abstract void findAcceptor();

    public abstract int getRechargeRate();

    public abstract void setRechargeRate(int i);

    public abstract boolean isBound();

    public abstract boolean isValidAcceptor();

    protected long ticks = 0L;

    public void checkTicks()
    {
        if(this.ticks >= 9223372036854775807L)
        {
            this.ticks = 1L;
        }
        this.ticks += 1L;
    }

}
