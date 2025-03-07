package com.clefal.nirvana_lib.network;

import com.clefal.nirvana_lib.NirvanaLib;
import com.clefal.nirvana_lib.NirvanaLibConstants;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class PacketHandlerForge {
    public static SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(NirvanaLib.id(NirvanaLibConstants.MOD_ID), () -> "1.0", s -> true, s -> true);
    ;

    public static <MSG extends S2CModPacket> BiConsumer<MSG, Supplier<NetworkEvent.Context>> wrapS2C() {
        return ((msg, contextSupplier) -> {
            contextSupplier.get().enqueueWork(msg::handleClient);
            contextSupplier.get().setPacketHandled(true);
        });
    }

    public static <MSG extends C2SModPacket> BiConsumer<MSG, Supplier<NetworkEvent.Context>> wrapC2S() {
        return ((msg, contextSupplier) -> {
            ServerPlayer player = contextSupplier.get().getSender();
            contextSupplier.get().enqueueWork(new Runnable() {
                @Override
                public void run() {
                    msg.handleServer(player);
                }
            });
            contextSupplier.get().setPacketHandled(true);
        });
    }

}
