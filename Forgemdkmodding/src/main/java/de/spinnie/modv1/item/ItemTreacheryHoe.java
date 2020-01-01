package de.spinnie.modv1.item;

import de.spinnie.modv1.init.modv1Tabs;
import net.minecraft.item.ItemHoe;

public class ItemTreacheryHoe extends ItemHoe{

	public ItemTreacheryHoe(ToolMaterial material) {
		super(material);
		setCreativeTab(modv1Tabs.tab);
	}

}
