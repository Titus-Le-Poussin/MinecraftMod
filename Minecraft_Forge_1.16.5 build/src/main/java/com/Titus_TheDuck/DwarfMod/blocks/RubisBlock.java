package com.Titus_TheDuck.DwarfMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.AbstractBlock;
import net.minecraftforge.common.ToolType;
import net.minecraft.block.SoundType;

public class RubisBlock extends Block {
    public RubisBlock() {
        super(AbstractBlock.Properties.of(Material.METAL)
            .strength(3.0f, 3.0f)           // dureté et résistance
            .harvestTool(ToolType.PICKAXE)  // pioche requise
            .harvestLevel(2)                // niveau fer minimum
            .requiresCorrectToolForDrops() // doit utiliser la bonne pioche
            .sound(SoundType.METAL));
    }
}