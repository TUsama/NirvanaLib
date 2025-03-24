package com.clefal.nirvana_lib.platform;

import com.clefal.nirvana_lib.network.C2SModPacket;
import com.clefal.nirvana_lib.network.PacketHandlerForge;
import com.clefal.nirvana_lib.network.S2CModPacket;
import com.clefal.nirvana_lib.platform.services.IPlatformHelper;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.function.Function;

public class ForgePlatformHelper implements IPlatformHelper {

    static int i = 7000;
    static int j = 5040;

    @Override
    public String getPlatformName() {

        return "Forge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.isProduction();
    }

    @Override
    public boolean isClient() {
        return FMLEnvironment.dist == Dist.CLIENT;
    }

    @Override
    public void sendToClient(S2CModPacket msg, ServerPlayer player) {
        Packet<?> vanillaPacket = getChannel().toVanillaPacket(msg, NetworkDirection.PLAY_TO_CLIENT);
        System.out.println("get vanilla packet!");
        player.connection.send(vanillaPacket);

    }

    @Override
    public void sendToServer(C2SModPacket msg) {
        getChannel().sendToServer(msg);
    }

    @Override
    public <MSG extends S2CModPacket> void registerClientMessage(Class<MSG> packetClass, Function<FriendlyByteBuf, MSG> reader) {
        getChannel().registerMessage(i++, packetClass, MSG::write, reader, PacketHandlerForge.wrapS2C());
    }

    @Override
    public <MSG extends C2SModPacket> void registerServerMessage(Class<MSG> packetClass, Function<FriendlyByteBuf, MSG> reader) {
        getChannel().registerMessage(j++, packetClass, MSG::write, reader, PacketHandlerForge.wrapC2S());
    }

    protected SimpleChannel getChannel() {
        return PacketHandlerForge.INSTANCE;
    }
}