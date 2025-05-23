package com.clefal.nirvana_lib.network.newtoolchain;

import commonnetwork.networking.data.PacketContext;
import commonnetwork.networking.data.Side;

public interface S2CModPacket<MSG extends S2CModPacket<MSG>> extends ModPacket<MSG>{

    void handleClient();

    @Override
    default void handle(PacketContext<MSG> ctx) {
        if (ctx.side() == Side.CLIENT) ctx.message().handleClient();
    }
}
