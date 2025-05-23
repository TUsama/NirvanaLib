package com.clefal.nirvana_lib.network.newtoolchain;

import commonnetwork.networking.data.PacketContext;

public interface C2SModPacket<MSG extends C2SModPacket<MSG>> extends ModPacket<MSG> {

    void handleServer(PacketContext<MSG> ctx);

    @Override
    default void handle(PacketContext<MSG> ctx) {
        ctx.message().handleServer(ctx);
    }
}
