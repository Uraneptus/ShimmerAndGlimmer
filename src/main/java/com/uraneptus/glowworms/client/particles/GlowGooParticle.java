package com.uraneptus.glowworms.client.particles;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import com.uraneptus.glowworms.core.registry.GlowwormsParticleTypes;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GlowGooParticle extends TextureSheetParticle {
    protected float colR = 0.20F;
    protected float colG = 1.00F;
    protected float colB = 0.87F;

    public GlowGooParticle(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet sprite) {
        super(pLevel, pX, pY, pZ);
        this.pickSprite(sprite);
        this.setSize(0.01F, 0.01F);
        this.setColor(colR, colG, colB);
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
    public static class GlowGooHangingParticle extends GlowGooParticle {
        private final ParticleOptions fallingParticle;

        public GlowGooHangingParticle(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet sprite) {
            super(pLevel, pX, pY, pZ, sprite);
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
    }

    @OnlyIn(Dist.CLIENT)
    public static class HangingProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public HangingProvider(SpriteSet pSprites) {
            this.sprite = pSprites;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            return new GlowGooHangingParticle(pLevel, pX, pY, pZ, this.sprite);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class GlowGooFallingParticle extends GlowGooParticle {
        protected ParticleOptions landParticle;

        public GlowGooFallingParticle(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet sprite) {
            super(pLevel, pX, pY, pZ, sprite);
            this.landParticle = GlowwormsParticleTypes.LANDING_GLOW_GOO.get();
            this.lifetime = (int)(64.0D / (Math.random() * 0.8D + 0.2D));
            this.gravity = 0.01F;
        }

        @Override
        protected void postMoveUpdate() {
            if (this.level.getFluidState(new BlockPos(this.x, this.y + 0.2, this.z)).isEmpty()) {
                FluidState fluidState = this.level.getFluidState(new BlockPos(this.x, this.y - 0.1, this.z));
                if (fluidState.is(FluidTags.WATER) || this.onGround) {
                    this.remove();
                    this.level.addParticle(landParticle, this.x, this.y, this.z, 0.0D, 0.0D, 0.0D);
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class FallingProvider implements ParticleProvider<SimpleParticleType> {
        protected final SpriteSet sprite;

        public FallingProvider(SpriteSet pSprites) {
            this.sprite = pSprites;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            return new GlowGooFallingParticle(pLevel, pX, pY, pZ, this.sprite);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class GlowGooLandingParticle extends GlowGooParticle {

        public GlowGooLandingParticle(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet sprite) {
            super(pLevel, pX, pY, pZ, sprite);
            this.lifetime = (int)(28.0D / (Math.random() * 0.8D + 0.2D));
            this.hasPhysics = false;
        }

        @Override
        public void render(VertexConsumer vertexConsumer, Camera camera, float partialTicks) {
            Vec3 cameraPos = camera.getPosition();
            float posX = (float) (Mth.lerp(partialTicks, this.xo, this.x) - cameraPos.x());
            float posY = (float) (Mth.lerp(partialTicks, this.yo, this.y) - cameraPos.y());
            float posZ = (float) (Mth.lerp(partialTicks, this.zo, this.z) - cameraPos.z());

            Vector3f[] vector3f = new Vector3f[]{new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F)};
            float quadSize = this.getQuadSize(partialTicks);

            for (int i = 0; i < 4; ++i) {
                Vector3f vec3f2 = vector3f[i];
                vec3f2.transform(new Quaternion(90.0F, 0.0F, 90.0F, true));
                vec3f2.mul(quadSize);
                vec3f2.add(posX, posY + 0.001F, posZ);
            }

            int light = this.getLightColor(partialTicks);
            vertexConsumer.vertex(vector3f[0].x(), vector3f[0].y(), vector3f[0].z()).uv(this.getU1(), this.getV1()).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(light).endVertex();
            vertexConsumer.vertex(vector3f[1].x(), vector3f[1].y(), vector3f[1].z()).uv(this.getU1(), this.getV0()).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(light).endVertex();
            vertexConsumer.vertex(vector3f[2].x(), vector3f[2].y(), vector3f[2].z()).uv(this.getU0(), this.getV0()).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(light).endVertex();
            vertexConsumer.vertex(vector3f[3].x(), vector3f[3].y(), vector3f[3].z()).uv(this.getU0(), this.getV1()).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(light).endVertex();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class LandingProvider implements ParticleProvider<SimpleParticleType> {
        protected final SpriteSet sprite;

        public LandingProvider(SpriteSet pSprites) {
            this.sprite = pSprites;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            return new GlowGooLandingParticle(pLevel, pX, pY, pZ, this.sprite);
        }
    }
}