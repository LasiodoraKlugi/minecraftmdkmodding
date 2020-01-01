package de.spinnie.modv1.item;

import de.spinnie.modv1.init.modv1Tabs;
import net.minecraft.item.ItemPickaxe;

public class ItemTreacheryPickaxe extends ItemPickaxe{

	public ItemTreacheryPickaxe(ToolMaterial material) {
		super(material);
		setCreativeTab(modv1Tabs.tab);
		attackSpeed = -2;  //desto kleiner , desto höher die Aufladezeit
	}

}
