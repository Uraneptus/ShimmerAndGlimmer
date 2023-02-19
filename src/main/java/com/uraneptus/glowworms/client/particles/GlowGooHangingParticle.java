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

@OnlyIn(Dist.CLIENT)
public class GlowGooHangingParticle extends GlowGooBaseParticle {
    private final ParticleOptions fallingParticle;

    public GlowGooHangingParticle(ClientLevel pLevel, double pX, double pY, double pZ) {
        super(pLevel, pX, pY, pZ);
        this.fallingParticle = GlowwormsParticleTypes.FALLING_GLOW_GOO.get();
        this.gravity *= 0.01F;
        this.lifetime = 100;
    }

    @Override
    protected void preMoveUpdate() {
        if (this.lifetime-- <= 0) {
            this.remove();
            this.level.addParticle(this.fallingParticle, this.x, this.y, this.z, this.xd, this.yd, this.zd);
        }

    }

    @Override
    protected void postMoveUpdate() {
        this.xd *= 0.02D;
        this.yd *= 0.02D;
        this.zd *= 0.02D;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        protected final SpriteSet sprite;

        public Provider(SpriteSet pSprites) {
            this.sprite = pSprites;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            GlowGooHangingParticle particle = new GlowGooHangingParticle(pLevel, pX, pY, pZ);
            particle.pickSprite(this.sprite);
            return particle;
        }
    }
}
