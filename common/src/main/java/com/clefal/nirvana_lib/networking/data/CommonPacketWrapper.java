package com.clefal.nirvana_lib.networking.data;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record CommonPacketWrapper<T>(PacketContainer<T> container, T packet) implements CustomPacketPayload
{
    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return container.type();
    }
}
