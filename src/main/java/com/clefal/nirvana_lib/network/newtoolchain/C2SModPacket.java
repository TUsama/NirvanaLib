package com.clefal.nirvana_lib.network.newtoolchain;

import net.minecraft.server.level.ServerPlayer;

public interface C2SModPacket<MSG extends C2SModPacket<MSG>> extends ModPacket<MSG> {

    void handleServer(ServerPlayer sender, MSG message, boolean isClient);

    @Override
    default void handle(ServerPlayer sender, MSG message, Side side) {
        message.handleServer(sender, message, side.equals(Side.CLIENT));
    }
}
