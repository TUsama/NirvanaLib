//? new_pipeline {
/*package com.clefal.nirvana_lib.client.render.batch;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.gui.render.TextureSetup;
import net.minecraft.client.gui.render.state.GuiElementRenderState;
import org.joml.Matrix3x2f;

import javax.annotation.Nullable;

public record BufferInfoRenderState(
        RenderPipeline pipeline,
        TextureSetup textureSetup,
        Matrix3x2f pose,
        float x0,
        float y0,
        float x1,
        float y1,
        float u0,
        float u1,
        float v0,
        float v1,
        int color,
        @Nullable ScreenRectangle scissorArea,
        @Nullable ScreenRectangle bounds
) implements GuiElementRenderState {

    public BufferInfoRenderState(
            RenderPipeline pipeline,
            TextureSetup textureSetup,
            Matrix3x2f pose,
            float x0,
            float y0,
            float x1,
            float y1,
            float u0,
            float u1,
            float v0,
            float v1,
            int color,
            @Nullable ScreenRectangle scissorArea
    ) {
        this(
                pipeline,
                textureSetup,
                pose,
                x0,
                y0,
                x1,
                y1,
                u0,
                u1,
                v0,
                v1,
                color,
                scissorArea,
                getBounds(x0, y0, x1, y1, pose, scissorArea)
        );
    }
    //? >=1.21.10 {
    /^public void buildVertices(VertexConsumer vertexConsumer) {
        vertexConsumer.addVertexWith2DPose(this.pose(), (float) this.x0(), (float) this.y0())
                .setUv(this.u0(), this.v0())
                .setColor(this.color());

        vertexConsumer.addVertexWith2DPose(this.pose(), (float) this.x0(), (float) this.y1())
                .setUv(this.u0(), this.v1())
                .setColor(this.color());

        vertexConsumer.addVertexWith2DPose(this.pose(), (float) this.x1(), (float) this.y1())
                .setUv(this.u1(), this.v1())
                .setColor(this.color());

        vertexConsumer.addVertexWith2DPose(this.pose(), (float) this.x1(), (float) this.y0())
                .setUv(this.u1(), this.v0())
                .setColor(this.color());
    }
    ^///? } else {
    @Override
    public void buildVertices(VertexConsumer consumer, float z) {
        consumer.addVertexWith2DPose(this.pose(), (float)this.x0(), (float)this.y0(), z).setUv(this.u0(), this.v0()).setColor(this.color());
        consumer.addVertexWith2DPose(this.pose(), (float)this.x0(), (float)this.y1(), z).setUv(this.u0(), this.v1()).setColor(this.color());
        consumer.addVertexWith2DPose(this.pose(), (float)this.x1(), (float)this.y1(), z).setUv(this.u1(), this.v1()).setColor(this.color());
        consumer.addVertexWith2DPose(this.pose(), (float)this.x1(), (float)this.y0(), z).setUv(this.u1(), this.v0()).setColor(this.color());
    }
    //? }

    @Nullable
    private static ScreenRectangle getBounds(
            float x0,
            float y0,
            float x1,
            float y1,
            Matrix3x2f pose,
            @Nullable ScreenRectangle scissorArea
    ) {
        ScreenRectangle rect =
                new ScreenRectangle((int) x0, (int) y0, (int) (x1 - x0), (int) (y1 - y0))
                        .transformMaxBounds(pose);

        return scissorArea != null
                ? scissorArea.intersection(rect)
                : rect;
    }


}
*///?}
