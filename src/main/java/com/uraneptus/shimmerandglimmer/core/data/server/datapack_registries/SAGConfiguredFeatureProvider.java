package com.uraneptus.shimmerandglimmer.core.data.server.datapack_registries;

import com.mojang.serialization.JsonOps;
import com.uraneptus.shimmerandglimmer.ShimmerAndGlimmer;
import com.uraneptus.shimmerandglimmer.common.blocks.GlowwormsBlock;
import com.uraneptus.shimmerandglimmer.core.data.SAGDatagenUtil;
import com.uraneptus.shimmerandglimmer.core.registry.SAGBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class SAGConfiguredFeatureProvider {
    private static final Map<ResourceLocation, ConfiguredFeature<?, ?>> ENTRIES = new HashMap<>();

    public static JsonCodecProvider<ConfiguredFeature<?, ?>> createConfiguredFeatures(DataGenerator generator, ExistingFileHelper fileHelper) {
        addGlowwormsConfig("glowworms", SAGBlocks.GLOWWORMS);

        return JsonCodecProvider.forDatapackRegistry(generator, fileHelper, ShimmerAndGlimmer.MOD_ID,  RegistryOps.create(JsonOps.INSTANCE, SAGDatagenUtil.REGISTRY_ACCESS), Registry.CONFIGURED_FEATURE_REGISTRY, ENTRIES);
    }

    private static void addGlowwormsConfig(String name, Supplier<? extends Block> block) {
        addEntry(name, new ConfiguredFeature<>(Feature.BLOCK_COLUMN, new BlockColumnConfiguration(List.of(
                BlockColumnConfiguration.layer(ConstantInt.of(1), BlockStateProvider.simple(block.get().defaultBlockState()
                        .setValue(GlowwormsBlock.GLOWWORM_STATE, GlowwormsBlock.GlowwormState.BASE))),

                BlockColumnConfiguration.layer(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder()
                                .add(UniformInt.of(2, 15), 2)
                                .add(UniformInt.of(0, 3), 4)
                                .add(UniformInt.of(0, 7), 10).build()),
                        BlockStateProvider.simple(block.get().defaultBlockState()
                                .setValue(GlowwormsBlock.GLOWWORM_STATE, GlowwormsBlock.GlowwormState.MIDDLE))),

                BlockColumnConfiguration.layer(ConstantInt.of(1), BlockStateProvider.simple(block.get().defaultBlockState()
                        .setValue(GlowwormsBlock.GLOWWORM_STATE, GlowwormsBlock.GlowwormState.END)))),
                Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, true)));
    }

    private static void addEntry(String name, ConfiguredFeature<?, ?> feature) {
        ENTRIES.put(ShimmerAndGlimmer.modPrefix(name), feature);
    }
}