package de.spinnie.modv1.proxy;

import de.spinnie.modv1.init.ModBlocks;
import de.spinnie.modv1.init.ModItems;
import de.spinnie.modv1.init.ModSmelting;
import de.spinnie.modv1.init.ModWorldGeneration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void preinit(FMLPreInitializationEvent event) {
		ModItems.init();
		ModBlocks.init();

		MinecraftForge.EVENT_BUS.register(ModItems.class);
		MinecraftForge.EVENT_BUS.register(ModBlocks.class);
		
		GameRegistry.registerWorldGenerator(new ModWorldGeneration(), 0);
	}

	public void init(FMLInitializationEvent event) {
		ModSmelting.init();  
		

	}

	public void postinit(FMLPostInitializationEvent event) {

	}

}
