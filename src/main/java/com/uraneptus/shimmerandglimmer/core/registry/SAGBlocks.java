package com.uraneptus.shimmerandglimmer.core.registry;

import com.uraneptus.shimmerandglimmer.ShimmerAndGlimmer;
import com.uraneptus.shimmerandglimmer.common.blocks.GlowwormsBlock;
import com.uraneptus.shimmerandglimmer.common.blocks.SAGCandleBlock;
import com.uraneptus.shimmerandglimmer.common.blocks.SAGGlassBlock;
import com.uraneptus.shimmerandglimmer.core.other.SAGProperties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.ConcretePowderBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ShimmerAndGlimmer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SAGBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ShimmerAndGlimmer.MOD_ID);

    public static final RegistryObject<Block> GLOWWORMS = BLOCKS.register("glowworms", () -> new GlowwormsBlock(SAGProperties.Blocks.GLOWWORMS));
    public static final RegistryObject<Block> BIOLUMINESCENT_WOOL = BLOCKS.register("bioluminescent_wool", () -> new Block(SAGProperties.Blocks.WOOL));
    public static final RegistryObject<Block> BIOLUMINESCENT_TERRACOTTA = BLOCKS.register("bioluminescent_terracotta", () -> new Block(SAGProperties.Blocks.TERRACOTTA));
    public static final RegistryObject<Block> BIOLUMINESCENT_CONCRETE = BLOCKS.register("bioluminescent_concrete", () -> new Block(SAGProperties.Blocks.CONCRETE));
    public static final RegistryObject<Block> BIOLUMINESCENT_CONCRETE_POWDER = BLOCKS.register("bioluminescent_concrete_powder", () -> new ConcretePowderBlock(BIOLUMINESCENT_CONCRETE.get(), SAGProperties.Blocks.CONCRETE));
    public static final RegistryObject<Block> BIOLUMINESCENT_STAINED_GLASS = BLOCKS.register("bioluminescent_stained_glass", () -> new SAGGlassBlock(SAGProperties.Blocks.STAINED_GLASS));
    public static final RegistryObject<Block> BIOLUMINESCENT_CANDLE = BLOCKS.register("bioluminescent_candle", () -> new SAGCandleBlock(SAGProperties.Blocks.CANDLE));

}
