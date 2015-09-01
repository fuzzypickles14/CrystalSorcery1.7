package com.fuzzypickles14.CrystalSorcery;

import com.fuzzypickles14.CrystalSorcery.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by toomz_000 on 5/14/2015.
 */
public class CrystalSorceryTab extends CreativeTabs
{
    public CrystalSorceryTab(String label) {
        super(label);

    }

    @Override
    public Item getTabIconItem() {
        return ModItems.nullCrystal;
    }
}
