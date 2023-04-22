package com.uraneptus.shimmerandglimmer.core.events;

import com.uraneptus.shimmerandglimmer.ShimmerAndGlimmer;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.data.loading.DatagenModLoader;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forgespi.locating.IModFile;
import net.minecraftforge.resource.PathPackResources;

import java.io.IOException;

@Mod.EventBusSubscriber(modid = ShimmerAndGlimmer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SAGCommonEvents {
    public static final String PACK_NAME = "shimmerandglimmer_compat_pack";

    @SubscribeEvent
    public static void addPackFinders(AddPackFindersEvent event) {
        event.addRepositorySource((consumer, constructor) -> {
            String path = ShimmerAndGlimmer.modPrefix(PACK_NAME).toString();
            IModFile file = ModList.get().getModFileById(ShimmerAndGlimmer.MOD_ID).getFile();
            try (PathPackResources pack = new PathPackResources(path, file.findResource("builtin/" + PACK_NAME))) {
                consumer.accept(constructor.create(
                        ShimmerAndGlimmer.modPrefix(PACK_NAME).toString(),
                        Component.literal("ShimmerAndGlimmer Compat Pack"),
                        false,
                        () -> pack,
                        pack.getMetadataSection(PackMetadataSection.SERIALIZER),
                        Pack.Position.TOP,
                        PackSource.BUILT_IN,
                        false
                ));
            } catch (IOException exception) {
                if (!DatagenModLoader.isRunningDataGen()) {
                    exception.printStackTrace();
                }
            }
        });
    }
}
