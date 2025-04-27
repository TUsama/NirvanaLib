package com.clefal.nirvana_lib.client.render.batch;

import com.mojang.blaze3d.vertex.VertexConsumer;
import org.joml.Matrix4f;

public record FillBufferInfo(float minX, float minY, float maxX, float maxY, float z, int packedColor,
                             Matrix4f matrix4f) implements IFillBufferInfo {


    public static FillBufferInfo fillOf(float minX, float minY, float maxX, float maxY, float z, int color, Matrix4f matrix4f) {
        return new FillBufferInfo(minX, minY, maxX, maxY, z, color, matrix4f);
    }

    @Override
    public void upload(VertexConsumer consumer) {
        consumer.addVertex(matrix4f, minX, minY, z).setColor(packedColor);
        consumer.addVertex(matrix4f, minX, maxY, z).setColor(packedColor);
        consumer.addVertex(matrix4f, maxX, maxY, z).setColor(packedColor);
        consumer.addVertex(matrix4f, maxX, minY, z).setColor(packedColor);
    }
}
