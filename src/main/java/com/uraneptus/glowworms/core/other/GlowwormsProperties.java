package com.uraneptus.glowworms.core.other;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

@SuppressWarnings("unused")
public class GlowwormsProperties {

    public static final class Blocks {

    }

    public static final class Items {

        public static final Item.Properties MISC_TAB = new Item.Properties().tab(CreativeModeTab.TAB_MISC);
        public static final Item.Properties FOOD_TAB = new Item.Properties().tab(CreativeModeTab.TAB_FOOD);
        public static final Item.Properties REDSTONE_TAB = new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE);
        public static final Item.Properties BUILDING_TAB = new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS);

        public static Item.Properties cannotStack() {
            return new Item.Properties().stacksTo(1);
        }
        public static Item.Properties sixteenStack() {
           return new Item.Properties().stacksTo(16);
        }

        //Item Specific

    }

    public static final class Foods {

    }
}
