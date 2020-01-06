package de.spinnie.modv1.item;

import de.spinnie.modv1.init.modv1Tabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemMultitool extends Item{
	
	public ItemMultitool() {
		setCreativeTab(modv1Tabs.tab);
		setMaxDamage(42);
	}
	

@Override
public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
	ItemStack stack = playerIn.getHeldItem(handIn);
	if (!worldIn.isRemote) { // Man ist nicht auf einer Slave World also Client Welt! = also Server Welt! Resourcen sparen
		RayTraceResult result = rayTrace(playerIn, 15);		//auf 50 blöcke
		if(result.typeOfHit == Type.MISS) {
			playerIn.sendStatusMessage(new TextComponentString("\u00A74Du kannst dich nur 15 Bloecke weit porten!"), true);
			return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
		}
		BlockPos pos = result.getBlockPos();
		if(!(playerIn instanceof EntityPlayerMP)) {
			return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
		}
		EntityPlayerMP playermp = (EntityPlayerMP) playerIn;
		playermp.connection.setPlayerLocation(pos.getX(), pos.getY()+5, pos.getZ(), playermp.rotationYaw, playermp.rotationPitch); //Server sendet an den Client
		stack.damageItem(1, playerIn);
		ItemStack stack1 = playerIn.getHeldItem(handIn);
		if(!worldIn.isRemote){ //abprüfen welt, immer besser auf dem server ausfürhen
			worldIn.setBlockState(playerIn.getPosition().down(), Blocks.BROWN_MUSHROOM_BLOCK.getDefaultState());
			//Bei Rechtsklick wird unter uns ein Pilz Block gesetzt
			stack1.damageItem(1, playerIn);
		}
		playerIn.jump(); //kleiner boost nach oben jump edit: muss auf beiden seiten gecallt werden(server,Client)
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));//Animationen
		
	}
	return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
}

public RayTraceResult rayTrace(EntityPlayer player, double blockReachDistance) {
	Vec3d vec3d = player.getPositionEyes(1.0F);
	Vec3d vec3d1 = player.getLook(1.0F);
	Vec3d vec3d2 = vec3d.addVector(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance,
			vec3d1.z * blockReachDistance);
	return player.getEntityWorld().rayTraceBlocks(vec3d, vec3d2, false, false, true);

	// etwas kompliziert
	// ray Trace Befehl= Berechnet Welcher Block in einer bestimmten Distanz ist,
	// oder irgendwo was dazwischen ist
}


}


