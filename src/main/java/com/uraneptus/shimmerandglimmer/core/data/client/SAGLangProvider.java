package com.uraneptus.shimmerandglimmer.core.data.client;

import com.uraneptus.shimmerandglimmer.ShimmerAndGlimmer;
import com.uraneptus.shimmerandglimmer.core.registry.SAGBlocks;
import com.uraneptus.shimmerandglimmer.core.registry.SAGItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class SAGLangProvider extends LanguageProvider {

    public SAGLangProvider(DataGenerator gen) {
        super(gen, ShimmerAndGlimmer.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(SAGBlocks.GLOWWORMS.get(), "Glowworms");
        add(SAGItems.BIOLUMINESCENT_DYE.get(), "Bioluminescent Dye");
        add(SAGBlocks.BIOLUMINESCENT_WOOL.get(), "Bioluminescent Wool");

    }

}