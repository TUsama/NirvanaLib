package com.clefal.nirvana_lib.utils;

import com.clefal.nirvana_lib.api.Dispatcher;
import com.clefal.nirvana_lib.api.Network;
import com.clefal.nirvana_lib.network.ModPacket;
import com.clefal.nirvana_lib.networking.data.PacketContext;
import io.vavr.collection.List;
import lombok.experimental.UtilityClass;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;

import java.util.function.Consumer;

@UtilityClass
public class NetworkUtils {

    public void sendToClient(ModPacket msg, ServerPlayer player){
        
        Dispatcher.sendToClient(msg, player);
    }

    public void  sendToClients(ModPacket msg, Iterable<ServerPlayer> playerList){
        playerList.forEach(x -> sendToClient(msg, x));
    }

    public void sendToServer(ModPacket msg){
        Dispatcher.sendToServer(msg);
    }

    public <MSG extends ModPacket> void registerPacket(CustomPacketPayload.Type<? extends CustomPacketPayload> type, Class<MSG> packetClass, StreamCodec<? extends FriendlyByteBuf, MSG> codec, Consumer<PacketContext<MSG>> handler){
        Network.registerPacket(type, packetClass, codec, handler);
    }


}
