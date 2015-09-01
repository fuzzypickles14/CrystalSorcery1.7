package com.fuzzypickles14.CrystalSorcery.handler;

import com.fuzzypickles14.CrystalSorcery.EnergySystem.Battery.CommonBattery;
import com.fuzzypickles14.CrystalSorcery.items.Wands.IWand;
import com.fuzzypickles14.CrystalSorcery.util.Energies;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

/**
 * Created by toomz_000 on 6/17/2015.
 */
public final class BatteryItemHandler
{
    public static int drainEnergyFromTab(Energies energy, ItemStack itemStack, EntityPlayer player, int amount, boolean remove)
    {
        if(itemStack == null)
        {
            return 0;
        }

        IInventory playerInv = player.inventory;
        int invSize = playerInv.getSizeInventory();

        for (int i = 0; i < invSize; i++)
        {
            ItemStack itemInSlot = playerInv.getStackInSlot(i);

            if(itemInSlot == itemStack)
            {
                continue;
            }

            if(itemInSlot != null && itemInSlot.getItem() instanceof CommonBattery)
            {
                CommonBattery battery = (CommonBattery) itemInSlot.getItem();
                if(battery.canDrain(energy, amount))
                {
                    if(itemStack.getItem() instanceof IWand)
                        continue;

                    int amountToDrain = amount;

                    if(remove)
                        battery.drainEnergy(energy, amountToDrain);

                    return amountToDrain;

                }
            }

        }

    return 0;
    }

    public static boolean drainEnergyExact(Energies energy, ItemStack stack, EntityPlayer player, int amount, boolean remove) {
        if(stack == null)
            return false;

        IInventory playerInv = player.inventory;

        int invSize = playerInv.getSizeInventory();
        int size = invSize;

        for(int i = 0; i < size; i++)
        {
            ItemStack itemInSlot = playerInv.getStackInSlot(i);
            if(itemInSlot == stack)
                continue;

            if(itemInSlot != null && itemInSlot.getItem() instanceof CommonBattery) {
                CommonBattery battery = (CommonBattery) itemInSlot.getItem();
                if(battery.canDrain(energy, amount) && battery.getCapacity(energy) > amount) {
                    if(stack.getItem() instanceof CommonBattery && !((CommonBattery) stack.getItem()).canDrain(energy, amount))
                        continue;

                    if(remove)
                        battery.drainEnergy(energy, amount);

                    return true;
                }
            }
        }

        return false;
    }
}
