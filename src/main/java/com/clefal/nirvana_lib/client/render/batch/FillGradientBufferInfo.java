package com.clefal.nirvana_lib.client.render.batch;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.gui.GuiGraphics;
//? new_pipeline {
/*import net.minecraft.client.gui.render.TextureSetup;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.util.ARGB;
*///?}
import org.joml.Matrix4f;

public record FillGradientBufferInfo(float minX, float minY, float maxX, float maxY, float z, float aF, float rF, float gF,
                                     float bF, float aT, float rT, float gT,
                                     float bT, Matrix4f matrix4f) implements IFillBufferInfo{


    public static FillGradientBufferInfo getShadow(float minX, float minY, float maxX, float maxY, Matrix4f matrix4f) {
        float f = 0;
        float f1 = 0;
        float f2 = 0;
        float f3 = 0;
        float f4 = 0.39f;
        float f5 = 0;
        float f6 = 0;
        float f7 = 0;

        return new FillGradientBufferInfo(minX, minY, maxX, maxY, 0.003f, f, f1, f2, f3, f4, f5, f6, f7, matrix4f);
    }


    @Override
    public void upload(VertexConsumer consumer) {
        //? if >1.20.1 {
        consumer.addVertex(matrix4f, minX, minY, z).setColor(rF, gF, bF, aF);
        consumer.addVertex(matrix4f, minX, maxY, z).setColor(rT, gT, bT, aT);
        consumer.addVertex(matrix4f, maxX, maxY, z).setColor(rT, gT, bT, aT);
        consumer.addVertex(matrix4f, maxX, minY, z).setColor(rF, gF, bF, aF);
        //?} else {
        /*consumer.vertex(matrix4f, minX, minY, z).color(rF, gF, bF, aF).endVertex();
        consumer.vertex(matrix4f, minX, maxY, z).color(rT, gT, bT, aT).endVertex();
        consumer.vertex(matrix4f, maxX, maxY, z).color(rT, gT, bT, aT).endVertex();
        consumer.vertex(matrix4f, maxX, minY, z).color(rF, gF, bF, aF).endVertex();
        *///?}
    }
    //? new_pipeline {
    /*@Override
    public FillBufferInfoRenderState toRenderState(GuiGraphics guiGraphics) {
        return new FillBufferInfoRenderState(RenderPipelines.GUI_TEXTURED, TextureSetup.noTexture(),guiGraphics.pose(), minX, minY, maxX, maxY, ARGB.colorFromFloat(aF, rF, gF, bF), ARGB.colorFromFloat(aT, rT, gT, bT), guiGraphics.peekScissorStack());
    }
    *///?}
}
