package com.uraneptus.shimmerandglimmer.core.registry;

import com.uraneptus.shimmerandglimmer.ShimmerAndGlimmer;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ShimmerAndGlimmer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SAGParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ShimmerAndGlimmer.MOD_ID);

    public static final RegistryObject<SimpleParticleType> HANGING_GLOW_GOO = PARTICLES.register("hanging_glow_goo", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FALLING_GLOW_GOO = PARTICLES.register("falling_glow_goo", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LANDING_GLOW_GOO = PARTICLES.register("landing_glow_goo", () -> new SimpleParticleType(false));

}
