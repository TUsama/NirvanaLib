package com.clefal.nirvana_lib.utils;


import commonnetwork.api.Dispatcher;
import commonnetwork.api.Network;
import lombok.experimental.UtilityClass;
import com.clefal.nirvana_lib.network.ModPacket;
//? if ~1.21 {
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
//?}
//? if =1.20.1 {
/*import java.util.function.Supplier;

import net.minecraft.resources.ResourceLocation;
*///?}

import net.minecraft.server.level.ServerPlayer;


@UtilityClass
public class NetworkUtils {

    public void sendToClient(ModPacket msg, ServerPlayer player) {
        Dispatcher.sendToClient(msg, player);
    }

    public void sendToClients(ModPacket msg, Iterable<ServerPlayer> playerList) {
        playerList.forEach(x -> sendToClient(msg, x));
    }

    public void sendToServer(ModPacket msg) {
        Dispatcher.sendToServer(msg);
    }

    //? if =1.20.1 {
    /*public <MSG extends ModPacket> void registerPacket(ResourceLocation packetIdentifier, Class<MSG> messageType, Supplier<MSG> supplier) {
        Network.registerPacket(packetIdentifier, messageType, (ModPacket::write), buf -> {
            MSG msg = supplier.get();
            msg.read(buf);
            return msg;
        }, x -> x.message().handle(x));
    }
*///?}


    //? if ~1.21 {
    public <MSG extends ModPacket> void registerPacket(CustomPacketPayload.Type<? extends CustomPacketPayload> type, Class<MSG> packetClass, StreamCodec<? extends FriendlyByteBuf, MSG> codec){
        Network.registerPacket(type, packetClass, codec, x -> x.message().handle(x));
    }
//?}

}
