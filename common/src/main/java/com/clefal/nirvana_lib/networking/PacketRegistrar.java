package com.clefal.nirvana_lib.networking;


import com.clefal.nirvana_lib.networking.data.PacketContext;
import com.clefal.nirvana_lib.networking.data.Side;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public interface PacketRegistrar
{
    /**
     * @return the side
     */
    Side getSide();


    /**
     * Packet Registration
     *
     * @param type        - The packet type.
     * @param packetClass - The class of the packet.
     * @param codec       - The StreamCodec.
     * @param handler     - The handler method.
     * @param <T>         - The class type
     * @return The registrar for chaining registrations.
     */
    <T> PacketRegistrar registerPacket(CustomPacketPayload.Type<? extends CustomPacketPayload> type, Class<T> packetClass, StreamCodec<? extends FriendlyByteBuf, T> codec, Consumer<PacketContext<T>> handler);

}
