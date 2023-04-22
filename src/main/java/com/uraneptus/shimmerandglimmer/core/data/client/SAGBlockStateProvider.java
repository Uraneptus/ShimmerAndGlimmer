package com.uraneptus.shimmerandglimmer.core.data.client;

import com.uraneptus.shimmerandglimmer.ShimmerAndGlimmer;
import com.uraneptus.shimmerandglimmer.common.blocks.GlowwormsBlock;
import com.uraneptus.shimmerandglimmer.core.data.SAGDatagenUtil;
import com.uraneptus.shimmerandglimmer.core.registry.SAGBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

@SuppressWarnings("SameParameterValue")
public class SAGBlockStateProvider extends BlockStateProvider {
    public SAGBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, ShimmerAndGlimmer.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        glowwormsBlock(SAGBlocks.GLOWWORMS);
        basicBlockNoShade(SAGBlocks.BIOLUMINESCENT_WOOL);
        basicBlockNoShade(SAGBlocks.BIOLUMINESCENT_TERRACOTTA);
        basicBlockNoShade(SAGBlocks.BIOLUMINESCENT_CONCRETE);
        basicBlockNoShade(SAGBlocks.BIOLUMINESCENT_CONCRETE_POWDER);
        basicBlockNoShade(SAGBlocks.BIOLUMINESCENT_STAINED_GLASS, "translucent");

    }

    private void basicBlock(Supplier<? extends Block> block) {
        simpleBlock(block.get());
    }

    private void basicBlockNoShade(Supplier<? extends Block> block) {
        getVariantBuilder(block.get()).partialState().setModels(
                new ConfiguredModel(models()
                        .withExistingParent(SAGDatagenUtil.name(block.get()), SAGDatagenUtil.CUBE_NO_SHADE)
                        .texture(SAGDatagenUtil.ALL, SAGDatagenUtil.modBlockLocation(SAGDatagenUtil.name(block.get())))));
    }

    private void basicBlockNoShade(Supplier<? extends Block> block, String renderType) {
        getVariantBuilder(block.get()).partialState().setModels(
                new ConfiguredModel(models()
                        .withExistingParent(SAGDatagenUtil.name(block.get()), SAGDatagenUtil.CUBE_NO_SHADE)
                        .texture(SAGDatagenUtil.ALL, SAGDatagenUtil.modBlockLocation(SAGDatagenUtil.name(block.get()))).renderType(renderType)));
    }

    private void glowwormsBlock(Supplier<? extends Block> block) {
        getVariantBuilder(block.get()).forAllStatesExcept(blockState -> {
            GlowwormsBlock.GlowwormState glowwormState = blockState.getValue(GlowwormsBlock.GLOWWORM_STATE);
            String suffix = switch (glowwormState) {
                case BASE, MIDDLE, END -> "_" + glowwormState;
            };

            return ConfiguredModel.builder().modelFile(
                    models().withExistingParent(SAGDatagenUtil.name(block.get()) + suffix, SAGDatagenUtil.GLOWWORMS)
                            .texture(SAGDatagenUtil.CROSS, SAGDatagenUtil.modBlockLocation(SAGDatagenUtil.name(block.get()) + suffix))).build();
        }, GlowwormsBlock.AGE);
    }
}
