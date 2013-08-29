package bstramke.TEOreGen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenMinableCluster extends WorldGenerator {
	private List cluster;
	private int genClusterSize;
	private int genBlockID = Block.stone.blockID;

	public WorldGenMinableCluster(ItemStack ore, int clusterSize) {
		this.cluster = new ArrayList();
		this.cluster.add(new WeightedRandomBlock(ore));
		this.genClusterSize = clusterSize;
	}

	public WorldGenMinableCluster(WeightedRandomBlock resource, int clusterSize) {
		this.cluster = new ArrayList();
		this.cluster.add(resource);
		this.genClusterSize = clusterSize;
	}

	public WorldGenMinableCluster(List resource, int clusterSize) {
		this.cluster = resource;
		this.genClusterSize = clusterSize;
	}

	public WorldGenMinableCluster(ItemStack ore, int clusterSize, int blockID) {
		this.cluster = new ArrayList();
		this.cluster.add(new WeightedRandomBlock(ore, 1));
		this.genClusterSize = clusterSize;
		this.genBlockID = blockID;
	}

	public WorldGenMinableCluster(WeightedRandomBlock resource, int clusterSize, int blockID) {
		this.cluster = new ArrayList();
		this.cluster.add(resource);
		this.genClusterSize = clusterSize;
		this.genBlockID = blockID;
	}

	public WorldGenMinableCluster(List resource, int clusterSize, int blockID) {
		this.cluster = resource;
		this.genClusterSize = clusterSize;
		this.genBlockID = blockID;
	}

	public boolean generate(World world, Random rand, int x, int y, int z) {
		float f = rand.nextFloat() * 3.141593F;
		double d0 = x + 8 + MathHelper.sin(f) * this.genClusterSize / 8.0F;
		double d1 = x + 8 - MathHelper.sin(f) * this.genClusterSize / 8.0F;
		double d2 = z + 8 + MathHelper.cos(f) * this.genClusterSize / 8.0F;
		double d3 = z + 8 - MathHelper.cos(f) * this.genClusterSize / 8.0F;
		double d4 = y + rand.nextInt(3) - 2;
		double d5 = y + rand.nextInt(3) - 2;

		for (int l = 0; l <= this.genClusterSize; l++) {
			double d6 = d0 + (d1 - d0) * l / this.genClusterSize;
			double d7 = d4 + (d5 - d4) * l / this.genClusterSize;
			double d8 = d2 + (d3 - d2) * l / this.genClusterSize;
			double d9 = rand.nextDouble() * this.genClusterSize / 16.0D;
			double d10 = (MathHelper.sin(l * 3.141593F / this.genClusterSize) + 1.0F) * d9 + 1.0D;
			double d11 = (MathHelper.sin(l * 3.141593F / this.genClusterSize) + 1.0F) * d9 + 1.0D;
			int i1 = MathHelper.floor_double(d6 - d10 / 2.0D);
			int j1 = MathHelper.floor_double(d7 - d11 / 2.0D);
			int k1 = MathHelper.floor_double(d8 - d10 / 2.0D);
			int l1 = MathHelper.floor_double(d6 + d10 / 2.0D);
			int i2 = MathHelper.floor_double(d7 + d11 / 2.0D);
			int j2 = MathHelper.floor_double(d8 + d10 / 2.0D);

			for (int k2 = i1; k2 <= l1; k2++) {
				double d12 = (k2 + 0.5D - d6) / (d10 / 2.0D);

				if (d12 * d12 < 1.0D) {
					for (int l2 = j1; l2 <= i2; l2++) {
						double d13 = (l2 + 0.5D - d7) / (d11 / 2.0D);

						if (d12 * d12 + d13 * d13 < 1.0D) {
							for (int i3 = k1; i3 <= j2; i3++) {
								double d14 = (i3 + 0.5D - d8) / (d10 / 2.0D);

								Block block = Block.blocksList[world.getBlockId(k2, l2, i3)];
								if ((d12 * d12 + d13 * d13 + d14 * d14 < 1.0D) && (block != null) && (block.isGenMineableReplaceable(world, k2, l2, i3, this.genBlockID))) {
									WeightedRandomBlock ore = (WeightedRandomBlock) WeightedRandom.getRandomItem(world.rand, this.cluster);
									world.setBlock(k2, l2, i3, ore.blockId, ore.metadata, 1);
								}
							}
						}
					}
				}
			}
		}
		return true;
	}
}