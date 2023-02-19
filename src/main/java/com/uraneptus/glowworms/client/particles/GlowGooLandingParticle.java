package com.uraneptus.glowworms.client.particles;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GlowGooLandingParticle extends TextureSheetParticle {

    public GlowGooLandingParticle(ClientLevel pLevel, double pX, double pY, double pZ) {
        super(pLevel, pX, pY, pZ);
        this.setSize(0.01F, 0.01F);
        this.lifetime = (int)(28.0D / (Math.random() * 0.8D + 0.2D));
        this.hasPhysics = false;
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
        if (this.age++ >= this.lifetime) {
            this.remove();
        }
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
        vertexConsumer.vertex((double) vector3f[0].x(), (double) vector3f[0].y(), (double) vector3f[0].z()).uv(this.getU1(), this.getV1()).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(light).endVertex();
        vertexConsumer.vertex((double) vector3f[1].x(), (double) vector3f[1].y(), (double) vector3f[1].z()).uv(this.getU1(), this.getV0()).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(light).endVertex();
        vertexConsumer.vertex((double) vector3f[2].x(), (double) vector3f[2].y(), (double) vector3f[2].z()).uv(this.getU0(), this.getV0()).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(light).endVertex();
        vertexConsumer.vertex((double) vector3f[3].x(), (double) vector3f[3].y(), (double) vector3f[3].z()).uv(this.getU0(), this.getV1()).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(light).endVertex();
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        protected final SpriteSet sprite;

        public Provider(SpriteSet pSprites) {
            this.sprite = pSprites;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            GlowGooLandingParticle particle = new GlowGooLandingParticle(pLevel, pX, pY, pZ);
            particle.pickSprite(this.sprite);
            return particle;
        }
    }
}
