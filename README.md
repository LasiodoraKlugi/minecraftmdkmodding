# minecraftmdkmodding
Version: 1.0.1 Starts
Changelog:

********************************************************************************************************* ~Stand: 25.10

Added Features to this mod:

Shaped Crafting

Shapeless Crafting

McMod.info

First Creative Tab

My own Item
   
    moditem

My own block
  
    modBlock

Version: 1.0.1 Ends

********************************************************************************************************* ~Stand: 18.11

Version: 1.0.2 Starts

Added Features to this mod:

Added Smelting
    
    furnace(mod.block + coal -> mod.item)

Added Block property:

     Hardness
  
     Resistance
  
     SoundType
  
     Harvest Level(pickaxe, iron)
  
     LightLevel
  
     Drop random(min 1, max 20)
  
     Drop moditem
     
Item settings imroved: 
                        
    Added item right klick(Keine abnutzung bis jetzt!)
    (mushroom, jump)
    
Version: 1.0.2 Ends

********************************************************************************************************* ~Stand: 7.12.19

Version: 1.0.3 Starts

Added new Item Teleport:
   
    Teleporting Item (50 Blocks, warnings, maxdamage)
    
Version: 1.0.3 Ends    
Version: 1.0.4 Starts    
Added Food:
     
Tobis fetter Burger:
    
    setAlwaysEdible
    PotionEffect:   
    LEVITATION
    RESISTANCE
    GLOWING
    HUNGER
    Entchant effect
    colour
    
Item/Blocks settings imroved:
    
    Item First: max item health = maxdamage
    Changed names: Klugis erstes Item -> Sonderbare Konsole
                   Klugis erster Block -> Pyrit Gestein
    Changend Skins
    Item right klick hat nun Abnutzung!
    
Uplouded all Jar- Files for everyone 1.0.2 -> 1.0.3 -> 1.0.4 -> 1.0.4.1

Version: 1.0.4 Ends

********************************************************************************************************* ~Stand: 25.12.19
Version: 1.0.5 Starts

Added Armor & Weapons & Tools  & World Generation:
Weapons & Tools:

    item.treacherys_axe.name=Baumfaeller
         super(material, 10.0F, 0F);
    item.treacherys_hoe.name=Hacke
    item.treacherys_pickaxe.name=Stein Hacke
         attackSpeed = -2;  //desto kleiner , desto höher die Aufladezeit
    item.treacherys_spade.name=Spaten
         attackDamage = 25; //hoher attack damage
    item.treacherys_sword.name=Klugis Schwert
         import aus Item Sword
    
Armor:
   
    item.pink_helmet.name=Pinker Helm
    item.pink_chestplate.name=Pinker Brustpanzer
    item.pink_leggings.name=Pinke Beinrüstung
    item.pink_boots.name=Pinke Stahlkappen Schuhe
    
    player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 20)); //20 Ticks
    player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 3));
    
Block with different textures:

    tile.modblockfacing.name=Redstone Schneeblock
    
World Block Generation:
 
    genOreMinMax(world, random, chunkPos, 5, modblockgen, 100, 120);
			
    genOreCenterSpread(world, random, chunkPos, 10, modblockgen, 200, 5);
    
 Version: 1.0.5 Ends

********************************************************************************************************* ~Stand: 29.12.2020
Version 1.0.5.1 Starts

Added new Features:

ModBlockFacing:

     modblockfacing hat nun die Eigenschaft, dass er sich mit der Facing Seite zum Spieler hin richtet!
     Mehr Kommentare dazu beim code.
 
Version 1.0.5.1 Ends
********************************************************************************************************* ~Stand: 1.1.2020
Version 1.0.6 Starts

Added new Features:

TF2 Rotation Wrench(with TF2 skin):
  
    Kann Blöcke drehen! Mehr dazu im Code.
    
Version 1.0.6 Ends
********************************************************************************************************* ~Stand: 2.1.2020 
Version 1.0.7 Starts

Added new Features:

Redstone Util für ModBlockFacing hinzugefügt:

     ModBlockFacing verbindet sich an der nicht Facing Seite mit Redstone!
     
     
Tile Entity:

     Wenn an/auf die Facing Seite eine Kiste gestellt wird, wird diese mit vorgegebenen Items befüllt!
     Erklärung beim Code!
     
Changed GUI Creative Tab Texture

Alle Versionen zum Download zur Verfügung gestellt unter: https://github.com/LasiodoraKlugi/Treachery-s-Steel-Bolter-by-Klugi

Version 1.0.7 Ends
********************************************************************************************************* ~Stand: 2.1.2020      
     
