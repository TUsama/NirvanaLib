package com.clefal.nirvana_lib.client.render.batch;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import org.joml.Matrix4f;

public record DrawStringBufferInfo(String text, float x, float y, int color, boolean dropShadow, Matrix4f matrix,
                                   Font.DisplayMode displayMode, int backgroundColor,
                                   int packedLightCoords) implements IBufferInfo {

    public static DrawStringBufferInfo of(String text, float x, float y, int color, boolean dropShadow, Matrix4f matrix, Font.DisplayMode displayMode) {
        return new DrawStringBufferInfo(text, x, y, color, dropShadow, matrix, displayMode, 0, 15728880);
    }

    public static DrawStringBufferInfo of(String text, float x, float y, int color, boolean dropShadow, Matrix4f matrix) {
        return of(text, x, y, color, dropShadow, matrix, Font.DisplayMode.NORMAL);
    }

    public static DrawStringBufferInfo of(String text, float x, float y, int color, Matrix4f matrix) {
        return of(text, x, y, color, false, matrix);
    }

    @Override
    public void upload(MultiBufferSource bufferSource) {
        Minecraft.getInstance().font.drawInBatch(text, x, y, color, dropShadow, matrix, bufferSource, displayMode, backgroundColor, packedLightCoords);
    }
}
