package de.spinnie.modv1.tileentity;

import java.awt.List;

import de.spinnie.modv1.block.BlockModFacing;
import de.spinnie.modv1.init.ModItems;
import de.spinnie.modv1.util.RedstoneUtil;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.model.animation.CapabilityAnimation;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import scala.Array;

public class TileEntityModFacing extends TileEntity implements ITickable {
	
	
	private int cooldown;
	
	//Braucht man damit es sich refresehd
	@Override 
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		return oldState.getBlock() != newSate.getBlock();
	}

	@Override
	public void update() {
         if(world.isRemote) {  //Wieder nur auf Serverseite
        	 return;
         }
		
         if(cooldown <20) {   //50Ticks = 2,5sek
        	 cooldown++;
        	 return;
         }
         cooldown = 0;
         
         if(!RedstoneUtil.isPowered(world, pos)) {
        	 return;
         }
         
         IBlockState ourState = world.getBlockState(pos);  //Holt man sich den Blockstate
         EnumFacing facing = ourState.getValue(BlockModFacing.FACING); //ab hier wird geschaut ob der Block ein tile entity hat und ob man sachen rein legen kanns
         BlockPos destinationPos = pos.offset(facing);
         
         TileEntity tileentity = world.getTileEntity(destinationPos); //hier wird gepr�ft ob tile Entity ist
         if(tileentity == null) {
        	 return;
         }
         
         if(!tileentity.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, facing.getOpposite())) {
        	 return;
         }
         IItemHandler handler = tileentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, facing.getOpposite());
         ItemHandlerHelper.insertItemStacked(handler, new ItemStack(ModItems.fetterburger, 3), false);  //Stick kann reingelegt werden! immer 2!
         ItemHandlerHelper.insertItemStacked(handler, new ItemStack(ModItems.treacherysSword, 1), false);
         ItemHandlerHelper.insertItemStacked(handler, new ItemStack(ModItems.moditem, 3), false);
         ItemHandlerHelper.insertItemStacked(handler, new ItemStack(ModItems.pinkBoots, 1), false);
         ItemHandlerHelper.insertItemStacked(handler, new ItemStack(ModItems.pinkLeggings, 1), false);
         ItemHandlerHelper.insertItemStacked(handler, new ItemStack(ModItems.pinkChestplate, 1), false);
         ItemHandlerHelper.insertItemStacked(handler, new ItemStack(ModItems.pinkHelmet, 1), false);
         ItemHandlerHelper.insertItemStacked(handler, new ItemStack(ModItems.treacherysPickaxe, 1), false);
         ItemHandlerHelper.insertItemStacked(handler, new ItemStack(ModItems.teleport, 1), false);
         ItemHandlerHelper.insertItemStacked(handler, new ItemStack(ModItems.multitool, 1), false);
         
         //somit wird jede 2,5 Sek (50Ticks), wenn eine Kiste auf der Facing Seite des Blocks steht, mit jeweils 2 Sticks bef�llt!
         //Grundlegend hierf�r ist aber das der Block an der nicht Facing Seite ein Redstone Signal angelegt bekommt!
         //Dreht man mithilfe des Wrenchs den Facing Block, so gibt dieser nur an der Facing S
         
      
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {    //Wird hiermit geladen
		super.readFromNBT(compound);
		cooldown = compound.getInteger("cooldown");
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {   //wird hiermit der cooldown(int) abgespeichert!
		super.writeToNBT(compound);
		compound.setInteger("cooldown", cooldown);
		return compound;
	}

}
