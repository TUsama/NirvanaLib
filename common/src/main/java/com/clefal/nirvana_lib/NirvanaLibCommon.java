package com.clefal.nirvana_lib;

import com.clefal.nirvana_lib.network.packets.C2SSendSyncingConfigPacket;
import com.clefal.nirvana_lib.platform.Services;

public class NirvanaLibCommon {

    public static void packetInit() {
        registerClientPackets();
        registerServerPackets();
    }

    private static void registerClientPackets() {
    }

    private static void registerServerPackets() {
        Services.PLATFORM.registerServerMessage(C2SSendSyncingConfigPacket.class, () -> (C2SSendSyncingConfigPacket::new));
    }
}
