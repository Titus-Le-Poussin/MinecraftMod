package com.Titus_TheDuck.DwarfMod.world;

import com.Titus_TheDuck.DwarfMod.DwarfMod;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class OreGeneration {
    
    public static final ConfiguredFeature<?, ?> RUBIS_ORE_FEATURE = Feature.ORE
        .configured(new OreFeatureConfig(
            OreFeatureConfig.FillerBlockType.NATURAL_STONE,
            DwarfMod.RUBIS_ORE.get().defaultBlockState(),
            3)) // 3 blocs de rubis par veine
        .decorated(Placement.RANGE.configured(
    new TopSolidRangeConfig(10, 0, (40)))); // Plus de tentatives, zone Y 10-40

    @SubscribeEvent
    public static void onBiomeLoading(BiomeLoadingEvent event) {
        event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, RUBIS_ORE_FEATURE);
    }
}