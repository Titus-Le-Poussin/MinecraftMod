package com.Titus_TheDuck.DwarfMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.AbstractBlock;
import net.minecraftforge.common.ToolType;

public class RubisOre extends Block {
    public RubisOre() {
        super(AbstractBlock.Properties.of(Material.STONE)
            .strength(3.0f, 3.0f)           // dureté et résistance
            .harvestTool(ToolType.PICKAXE)  // pioche requise
            .harvestLevel(2)                // niveau fer minimum
            .requiresCorrectToolForDrops()); // doit utiliser la bonne pioche
    }
}