package de.spinnie.modv1;

import static de.spinnie.modv1.ModConstants.MODID;
import static de.spinnie.modv1.ModConstants.NAME;
import static de.spinnie.modv1.ModConstants.VERSION;

import de.spinnie.modv1.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MODID, name = NAME, version = VERSION)
public class ModV1 {

	@Instance
	private static ModV1 instance;

	public static ModV1 getInstance() {
		return instance;
	}

	@SidedProxy(serverSide = "de.spinnie.modv1.proxy.CommonProxy", clientSide = "de.spinnie.modv1.proxy.ClientProxy")
	private static CommonProxy proxy;

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		proxy.preinit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		proxy.postinit(event);
	}

}
