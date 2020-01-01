package de.spinnie.modv1.item;

import de.spinnie.modv1.init.modv1Tabs;
import net.minecraft.item.ItemAxe;

public class ItemTreacheryAxe extends ItemAxe{

	public ItemTreacheryAxe(ToolMaterial material) {
		super(material, 10.0F, 0F);
		setCreativeTab(modv1Tabs.tab);

	}

}
