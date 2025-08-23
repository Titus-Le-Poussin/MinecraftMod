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
import com.Titus_TheDuck.DwarfMod.entities.ChevreEntity;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.MinecraftForge; 
import com.Titus_TheDuck.DwarfMod.world.OreGeneration; 
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent; 
import com.Titus_TheDuck.DwarfMod.blocks.RubisBlock;
import com.Titus_TheDuck.DwarfMod.items.RubisSword;
import net.minecraftforge.common.ForgeSpawnEggItem; // Utilisation de ForgeSpawnEggItem pour le Supplier


@Mod("dwarfmod")
public class DwarfMod {
    public static final String MOD_ID = "dwarfmod";
    // Registre pour nos items custom
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    

    // APRÈS les registres existants :
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MOD_ID);
    //chevre
    public static final RegistryObject<SoundEvent> CHEVRE_AMBIENT = SOUNDS.register("entity.chevre.ambient", 
    () -> new SoundEvent(new ResourceLocation(MOD_ID, "entity.chevre.ambient")));    
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MOD_ID);

    // Entity chèvre
    public static final RegistryObject<EntityType<ChevreEntity>> CHEVRE = ENTITIES.register("chevre",
        () -> EntityType.Builder.of(ChevreEntity::new, EntityClassification.CREATURE)
            .sized(1.0F, 1.0F)
            .build("chevre"));


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


        // Correction : Utilisation de ForgeSpawnEggItem avec Supplier pour éviter le crash de registre
        // Le Supplier () -> CHEVRE.get() permet d'attendre que l'entité soit enregistrée avant d'y accéder
        public static final RegistryObject<Item> CHEVRE_SPAWN_EGG = ITEMS.register("chevre_spawn_egg",
            () -> new ForgeSpawnEggItem(
                () -> CHEVRE.get(), // Supplier pour l'entité chèvre
                0xFFFFFF,           // couleur principale (blanc)
                0xAAAAAA,           // couleur secondaire (gris)
                new Item.Properties().tab(ItemGroup.TAB_MISC)
            )
        );


    
    private static final Logger LOGGER = LogManager.getLogger();
    public DwarfMod() {
        // Enregistrement du bus d'événements
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        // Configuration initiale du mod
        modEventBus.addListener(this::setup);
        
        // Enregistrement des items, blocs, etc. (à ajouter ici)
        ITEMS.register(modEventBus);
        BLOCKS.register(modEventBus);
        SOUNDS.register(modEventBus);
        ENTITIES.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(OreGeneration.class);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM DWARF MOD SETUP!");
        LOGGER.info("Le mod Dwarf est maintenant prêt !");
        LOGGER.info("Rubis enregistré avec succès !");
    }
}

//./gradlew runClient pour build
//cd "/c/Users/Utilisateur/Documents/Informatique Etudes 2025/minecraft_mod/Minecraft_Forge_1.16.5 build"
//./gradlew runClient