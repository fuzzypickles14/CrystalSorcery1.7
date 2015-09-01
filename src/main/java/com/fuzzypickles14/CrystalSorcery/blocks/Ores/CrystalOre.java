package com.fuzzypickles14.CrystalSorcery.blocks.Ores;

import com.fuzzypickles14.CrystalSorcery.init.ModBlocks;
import com.fuzzypickles14.CrystalSorcery.init.ModItems;
import net.minecraft.block.BlockOre;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by toomz_000 on 5/14/2015.
 */
public class CrystalOre extends BlockOre
{
    public CrystalOre()
    {
        this.setHardness(5.0f);
    }
    public Item getItemDropped(Random rand, int fortune)
    {
        return this == ModBlocks.crystalOre ? ModItems.nullCrystal: Item.getItemFromBlock(this);
    }

    public int quantityDropped(Random random)
    {
        return random.nextInt(3) + 1;
    }

    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(random, fortune))
        {
            int j = random.nextInt(fortune + 2) - 1;

            if (j < 0)
            {
                j = 0;
            }

            return this.quantityDropped(random) * (j + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }
}
