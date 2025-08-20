package com.example.examplemod;

// IMPORTS : On importe toutes les classes Minecraft et Forge dont on a besoin
// Pensez aux imports comme des "outils" qu'on va chercher dans la boîte à outils
import net.minecraft.block.Block;                    // Pour manipuler les blocs
import net.minecraft.block.Blocks;                   // Liste de tous les blocs existants (STONE, DIRT, etc.)
import net.minecraftforge.common.MinecraftForge;     // Cœur de Forge pour les événements globaux
import net.minecraftforge.event.RegistryEvent;       // Événements d'enregistrement (blocs, items, etc.)
import net.minecraftforge.eventbus.api.SubscribeEvent; // Annotation pour écouter les événements
import net.minecraftforge.fml.InterModComms;         // Communication entre mods
import net.minecraftforge.fml.common.Mod;            // Annotation qui dit "cette classe EST un mod"
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;    // Événement setup côté client
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;    // Événement setup général
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;   // Envoi de messages entre mods
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;   // Réception de messages entre mods
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;    // Démarrage du serveur
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;    // Contexte de chargement des mods
import org.apache.logging.log4j.LogManager;          // Gestionnaire de logs
import org.apache.logging.log4j.Logger;              // Logger pour afficher des messages

import java.util.stream.Collectors;                  // Utilitaire Java pour traiter les flux de données

// @Mod = "CETTE CLASSE EST UN MOD MINECRAFT !"
// C'est l'annotation magique qui dit à Forge : "Hey, regarde ici, il y a un mod !"
// "examplemod" = ID unique du mod (DOIT correspondre au fichier mods.toml)
// Exemple : si vous créez un mod de dragons, mettez @Mod("dragonmod")
@Mod("examplemod")
public class ExampleMod
{
    // LOGGER = votre "journal de bord" pour déboguer
    // Comme un carnet où vous notez ce qui se passe dans votre mod
    // Très utile pour savoir si votre code fonctionne ou plante !
    // Exemple d'usage : LOGGER.info("Mon item s'est bien enregistré !");
    private static final Logger LOGGER = LogManager.getLogger();

    // CONSTRUCTEUR = ce qui s'exécute quand Forge charge votre mod
    // C'est comme "allumer" votre mod : tout ce qui est ici se passe AU DÉMARRAGE
    // Pensez-y comme à l'installation de votre mod dans Minecraft
    public ExampleMod() {
        
        // ÉTAPE 1 : Brancher notre mod sur les "événements" de Minecraft
        // Un événement = quelque chose qui arrive (démarrage, joueur se connecte, bloc cassé, etc.)
        // FMLJavaModLoadingContext = le "standard téléphonique" entre notre mod et Forge
        
        // Setup général = configuration de base (serveur + client)
        // Exemple : enregistrer des recettes, configurer la génération de minerais
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        
        // Communication entre mods = votre mod peut "parler" à d'autres mods
        // Exemple : dire à JEI (Just Enough Items) d'afficher vos recettes
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        
        // Réception de messages d'autres mods
        // Exemple : recevoir des infos d'un mod de magie pour rendre vos items compatibles
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        
        // Setup client = configuration côté joueur uniquement (pas serveur dédié)
        // Exemple : interfaces graphiques, sons, effets visuels
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // ÉTAPE 2 : S'abonner aux événements du JEU (pas du mod)
        // Différence : événements MOD = pendant le chargement, événements JEU = pendant la partie
        // Exemple : quand un joueur casse un bloc, quand une entité meurt, etc.
        MinecraftForge.EVENT_BUS.register(this);
    }

    // MÉTHODE SETUP = "installation" de votre mod dans Minecraft
    // Cette méthode s'exécute UNE SEULE FOIS quand Minecraft démarre avec votre mod
    // C'est ici qu'on configure tout ce qui doit être prêt avant que les joueurs arrivent
    // Exemples concrets : enregistrer des recettes, configurer la génération de minerais, etc.
    private void setup(final FMLCommonSetupEvent event)
    {
        // Message de debug pour savoir que notre mod démarre bien
        // Vous verrez ce message dans les logs de Minecraft au démarrage
        LOGGER.info("HELLO FROM PREINIT");
        
        // Exemple concret : afficher des infos sur un bloc existant
        // Blocks.DIRT = le bloc de terre de Minecraft
        // getRegistryName() = son nom technique interne ("minecraft:dirt")
        // Utile pour comprendre comment Minecraft nomme ses éléments !
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        
        // EXEMPLES de ce qu'on pourrait faire ici :
        // - Enregistrer des recettes de craft custom
        // - Configurer quels biomes contiennent nos minerais
        // - Définir les propriétés de nos outils (durabilité, vitesse, etc.)
        // - Enregistrer des sons custom
    }

    // MÉTHODE CLIENT = configuration spécifique au côté "joueur"
    // ATTENTION : cette méthode ne s'exécute QUE côté client (pas sur serveur dédié !)
    // Différence client/serveur : client = ce que voit le joueur, serveur = la logique du jeu
    // Exemples côté client : interfaces, sons, effets visuels, contrôles clavier
    private void doClientStuff(final FMLClientSetupEvent event) {
        
        // Exemple : accéder aux paramètres du jeu (impossible côté serveur !)
        // event.getMinecraftSupplier().get().options = les options du joueur (graphismes, son, etc.)
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().options);
        
