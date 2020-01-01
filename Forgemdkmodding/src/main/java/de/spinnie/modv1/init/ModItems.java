package de.spinnie.modv1.init;

import de.spinnie.modv1.ModConstants;
import de.spinnie.modv1.item.ItemFetterBurger;
import de.spinnie.modv1.item.ItemFirst;
import de.spinnie.modv1.item.ItemPinkArmor;
import de.spinnie.modv1.item.ItemTeleport;
import de.spinnie.modv1.item.ItemTreacheryAxe;
import de.spinnie.modv1.item.ItemTreacheryHoe;
import de.spinnie.modv1.item.ItemTreacheryPickaxe;
import de.spinnie.modv1.item.ItemTreacherySpade;
import de.spinnie.modv1.item.ItemTreacherySword;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

	public static final ItemFirst moditem = new ItemFirst();
	
	public static final ItemTeleport teleport = new ItemTeleport();
	
	public static final ItemFetterBurger fetterburger = new ItemFetterBurger();
	
	public static final ToolMaterial treacherysToolMaterial = EnumHelper.addToolMaterial("treachery", 3, 1000, 16, 6F, 35);
	public static final ItemTreacherySword treacherysSword = new ItemTreacherySword(treacherysToolMaterial);
	public static final ItemTreacheryPickaxe treacherysPickaxe = new ItemTreacheryPickaxe(treacherysToolMaterial);
	public static final ItemTreacheryAxe treacherysAxe = new ItemTreacheryAxe(treacherysToolMaterial);
	public static final ItemTreacherySpade treacherysSpade = new ItemTreacherySpade(treacherysToolMaterial);
	public static final ItemTreacheryHoe treacherysHoe= new ItemTreacheryHoe(treacherysToolMaterial);
	
	public static final ArmorMaterial pinkArmorMaterial = EnumHelper.addArmorMaterial("pink", ModConstants.MODID + ":pink", 80, new int[] {3, 5, 6, 3}, 30, SoundEvents.ENTITY_WITHER_SHOOT , 0F);
    public static final ItemPinkArmor pinkHelmet = new ItemPinkArmor(pinkArmorMaterial, 0, EntityEquipmentSlot.HEAD); //Helm 0 im HEAD sloot
    public static final ItemPinkArmor pinkChestplate = new ItemPinkArmor(pinkArmorMaterial, 1, EntityEquipmentSlot.CHEST); // Chest 1 im CHEST slot
    public static final ItemPinkArmor pinkLeggings = new ItemPinkArmor(pinkArmorMaterial, 2, EntityEquipmentSlot.LEGS); 
    public static final ItemPinkArmor pinkBoots = new ItemPinkArmor(pinkArmorMaterial, 3, EntityEquipmentSlot.FEET);
    
	
	public static void init() {
		setName(moditem, "moditem");
		setName(teleport, "teleport");
		setName(fetterburger, "fetterburger");
		
		setName(treacherysSword, "treacherys_sword");  //wie in textures und lang datei
		setName(treacherysPickaxe, "treacherys_pickaxe");
		setName(treacherysAxe, "treacherys_axe");
		setName(treacherysSpade, "treacherys_spade");
		setName(treacherysHoe, "treacherys_hoe");
		
		setName(pinkHelmet,"pink_helmet");
		setName(pinkChestplate,"pink_chestplate");
		setName(pinkLeggings,"pink_leggings");
		setName(pinkBoots,"pink_boots");
	}

	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		registry.register(moditem);
		
		registry.register(teleport);
		
		registry.register(fetterburger);
		
		registry.registerAll(treacherysSword, treacherysPickaxe, treacherysAxe, treacherysSpade, treacherysHoe);
		
		registry.registerAll(pinkHelmet, pinkChestplate, pinkLeggings, pinkBoots);
	}

	public static void setName(Item item, String name) {
		item.setRegistryName(new ResourceLocation(ModConstants.MODID, name));
		item.setUnlocalizedName(name);

	}

}
