package de.spinnie.modv1.item;

import de.spinnie.modv1.init.modv1Tabs;
import net.minecraft.item.ItemSpade;

public class ItemTreacherySpade extends ItemSpade{

	public ItemTreacherySpade(ToolMaterial material) { 
		super(material);
		setCreativeTab(modv1Tabs.tab);
		attackDamage = 25; //hoher attack damage . Durch Attack damage hat material nichts zu ändern.
	}


}