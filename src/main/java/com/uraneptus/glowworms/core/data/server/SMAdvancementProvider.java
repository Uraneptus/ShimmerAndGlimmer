package com.uraneptus.glowworms.core.data.server;

import net.minecraft.advancements.Advancement;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

@SuppressWarnings("unused")
public class SMAdvancementProvider extends AdvancementProvider {
    public SMAdvancementProvider(DataGenerator generatorIn, ExistingFileHelper fileHelperIn) {
        super(generatorIn, fileHelperIn);
    }

    @Override
    protected void registerAdvancements(Consumer<Advancement> consumer, ExistingFileHelper fileHelper) {

    }
}
