package com.Titus_TheDuck.DwarfMod.entities;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import com.Titus_TheDuck.DwarfMod.client.chevre; // ton modèle exporté

public class ChevreRenderer extends MobRenderer<Entity, chevre> {
    public ChevreRenderer(EntityRendererManager renderManager) {
        super(renderManager, new chevre(), 0.7F); // 0.7F = taille de l’ombre
    }

    @Override
    public ResourceLocation getTextureLocation(Entity entity) {
        return new ResourceLocation("dwarfmod:textures/entity/chevre/MountainGoat.png");
    }
}