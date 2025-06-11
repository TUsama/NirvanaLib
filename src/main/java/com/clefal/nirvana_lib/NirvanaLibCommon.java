package com.clefal.nirvana_lib;

import com.clefal.nirvana_lib.network.packets.C2SSendSyncingConfigPacket;
import com.clefal.nirvana_lib.utils.DevUtils;
import com.clefal.nirvana_lib.utils.NetworkUtils;

public class NirvanaLibCommon {

    public static void init() {
        DevUtils.announceDevEnabled();
        registerClientPackets();
        registerServerPackets();
    }

    private static void registerClientPackets() {
    }

    private static void registerServerPackets() {
        NetworkUtils.registerPacket(C2SSendSyncingConfigPacket::new);
    }

}
