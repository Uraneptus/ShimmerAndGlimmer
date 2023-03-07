package com.uraneptus.glowworms.core.data.client;

import com.uraneptus.glowworms.GlowwormsMod;
import com.uraneptus.glowworms.core.registry.GlowwormsBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class GlowwormsLangProvider extends LanguageProvider {

    public GlowwormsLangProvider(DataGenerator gen) {
        super(gen, GlowwormsMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(GlowwormsBlocks.GLOWWORMS.get(), "Glowworms");

    }

}