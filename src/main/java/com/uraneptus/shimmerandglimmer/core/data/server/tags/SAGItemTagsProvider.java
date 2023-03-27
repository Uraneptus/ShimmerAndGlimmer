package com.uraneptus.shimmerandglimmer.core.data.server.tags;

import com.uraneptus.shimmerandglimmer.ShimmerAndGlimmer;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class SAGItemTagsProvider extends ItemTagsProvider {

    public SAGItemTagsProvider(DataGenerator generator, BlockTagsProvider provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, provider, ShimmerAndGlimmer.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

    }
}
