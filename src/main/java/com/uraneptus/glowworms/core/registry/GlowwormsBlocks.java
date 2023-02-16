package com.uraneptus.glowworms.core.registry;

import com.uraneptus.glowworms.Glowworms;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Glowworms.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GlowwormsBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Glowworms.MOD_ID);



}
