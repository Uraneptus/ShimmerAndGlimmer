package com.uraneptus.shimmerandglimmer.core.data.server.tags;

import com.uraneptus.shimmerandglimmer.ShimmerAndGlimmer;
import com.uraneptus.shimmerandglimmer.core.other.tags.SAGBiomeTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class SAGBiomeTagsProvider extends BiomeTagsProvider {
    public SAGBiomeTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper fileHelper) {
        super(generator, ShimmerAndGlimmer.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags() {
        tag(SAGBiomeTags.IS_OVERWORLD_NO_CAVES)
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

        tag(SAGBiomeTags.GLOWWORMS_GENERATE_IN).addTag(SAGBiomeTags.IS_OVERWORLD_NO_CAVES).add(Biomes.DEEP_DARK);
    }
}
