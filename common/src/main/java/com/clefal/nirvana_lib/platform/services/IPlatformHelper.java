package com.clefal.nirvana_lib.platform.services;

import com.clefal.nirvana_lib.network.C2SModPacket;
import com.clefal.nirvana_lib.network.S2CModPacket;
import com.clefal.nirvana_lib.network.SafeMSGInvoker;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;

import java.util.Collection;
import java.util.function.Function;

public interface IPlatformHelper {

    /**
     * Gets the name of the current platform
     *
     * @return The name of the current platform.
     */
    String getPlatformName();

    /**
     * Checks if a mod with the given id is loaded.
     *
     * @param modId The mod to check if it is loaded.
     * @return True if the mod is loaded, false otherwise.
     */
    boolean isModLoaded(String modId);

    /**
     * Check if the game is currently in a development environment.
     *
     * @return True if in a development environment, false otherwise.
     */
    boolean isDevelopmentEnvironment();

    /**
     * Gets the name of the environment type as a string.
     *
     * @return The name of the environment type.
     */
    default String getEnvironmentName() {

        return isDevelopmentEnvironment() ? "development" : "production";
    }

    boolean isClient();

    void sendToClient(S2CModPacket msg, ServerPlayer player);

    default void sendToClients(S2CModPacket msg, Iterable<ServerPlayer> playerList) {
        playerList.forEach(player -> sendToClient(msg,player));
    }
    void sendToServer(C2SModPacket msg);


    <MSG extends S2CModPacket> void registerClientMessage(Class<MSG> packetClass, SafeMSGInvoker<MSG> reader);

    <MSG extends C2SModPacket> void registerServerMessage(Class<MSG> packetClass, SafeMSGInvoker<MSG> reader);
}