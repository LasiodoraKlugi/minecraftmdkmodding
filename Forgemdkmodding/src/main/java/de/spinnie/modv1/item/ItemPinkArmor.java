package de.spinnie.modv1.item;

import de.spinnie.modv1.init.modv1Tabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemPinkArmor extends ItemArmor{

	public ItemPinkArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
        setCreativeTab(modv1Tabs.tab);
	}

}
