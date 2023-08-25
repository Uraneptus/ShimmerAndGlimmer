package com.uraneptus.shimmerandglimmer;

import com.mojang.logging.LogUtils;
import com.uraneptus.shimmerandglimmer.core.data.client.SAGBlockStateProvider;
import com.uraneptus.shimmerandglimmer.core.data.client.SAGItemModelProvider;
import com.uraneptus.shimmerandglimmer.core.data.client.SAGLangProvider;
import com.uraneptus.shimmerandglimmer.core.data.server.SAGLootTableProvider;
import com.uraneptus.shimmerandglimmer.core.data.server.datapack_registries.SAGBiomeModifiersProvider;
import com.uraneptus.shimmerandglimmer.core.data.server.datapack_registries.SAGConfiguredFeatureProvider;
import com.uraneptus.shimmerandglimmer.core.data.server.datapack_registries.SAGPlacedFeaturesProvider;
import com.uraneptus.shimmerandglimmer.core.data.server.tags.SAGBiomeTagsProvider;
import com.uraneptus.shimmerandglimmer.core.data.server.tags.SAGBlockTagsProvider;
import com.uraneptus.shimmerandglimmer.core.data.server.tags.SAGItemTagsProvider;
import com.uraneptus.shimmerandglimmer.core.registry.SAGBlocks;
import com.uraneptus.shimmerandglimmer.core.registry.SAGItems;
import com.uraneptus.shimmerandglimmer.core.registry.SAGParticleTypes;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ShimmerAndGlimmer.MOD_ID)
@Mod.EventBusSubscriber(modid = ShimmerAndGlimmer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ShimmerAndGlimmer {
    public static final String MOD_ID = "shimmerandglimmer";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static ResourceLocation modPrefix(String path) {
        return new ResourceLocation(ShimmerAndGlimmer.MOD_ID, path);
    }

    public ShimmerAndGlimmer() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        bus.addListener(this::gatherData);

        SAGBlocks.BLOCKS.register(bus);
        SAGItems.ITEMS.register(bus);
        SAGParticleTypes.PARTICLES.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        boolean includeClient = event.includeClient();
        boolean includeServer = event.includeServer();
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        generator.addProvider(includeClient, new SAGBlockStateProvider(generator, fileHelper));
        generator.addProvider(includeClient, new SAGItemModelProvider(generator, fileHelper));
        generator.addProvider(includeClient, new SAGLangProvider(generator));

        SAGBlockTagsProvider blockTagProvider = new SAGBlockTagsProvider(generator, fileHelper);
        generator.addProvider(includeServer, blockTagProvider);
        generator.addProvider(includeServer, new SAGItemTagsProvider(generator, blockTagProvider, fileHelper));
        generator.addProvider(includeServer, new SAGBiomeTagsProvider(generator, fileHelper));
        generator.addProvider(includeServer, new SAGLootTableProvider(generator));
        generator.addProvider(includeServer, SAGBiomeModifiersProvider.createBiomeModifiers(generator, fileHelper));
        generator.addProvider(includeServer, SAGConfiguredFeatureProvider.createConfiguredFeatures(generator, fileHelper));
        generator.addProvider(includeServer, SAGPlacedFeaturesProvider.createPlacedFeatures(generator, fileHelper));

/*
        generator.addProvider(includeServer, new SMAdvancementProvider(generator, fileHelper));
        generator.addProvider(includeServer, new SMRecipeProvider(generator));
 */
    }
}
