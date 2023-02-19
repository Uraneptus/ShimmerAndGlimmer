package com.uraneptus.glowworms.client.particles;

import com.uraneptus.glowworms.core.registry.GlowwormsParticleTypes;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GlowGooFallingParticle extends GlowGooBaseParticle {
    protected ParticleOptions landParticle;

    public GlowGooFallingParticle(ClientLevel pLevel, double pX, double pY, double pZ) {
        super(pLevel, pX, pY, pZ);
        this.landParticle = GlowwormsParticleTypes.LANDING_GLOW_GOO.get();
        this.lifetime = (int)(64.0D / (Math.random() * 0.8D + 0.2D));
        this.gravity = 0.01F;
    }

    @Override
    protected void postMoveUpdate() {
        if (this.onGround) {
            this.remove();
            this.level.addParticle(landParticle, this.x, this.y, this.z, 0.0D, 0.0D, 0.0D);
        }

    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        protected final SpriteSet sprite;

        public Provider(SpriteSet pSprites) {
            this.sprite = pSprites;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            GlowGooFallingParticle particle = new GlowGooFallingParticle(pLevel, pX, pY, pZ);
            particle.pickSprite(this.sprite);
            return particle;
        }
    }
}
