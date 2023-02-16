package com.uraneptus.glowworms.core.registry;

import com.uraneptus.glowworms.Glowworms;
import com.uraneptus.glowworms.common.particletypes.ParticleWithDirectionType;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Glowworms.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SMParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Glowworms.MOD_ID);

}
