package com.clefal.nirvana_lib.platform;

import com.clefal.nirvana_lib.network.C2SModPacket;
import com.clefal.nirvana_lib.network.PacketHandlerForge;
import com.clefal.nirvana_lib.network.S2CModPacket;
import com.clefal.nirvana_lib.network.SafeMSGInvoker;
import com.clefal.nirvana_lib.platform.services.IPlatformHelper;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.simple.SimpleChannel;

public class ForgePlatformHelper implements IPlatformHelper {

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
    public void sendToClient(S2CModPacket msg, ServerPlayer player) {
        getChannel().sendTo(msg, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
    }

    @Override
    public void sendToServer(C2SModPacket msg) {
        getChannel().sendToServer(msg);
    }
    static int i = 1024000;
    @Override
    public <MSG extends S2CModPacket> void registerClientMessage(Class<MSG> packetClass, SafeMSGInvoker<MSG> reader) {
        getChannel().registerMessage(i++, packetClass, MSG::write, reader.get(), PacketHandlerForge.wrapS2C());
    }

    static int j = 5000;

    @Override
    public <MSG extends C2SModPacket> void registerServerMessage(Class<MSG> packetClass, SafeMSGInvoker<MSG> reader) {
        getChannel().registerMessage(j++, packetClass, MSG::write, reader.get(), PacketHandlerForge.wrapC2S());
    }

    protected SimpleChannel getChannel(){
        return PacketHandlerForge.INSTANCE;
    }
}