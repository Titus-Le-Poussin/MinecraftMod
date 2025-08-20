package com.Titus_TheDuck.DwarfMod;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.IEventBus;

@Mod("dwarfmod")
public class DwarfMod {
    public static final String MOD_ID = "dwarfmod";
    private static final Logger LOGGER = LogManager.getLogger();
    public DwarfMod() {
        // Enregistrement du bus d'événements
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        // Configuration initiale du mod
        modEventBus.addListener(this::setup);
        
        // Enregistrement des items, blocs, etc. (à ajouter ici)
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM DWARF MOD SETUP!");
        LOGGER.info("Le mod Dwarf est maintenant prêt !");
    }
}
