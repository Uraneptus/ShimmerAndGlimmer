package com.uraneptus.shimmerandglimmer.core.registry;

import com.uraneptus.shimmerandglimmer.ShimmerAndGlimmer;
import com.uraneptus.shimmerandglimmer.common.blocks.GlowwormsBlock;
import com.uraneptus.shimmerandglimmer.core.other.SAGProperties;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ShimmerAndGlimmer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SAGBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ShimmerAndGlimmer.MOD_ID);

    public static final RegistryObject<Block> GLOWWORMS = BLOCKS.register("glowworms", () -> new GlowwormsBlock(SAGProperties.Blocks.GLOWWORMS.randomTicks()));

}
