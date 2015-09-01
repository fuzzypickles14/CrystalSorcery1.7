package com.fuzzypickles14.CrystalSorcery.KnowledgeSystem.CodexEntry;

import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by toomz_000 on 7/4/2015.
 */
public class EntryCategoryList
{
    public int minDisplayColumn;
    public int minDisplayRow;
    public int maxDisplayColumn;
    public int maxDisplayRow;
    public ResourceLocation icon;
    public ResourceLocation background;

    public EntryCategoryList(ResourceLocation icon, ResourceLocation background)
    {
        this.icon = icon;
        this.background = background;
    }

    public Map<String, Entry> entries = new HashMap();

}
