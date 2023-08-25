package com.uraneptus.shimmerandglimmer.common.blocks;

import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.ToIntFunction;

public class SAGCandleBlock extends CandleBlock {
    public static final ToIntFunction<BlockState> LIGHT_EMISSION = (state) -> state.getValue(LIT) ? (3 * state.getValue(CANDLES)) + 3 : 3;

    public SAGCandleBlock(Properties pProperties) {
        super(pProperties);
    }
}
