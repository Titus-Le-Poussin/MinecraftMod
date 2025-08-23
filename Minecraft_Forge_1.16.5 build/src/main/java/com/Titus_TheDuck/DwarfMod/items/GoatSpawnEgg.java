package com.Titus_TheDuck.DwarfMod.items;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemGroup;

public class GoatSpawnEgg extends SwordItem {
    public GoatSpawnEgg() {
        super(ModItemTier.RUBIS, 3, -2.4f, new Properties()
            .tab(ItemGroup.TAB_COMBAT));
    }
}