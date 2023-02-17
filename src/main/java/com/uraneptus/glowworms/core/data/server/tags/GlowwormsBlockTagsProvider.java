package com.uraneptus.glowworms.core.data.server.tags;

import com.uraneptus.glowworms.GlowwormsMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class GlowwormsBlockTagsProvider extends BlockTagsProvider {

    public GlowwormsBlockTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, GlowwormsMod.MOD_ID, existingFileHelper);
    }

    @Override
    public void addTags() {

    }
}
