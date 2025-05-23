package com.clefal.nirvana_lib.network;

import net.minecraft.network.FriendlyByteBuf;
@Deprecated(forRemoval = true)
public interface ModPacket {
    void write(FriendlyByteBuf buf);
}
