package bstramke.TEOreGen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenDefaultMinable implements IWorldGenerator {

	final WorldGenerator worldGen;
	final int count;
	final int minY;
	final int maxY;

	public WorldGenDefaultMinable(WorldGenerator worldGen, int count, int minY, int maxY) {
		this.worldGen = worldGen;
		this.count = count;
		this.minY = minY;
		this.maxY = maxY;
	}

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		generate(world, random, chunkX, chunkZ);
	}

	public void generate(World world, Random random, int chunkX, int chunkZ) {
		int blockX = chunkX * 16;
		int blockZ = chunkZ * 16;

		for (int i = 0; i < this.count; i++) {
			int x = blockX + random.nextInt(16);
			int y = this.minY + random.nextInt(this.maxY - this.minY);
			int z = blockZ + random.nextInt(16);
			this.worldGen.generate(world, random, x, y, z);
		}
	}
}
