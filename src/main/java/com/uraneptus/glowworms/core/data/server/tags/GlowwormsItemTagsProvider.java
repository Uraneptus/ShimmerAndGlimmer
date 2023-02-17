package com.uraneptus.glowworms.core.data.server.tags;

import com.uraneptus.glowworms.GlowwormsMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class GlowwormsItemTagsProvider extends ItemTagsProvider {

    public GlowwormsItemTagsProvider(DataGenerator generator, BlockTagsProvider provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, provider, GlowwormsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

    }
}
