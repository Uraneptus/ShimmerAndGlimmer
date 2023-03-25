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
        tag(GlowwormsBiomeTags.IS_OVERWORLD_NO_CAVES)
                .addTag(BiomeTags.IS_OCEAN)
                .addTag(BiomeTags.IS_FOREST)
                .addTag(BiomeTags.IS_SAVANNA)
                .addTag(BiomeTags.IS_MOUNTAIN)
                .addTag(BiomeTags.IS_BADLANDS)
                .addTag(BiomeTags.IS_JUNGLE)
                .addTag(BiomeTags.IS_BEACH)
                .addTag(BiomeTags.IS_RIVER)
                .addTag(BiomeTags.IS_HILL)
                .addTag(BiomeTags.IS_TAIGA)
                .addTag(Tags.Biomes.IS_SNOWY)
                .addTag(Tags.Biomes.IS_PLAINS)
                .addTag(Tags.Biomes.IS_SANDY)
                .addTag(Tags.Biomes.IS_SWAMP)
                .addTag(Tags.Biomes.IS_MUSHROOM);

        tag(GlowwormsBiomeTags.GLOWWORMS_GENERATE_IN).addTag(GlowwormsBiomeTags.IS_OVERWORLD_NO_CAVES).add(Biomes.DEEP_DARK);
    }
}
