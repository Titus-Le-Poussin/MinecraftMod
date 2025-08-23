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
    public ChevreEntity(EntityType<? extends ChevreEntity> type, World world) {
        super(type, world);
    }
public static AttributeModifierMap.MutableAttribute createAttributes() {
    return SheepEntity.createAttributes()
        .add(Attributes.MAX_HEALTH, 13.0D)
        .add(Attributes.MOVEMENT_SPEED, 0.30D);
}
    @Override
    protected SoundEvent getAmbientSound() {
        return com.Titus_TheDuck.DwarfMod.DwarfMod.CHEVRE_AMBIENT.get();
    }
}