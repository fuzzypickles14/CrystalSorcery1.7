package com.fuzzypickles14.CrystalSorcery.KnowledgeSystem;

import com.fuzzypickles14.CrystalSorcery.CrystalSorcery;
import com.fuzzypickles14.CrystalSorcery.Reference;
import net.minecraft.item.Item;

/**
 * Created by toomz_000 on 7/3/2015.
 */
public class Codex extends Item implements ICodex
{
    public Codex()
    {
        this.setMaxStackSize(1);
        this.setTextureName(Reference.MOD_ID +  ":" + "summonersCodex");
        this.setUnlocalizedName("SummonersCodex");
        this.setCreativeTab(CrystalSorcery.tabCrystal);
    }


}
