package com.uraneptus.glowworms.core.events;

import com.uraneptus.glowworms.GlowwormsMod;
import com.uraneptus.glowworms.client.particles.GlowGooParticle;
import com.uraneptus.glowworms.core.registry.GlowwormsParticleTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(modid = GlowwormsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GlowwormsClientEvents {

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
        event.register(GlowwormsParticleTypes.HANGING_GLOW_GOO.get(), GlowGooParticle.HangingProvider::new);
        event.register(GlowwormsParticleTypes.FALLING_GLOW_GOO.get(), GlowGooParticle.FallingProvider::new);
        event.register(GlowwormsParticleTypes.LANDING_GLOW_GOO.get(), GlowGooParticle.LandingProvider::new);
    }
}
