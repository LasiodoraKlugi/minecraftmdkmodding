package de.spinnie.modv1.block;

import java.util.Random;

import de.spinnie.modv1.init.ModItems;
import de.spinnie.modv1.init.modv1Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockFirst extends Block {

	public BlockFirst() {
		super(Material.ROCK);
		setCreativeTab(modv1Tabs.tab);
		setHardness(4.5F);
		setResistance(90F);
		setSoundType(SoundType.SNOW);
		setHarvestLevel("pickaxe", 2);  //Harvest level nachsehen mit (F3)strg hovern drücken und klicken auf Harvest
		setLightLevel(0.8F);			// strg+shift+h open search menue and search for ItemTool -> List with items(pickusw)
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return random.nextInt(20) +1;             //dropt min 1 bis 20 items random
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.moditem;       //dropt mein Item beim abbau                     
	}
}
