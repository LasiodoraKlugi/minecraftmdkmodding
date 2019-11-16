package de.spinnie.modv1.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class CreativeTabModv1 extends CreativeTabs {

	public CreativeTabModv1() {
		super("modtab");
	}

	@Override
	public ItemStack getTabIconItem() {
		// TODO Auto-generated method stub
		return new ItemStack(Blocks.ANVIL);
	}

}
