package de.spinnie.modv1.util;

import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RedstoneUtil {

	// Wird gecheckt ob ein Block gepowered ist oder nicht!
	//In diesem Fall verbindet sich das Redstone an meinem FacingBlock an jeder Seite außer der Facing Seite!
	
	public static boolean isPowered(World world, BlockPos pos) {
	   boolean powered = world.isBlockPowered(pos);  //wird zurückgegeben wenn z.B. weak oder strong powered
	   if(!powered) {
		   for(EnumFacing facing : EnumFacing.VALUES) {  //Alle EnumFacings werden durchgegangen
			   BlockPos offsetPos = pos.offset(facing);
			   IBlockState state = world.getBlockState(offsetPos);
				   if(state.getBlock() == Blocks.REDSTONE_WIRE && state.getValue(BlockRedstoneWire.POWER) > 0) {  //Es muss was gepowered sein!
					   return true;
				   }
		   }
	   }
	return powered;
	}
	
}