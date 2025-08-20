package com.Titus_TheDuck.DwarfMod;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import com.Titus_TheDuck.DwarfMod.items.RubisItem;
import com.Titus_TheDuck.DwarfMod.items.RawRubis;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;
import net.minecraft.item.Item;
import com.Titus_TheDuck.DwarfMod.blocks.RubisOre;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.MinecraftForge; 
import com.Titus_TheDuck.DwarfMod.world.OreGeneration; 
import net.minecraft.item.ItemGroup; 
import com.Titus_TheDuck.DwarfMod.blocks.RubisBlock;
import com.Titus_TheDuck.DwarfMod.items.RubisSword;


@Mod("dwarfmod")
public class DwarfMod {
    public static final String MOD_ID = "dwarfmod";
    // Registre pour nos items custom
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    // Notre rubis !
    public static final RegistryObject<Item> RUBIS = ITEMS.register("rubis", RubisItem::new);
    public static final RegistryObject<Item> RAW_RUBIS = ITEMS.register("raw_rubis", RawRubis::new);
    public static final RegistryObject<Block> RUBIS_ORE = BLOCKS.register("rubis_ore", RubisOre::new);
    public static final RegistryObject<Block> RUBIS_BLOCK = BLOCKS.register("rubis_block", RubisBlock::new);
    public static final RegistryObject<Item> RUBIS_SWORD = ITEMS.register("rubis_sword", RubisSword::new);
    // Item pour le bloc Rubis Ore
    public static final RegistryObject<Item> RUBIS_ORE_ITEM = ITEMS.register("rubis_ore", 
    () -> new BlockItem(RUBIS_ORE.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    // Item pour le bloc Rubis Block
    public static final RegistryObject<Item> RUBIS_BLOCK_ITEM = ITEMS.register("rubis_block", 
        () -> new BlockItem(RUBIS_BLOCK.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));


    
    private static final Logger LOGGER = LogManager.getLogger();
    public DwarfMod() {
        // Enregistrement du bus d'événements
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        // Configuration initiale du mod
        modEventBus.addListener(this::setup);
        
        // Enregistrement des items, blocs, etc. (à ajouter ici)
        ITEMS.register(modEventBus);
        BLOCKS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(OreGeneration.class);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM DWARF MOD SETUP!");
        LOGGER.info("Le mod Dwarf est maintenant prêt !");
        LOGGER.info("Rubis enregistré avec succès !");
    }
}

//./gradlew runClient pour build
