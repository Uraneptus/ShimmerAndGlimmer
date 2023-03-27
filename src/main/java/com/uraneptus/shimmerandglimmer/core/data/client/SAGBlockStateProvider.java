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
                    models().withExistingParent(SAGDatagenUtil.name(block.get()) + suffix, SAGDatagenUtil.vanillaBlockLocation(SAGDatagenUtil.CROSS)).renderType("tripwire")
                            .texture(SAGDatagenUtil.CROSS, SAGDatagenUtil.modBlockLocation(SAGDatagenUtil.name(block.get()) + suffix))).build();
        }, GlowwormsBlock.AGE);
    }
}
