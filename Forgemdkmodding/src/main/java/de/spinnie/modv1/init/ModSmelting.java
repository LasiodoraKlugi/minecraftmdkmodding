package de.spinnie.modv1.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModSmelting {
	
	public static void init() {
		GameRegistry.addSmelting(ModBlocks.modblock, new ItemStack(ModItems.moditem, 6), 5F);
		
	}

}
