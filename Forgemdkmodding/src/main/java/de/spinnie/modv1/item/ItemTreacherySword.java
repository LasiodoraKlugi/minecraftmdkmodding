package de.spinnie.modv1.item;

import com.google.common.collect.Multimap;

import de.spinnie.modv1.init.modv1Tabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemTreacherySword extends ItemSword{

	public ItemTreacherySword(ToolMaterial material) {
		super(material);
		setCreativeTab(modv1Tabs.tab);
	}

	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
        	//attack damage muss man nicht setzen
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", 0, 0));
            //import aus ItemSword
        }

        return multimap;
    }
	@SideOnly(Side.CLIENT)
	@Override
	public boolean hasEffect(ItemStack stack) {    //sieht nun entchantet aus
		return true;
        
	}
}

