package com.uraneptus.glowworms.client.particles;

import com.uraneptus.glowworms.common.particletypes.DirectionParticleOptions;
import com.uraneptus.glowworms.core.registry.GlowwormsParticleTypes;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;

public class GlowGooFallingParticle extends GlowGooBaseParticle {
    protected ParticleOptions landParticle;

    public GlowGooFallingParticle(ClientLevel pLevel, double pX, double pY, double pZ) {
        super(pLevel, pX, pY, pZ);
        this.landParticle = GlowwormsParticleTypes.LANDING_GLOW_GOO.get();
    }
}
