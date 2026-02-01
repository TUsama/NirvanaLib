package com.clefal.nirvana_lib.utils;


import com.clefal.nirvana_lib.NirvanaLibConstants;

import com.clefal.nirvana_lib.network.newtoolchain.ModPacket;
import commonnetwork.api.Dispatcher;
import commonnetwork.api.Network;
import lombok.experimental.UtilityClass;


//? !legacy {
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.codec.StreamDecoder;
//?}

import java.util.ArrayList;
import java.util.function.Supplier;

import net.minecraft.network.FriendlyByteBuf;

import net.minecraft.resources.ResourceLocation;

import net.minecraft.server.MinecraftServer;
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

    public <T> void sendToAllClients(T msg, MinecraftServer level){
        sendToClients(msg, level.getPlayerList().getPlayers());
    }

    public <MSG extends ModPacket<MSG>> void registerPacket(Supplier<MSG> supplier) {
        Class<MSG> selfClass = supplier.get().getSelfClass();
        //? !legacy {
        var codec = StreamCodec.of((buf, msg) -> {
            msg.write(buf);

        }, (StreamDecoder<FriendlyByteBuf, MSG>) buf -> {
            MSG msg = supplier.get();
            msg.read(buf);
            return msg;
        });
        Network.registerPacket(supplier.get().type(), selfClass, codec, x -> x.message().handle(x));
        //?} else {
        /*Network.registerPacket(classToResourceLocation(selfClass), selfClass, (ModPacket::write), buf -> {
            MSG msg = supplier.get();
            msg.read(buf);
            return msg;
        }, x -> x.message().handle(x));
        
        *///?}
    }


    public static ResourceLocation classToResourceLocation(Class<?> clas) {
        String name = clas.getSimpleName().toLowerCase();
        String result;
        ArrayList<Character> characters = new ArrayList<>();
        for (char c : name.toCharArray()) {
            characters.add(c);
        }
        result = characters.stream()
                .filter(NetworkUtils::validPathChar)
                .collect(StringBuilder::new, (StringBuilder::append), StringBuilder::append).toString();


        return NirvanaLibConstants.id(result.toLowerCase());
    }

    public static boolean validPathChar(char pathChar) {
        return pathChar == '_' || pathChar == '-' || pathChar >= 'a' && pathChar <= 'z' || pathChar >= '0' && pathChar <= '9' || pathChar == '/' || pathChar == '.';
    }

}
