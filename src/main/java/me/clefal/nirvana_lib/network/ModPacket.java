package me.clefal.nirvana_lib.network;
import commonnetwork.networking.data.PacketContext;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
//? if ~1.21 {

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public interface ModPacket<MSG> extends CustomPacketPayload {
    void handle(PacketContext<MSG> ctx);
}

//?} elif = 1.20.1 {
/*public interface ModPacket<MSG>{

    ResourceLocation getResourceLocation();
    void handle(PacketContext<MSG> ctx);
    void write(FriendlyByteBuf buf);
    void read(FriendlyByteBuf buf);
}

*///?}

