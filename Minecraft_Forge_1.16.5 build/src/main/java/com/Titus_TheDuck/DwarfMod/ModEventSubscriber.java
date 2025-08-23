package com.Titus_TheDuck.DwarfMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import com.Titus_TheDuck.DwarfMod.entities.ChevreEntity;

@Mod.EventBusSubscriber(modid = DwarfMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {
    @SubscribeEvent
    public static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(DwarfMod.CHEVRE.get(), ChevreEntity.createAttributes().build());
    }
}