        // EXEMPLES de ce qu'on pourrait faire ici :
        // - Enregistrer des raccourcis clavier custom (touche pour ouvrir un menu)
        // - Configurer le rendu de nos blocs/items (couleurs, animations)
        // - Enregistrer des interfaces graphiques (GUIs)
        // - Définir des effets de particules
        // - Configurer des shaders ou effets visuels
    }

    // COMMUNICATION ENTRE MODS - Envoi de messages
    // IMC = Inter-Mod Communications = système pour que les mods se parlent entre eux
    // Imaginez que votre mod de magie veut dire au mod JEI d'afficher vos sorts dans son interface
    // Ou que votre mod d'armes veut être compatible avec un mod d'enchantements
    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // Exemple concret : envoyer un message "helloworld" au mod "examplemod"
        // Dans la vraie vie, ça pourrait être :
        // - "Voici mes nouveaux minerais" → mod de génération de monde
        // - "Voici mes outils" → mod d'enchantements
        // - "Voici mes recettes" → JEI (Just Enough Items)
        
        // () -> { ... } = fonction lambda (fonction anonyme en Java)
        // Équivalent à créer une petite fonction temporaire
        InterModComms.sendTo("examplemod", "helloworld", () -> { 
            LOGGER.info("Hello world from the MDK"); 
            return "Hello world";
        });
        
        // EXEMPLES RÉELS de messages IMC :
        // InterModComms.sendTo("jei", "registerRecipes", () -> mesRecettesCustom);
        // InterModComms.sendTo("biomesoplenty", "addBiomeOres", () -> mesNouveauxMinerais);
    }

    // COMMUNICATION ENTRE MODS - Réception de messages
    // Cette méthode traite tous les messages que d'autres mods nous ont envoyés
    // Imaginez un système de messagerie entre mods !
    private void processIMC(final InterModProcessEvent event)
    {
        // On récupère tous les messages reçus et on les traite
        // event.getIMCStream() = flux de tous les messages reçus d'autres mods
        
        // Exemple de traitement avec les flux Java (Stream API) :
        // .map() = transformer chaque élément
        // .collect() = rassembler le tout dans une liste
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).  // Extraire le contenu de chaque message
                collect(Collectors.toList()));         // Transformer en liste Java
        
        // EXEMPLE RÉEL de traitement :
        // event.getIMCStream().forEach(message -> {
        //     if (message.getMethod().equals("addCompatibleTool")) {
        //         String toolName = (String) message.getMessageSupplier().get();
        //         // Ajouter cet outil à notre liste d'outils compatibles
        //         ajouterOutilCompatible(toolName);
        //     }
        // });
    }
    // ÉVÉNEMENTS DU JEU - Écouter ce qui se passe pendant la partie
    // @SubscribeEvent = "Forge, appelle cette méthode quand cet événement arrive !"
    // Différence avec les méthodes précédentes : celles-ci s'exécutent PENDANT le jeu, pas au démarrage
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // Cette méthode s'exécute quand le serveur Minecraft démarre (monde chargé)
        // Utile pour initialiser des données de monde, des commandes custom, etc.
        LOGGER.info("HELLO from server starting");
        
        // EXEMPLES de ce qu'on pourrait faire ici :
        // - Enregistrer des commandes custom (/monmod give ruby)
        // - Charger des données sauvegardées du monde
        // - Initialiser des systèmes globaux (économie, guildes, etc.)
        // - Configurer des événements récurrents (météores qui tombent, etc.)
    }

    // CLASSE INTERNE - Gestionnaire d'enregistrement des éléments
    // Cette classe s'occupe d'enregistrer tous vos nouveaux éléments (blocs, items, entités, etc.)
    // @EventBusSubscriber = cette classe écoute automatiquement les événements (pas besoin de s'enregistrer manuellement)
    // bus=MOD = on écoute les événements du MOD (enregistrement), pas les événements du JEU (partie en cours)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        
        // ENREGISTREMENT DES BLOCS - Quand Minecraft enregistre tous les blocs du jeu
        // Cette méthode s'exécute PENDANT le chargement, avant que le jeu ne démarre
        // C'est LE moment pour ajouter vos blocs custom au jeu !
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            
            // Message de debug pour savoir qu'on est dans la bonne méthode
            LOGGER.info("HELLO from Register Block");
            
            // EXEMPLE CONCRET de ce qu'on ferait ici pour ajouter un bloc custom :
            // 
            // 1. Créer le bloc :
            // Block monBlocCustom = new Block(Block.Properties.create(Material.ROCK)
            //     .hardnessAndResistance(3.0f)  // Résistance du bloc
            //     .sound(SoundType.STONE));     // Son quand on marche dessus
            //
            // 2. L'enregistrer :
            // blockRegistryEvent.getRegistry().register(monBlocCustom.setRegistryName("monmod", "mon_bloc"));
            //
            // 3. Maintenant "mon_bloc" existe dans Minecraft !
        }
        
        // AUTRES ÉVÉNEMENTS D'ENREGISTREMENT possibles :
        // @SubscribeEvent
        // public static void onItemsRegistry(RegistryEvent.Register<Item> event) {
        //     // Enregistrer des items custom (épées, outils, nourriture, etc.)
        // }
        //
        // @SubscribeEvent  
        // public static void onEntitiesRegistry(RegistryEvent.Register<EntityType<?>> event) {
        //     // Enregistrer des entités custom (nouveaux mobs, animaux, etc.)
        // }
    }
}
