package com.clefal.nirvana_lib.network.newtoolchain;
import com.clefal.nirvana_lib.utils.NetworkUtils;
import commonnetwork.networking.data.PacketContext;
import net.minecraft.network.FriendlyByteBuf;


//? >1.20.1
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public interface ModPacket<MSG>
    //? >1.20.1
        extends CustomPacketPayload
{
    void handle(PacketContext<MSG> ctx);
    void write(FriendlyByteBuf buf);
    void read(FriendlyByteBuf buf);
    Class<MSG> getSelfClass();
    //? >1.20.1 {
    @Override
    default Type<? extends CustomPacketPayload> type(){
        return new Type<>(NetworkUtils.classToResourceLocation(getSelfClass()));
    }
    //?}
}

