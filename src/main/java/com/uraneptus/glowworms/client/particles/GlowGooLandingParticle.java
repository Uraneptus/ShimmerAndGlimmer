package com.uraneptus.glowworms.client.particles;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import com.uraneptus.glowworms.common.particletypes.DirectionParticleOptions;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GlowGooLandingParticle extends TextureSheetParticle {
    private final Direction face;

    public GlowGooLandingParticle(ClientLevel pLevel, double pX, double pY, double pZ, Direction face) {
        super(pLevel, pX, pY, pZ);
        this.setSize(0.01F, 0.01F);
        this.lifetime = (int)(28.0D / (Math.random() * 0.8D + 0.2D));
        this.hasPhysics = false;
        this.face = face;
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
        float posX = (float) (Mth.lerp((double) partialTicks, this.xo, this.x) - cameraPos.x());
        float posY = (float) (Mth.lerp((double) partialTicks, this.yo, this.y) - cameraPos.y());
        float posZ = (float) (Mth.lerp((double) partialTicks, this.zo, this.z) - cameraPos.z());

        Quaternion quaternion = this.face.getRotation();
        quaternion.mul(Vector3f.XP.rotationDegrees(90.0F));

        float roll = Mth.lerp(partialTicks, this.oRoll, this.roll);
        quaternion.mul(Vector3f.ZP.rotation(roll));

        Vector3f spriteNormal = new Vector3f(-1.0F, -1.0F, 0.0F);
        spriteNormal.transform(quaternion);
        Vector3f[] faces = new Vector3f[] { new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F) };
        float quadSize = this.getQuadSize(partialTicks);

        for (int i = 0; i < 4; ++i) {
            Vector3f face = faces[i];
            face.transform(quaternion);
            face.mul(quadSize);
            face.add(posX, posY, posZ);
        }

        int light = this.getLightColor(partialTicks);
        vertexConsumer.vertex((double) faces[0].x(), (double) faces[0].y(), (double) faces[0].z()).uv(this.getU1(), this.getV1()).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(light).endVertex();
        vertexConsumer.vertex((double) faces[1].x(), (double) faces[1].y(), (double) faces[1].z()).uv(this.getU1(), this.getV0()).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(light).endVertex();
        vertexConsumer.vertex((double) faces[2].x(), (double) faces[2].y(), (double) faces[2].z()).uv(this.getU0(), this.getV0()).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(light).endVertex();
        vertexConsumer.vertex((double) faces[3].x(), (double) faces[3].y(), (double) faces[3].z()).uv(this.getU0(), this.getV1()).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(light).endVertex();
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<DirectionParticleOptions> {
        protected final SpriteSet sprite;

        public Provider(SpriteSet pSprites) {
            this.sprite = pSprites;
        }

        public Particle createParticle(DirectionParticleOptions pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            GlowGooParticle particle = new GlowGooParticle.LandingParticle(pLevel, pX, pY, pZ);
            particle.setColor(GlowGooParticle.r, GlowGooParticle.g, GlowGooParticle.b);
            particle.pickSprite(this.sprite);
            return particle;
        }
    }
}
