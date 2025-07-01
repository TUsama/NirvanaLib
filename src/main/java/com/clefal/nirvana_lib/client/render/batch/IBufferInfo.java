package com.clefal.nirvana_lib.client.render.batch;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;

public interface IBufferInfo {

    default void upload(VertexConsumer consumer){

    }
    default void upload(MultiBufferSource bufferSource){

    }
}
