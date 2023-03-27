package com.uraneptus.shimmerandglimmer.core.other.tags;

import com.uraneptus.shimmerandglimmer.ShimmerAndGlimmer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class SAGBiomeTags {
    public static final TagKey<Biome> GLOWWORMS_GENERATE_IN = TagKey.create(Registry.BIOME_REGISTRY, ShimmerAndGlimmer.modPrefix("glowworms_generate_in"));
    public static final TagKey<Biome> IS_OVERWORLD_NO_CAVES = TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("forge", "is_overworld_no_caves"));
}
