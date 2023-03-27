package com.uraneptus.shimmerandglimmer.core.data.server.datapack_registries;

import com.mojang.serialization.JsonOps;
import com.uraneptus.shimmerandglimmer.ShimmerAndGlimmer;
import com.uraneptus.shimmerandglimmer.core.data.SAGDatagenUtil;
import com.uraneptus.shimmerandglimmer.core.other.tags.SAGBiomeTags;
import net.minecraft.core.HolderSet;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class SAGBiomeModifiersProvider {
    private static final Map<ResourceLocation, BiomeModifier> ENTRIES = new HashMap<>();

    public static JsonCodecProvider<BiomeModifier> createBiomeModifiers(DataGenerator generator, ExistingFileHelper fileHelper) {
        addFeatureModifier("glowworms", SAGBiomeTags.GLOWWORMS_GENERATE_IN, GenerationStep.Decoration.VEGETAL_DECORATION);

        return JsonCodecProvider.forDatapackRegistry(generator, fileHelper, ShimmerAndGlimmer.MOD_ID,  RegistryOps.create(JsonOps.INSTANCE, SAGDatagenUtil.REGISTRY_ACCESS), ForgeRegistries.Keys.BIOME_MODIFIERS, ENTRIES);
    }

    private static void addFeatureModifier(String name, TagKey<Biome> biomeTag, GenerationStep.Decoration decorationStep) {
        addEntry(name, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(new HolderSet.Named<>(SAGDatagenUtil.BIOME_REGISTRY, biomeTag), SAGDatagenUtil.getPlacementHolder(name), decorationStep));
    }

    private static void addSingleSpawnModifier(String name, TagKey<Biome> biomeTag, EntityType<?> entity, int weight, int minCount, int maxCount) {
        addEntry(name, ForgeBiomeModifiers.AddSpawnsBiomeModifier.singleSpawn(new HolderSet.Named<>(SAGDatagenUtil.BIOME_REGISTRY, biomeTag), new MobSpawnSettings.SpawnerData(entity, weight, minCount, maxCount)));
    }

    private static void addEntry(String name, BiomeModifier modifier) {
        ENTRIES.put(ShimmerAndGlimmer.modPrefix(name), modifier);
    }
}