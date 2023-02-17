package com.uraneptus.glowworms.core.data;

import com.uraneptus.glowworms.GlowwormsMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public class GlowwormsDatagenUtil {
    public static final String LAYER0 = "layer0";
    public static final String GENERATED = "item/generated";
    public static final String HANDHELD = "item/handheld";
    public static final String CROSS = "cross";

    public static String name(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }

    public static String name(Item item) {
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }

    public static ResourceLocation modBlockLocation(String path) {
        return GlowwormsMod.modPrefix(ModelProvider.BLOCK_FOLDER + "/" + path);
    }

    public static ResourceLocation modItemLocation(String path) {
        return GlowwormsMod.modPrefix(ModelProvider.ITEM_FOLDER + "/" + path);
    }

    public static ResourceLocation vanillaBlockLocation(String path) {
        return new ResourceLocation(ModelProvider.BLOCK_FOLDER + "/" + path);
    }

    public static ResourceLocation vanillaItemLocation(String path) {
        return new ResourceLocation(ModelProvider.ITEM_FOLDER + "/" + path);
    }

    public static ResourceLocation craftingPath(String name) {
        return GlowwormsMod.modPrefix("crafting/" + name);
    }

    public static ResourceLocation smeltingPath(String name) {
        return GlowwormsMod.modPrefix("smelting/" + name);
    }

    public static ResourceLocation blastingPath(String name) {
        return GlowwormsMod.modPrefix("blasting/" + name);
    }

    public static ResourceLocation smokingPath(String name) {
        return GlowwormsMod.modPrefix("smoking/" + name);
    }

    public static ResourceLocation campfire_cookingPath(String name) {
        return GlowwormsMod.modPrefix("campfire_cooking/" + name);
    }

    public static ResourceLocation stonecuttingPath(String name) {
        return GlowwormsMod.modPrefix("stonecutting/" + name);
    }

    public static ResourceLocation smithingPath(String name) {
        return GlowwormsMod.modPrefix("smithing/" + name);
    }

}
