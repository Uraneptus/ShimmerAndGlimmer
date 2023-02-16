package com.uraneptus.glowworms.core.data.client;

import com.uraneptus.glowworms.Glowworms;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

@SuppressWarnings("SameParameterValue")
public class SMBlockStateProvider extends BlockStateProvider {
    public SMBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Glowworms.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }

    private void basicBlock(Supplier<? extends Block> block) {
        simpleBlock(block.get());
    }

}
