package com.clefal.nirvana_lib.network;

import net.minecraft.network.FriendlyByteBuf;

public interface ModPacket {
    void write(FriendlyByteBuf buf);
}
