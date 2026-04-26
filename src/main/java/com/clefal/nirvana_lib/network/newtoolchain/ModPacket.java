package com.clefal.nirvana_lib.network.newtoolchain;

import com.clefal.nirvana_lib.utils.NetworkUtils;
import net.minecraft.network.FriendlyByteBuf;
//? >1.20.1
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;

public interface ModPacket<MSG>
        //? >1.20.1
        extends CustomPacketPayload
{
    void handle(ServerPlayer sender, MSG message, Side side);

    void write(FriendlyByteBuf buf);

    void read(FriendlyByteBuf buf);

    Class<MSG> getSelfClass();

    //? >1.20.1 {
    @Override
    default Type<? extends CustomPacketPayload> type() {
        return new Type<>(NetworkUtils.classToResourceLocation(getSelfClass()));
    }
    //?}
}

