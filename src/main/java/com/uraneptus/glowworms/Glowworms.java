package com.uraneptus.glowworms;

import com.google.gson.JsonElement;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.JsonOps;
import com.uraneptus.glowworms.core.registry.SMBlocks;
import com.uraneptus.glowworms.core.registry.SMItems;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.RegistryOps;
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

@Mod(Glowworms.MOD_ID)
@Mod.EventBusSubscriber(modid = Glowworms.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Glowworms {
    public static final String MOD_ID = "glowworms";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static ResourceLocation modPrefix(String path) {
        return new ResourceLocation(Glowworms.MOD_ID, path);
    }

    public Glowworms() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        bus.addListener(this::gatherData);

        SMBlocks.BLOCKS.register(bus);
        SMItems.ITEMS.register(bus);

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
        RegistryAccess registryAccess = RegistryAccess.builtinCopy();
        RegistryOps<JsonElement> registryOps = RegistryOps.create(JsonOps.INSTANCE, registryAccess);
/*
        generator.addProvider(includeClient, new SMBlockStateProvider(generator, fileHelper));
        generator.addProvider(includeClient, new SMItemModelProvider(generator, fileHelper));
        generator.addProvider(includeClient, new SMLangProvider(generator));

        SMBlockTagsProvider blockTagProvider = new SMBlockTagsProvider(generator, fileHelper);

        generator.addProvider(includeServer, blockTagProvider);
        generator.addProvider(includeServer, new SMItemTagsProvider(generator, blockTagProvider, fileHelper));
        generator.addProvider(includeServer, new SMBiomeTagsProvider(generator, fileHelper));
        generator.addProvider(includeServer, new SMLootTableProvider(generator));
        generator.addProvider(includeServer, new SMAdvancementProvider(generator, fileHelper));
        generator.addProvider(includeServer, new SMRecipeProvider(generator));
        SMDatapackRegistryProviders.registerDatapackProviders(fileHelper, generator, registryOps);

 */
    }
}
