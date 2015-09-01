package com.fuzzypickles14.CrystalSorcery.EnergySystem.Battery;

import com.fuzzypickles14.CrystalSorcery.CrystalSorcery;
import com.fuzzypickles14.CrystalSorcery.Reference;
import com.fuzzypickles14.CrystalSorcery.util.Energies;
import com.fuzzypickles14.CrystalSorcery.util.EnergyList;



/**
 * Created by toomz_000 on 6/14/2015.
 */
public class Lvl1Battery extends CommonBattery
{
    private int totalCapacity;
    private int fireCapacity, waterCapacity, earthCapacity, airCapacity;
    private double discountRate;
    private EnergyList eList = new EnergyList();
    public Lvl1Battery()
    {
        super();
        this.setUnlocalizedName("lvl1Battery");
        this.setTextureName(Reference.MOD_ID + ":" + "lvl1Battery");
        this.totalCapacity = 200;
        this.discountRate = 1.1;


        fireCapacity = totalCapacity / 4;
        waterCapacity = totalCapacity / 4;
        earthCapacity = totalCapacity / 4;
        airCapacity = totalCapacity / 4;


        eList.addEnergy(Energies.FIRE, fireCapacity);
        eList.addEnergy(Energies.WATER, waterCapacity);
        eList.addEnergy(Energies.EARTH, earthCapacity);
        eList.addEnergy(Energies.AIR,airCapacity);
    }

    @Override
    public int getCapacity(Energies type) {
        return eList.energies.get(type);
    }

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(int rate)
    {
        discountRate = rate;
    }

    @Override
    public void drainEnergy(Energies type, int amount)
    {
        int current = eList.energies.get(type);
        int newAmount = current -= amount;
        eList.energies.replace(type, current, newAmount );

    }

    @Override
    public void fillEnergy(Energies type, int amount)
    {
        int current = eList.energies.get(type);
        int newAmount = current += amount;
        eList.energies.replace(type, current, newAmount );
    }

    @Override
    public boolean canDrain(Energies type, int amount) {
        return eList.energies.get(type) >= amount;
    }

    @Override
    public boolean canFill(Energies type) {
        return eList.energies.get(type) <= getCapacity(type);
    }
}
