package com.fuzzypickles14.CrystalSorcery.EnergySystem.Battery;

import com.fuzzypickles14.CrystalSorcery.util.Energies;

/**
 * Created by toomz_000 on 6/14/2015.
 */
public class Lvl2Battery extends CommonBattery {
    @Override
    public int getCapacity(Energies type) {
        return 0;
    }

    @Override
    public double getDiscountRate() {
        return 0;
    }

    @Override
    public void setDiscountRate(int rate) {

    }

    @Override
    public void drainEnergy(Energies type, int amount) {

    }

    @Override
    public void fillEnergy(Energies type, int amount) {

    }

    @Override
    public boolean canDrain(Energies type, int amount) {
        return false;
    }

    @Override
    public boolean canFill(Energies type) {
        return false;
    }
}
