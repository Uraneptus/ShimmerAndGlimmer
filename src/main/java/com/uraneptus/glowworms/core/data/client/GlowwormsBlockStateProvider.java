package com.uraneptus.glowworms.core.data.client;

import com.uraneptus.glowworms.GlowwormsMod;
import com.uraneptus.glowworms.core.data.GlowwormsDatagenUtil;
import com.uraneptus.glowworms.core.registry.GlowwormsBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

@SuppressWarnings("SameParameterValue")
public class GlowwormsBlockStateProvider extends BlockStateProvider {
    public GlowwormsBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, GlowwormsMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        glowwormsBlocks(GlowwormsBlocks.GLOWWORMS);
        glowwormsBlocks(GlowwormsBlocks.GLOWWORMS_PLANT);

    }

    private void basicBlock(Supplier<? extends Block> block) {
        simpleBlock(block.get());
    }

    private void glowwormsBlocks(Supplier<? extends Block> block) {
        getVariantBuilder(block.get()).forAllStatesExcept(blockState -> ConfiguredModel.builder().modelFile(
                models().withExistingParent(GlowwormsDatagenUtil.name(block.get()), GlowwormsDatagenUtil.vanillaBlockLocation(GlowwormsDatagenUtil.CROSS)).renderType("tripwire")
                        .texture(GlowwormsDatagenUtil.CROSS, GlowwormsDatagenUtil.modBlockLocation(GlowwormsDatagenUtil.name(block.get())))).build(), GrowingPlantHeadBlock.AGE);
    }

}
