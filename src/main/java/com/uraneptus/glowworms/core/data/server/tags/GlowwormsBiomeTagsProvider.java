package com.uraneptus.glowworms.core.data.server.tags;

import com.uraneptus.glowworms.GlowwormsMod;
import com.uraneptus.glowworms.core.other.tags.GlowwormsBiomeTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class GlowwormsBiomeTagsProvider extends BiomeTagsProvider {
    public GlowwormsBiomeTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper fileHelper) {
        super(generator, GlowwormsMod.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags() {
        tag(GlowwormsBiomeTags.GLOWWORMS_GENERATE_IN).addTag(BiomeTags.IS_OVERWORLD);
    }
}
