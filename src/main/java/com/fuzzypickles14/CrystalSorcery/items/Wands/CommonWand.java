package com.fuzzypickles14.CrystalSorcery.items.Wands;

import com.fuzzypickles14.CrystalSorcery.CrystalSorcery;
import com.fuzzypickles14.CrystalSorcery.Reference;
import net.minecraft.item.Item;

/**
 * Created by toomz_000 on 6/15/2015.
 */
public class CommonWand extends Item implements IWand
{
      public CommonWand()
      {
          this.setUnlocalizedName(getClass().toString());
          this.setCreativeTab(CrystalSorcery.tabCrystal);

      }
}
