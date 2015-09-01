package com.fuzzypickles14.CrystalSorcery.util;

import java.util.LinkedHashMap;

/**
 * Created by toomz_000 on 6/15/2015.
 */
public class EnergyList
{
    public LinkedHashMap<Energies, Integer> energies = new LinkedHashMap<Energies, Integer>();

    public EnergyList addEnergy(Energies energy, int amount)
    {
        if(this.energies.containsKey(energy))
        {
              int previous = this.energies.get(energy).intValue();
              amount += previous;
        }
        this.energies.put(energy, amount);
        return this;
    }
}
