package com.fuzzypickles14.CrystalSorcery.worldgen;

import com.fuzzypickles14.CrystalSorcery.init.ModBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

/**
 * Created by toomz_000 on 5/14/2015.
 */
public class ModOreGen implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId)
        {
            case -1:
                GenerateNether(world, chunkX * 16, chunkZ * 16, random);
                break;
            case 0:
                GenerateOverworld(world, chunkX * 16, chunkZ * 16, random);
                break;
            case 1:
                GenerateEnd(world, chunkX * 16, chunkZ * 16, random);
                break;
        }
    }

    private void addOre(Block block, Block spawn, Random random, World world, int x, int z, int minY, int maxY, int minVein, int maxVein, int chance)
    {
        for(int i = 0; i < chance; i++)
        {
            int chunkSize = 16;

            int xCoord = x + random.nextInt(chunkSize);
            int zCoord = z + random.nextInt(chunkSize);
            int yCoord = minY + random.nextInt(maxY - minY);

            new WorldGenMinable(block, maxVein).generate(world, random, xCoord, yCoord, zCoord);
        }
    }
    private void GenerateEnd(World world, int i, int i1, Random random) {

    }

    private void GenerateOverworld(World world, int i, int j, Random random)
    {

        addOre(ModBlocks.crystalOre, Blocks.stone, random, world, i, j, 15, 100, 4, 8, 60 );
        addOre(ModBlocks.fireCrystalOre, Blocks.stone, random, world, i, j, 15, 100, 4, 8, 60 );
        addOre(ModBlocks.earthCrystalOre, Blocks.stone, random, world, i, j, 15, 100, 4, 8, 60 );
        addOre(ModBlocks.waterCrystalOre, Blocks.stone, random, world, i, j, 15, 100, 4, 8, 60 );
        addOre(ModBlocks.airCrystalOre, Blocks.stone, random, world, i, j, 15, 100, 4, 8, 60 );
        addOre(ModBlocks.lightCrystalOre, Blocks.stone, random, world, i, j, 5, 20, 1, 3, 20 );
        addOre(ModBlocks.darkCrystalOre, Blocks.stone, random, world, i, j, 5, 20, 1, 3, 20 );

    }

    private void GenerateNether(World world, int i, int i1, Random random) {


    }
}
