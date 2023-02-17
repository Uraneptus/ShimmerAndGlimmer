package com.uraneptus.glowworms.core.data.server.tags;

import com.uraneptus.glowworms.GlowwormsMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class GlowwormsBiomeTagsProvider extends BiomeTagsProvider {
    public GlowwormsBiomeTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper fileHelper) {
        super(generator, GlowwormsMod.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags() {

    }
}
