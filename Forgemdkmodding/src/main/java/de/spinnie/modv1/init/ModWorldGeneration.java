package de.spinnie.modv1.init;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkGeneratorDebug;
import net.minecraft.world.gen.ChunkGeneratorOverworld;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGeneration implements IWorldGenerator {
	
	private final WorldGenMinable modblockgen = new WorldGenMinable(ModBlocks.modblock.getDefaultState(), 5, (blockstate) -> blockstate.getBlock() == Blocks.AIR);

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		BlockPos chunkPos = new BlockPos(chunkX * 16, 0, chunkZ * 16);
		
		if(chunkGenerator instanceof ChunkGeneratorOverworld) {
			genOreMinMax(world, random, chunkPos, 5, modblockgen, 100, 120);
			
			genOreCenterSpread(world, random, chunkPos, 10, modblockgen, 200, 5);
 
	}

}
	
	 /**
     * Standard ore generation helper. Vanilla uses this to generate most ores.
     * The main difference between this and {@link #genStandardOre2} is that this takes min and max heights, while
     * genStandardOre2 takes center and spread.
     */
    protected void genOreMinMax(World worldIn, Random random,BlockPos chunkPos, int blockCount, WorldGenerator generator, int minHeight, int maxHeight)
    {
        if (maxHeight < minHeight)
        {
            int i = minHeight;
            minHeight = maxHeight;
            maxHeight = i;
        }
        else if (maxHeight == minHeight)
        {
            if (minHeight < 255)
            {
                ++maxHeight;
            }
            else
            {
                --minHeight;
            }
        }

        for (int j = 0; j < blockCount; ++j)
        {
            BlockPos blockpos = chunkPos.add(random.nextInt(16), random.nextInt(maxHeight - minHeight) + minHeight, random.nextInt(16));
            generator.generate(worldIn, random, blockpos);
        }
    }

    /**
     * Standard ore generation helper. Vanilla uses this to generate Lapis Lazuli.
     * The main difference between this and {@link #genStandardOre1} is that this takes takes center and spread, while
     * genStandardOre1 takes min and max heights.
     */
    protected void genOreCenterSpread(World worldIn, Random random, BlockPos chunkPos, int blockCount, WorldGenerator generator, int centerHeight, int spread)
    {
        for (int i = 0; i < blockCount; ++i)
        {
            BlockPos blockpos = chunkPos.add(random.nextInt(16), random.nextInt(spread) + random.nextInt(spread) + centerHeight - spread, random.nextInt(16));
            generator.generate(worldIn, random, blockpos);
        }
    }
}