package com.uraneptus.shimmerandglimmer.core.data.client;

import com.uraneptus.shimmerandglimmer.ShimmerAndGlimmer;
import com.uraneptus.shimmerandglimmer.core.registry.SAGBlocks;
import com.uraneptus.shimmerandglimmer.core.registry.SAGItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

import static com.uraneptus.shimmerandglimmer.core.data.SAGDatagenUtil.*;

@SuppressWarnings({"unused", "SameParameterValue"})
public class SAGItemModelProvider extends ItemModelProvider {

    public SAGItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ShimmerAndGlimmer.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        glowwormsItem(SAGBlocks.GLOWWORMS);
        basicItem(SAGItems.BIOLUMINESCENT_DYE);
        basicBlockItem(SAGBlocks.BIOLUMINESCENT_WOOL);
        basicBlockItem(SAGBlocks.BIOLUMINESCENT_TERRACOTTA);
        basicBlockItem(SAGBlocks.BIOLUMINESCENT_CONCRETE);
        basicBlockItem(SAGBlocks.BIOLUMINESCENT_CONCRETE_POWDER);
        basicBlockItem(SAGBlocks.BIOLUMINESCENT_STAINED_GLASS);
    }

    private void basicBlockItem(Supplier<? extends Block> blockForItem) {
        withExistingParent(name(blockForItem.get()), modBlockLocation(name(blockForItem.get())));
    }

    private void basicItem(Supplier<? extends Item> item) {
        basicItem(item.get());
    }

    private void blockItemWithBlockTexture(Supplier<? extends Block> blockForItem) {
        withExistingParent(name(blockForItem.get()), GENERATED).texture(LAYER0, modBlockLocation(name(blockForItem.get())));
    }

    private void blockItemWithItemTexture(Supplier<? extends Block> blockForItem) {
        basicItem(blockForItem.get().asItem());
    }

    private void glowwormsItem(Supplier<? extends Block> blockForItem) {
        withExistingParent(name(blockForItem.get()), GENERATED).texture(LAYER0, modBlockLocation(name(blockForItem.get()) + "_end"));
    }
}
