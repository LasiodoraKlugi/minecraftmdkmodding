package de.spinnie.modv1.init;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModModels {

	@SubscribeEvent
	public static void register(ModelRegistryEvent event) {
		register(ModItems.moditem);
		register(Item.getItemFromBlock(ModBlocks.modblock)); // bekommme Item block
	}

	private static void register(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0,
				new ModelResourceLocation(item.getRegistryName(), "inventory"));

	}
}