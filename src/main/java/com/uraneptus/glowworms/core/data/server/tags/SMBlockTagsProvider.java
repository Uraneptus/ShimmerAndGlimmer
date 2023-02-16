package com.uraneptus.glowworms.core.data.server.tags;

import com.uraneptus.glowworms.Glowworms;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class SMBlockTagsProvider extends BlockTagsProvider {

    public SMBlockTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, Glowworms.MOD_ID, existingFileHelper);
    }

    @Override
    public void addTags() {

    }
}
