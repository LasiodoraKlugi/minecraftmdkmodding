package de.spinnie.modv1.item;

import de.spinnie.modv1.init.ModBlocks;
import de.spinnie.modv1.init.modv1Tabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemFirst extends Item {

	public ItemFirst() {
		setCreativeTab(modv1Tabs.tab);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if(!worldIn.isRemote){ //abprüfen welt, immer besser auf dem server ausfürhen
			worldIn.setBlockState(playerIn.getPosition().down(), Blocks.BROWN_MUSHROOM_BLOCK.getDefaultState());
			//Bei Rechtsklick wird unter uns ein Pilz Block gesetzt
		}
		playerIn.jump(); //kleiner boost nach oben jump edit: muss auf beiden seiten gecallt werden(server,Client)
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));//Animationen

	}

}
