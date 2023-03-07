package com.uraneptus.glowworms.core.data.client;

import com.uraneptus.glowworms.GlowwormsMod;
import com.uraneptus.glowworms.common.blocks.GlowwormsBlock;
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
        glowwormsBlock(GlowwormsBlocks.GLOWWORMS);

    }

    private void basicBlock(Supplier<? extends Block> block) {
        simpleBlock(block.get());
    }

    private void glowwormsBlock(Supplier<? extends Block> block) {
        getVariantBuilder(block.get()).forAllStatesExcept(blockState -> {
            GlowwormsBlock.GlowwormState glowwormState = blockState.getValue(GlowwormsBlock.GLOWWORM_STATE);
            String suffix = switch (glowwormState) {
                case BASE, MIDDLE, END -> "_" + glowwormState;
            };

            return ConfiguredModel.builder().modelFile(
                    models().withExistingParent(GlowwormsDatagenUtil.name(block.get()) + suffix, GlowwormsDatagenUtil.vanillaBlockLocation(GlowwormsDatagenUtil.CROSS)).renderType("tripwire")
                            .texture(GlowwormsDatagenUtil.CROSS, GlowwormsDatagenUtil.modBlockLocation(GlowwormsDatagenUtil.name(block.get()) + suffix))).build();
        }, GlowwormsBlock.AGE);
    }
}
