package com.uraneptus.shimmerandglimmer.core.other.tags;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class SAGItemTags {
    public static final TagKey<Item> DYES = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "dyes"));
    public static final TagKey<Item> BIOLUMINESCENT_DYE = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "dyes/bioluminescent"));

}
