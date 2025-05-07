package com.clefal.nirvana_lib.platform;

import com.clefal.nirvana_lib.NirvanaLibConstants;
import com.clefal.nirvana_lib.network.*;
import com.clefal.nirvana_lib.platform.services.IPlatformHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

import java.util.Locale;
import java.util.function.Function;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public boolean isClient() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
    }

    @Override
    public void sendToClient(S2CModPacket msg, ServerPlayer player) {
        FriendlyByteBuf buf = PacketByteBufs.create();
        msg.write(buf);
        ServerPlayNetworking.send(player,packet(msg.getClass()), buf);
    }

    @Override
    public void sendToServer(C2SModPacket msg) {
        FriendlyByteBuf buf = PacketByteBufs.create();
        msg.write(buf);
        ClientPlayNetworking.send(packet(msg.getClass()), buf);
    }

    @Override
    public <MSG extends S2CModPacket> void registerClientMessage(Class<MSG> packetClass, Function<FriendlyByteBuf, MSG> reader) {
        ClientPlayNetworking.registerGlobalReceiver(packet(packetClass), new ClientHandler<>(reader));
    }

    @Override
    public <MSG extends C2SModPacket> void registerServerMessage(Class<MSG> packetClass, Function<FriendlyByteBuf, MSG> reader) {
        ServerPlayNetworking.registerGlobalReceiver(packet(packetClass), new ServerHandler<>(reader));

    }

    protected ResourceLocation packet(Class<?> clazz) {
        String lowerCase = clazz.getName().toLowerCase(Locale.ROOT);
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : lowerCase.toCharArray()) {
            if (Character.isLetter(c)){
                stringBuilder.append(c);
            } else {
                stringBuilder.append("/");
            }
        }
        return NirvanaLibConstants.id(stringBuilder.toString());
    }

}
