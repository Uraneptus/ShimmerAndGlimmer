package com.uraneptus.glowworms.core.data.client;

import com.uraneptus.glowworms.GlowwormsMod;
import com.uraneptus.glowworms.core.registry.GlowwormsBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

import static com.uraneptus.glowworms.core.data.GlowwormsDatagenUtil.*;

@SuppressWarnings({"unused", "SameParameterValue"})
public class GlowwormsItemModelProvider extends ItemModelProvider {

    public GlowwormsItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, GlowwormsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        glowwormsItem(GlowwormsBlocks.GLOWWORMS);
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
