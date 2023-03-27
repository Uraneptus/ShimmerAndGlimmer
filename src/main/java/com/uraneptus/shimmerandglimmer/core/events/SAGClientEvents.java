package com.uraneptus.shimmerandglimmer.core.events;

import com.uraneptus.shimmerandglimmer.ShimmerAndGlimmer;
import com.uraneptus.shimmerandglimmer.client.particles.GlowGooParticle;
import com.uraneptus.shimmerandglimmer.core.registry.SAGParticleTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(modid = ShimmerAndGlimmer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SAGClientEvents {

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
        event.register(SAGParticleTypes.HANGING_GLOW_GOO.get(), GlowGooParticle.HangingProvider::new);
        event.register(SAGParticleTypes.FALLING_GLOW_GOO.get(), GlowGooParticle.FallingProvider::new);
        event.register(SAGParticleTypes.LANDING_GLOW_GOO.get(), GlowGooParticle.LandingProvider::new);
    }
}
