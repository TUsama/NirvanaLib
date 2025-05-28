package com.clefal.nirvana_lib.network.newtoolchain;

import commonnetwork.networking.data.PacketContext;
import commonnetwork.networking.data.Side;
import net.minecraft.server.level.ServerPlayer;

public interface C2SModPacket<MSG extends C2SModPacket<MSG>> extends ModPacket<MSG> {

    void handleServer(ServerPlayer sender, MSG message, boolean isClient);

    @Override
    default void handle(PacketContext<MSG> ctx) {
        ctx.message().handleServer(ctx.sender(), ctx.message(), ctx.side().equals(Side.CLIENT));
    }
}
