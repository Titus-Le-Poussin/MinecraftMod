package com.Titus_TheDuck.DwarfMod.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import com.Titus_TheDuck.DwarfMod.DwarfMod;
import com.Titus_TheDuck.DwarfMod.entities.ChevreEntity;
import com.Titus_TheDuck.DwarfMod.entities.ChevreRenderer;

@Mod.EventBusSubscriber(modid = DwarfMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventSubscriber {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(DwarfMod.CHEVRE.get(), ChevreRenderer::new);
    }
}