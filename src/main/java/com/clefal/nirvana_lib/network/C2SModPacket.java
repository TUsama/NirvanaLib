package com.clefal.nirvana_lib.network;

import net.minecraft.server.level.ServerPlayer;
@Deprecated(forRemoval = true)
public interface C2SModPacket extends ModPacket {

    void handleServer(ServerPlayer player);

}
