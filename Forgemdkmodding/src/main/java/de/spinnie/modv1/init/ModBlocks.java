package de.spinnie.modv1.init;

import de.spinnie.modv1.ModConstants;
import de.spinnie.modv1.block.BlockFirst;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

	public static final BlockFirst modblock = new BlockFirst();

	public static void init() {
		setName(modblock, "modblock");
	}

	@SubscribeEvent
	public static void register(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();
		registry.register(modblock);
	}

	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		registry.register(new ItemBlock(modblock).setRegistryName(modblock.getRegistryName()));
	}

	public static void setName(Block block, String name) {
		block.setRegistryName(new ResourceLocation(ModConstants.MODID, name));
		block.setUnlocalizedName(name);

	}
}
