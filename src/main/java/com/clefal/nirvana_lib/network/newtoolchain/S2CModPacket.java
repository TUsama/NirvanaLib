package com.clefal.nirvana_lib.network.newtoolchain;

import net.minecraft.server.level.ServerPlayer;

public interface S2CModPacket<MSG extends S2CModPacket<MSG>> extends ModPacket<MSG> {

    void handleClient();

    @Override
    default void handle(ServerPlayer sender, MSG message, Side side) {
        if (side == Side.CLIENT) message.handleClient();
    }
}
