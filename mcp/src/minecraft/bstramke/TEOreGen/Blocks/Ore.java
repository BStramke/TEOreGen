package bstramke.TEOreGen.Blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Ore extends Block {
	public static final String[] NAMES = { "copper", "tin", "silver", "lead", "nickel" };
	public static final String[] INGOTNAMES = { "ingotCopper", "ingotTin", "ingotSilver", "ingotLead", "ingotNickel" };

	public static enum Ores {
		COPPER, TIN, SILVER, LEAD, NICKEL;
	}

	public static int[] oreMinY = { 40, 20, 5, 10, 5 };
	public static int[] oreMaxY = { 75, 55, 30, 35, 20 };
	public static int[] oreNumCluster = { 10, 7, 3, 4, 2 };
	public static int[] oreClusterSize = { 8, 8, 8, 8, 4 };

	public static ItemStack oreCopper;
	public static ItemStack oreTin;
	public static ItemStack oreSilver;
	public static ItemStack oreLead;
	public static ItemStack oreNickel;

	private Icon[] ico = new Icon[5];

	public Ore(int id) {
		super(id, Material.rock);
		setHardness(3.0F);
		setResistance(5.0F);
		setStepSound(Block.soundStoneFootstep);
		setCreativeTab(CreativeTabs.tabBlock);
		setUnlocalizedName("TEOreGen");

		MinecraftForge.setBlockHarvestLevel(this, 0, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(this, 1, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(this, 2, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(this, 3, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(this, 4, "pickaxe", 2);
		
		LanguageRegistry.instance().addStringLocalization("tile.TEOreGen.copper.name", "Copper Ore");
		LanguageRegistry.instance().addStringLocalization("tile.TEOreGen.tin.name", "Tin Ore");
		LanguageRegistry.instance().addStringLocalization("tile.TEOreGen.lead.name", "Lead Ore");
		LanguageRegistry.instance().addStringLocalization("tile.TEOreGen.silver.name", "Silver Ore");
		LanguageRegistry.instance().addStringLocalization("tile.TEOreGen.nickel.name", "Ferrous Ore");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		ico[0] = iconRegister.registerIcon("TEOreGen:Ore_Copper");
		ico[1] = iconRegister.registerIcon("TEOreGen:Ore_Tin");
		ico[2] = iconRegister.registerIcon("TEOreGen:Ore_Silver");
		ico[3] = iconRegister.registerIcon("TEOreGen:Ore_Lead");
		ico[4] = iconRegister.registerIcon("TEOreGen:Ore_Ferrous");
	}

	@Override
	public Icon getIcon(int side, int metadata) {
		return ico[metadata];
	}
	
	

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(int itemId, CreativeTabs tab, List list) {
		for (int i = 0; i < NAMES.length; i++)
			list.add(new ItemStack(itemId, 1, i));
	}
}
