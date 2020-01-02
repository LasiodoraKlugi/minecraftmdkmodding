package de.spinnie.modv1.block;

import de.spinnie.modv1.ModConstants;
import de.spinnie.modv1.init.modv1Tabs;
import de.spinnie.modv1.tileentity.TileEntityModFacing;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockModFacing extends Block implements ITileEntityProvider{

	public static final PropertyDirection FACING = PropertyDirection.create("facing");
	
	public BlockModFacing() {
		super(Material.ROCK);
        setCreativeTab(modv1Tabs.tab);
        setDefaultState(getDefaultState().withProperty(FACING, EnumFacing.NORTH));
        GameRegistry.registerTileEntity(TileEntityModFacing.class, new ResourceLocation(ModConstants.MODID, "modblockfacing"));
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
     
     @Override
    public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
         if(side == null) {  //Muss gecheckt werden ob die richtigen seiten
        	 return true;
         }
         if(state.getValue(FACING) != side.getOpposite()) { //muss die richtige Seite sein
        	 return true;
         }
		return false;
     }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityModFacing();
	}	
}
