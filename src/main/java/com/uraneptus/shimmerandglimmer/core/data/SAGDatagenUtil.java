package com.uraneptus.shimmerandglimmer.core.data;

import com.uraneptus.shimmerandglimmer.ShimmerAndGlimmer;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public class SAGDatagenUtil {
    public static final String LAYER0 = "layer0";
    public static final String CROSS = "cross";
    public static final String ALL = "all";
    public static final ResourceLocation GENERATED = vanillaItemLocation("generated");
    public static final ResourceLocation HANDHELD = vanillaItemLocation("handheld");
    public static final ResourceLocation SPAWN_EGG = vanillaItemLocation("template_spawn_egg");
    public static final ResourceLocation CUBE_NO_SHADE = modBlockLocation("cube_no_shade");
    //This is the same as the regular cross parent, but this way it can be modified via ressourcepacks without modifying everything that is child of the cross model
    public static final ResourceLocation GLOWWORMS = modBlockLocation("glowworms");

    public static final RegistryAccess REGISTRY_ACCESS = RegistryAccess.builtinCopy();
    public static final Registry<ConfiguredFeature<?, ?>> CONFIGURED_FEATURE_REGISTRY = REGISTRY_ACCESS.registryOrThrow(Registry.CONFIGURED_FEATURE_REGISTRY);
    public static final Registry<Biome> BIOME_REGISTRY = REGISTRY_ACCESS.registryOrThrow(Registry.BIOME_REGISTRY);
    public static final Registry<PlacedFeature> PLACED_FEATURE_REGISTRY = REGISTRY_ACCESS.registryOrThrow(Registry.PLACED_FEATURE_REGISTRY);

    public static Holder<ConfiguredFeature<?, ?>> getConfigHolder(String name) {
        return CONFIGURED_FEATURE_REGISTRY.getOrCreateHolderOrThrow(ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, ShimmerAndGlimmer.modPrefix(name)));
    }

    public static HolderSet<PlacedFeature> getPlacementHolder(String name) {
        return HolderSet.direct(PLACED_FEATURE_REGISTRY.getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, ShimmerAndGlimmer.modPrefix(name))));
    }

    public static String name(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }

    public static String name(Item item) {
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }

    public static ResourceLocation modBlockLocation(String path) {
        return ShimmerAndGlimmer.modPrefix(ModelProvider.BLOCK_FOLDER + "/" + path);
    }

    public static ResourceLocation modItemLocation(String path) {
        return ShimmerAndGlimmer.modPrefix(ModelProvider.ITEM_FOLDER + "/" + path);
    }

    public static ResourceLocation vanillaBlockLocation(String path) {
        return new ResourceLocation(ModelProvider.BLOCK_FOLDER + "/" + path);
    }

    public static ResourceLocation vanillaItemLocation(String path) {
        return new ResourceLocation(ModelProvider.ITEM_FOLDER + "/" + path);
    }
}
