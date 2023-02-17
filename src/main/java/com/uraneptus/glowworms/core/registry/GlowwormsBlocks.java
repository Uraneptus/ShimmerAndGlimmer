package com.uraneptus.glowworms.core.registry;

import com.uraneptus.glowworms.GlowwormsMod;
import com.uraneptus.glowworms.common.blocks.Glowworms;
import com.uraneptus.glowworms.common.blocks.GlowwormsPlant;
import com.uraneptus.glowworms.core.other.GlowwormsProperties;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = GlowwormsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GlowwormsBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GlowwormsMod.MOD_ID);

    public static final RegistryObject<Block> GLOWWORMS = BLOCKS.register("glowworms", () -> new Glowworms(GlowwormsProperties.Blocks.GLOWWORMS.randomTicks()));
    public static final RegistryObject<Block> GLOWWORMS_PLANT = BLOCKS.register("glowworms_plant", () -> new GlowwormsPlant(GlowwormsProperties.Blocks.GLOWWORMS));

}
