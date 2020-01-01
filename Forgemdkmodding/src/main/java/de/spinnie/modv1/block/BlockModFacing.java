package de.spinnie.modv1.block;

import de.spinnie.modv1.init.modv1Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockModFacing extends Block{

	public BlockModFacing() {
		super(Material.ROCK);
        setCreativeTab(modv1Tabs.tab);
	}
	
	

}
