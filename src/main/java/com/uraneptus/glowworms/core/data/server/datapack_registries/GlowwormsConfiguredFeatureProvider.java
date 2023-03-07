package com.uraneptus.glowworms.core.data.server.datapack_registries;

import com.mojang.serialization.JsonOps;
import com.uraneptus.glowworms.GlowwormsMod;
import com.uraneptus.glowworms.core.data.GlowwormsDatagenUtil;
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

public class GlowwormsConfiguredFeatureProvider {
    private static final Map<ResourceLocation, ConfiguredFeature<?, ?>> ENTRIES = new HashMap<>();

    public static JsonCodecProvider<ConfiguredFeature<?, ?>> createConfiguredFeatures(DataGenerator generator, ExistingFileHelper fileHelper) {
        //addHangingTwoBlockConfig("glowworms", BlockStateProvider.simple(GlowwormsBlocks.GLOWWORMS_PLANT.get()), new RandomizedIntStateProvider(BlockStateProvider.simple(GlowwormsBlocks.GLOWWORMS.get()), Glowworms.AGE, UniformInt.of(23, 25)));

        return JsonCodecProvider.forDatapackRegistry(generator, fileHelper, GlowwormsMod.MOD_ID,  RegistryOps.create(JsonOps.INSTANCE, GlowwormsDatagenUtil.REGISTRY_ACCESS), Registry.CONFIGURED_FEATURE_REGISTRY, ENTRIES);
    }

    private static void addHangingTwoBlockConfig(String name, BlockStateProvider bodyBlock, BlockStateProvider headBlock) {
        addEntry(name, new ConfiguredFeature<>(Feature.BLOCK_COLUMN, new BlockColumnConfiguration(List.of(
                BlockColumnConfiguration.layer(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder()
                                .add(UniformInt.of(0, 15), 2)
                                .add(UniformInt.of(0, 3), 4)
                                .add(UniformInt.of(0, 7), 10).build()), bodyBlock),
                BlockColumnConfiguration.layer(ConstantInt.of(1), headBlock)),
                Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, true)));
    }

    private static void addEntry(String name, ConfiguredFeature<?, ?> feature) {
        ENTRIES.put(GlowwormsMod.modPrefix(name), feature);
    }
}