package bstramke.TEOreGen;

import java.util.ArrayList;
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import bstramke.TEOreGen.Blocks.ItemBlockOre;
import bstramke.TEOreGen.Blocks.Ore;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(name = "TEOreGen", version = "0.1", modid = "TEOreGen")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class TEOreGen extends DummyModContainer {

	@Instance
	public static TEOreGen instance = new TEOreGen();

	public static int TEOreBlockId;

	// @SidedProxy(clientSide = "bstramke.TEOreGen.Client.ClientProxy", serverSide = "bstramke.TEOreGen.Common.CommonProxy")
	// public static CommonProxy proxy;

	@EventHandler
	public void PreLoad(FMLPreInitializationEvent event) {
		FMLLog.log("TEOreGen", Level.INFO, "PreLoad");
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		TEOreBlockId = config.getBlock("Ore", 2001).getInt(2001);

		config.save();
		// proxy.registerRenderThings();
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {

		Block blockOre = new Ore(TEOreBlockId);

		GameRegistry.registerBlock(blockOre, ItemBlockOre.class, "Ore");

		Ore.oreCopper = new ItemStack(blockOre, 1, 0);
		Ore.oreTin = new ItemStack(blockOre, 1, 1);
		Ore.oreSilver = new ItemStack(blockOre, 1, 2);
		Ore.oreLead = new ItemStack(blockOre, 1, 3);
		Ore.oreNickel = new ItemStack(blockOre, 1, 4);

		OreDictionary.registerOre("oreCopper", Ore.oreCopper);
		OreDictionary.registerOre("oreTin", Ore.oreTin);
		OreDictionary.registerOre("oreSilver", Ore.oreSilver);
		OreDictionary.registerOre("oreLead", Ore.oreLead);
		OreDictionary.registerOre("oreNickel", Ore.oreNickel);		  
		 
		for(int i = 0; i < Ore.NAMES.length; i++)
		{
			ArrayList resList = new ArrayList();
			resList.add(new WeightedRandomBlock(new ItemStack(blockOre, 1, i)));
			GameRegistry.registerWorldGenerator(new WorldGenDefaultMinable(new WorldGenMinableCluster(resList, Ore.oreClusterSize[i]), Ore.oreNumCluster[i],Ore.oreMinY[i], Ore.oreMaxY[i]));
			//CoFHWorld.addFeature(category, oreList[i], BlockOre.NAMES[i], Ore.oreClusterSize[i], Ore.oreNumCluster[i], Ore.oreMinY[i], Ore.oreMaxY[i], 0, true, BlockOre.enable[i]);
		}
	}
}
