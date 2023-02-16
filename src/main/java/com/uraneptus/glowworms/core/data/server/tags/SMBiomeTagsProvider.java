package com.uraneptus.glowworms.core.data.server.tags;

import com.uraneptus.glowworms.Glowworms;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class SMBiomeTagsProvider extends BiomeTagsProvider {
    public SMBiomeTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper fileHelper) {
        super(generator, Glowworms.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags() {

    }
}
