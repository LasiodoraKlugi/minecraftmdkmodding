package de.spinnie.modv1.item;

import de.spinnie.modv1.ModV1;
import de.spinnie.modv1.init.ModItems;
import de.spinnie.modv1.init.modv1Tabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemPinkArmor extends ItemArmor{

	public ItemPinkArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
        setCreativeTab(modv1Tabs.tab);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) { //wird immer ausgeführt wenn man eines meienr Items an hat
		if(ModItems.pinkChestplate.equals(itemStack.getItem())) { //immer wenn chestplate an dann wird das hier ausgeführt
			player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 20)); //20 Ticks
			player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 3));
		}
			
		}

	}


