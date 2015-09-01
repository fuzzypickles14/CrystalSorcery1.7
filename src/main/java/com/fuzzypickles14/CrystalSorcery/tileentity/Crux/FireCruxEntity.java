package com.fuzzypickles14.CrystalSorcery.tileentity.Crux;

/**
 * Created by toomz_000 on 5/15/2015.
 */
public class FireCruxEntity extends CruxEntity
{
    private double maxEnergy;
    private double energy;
    private int level;
    private int rate;
    private int range;
    private int energyScale;
    private int rateScale;
    private int rangeScale;


    public FireCruxEntity()
    {
        level = 1;
        rate = 1;
        range = 16;
        maxEnergy = 1000;
        energy = 0;
        energyScale = 1;
        rateScale = 1;
        rangeScale = 1;
    }


    @Override
    public void setLevel(int level) {

    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public void setEnergy(double energy) {

    }

    @Override
    public void generateEnergy()
    {
        checkTicks();
        if(isBound())
        {
            if(this.energy < maxEnergy)
            {
                double energyToAdd = 20;

                if((this.ticks * rate) % 40L == 0L)
                {
                    this.energy += energyToAdd;
                }
            }
        }
    }


    @Override
    public void consumeEnergy(double energy) {

    }

    @Override
    public void findAcceptor() {

    }


    @Override
    public int getRechargeRate() {
        return rate;
    }

    @Override
    public void setRechargeRate(int i) {

    }

    @Override
    public boolean isBound() {
        return false;
    }

    @Override
    public boolean isValidAcceptor() {
        return false;
    }

    public void updateEntity()
    {
        if(!this.worldObj.isRemote)
        {
            generateEnergy();
        }
    }
}
