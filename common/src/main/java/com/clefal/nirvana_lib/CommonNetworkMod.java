package com.clefal.nirvana_lib;


import com.clefal.nirvana_lib.networking.DelayedPacketRegistrationHandler;
import com.clefal.nirvana_lib.networking.PacketRegistrar;
import com.clefal.nirvana_lib.networking.PacketRegistrationHandler;
import com.clefal.nirvana_lib.networking.data.PacketContext;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class CommonNetworkMod
{
    private final PacketRegistrationHandler packetRegistration;
    private static DelayedPacketRegistrationHandler delayedHandler;
    public static CommonNetworkMod INSTANCE;

    public CommonNetworkMod(PacketRegistrationHandler packetRegistration)
    {
        INSTANCE = this;
        this.packetRegistration = packetRegistration;
        getDelayedHandler().registerQueuedPackets(packetRegistration);
    }

    /**
     * Fabric does not enforce load order, so we may have to delay packet registrations.
     *
     * @return the handler;
     */
    private static DelayedPacketRegistrationHandler getDelayedHandler()
    {
        if (delayedHandler == null)
        {
            delayedHandler = new DelayedPacketRegistrationHandler();
        }
        return delayedHandler;
    }


    public static <T> PacketRegistrar registerPacket(CustomPacketPayload.Type<? extends CustomPacketPayload> type, Class<T> packetClass, StreamCodec<? extends FriendlyByteBuf, T> codec, Consumer<PacketContext<T>> handler)
    {
        if (INSTANCE != null)
        {
            return INSTANCE.packetRegistration.registerPacket(type, packetClass, codec, handler);
        }
        else
        {
            return getDelayedHandler().registerPacket(type, packetClass, codec, handler);
        }
    }

    public PacketRegistrationHandler getPacketRegistration()
    {
        return packetRegistration;
    }
}
