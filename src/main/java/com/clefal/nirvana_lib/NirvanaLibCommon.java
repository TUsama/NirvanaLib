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
        //? if =1.20.1 {
        
        /*NetworkUtils.registerPacket(C2SSendSyncingConfigPacket.class, C2SSendSyncingConfigPacket::new);
         *///?} else {
        NetworkUtils.registerPacket(C2SSendSyncingConfigPacket.TYPE, C2SSendSyncingConfigPacket.class, C2SSendSyncingConfigPacket.CODEC);
        //?}

    }

}
