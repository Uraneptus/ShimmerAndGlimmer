package com.uraneptus.shimmerandglimmer.core.data.server.tags;

import com.uraneptus.shimmerandglimmer.ShimmerAndGlimmer;
import com.uraneptus.shimmerandglimmer.core.other.tags.SAGBlockTags;
import com.uraneptus.shimmerandglimmer.core.registry.SAGBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class SAGBlockTagsProvider extends BlockTagsProvider {

    public SAGBlockTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, ShimmerAndGlimmer.MOD_ID, existingFileHelper);
    }

    @Override
    public void addTags() {
        this.tag(SAGBlockTags.GLOWWORMS).add(
                SAGBlocks.GLOWWORMS.get()
        );
        this.tag(SAGBlockTags.GLOWWORMS_PLACEABLE)
                .addTag(BlockTags.DIRT)
                .addTag(BlockTags.BASE_STONE_OVERWORLD)
                .add(Blocks.SCULK);
    }
}
