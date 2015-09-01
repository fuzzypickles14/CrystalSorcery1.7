package com.fuzzypickles14.CrystalSorcery.EnergySystem.Battery;

import com.fuzzypickles14.CrystalSorcery.CrystalSorcery;
import com.fuzzypickles14.CrystalSorcery.util.Energies;
import net.minecraft.item.Item;

/**
 * Created by toomz_000 on 6/14/2015.
 */
public abstract class CommonBattery extends Item
{

    public CommonBattery()
    {
        this.setCreativeTab(CrystalSorcery.tabCrystal);
        this.setMaxStackSize(1);
    }
    public abstract int getCapacity(Energies type);


    public abstract double getDiscountRate();


    public abstract void setDiscountRate(int rate);


    public abstract void drainEnergy(Energies type, int amount);


    public abstract void fillEnergy(Energies type, int amount);

    public abstract boolean canDrain(Energies type, int amount);

    public abstract boolean canFill(Energies type);



}
