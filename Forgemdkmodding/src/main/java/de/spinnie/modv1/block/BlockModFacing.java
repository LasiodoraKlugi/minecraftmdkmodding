package de.spinnie.modv1.block;

import de.spinnie.modv1.init.modv1Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockModFacing extends Block{

	public static final PropertyDirection FACING = PropertyDirection.create("facing");
	
	public BlockModFacing() {
		super(Material.ROCK);
        setCreativeTab(modv1Tabs.tab);
        setDefaultState(getDefaultState().withProperty(FACING, EnumFacing.NORTH));
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		return getDefaultState().withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer));//mit .getOpposite wird es weggeplaced
		
		//Wird jetzt immer zu einem hin geplaced
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING).getIndex();
	}
	 //Übersetzung Int -> blockstate und zurück
	// int wieder in enumfacing übersetzt
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
	}
	
     @Override
    protected BlockStateContainer createBlockState() {
    	return new BlockStateContainer(this, FACING);    //Block weiß das er property hat
    }
	
	
}
