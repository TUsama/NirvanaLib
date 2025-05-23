package com.clefal.nirvana_lib.client.render.batch;

import com.mojang.blaze3d.vertex.VertexConsumer;

public interface IBufferInfo {

    void upload(VertexConsumer consumer);
}
