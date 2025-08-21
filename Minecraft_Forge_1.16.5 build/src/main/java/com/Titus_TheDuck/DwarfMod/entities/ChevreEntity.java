package com.Titus_TheDuck.DwarfMod.entities;

import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.DamageSource;

public class ChevreEntity extends SheepEntity {
    public ChevreEntity(EntityType<? extends SheepEntity> type, World world) {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
    return SheepEntity.createAttributes()
        .add(Attributes.MAX_HEALTH, 13.0D)    // Plus résistante qu'un mouton ; 13 coeur. 
        .add(Attributes.MOVEMENT_SPEED, 0.30D)  // Plus rapide; environ 13 blocs/seconde
        .add(Attributes.JUMP_STRENGTH, 1D);   // Saute plus haut !; (environ2.5/3 block)
    }
    
    // Comportements spéciaux de la chèvre (saut plus haut, etc.)
}