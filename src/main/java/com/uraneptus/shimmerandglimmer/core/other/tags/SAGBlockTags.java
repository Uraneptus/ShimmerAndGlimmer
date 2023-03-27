package com.uraneptus.shimmerandglimmer.core.other.tags;

import com.uraneptus.shimmerandglimmer.ShimmerAndGlimmer;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class SAGBlockTags {

    public static final TagKey<Block> GLOWWORMS_PLACEABLE = TagKey.create(Registry.BLOCK_REGISTRY, ShimmerAndGlimmer.modPrefix("glowworms_placeable"));
    public static final TagKey<Block> GLOWWORMS = TagKey.create(Registry.BLOCK_REGISTRY, ShimmerAndGlimmer.modPrefix("glowworms"));
}
