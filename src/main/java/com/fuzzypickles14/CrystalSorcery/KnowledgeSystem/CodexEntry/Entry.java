package com.fuzzypickles14.CrystalSorcery.KnowledgeSystem.CodexEntry;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * Created by toomz_000 on 7/3/2015.
 */
public class Entry
{
    public final String name;
    public final String type;
    public String[] parents = null;
    public String[] parentsHidden = null;
    public String[] siblings = null;
    public final int displayColumn;
    public final int displayRow;
    public final ItemStack icon_item;
    public final ResourceLocation icon_resource;
    private int complexity;
    private boolean isSpecial;
    private boolean isSecondary;
    private boolean isRound;
    private boolean isStub;
    private boolean isVirtual;




    public Entry(String name, String type)
    {
        this.name = name;
        this.type = type;
        this.icon_resource = null;
        this.icon_item = null;
        this.displayColumn = 0;
        this.displayRow = 0;
    }

    public String getName()
    {
        return this.name;
    }
    public boolean isVirtual()
    {
        return this.isVirtual;
    }
}
