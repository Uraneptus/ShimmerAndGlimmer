package com.uraneptus.glowworms.client.particles;

import com.uraneptus.glowworms.common.particletypes.DirectionParticleOptions;
import com.uraneptus.glowworms.core.registry.GlowwormsParticleTypes;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public class GlowGooParticle extends TextureSheetParticle {
    public static float r = 0.20F;
    public static float g = 1.00F;
    public static float b = 0.87F;
    public GlowGooParticle(ClientLevel pLevel, double pX, double pY, double pZ) {
        super(pLevel, pX, pY, pZ);
        this.setSize(0.01F, 0.01F);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public int getLightColor(float pPartialTick) {
        return 240;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.preMoveUpdate();
        if (!this.removed) {
            this.yd -= this.gravity;
            this.move(this.xd, this.yd, this.zd);
            this.postMoveUpdate();
            if (!this.removed) {
                this.xd *= 0.98F;
                this.yd *= 0.98F;
                this.zd *= 0.98F;
                BlockPos blockpos = new BlockPos(this.x, this.y, this.z);
                FluidState fluidstate = this.level.getFluidState(blockpos);
                if (this.y < (double)((float)blockpos.getY() + fluidstate.getHeight(this.level, blockpos))) {
                    this.remove();
                }

            }
        }
    }

    protected void preMoveUpdate() {
        if (this.lifetime-- <= 0) {
            this.remove();
        }

    }

    protected void postMoveUpdate() {
    }


    @OnlyIn(Dist.CLIENT)
    static class LandingParticle extends GlowGooParticle {
        LandingParticle(ClientLevel pLevel, double pX, double pY, double pZ) {
            super(pLevel, pX, pY, pZ);
            this.lifetime = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
        }
    }

    @OnlyIn(Dist.CLIENT)
    static class FallingParticle extends GlowGooParticle {
        protected ParticleType<DirectionParticleOptions> landParticle;
        FallingParticle(ClientLevel pLevel, double pX, double pY, double pZ, ParticleType<DirectionParticleOptions> pLandParticle) {
            this(pLevel, pX, pY, pZ, (int)(64.0D / (Math.random() * 0.8D + 0.2D)));
            this.landParticle = pLandParticle;
        }

        FallingParticle(ClientLevel pLevel, double pX, double pY, double pZ, int pLifetime) {
            super(pLevel, pX, pY, pZ);
            this.lifetime = pLifetime;
        }

        protected void postMoveUpdate() {
            if (this.onGround) {
                this.remove();
                this.level.addParticle(new DirectionParticleOptions(), this.x, this.y, this.z, 0.0D, 0.0D, 0.0D);
            }

        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class GlowGooFallProvider implements ParticleProvider<SimpleParticleType> {
        protected final SpriteSet sprite;

        public GlowGooFallProvider(SpriteSet pSprites) {
            this.sprite = pSprites;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            GlowGooParticle particle = new GlowGooParticle.FallingParticle(pLevel, pX, pY, pZ, GlowwormsParticleTypes.LANDING_GLOW_GOO.get());
            particle.gravity = 0.01F;
            particle.setColor(GlowGooParticle.r, GlowGooParticle.g, GlowGooParticle.b);
            particle.pickSprite(this.sprite);
            return particle;
        }
    }

}