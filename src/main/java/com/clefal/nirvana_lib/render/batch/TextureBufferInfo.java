package com.clefal.nirvana_lib.render.batch;

import com.mojang.blaze3d.vertex.VertexConsumer;
import org.joml.Matrix4f;

public record TextureBufferInfo(float pX1, float pX2, float pY1, float pY2, float pBlitOffset, float pMinU, float pMaxU, float pMinV, float pMaxV, Matrix4f matrix4f, RenderInfo renderInfo) implements IBufferInfo{

    public static TextureBufferInfo of(float pX, float pY, float pBlitOffset, int pUOffset, int pVOffset, int pUWidth, int pVHeight, Matrix4f matrix4f) {
        return of(pX, pY, pBlitOffset, (float) pUOffset, (float) pVOffset, pUWidth, pVHeight, 256, 256, matrix4f);
    }

    public static TextureBufferInfo of(float pX, float pY, int pUOffset, int pVOffset, int pUWidth, int pVHeight, Matrix4f matrix4f) {
        return of(pX, pY, 0, (float) pUOffset, (float) pVOffset, pUWidth, pVHeight, 256, 256, matrix4f);
    }

    public static TextureBufferInfo of(float pX, float pY, float pBlitOffset, float pUOffset, float pVOffset, int pUWidth, int pVHeight, int pTextureWidth, int pTextureHeight, Matrix4f matrix4f) {
        return of(pX, pX + pUWidth, pY, pY + pVHeight, pBlitOffset, pUWidth, pVHeight, pUOffset, pVOffset, pTextureWidth, pTextureHeight, matrix4f);
    }

    public static TextureBufferInfo of(float pX, float pY, int pWidth, int pHeight, float pUOffset, float pVOffset, int pUWidth, int pVHeight, int pTextureWidth, int pTextureHeight, Matrix4f matrix4f) {
        return of(pX, pX + pWidth, pY, pY + pHeight, 0, pUWidth, pVHeight, pUOffset, pVOffset, pTextureWidth, pTextureHeight, matrix4f);
    }

    public static TextureBufferInfo of(float pX, float pY, int pWidth, int pHeight, float pBlitOffset, float pUOffset, float pVOffset, int pUWidth, int pVHeight, int pTextureWidth, int pTextureHeight, Matrix4f matrix4f) {
        return of(pX, pX + pWidth, pY, pY + pHeight, pBlitOffset, pUWidth, pVHeight, pUOffset, pVOffset, pTextureWidth, pTextureHeight, matrix4f);
    }


    public static TextureBufferInfo of(float pX, float pY, float pUOffset, float pVOffset, int pWidth, int pHeight, int pTextureWidth, int pTextureHeight, Matrix4f matrix4f) {
        return of(pX, pY, pWidth, pHeight, pUOffset, pVOffset, pWidth, pHeight, pTextureWidth, pTextureHeight, matrix4f);
    }

    public static TextureBufferInfo of(float pX, float pY, float pUOffset, float pVOffset, int pWidth, int pHeight, float pBlitOffset, int pTextureWidth, int pTextureHeight, Matrix4f matrix4f) {
        return of(pX, pY, pWidth, pHeight, pUOffset, pVOffset, pWidth, pHeight, pTextureWidth, pTextureHeight, matrix4f);
    }


    public static TextureBufferInfo of(float pX1, float pX2, float pY1, float pY2, float pBlitOffset, int pUWidth, int pVHeight, float pUOffset, float pVOffset, int pTextureWidth, int pTextureHeight, Matrix4f matrix4f) {
        return new TextureBufferInfo(pX1, pX2, pY1, pY2, pBlitOffset, (pUOffset + 0.0F) / (float) pTextureWidth, (pUOffset + (float) pUWidth) / (float) pTextureWidth, (pVOffset + 0.0F) / (float) pTextureHeight, (pVOffset + (float) pVHeight) / (float) pTextureHeight, matrix4f, new RenderInfo(1.0f));
    }

    public TextureBufferInfo withRenderInfo(RenderInfo renderInfo) {
        return new TextureBufferInfo(pX1, pX2, pY1, pY2, pBlitOffset, this.pMinU, this.pMaxU, this.pMinV, this.pMaxV, this.matrix4f, renderInfo);
    }

    public void upload(VertexConsumer consumer) {
        final int light = 0xF000F0;
        float opacity = Math.min(this.renderInfo().opacity, 1.0f);
        //? if ~1.21 {
        /*consumer.addVertex(matrix4f, pX1, pY1, pBlitOffset).setColor(1.0f, 1.0f, 1.0f, opacity).setUv(pMinU, pMinV).setLight(light);
        consumer.addVertex(matrix4f, pX1, pY2, pBlitOffset).setColor(1.0f, 1.0f, 1.0f, opacity).setUv(pMinU, pMaxV).setLight(light);
        consumer.addVertex(matrix4f, pX2, pY2, pBlitOffset).setColor(1.0f, 1.0f, 1.0f, opacity).setUv(pMaxU, pMaxV).setLight(light);
        consumer.addVertex(matrix4f, pX2, pY1, pBlitOffset).setColor(1.0f, 1.0f, 1.0f, opacity).setUv(pMaxU, pMinV).setLight(light);
        *///?} else {
        consumer.vertex(0, 0, 0).color(1.0f, 1.0f, 1.0f, opacity).uv(pMinU, pMinV).uv2(light).endVertex();
        consumer.vertex(0, 0, 0).color(1.0f, 1.0f, 1.0f, opacity).uv(pMinU, pMaxV).uv2(light).endVertex();
        consumer.vertex(0, 0, 0).color(1.0f, 1.0f, 1.0f, opacity).uv(pMaxU, pMaxV).uv2(light).endVertex();
        consumer.vertex(0, 0, 0).color(1.0f, 1.0f, 1.0f, opacity).uv(pMaxU, pMinV).uv2(light).endVertex();
        //?}

    }

    public record RenderInfo(float opacity) {
        public static RenderInfo ofOpacity(float opacity){
            return new RenderInfo(opacity);
        }
    }
}
