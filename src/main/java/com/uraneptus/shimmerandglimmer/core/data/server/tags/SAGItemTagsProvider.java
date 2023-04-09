package com.uraneptus.shimmerandglimmer.core.data.server.tags;

import com.uraneptus.shimmerandglimmer.ShimmerAndGlimmer;
import com.uraneptus.shimmerandglimmer.core.other.tags.SAGItemTags;
import com.uraneptus.shimmerandglimmer.core.registry.SAGItems;
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
        tag(SAGItemTags.DYES).addTag(SAGItemTags.BIOLUMINESCENT_DYE);
        tag(SAGItemTags.BIOLUMINESCENT_DYE).add(SAGItems.BIOLUMINESCENT_DYE.get());
    }
}
