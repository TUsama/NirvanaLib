package com.clefal.nirvana_lib.networking;


import com.clefal.nirvana_lib.api.NetworkHandler;
import com.clefal.nirvana_lib.networking.data.PacketContainer;
import com.clefal.nirvana_lib.networking.data.PacketContext;
import com.clefal.nirvana_lib.networking.data.Side;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public abstract class PacketRegistrationHandler implements NetworkHandler, PacketRegistrar {
    protected final Side side;
    final Map<Class<?>, PacketContainer<?>> PACKET_MAP = new HashMap<>();

    /**
     * Handles packet registration
     *
     * @param side - The side
     */
    public PacketRegistrationHandler(Side side) {
        this.side = side;
    }


    @Override
    public <T> PacketRegistrar registerPacket(CustomPacketPayload.Type<? extends CustomPacketPayload> type, Class<T> packetClass, StreamCodec<? extends FriendlyByteBuf, T> codec, Consumer<PacketContext<T>> handler) {
        PacketContainer<T> container = new PacketContainer<>(type, packetClass, codec, handler);
        PACKET_MAP.put(packetClass, container);
        registerPacket(container);
        return this;
    }

    public Side getSide() {
        return side;
    }

    abstract <T> void registerPacket(PacketContainer<T> container);

}
