package com.clefal.nirvana_lib.utils;


import com.clefal.nirvana_lib.NirvanaLibConstants;

import com.clefal.nirvana_lib.platform.Services;
import commonnetwork.api.Dispatcher;
import commonnetwork.api.Network;
import lombok.experimental.UtilityClass;
import com.clefal.nirvana_lib.network.newtoolchain.ModPacket;
//? if ~1.21 {
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
//?}
//? if =1.20.1 {
/*import java.util.function.Function;
import java.util.function.Supplier;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

import com.clefal.nirvana_lib.network.C2SModPacket;
import com.clefal.nirvana_lib.network.S2CModPacket;
import static net.minecraft.resources.ResourceLocation.isAllowedInResourceLocation;
*///?}

import net.minecraft.server.level.ServerPlayer;




@UtilityClass
public class NetworkUtils {

    public <T> void sendToClient(T msg, ServerPlayer player) {
        Dispatcher.sendToClient(msg, player);
    }

    public <T> void sendToClients(T msg, Iterable<ServerPlayer> playerList) {
        playerList.forEach(x -> sendToClient(msg, x));
    }

    public <T> void sendToServer(T msg) {
        Dispatcher.sendToServer(msg);
    }

    //? if =1.20.1 {

    /*@Deprecated(forRemoval = true)
    public void sendToClient(S2CModPacket msg, ServerPlayer player) {
        Dispatcher.sendToClient(msg, player);
    }

    @Deprecated(forRemoval = true)
    public void sendToClients(S2CModPacket msg, Iterable<ServerPlayer> playerList) {
        for (ServerPlayer serverPlayer : playerList) {
            sendToClient(msg, serverPlayer);
        }
    }

    @Deprecated(forRemoval = true)
    public void sendToServer(C2SModPacket msg) {
        Dispatcher.sendToServer(msg);
    }

    public <MSG extends ModPacket<MSG>> void registerPacket(ResourceLocation packetIdentifier, Class<MSG> messageType, Supplier<MSG> supplier) {
        Network.registerPacket(packetIdentifier, messageType, (ModPacket::write), buf -> {
            MSG msg = supplier.get();
            msg.read(buf);
            return msg;
        }, x -> x.message().handle(x));
    }

    @Deprecated(forRemoval = true)
    public static <MSG extends C2SModPacket> void registerServerMessage(Class<MSG> packetClass, Function<FriendlyByteBuf, MSG> reader) {
        Network.registerPacket(classToResourceLocation(packetClass), packetClass, MSG::write, reader, x -> x.message().handleServer(x.sender()));
    }

    @Deprecated(forRemoval = true)
    public static <MSG extends S2CModPacket> void registerClientMessage(Class<MSG> packetClass, Function<FriendlyByteBuf, MSG> reader) {
        Network.registerPacket(classToResourceLocation(packetClass), packetClass, MSG::write, reader, x -> x.message().handleClient());
    }

    private static ResourceLocation classToResourceLocation(Class<?> clas) {
        String name = clas.getSimpleName();
        String result;
        result = name.chars()
                .filter(x -> !isAllowedInResourceLocation(name.charAt(x)))
                .boxed()
                .map(name::charAt)
                .collect(StringBuilder::new, (StringBuilder::append), StringBuilder::append).toString();


        return NirvanaLibConstants.id(result.toLowerCase());
    }
*///?}


    //? if ~1.21 {
    public <MSG extends ModPacket> void registerPacket(CustomPacketPayload.Type<? extends CustomPacketPayload> type, Class<MSG> packetClass, StreamCodec<? extends FriendlyByteBuf, MSG> codec){
        Network.registerPacket(type, packetClass, codec, x -> x.message().handle(x));
    }
//?}

}
