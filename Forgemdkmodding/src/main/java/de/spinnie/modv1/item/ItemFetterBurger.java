package de.spinnie.modv1.item;

import de.spinnie.modv1.init.modv1Tabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFetterBurger extends ItemFood{

	public ItemFetterBurger() {
	  super(5, 3,false); 
	  setCreativeTab(modv1Tabs.tab);
	  setAlwaysEdible();
	 
      
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
            if(!worldIn.isRemote); //Muss auf Serverwelt ausgeführt werden
            player.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 100, 2));
            player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 150, 4));
            player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 2500, 0));
            player.addExperience(500);
            player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 5000, 3));
	}
	@SideOnly(Side.CLIENT)
	@Override
	public boolean hasEffect(ItemStack stack) {    //sieht nun entchantet aus
		return true;
        
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack) {  //Farbwahl
		return EnumRarity.EPIC;
	}

}