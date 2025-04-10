package com.clefal.nirvana_lib.utils;

import com.clefal.nirvana_lib.network.C2SModPacket;
import com.clefal.nirvana_lib.network.S2CModPacket;
import com.clefal.nirvana_lib.platform.Services;
import lombok.experimental.UtilityClass;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;

import java.util.function.Function;

@UtilityClass
public class NetworkUtils {

    public void sendToClient(S2CModPacket msg, ServerPlayer player){
        
        Services.PLATFORM.sendToClient(msg, player);
    }

    public void  sendToClients(S2CModPacket msg, Iterable<ServerPlayer> playerList){
        for (ServerPlayer serverPlayer : playerList) {
            Services.PLATFORM.sendToClient(msg, serverPlayer);
        }
    }

    public void sendToServer(C2SModPacket msg){
        Services.PLATFORM.sendToServer(msg);
    }

    public <MSG extends S2CModPacket> void registerClientMessage(Class<MSG> packetClass, Function<FriendlyByteBuf, MSG> reader){
        Services.PLATFORM.registerClientMessage(packetClass, reader);
    }

    public <MSG extends C2SModPacket> void registerServerMessage(Class<MSG> packetClass, Function<FriendlyByteBuf, MSG> reader){
        Services.PLATFORM.registerServerMessage(packetClass, reader);
    }

}
