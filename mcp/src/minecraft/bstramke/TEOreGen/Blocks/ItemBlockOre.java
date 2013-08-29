package bstramke.TEOreGen.Blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockOre extends ItemBlock {
	public ItemBlockOre(int id) {
		super(id);
		setHasSubtypes(true);
		setMaxDamage(0);
	}

	public String getUnlocalizedName(ItemStack itemstack) {
		return getUnlocalizedName() + "." + Ore.NAMES[itemstack.getItemDamage()];
	}

	public int getMetadata(int i) {
		return i;
	}
}
