package com.fuzzypickles14.CrystalSorcery.util;

import java.util.LinkedHashMap;

/**
 * Created by toomz_000 on 6/14/2015.
 */
public class Energies
{
    String name;
    int color;
    Energies[] components;

    public Energies(String name, int color)
    {
        this.name = name;
        this.color = color;
    }

    public Energies(String name, int color, Energies[] components)
    {
        this.name = name;
        this.color = color;
        this.components = components;
    }

    public String getName()
    {
        return name;
    }

    public int getColor()
    {
        return color;
    }

    public Energies[] getComponents()
    {
        return components;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setColor(int color)
    {
        this.color = color;
    }

    public void setComponents(Energies[] components)
    {
        this.components  = components;
    }

    public static LinkedHashMap<String, Energies> energies = new LinkedHashMap<String, Energies>();
    public static final Energies FIRE = new Energies("fire", 16734721);
    public static final Energies WATER = new Energies("water", 3986684);
    public static final Energies EARTH = new Energies("earth", 5685248);
    public static final Energies AIR = new Energies("air", 16777086);
}
