package com.clefal.nirvana_lib.network;

import com.clefal.nirvana_lib.network.packets.C2SSendSyncingConfigPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public interface ModPacket<MSG> extends CustomPacketPayload {
    StreamCodec<FriendlyByteBuf, MSG> getCodeC();
}
