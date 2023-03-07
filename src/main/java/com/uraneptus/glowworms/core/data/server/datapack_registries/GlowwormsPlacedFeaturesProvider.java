package com.uraneptus.glowworms.core.data.server.datapack_registries;

import com.mojang.serialization.JsonOps;
import com.uraneptus.glowworms.GlowwormsMod;
import com.uraneptus.glowworms.core.data.GlowwormsDatagenUtil;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlowwormsPlacedFeaturesProvider {
    private static final Map<ResourceLocation, PlacedFeature> ENTRIES = new HashMap<>();

    public static JsonCodecProvider<PlacedFeature> createPlacedFeatures(DataGenerator generator, ExistingFileHelper fileHelper) {
        //addHangingCaveFeature("glowworms", 188);

        return JsonCodecProvider.forDatapackRegistry(generator, fileHelper, GlowwormsMod.MOD_ID,  RegistryOps.create(JsonOps.INSTANCE, GlowwormsDatagenUtil.REGISTRY_ACCESS), Registry.PLACED_FEATURE_REGISTRY, ENTRIES);
    }

    private static void addHangingCaveFeature(String name, int count) {
        addFeaturePlacement(name, CountPlacement.of(count),  InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome());
    }

    private static void addFeaturePlacement(String name, PlacementModifier... placementModifiers) {
        addEntry(name, new PlacedFeature(GlowwormsDatagenUtil.getConfigHolder(name), List.of(placementModifiers)));
    }

    private static void addEntry(String name, PlacedFeature feature) {
        ENTRIES.put(GlowwormsMod.modPrefix(name), feature);
    }
}