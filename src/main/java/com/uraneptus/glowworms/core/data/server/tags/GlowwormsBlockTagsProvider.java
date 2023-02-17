package com.uraneptus.glowworms.core.data.server.tags;

import com.uraneptus.glowworms.GlowwormsMod;
import com.uraneptus.glowworms.core.other.tags.GlowwormsBlockTags;
import com.uraneptus.glowworms.core.registry.GlowwormsBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class GlowwormsBlockTagsProvider extends BlockTagsProvider {

    public GlowwormsBlockTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, GlowwormsMod.MOD_ID, existingFileHelper);
    }

    @Override
    public void addTags() {
        this.tag(GlowwormsBlockTags.GLOWWORMS).add(
                GlowwormsBlocks.GLOWWORMS.get(),
                GlowwormsBlocks.GLOWWORMS_PLANT.get()
        );
        this.tag(GlowwormsBlockTags.GLOWWORMS_PLACEABLE)
                .addTag(BlockTags.DIRT)
                .addTag(BlockTags.BASE_STONE_OVERWORLD)
                .addTag(GlowwormsBlockTags.GLOWWORMS);
    }
}
