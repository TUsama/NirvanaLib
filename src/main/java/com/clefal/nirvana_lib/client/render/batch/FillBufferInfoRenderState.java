//? new_pipeline {
/*package com.clefal.nirvana_lib.client.render.batch;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.gui.render.TextureSetup;
import net.minecraft.client.gui.render.state.GuiElementRenderState;
import org.joml.Matrix3x2f;

import javax.annotation.Nullable;

public record FillBufferInfoRenderState(
        RenderPipeline pipeline,
        TextureSetup textureSetup,
        Matrix3x2f pose,
        float x0,
        float y0,
        float x1,
        float y1,
        int col1,
        int col2,
        @Nullable ScreenRectangle scissorArea,
        @Nullable ScreenRectangle bounds
) implements GuiElementRenderState {

    public FillBufferInfoRenderState(
            RenderPipeline pipeline,
            TextureSetup textureSetup,
            Matrix3x2f pose,
            float x0,
            float y0,
            float x1,
            float y1,
            int col1,
            int col2,
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
                col1,
                col2,
                scissorArea,
                getBounds(x0, y0, x1, y1, pose, scissorArea)
        );
    }
    //? >=1.21.10 {
    /^public void buildVertices(VertexConsumer vertexConsumer) {
        vertexConsumer.addVertexWith2DPose(this.pose(), (float) this.x0(), (float) this.y0())
                .setColor(this.col1());

        vertexConsumer.addVertexWith2DPose(this.pose(), (float) this.x0(), (float) this.y1())
                .setColor(this.col2());

        vertexConsumer.addVertexWith2DPose(this.pose(), (float) this.x1(), (float) this.y1())
                .setColor(this.col2());

        vertexConsumer.addVertexWith2DPose(this.pose(), (float) this.x1(), (float) this.y0())
                .setColor(this.col1());
    }
    ^///? } else {

    @Override
    public void buildVertices(VertexConsumer vertexConsumer, float v) {
        vertexConsumer.addVertexWith2DPose(this.pose(), (float)this.x0(), (float)this.y0(), 0).setColor(this.col1());
        vertexConsumer.addVertexWith2DPose(this.pose(), (float)this.x0(), (float)this.y1(), 0).setColor(this.col2());
        vertexConsumer.addVertexWith2DPose(this.pose(), (float)this.x1(), (float)this.y1(), 0).setColor(this.col2());
        vertexConsumer.addVertexWith2DPose(this.pose(), (float)this.x1(), (float)this.y0(), 0).setColor(this.col1());
    }

    //?}

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