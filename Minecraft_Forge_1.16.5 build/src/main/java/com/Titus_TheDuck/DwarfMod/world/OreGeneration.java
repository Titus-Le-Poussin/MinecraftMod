package com.Titus_TheDuck.DwarfMod.world;

import com.Titus_TheDuck.DwarfMod.DwarfMod;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class OreGeneration {
    
    // Configuration du minerai de rubis
    public static final ConfiguredFeature<?, ?> RUBIS_ORE_FEATURE = Feature.ORE
        .configured(new OreFeatureConfig(
            OreFeatureConfig.FillerBlockType.NATURAL_STONE,
            DwarfMod.RUBIS_ORE.get().defaultBlockState(),
            3)) // taille de veine (1-3 blocs)
        .decorated(Placement.COUNT_RANGE.configured(
            new CountRangeConfig(6, 5, 0, 20))); // 6 tentatives, Y 5-20

    @SubscribeEvent
    public static void onBiomeLoading(BiomeLoadingEvent event) {
        // Ajoute le minerai dans tous les biomes
        event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, RUBIS_ORE_FEATURE);
    }
}