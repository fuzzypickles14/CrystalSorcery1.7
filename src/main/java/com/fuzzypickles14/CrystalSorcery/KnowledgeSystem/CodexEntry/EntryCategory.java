package com.fuzzypickles14.CrystalSorcery.KnowledgeSystem.CodexEntry;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.apache.logging.log4j.Level;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by toomz_000 on 7/3/2015.
 */
public final class EntryCategory implements Comparable<EntryCategory>
{
    public static LinkedHashMap<String, EntryCategoryList> researchCategories = new LinkedHashMap();
    public static List<EntryCategory> categories = new ArrayList<EntryCategory>();

    private String categoryName;
    private ItemStack itemIcon;


    public static EntryCategoryList getResearchList(String key)
    {
        return (EntryCategoryList)researchCategories.get(key);
    }

    public static String getCategoryName(String key)
    {
        return StatCollector.translateToLocal("tc.research_category." + key);
    }

    public static Entry getResearch(String key)
    {
        Collection rc = researchCategories.values();
        for (Object cat : rc)
        {
            Collection rl = ((EntryCategoryList)cat).entries.values();
            for (Object ri : rl) {
                if (((Entry)ri).name.equals(key)) {
                    return (Entry)ri;
                }
            }
        }
        return null;
    }

    public static void registerCategory(String key, ResourceLocation icon, ResourceLocation background)
    {
        if (getResearchList(key) == null)
        {
            EntryCategoryList rl = new EntryCategoryList(icon, background);
            researchCategories.put(key, rl);
        }
    }

    public static void addResearch(Entry ri)
    {
        EntryCategoryList rl = getResearchList(ri.type);
        if ((rl != null) && (!rl.entries.containsKey(ri.name)))
        {
            if (!ri.isVirtual()) {
                for (Entry rr : rl.entries.values()) {
                    if ((rr.displayColumn == ri.displayColumn) && (rr.displayRow == ri.displayRow))
                    {
                        FMLLog.log(Level.FATAL, "[Thaumcraft] Research [" + ri.getName() + "] not added as it overlaps with existing research [" + rr.getName() + "]", new Object[0]);
                        return;
                    }
                }
            }
            rl.entries.put(ri.name, ri);
            if (ri.displayColumn < rl.minDisplayColumn) {
                rl.minDisplayColumn = ri.displayColumn;
            }
            if (ri.displayRow < rl.minDisplayRow) {
                rl.minDisplayRow = ri.displayRow;
            }
            if (ri.displayColumn > rl.maxDisplayColumn) {
                rl.maxDisplayColumn = ri.displayColumn;
            }
            if (ri.displayRow > rl.maxDisplayRow) {
                rl.maxDisplayRow = ri.displayRow;
            }
        }
    }

    public static List<EntryCategory> getAllCategories()
    {
        return categories;
    }

    @Override
    public int compareTo(EntryCategory o) {
        return 0;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public EntryCategory setIcon(ItemStack itemIcon) {
        this.itemIcon = itemIcon;
        return this;
    }

    public ItemStack getItemIcon()
    {
        return itemIcon;
    }
}
