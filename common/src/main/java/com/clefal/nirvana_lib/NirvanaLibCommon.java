package com.clefal.nirvana_lib;

import com.clefal.nirvana_lib.network.SafeMSGInvoker;
import com.clefal.nirvana_lib.network.packets.C2SSendSyncingConfigPacket;
import com.clefal.nirvana_lib.utils.NetworkUtil;
import net.minecraft.network.FriendlyByteBuf;

import java.util.function.Function;

public class NirvanaLibCommon {

    public static void packetInit() {
        registerClientPackets();
        registerServerPackets();
    }

    private static void registerClientPackets() {
    }

    private static void registerServerPackets() {
        NetworkUtil.registerServerMessage(C2SSendSyncingConfigPacket.class, new SafeMSGInvoker<C2SSendSyncingConfigPacket>() {
            @Override
            public Function<FriendlyByteBuf, C2SSendSyncingConfigPacket> get() {
                return buf -> new C2SSendSyncingConfigPacket(buf);
            }
        });
    }
}
