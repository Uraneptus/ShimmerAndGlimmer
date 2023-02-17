package com.uraneptus.glowworms.core.other.tags;

import com.uraneptus.glowworms.GlowwormsMod;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class GlowwormsBlockTags {

    public static final TagKey<Block> GLOWWORMS_PLACEABLE = TagKey.create(Registry.BLOCK_REGISTRY, GlowwormsMod.modPrefix("glowworms_placeable"));
    public static final TagKey<Block> GLOWWORMS = TagKey.create(Registry.BLOCK_REGISTRY, GlowwormsMod.modPrefix("glowworms"));
}
