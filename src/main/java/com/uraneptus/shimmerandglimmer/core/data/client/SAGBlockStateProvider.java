package com.uraneptus.shimmerandglimmer.core.data.client;

import com.uraneptus.shimmerandglimmer.ShimmerAndGlimmer;
import com.uraneptus.shimmerandglimmer.common.blocks.GlowwormsBlock;
import com.uraneptus.shimmerandglimmer.core.data.SAGDatagenUtil;
import com.uraneptus.shimmerandglimmer.core.registry.SAGBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

import static com.uraneptus.shimmerandglimmer.core.data.SAGDatagenUtil.*;

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
        candleBlock(SAGBlocks.BIOLUMINESCENT_CANDLE);

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

    private void candleBlock(Supplier<? extends Block> block) {
        getVariantBuilder(block.get()).forAllStatesExcept(blockstate -> {
            int candles = blockstate.getValue(BlockStateProperties.CANDLES);

            String variants = switch (candles) {
                case 1 -> "_one_candle";
                case 2 -> "_two_candles";
                case 3 -> "_three_candles";
                case 4 -> "_four_candles";
                default -> "";
            };

            String templatePath = "template" + (candles > 1 ? variants : "_candle");
            String lit = blockstate.getValue(BlockStateProperties.LIT) ? "_lit" : "";
            String filePath = modBlockLocation(name(block.get())) + variants + lit;
            ResourceLocation texture = modBlockLocation(name(block.get()) + lit);

            ModelFile modelFile = models().withExistingParent(filePath, vanillaBlockLocation(templatePath))
                    .texture("all", texture)
                    .texture("particle", texture);

            return ConfiguredModel.builder().modelFile(modelFile).build();
        }, BlockStateProperties.WATERLOGGED);
    }
}
