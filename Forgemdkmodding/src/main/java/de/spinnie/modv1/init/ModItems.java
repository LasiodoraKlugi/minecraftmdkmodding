package de.spinnie.modv1.init;

import de.spinnie.modv1.ModConstants;
import de.spinnie.modv1.item.ItemFetterBurger;
import de.spinnie.modv1.item.ItemFirst;
import de.spinnie.modv1.item.ItemTeleport;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

	public static final ItemFirst moditem = new ItemFirst();
	
	public static final ItemTeleport teleport = new ItemTeleport();
	
	public static final ItemFetterBurger fetterburger = new ItemFetterBurger();

	public static void init() {
		setName(moditem, "moditem");
		setName(teleport, "teleport");
		setName(fetterburger, "fetterburger");
	}

	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		registry.register(moditem);
		
		registry.register(teleport);
		
		registry.register(fetterburger);
	}

	public static void setName(Item item, String name) {
		item.setRegistryName(new ResourceLocation(ModConstants.MODID, name));
		item.setUnlocalizedName(name);

	}

}
