package com.uraneptus.shimmerandglimmer.core.other;

import com.uraneptus.shimmerandglimmer.common.blocks.GlowwormsBlock;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

@SuppressWarnings("unused")
public class SAGProperties {

    public static final class Blocks {
        public static final BlockBehaviour.Properties GLOWWORMS = BlockBehaviour.Properties.of(Material.PLANT).lightLevel(GlowwormsBlock.LIGHT_LEVEL).randomTicks().noOcclusion().noCollission().instabreak().sound(SoundType.WEEPING_VINES).emissiveRendering(net.minecraft.world.level.block.Blocks::always);

    }

    public static final class Items {

        public static final Item.Properties MISC_TAB = new Item.Properties().tab(CreativeModeTab.TAB_MISC);
        public static final Item.Properties FOOD_TAB = new Item.Properties().tab(CreativeModeTab.TAB_FOOD);
        public static final Item.Properties REDSTONE_TAB = new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE);
        public static final Item.Properties DECORATIONS = new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS);

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
