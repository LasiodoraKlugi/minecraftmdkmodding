package de.spinnie.modv1.item;

import de.spinnie.modv1.init.modv1Tabs;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemWrench extends Item{
	
	public ItemWrench() {
		setCreativeTab(modv1Tabs.tab);
		setMaxStackSize(1);
	}
	
	@Override
	public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ, EnumHand hand) {
		if(!world.isRemote) { // Wird nur auf Server berechnet!
			IBlockState state = world.getBlockState(pos); //state von Block bekommen
			
			for(IProperty<?> prop : state.getProperties().keySet()) {
				if((prop.getName().equals("facing")  || prop.getName().equals("rotation")) && prop.getValueClass() == EnumFacing.class) {
					if(prop.getAllowedValues().contains(side)) {
						world.setBlockState(pos, state.withProperty((IProperty<EnumFacing>)prop, side));  //muss gecastet werden weil man es vorher nicht weiß
						//gibt als Return wert einen neuen State zurück
						// Wenn der Block rotierbar ist, wird er geupdatet und gedreht
					}
				}

			}
		}
		return EnumActionResult.SUCCESS;
				
	}

}
