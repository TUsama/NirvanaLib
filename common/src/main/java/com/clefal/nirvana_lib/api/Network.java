package com.clefal.nirvana_lib.api;

import com.clefal.nirvana_lib.CommonNetworkMod;
import com.clefal.nirvana_lib.networking.PacketRegistrar;
import com.clefal.nirvana_lib.networking.data.PacketContext;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

import java.util.function.Consumer;

public class Network {

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
    public static <T> PacketRegistrar registerPacket(CustomPacketPayload.Type<? extends CustomPacketPayload> type, Class<T> packetClass, StreamCodec<? extends FriendlyByteBuf, T> codec, Consumer<PacketContext<T>> handler) {
        return CommonNetworkMod.registerPacket(type, packetClass, codec, handler);
    }

    /**
     * Gets the Network handler for use to send packets.
     *
     * @return - The network handler
     */
    public static NetworkHandler getNetworkHandler() {
        return CommonNetworkMod.INSTANCE.getPacketRegistration();
    }
}
