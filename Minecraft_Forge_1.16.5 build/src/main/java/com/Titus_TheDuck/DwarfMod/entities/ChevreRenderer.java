package com.Titus_TheDuck.DwarfMod.entities;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import com.Titus_TheDuck.DwarfMod.entities.ChevreModel;

public class ChevreRenderer extends MobRenderer<ChevreEntity, ChevreModel> {
    public ChevreRenderer(EntityRendererManager renderManager) {
        super(renderManager, new ChevreModel(), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(ChevreEntity entity) {
        return new ResourceLocation("dwarfmod:textures/entity/chevre/mountain_goat.png");
    }
}