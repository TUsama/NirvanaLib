package com.clefal.nirvana_lib;

import com.clefal.nirvana_lib.network.packets.C2SSendSyncingConfigPacket;
import com.clefal.nirvana_lib.utils.NetworkUtils;
import net.minecraft.resources.ResourceLocation;

public class NirvanaLibCommon {

    public static void packetInit() {
        registerClientPackets();
        registerServerPackets();
    }

    private static void registerClientPackets() {
    }

    private static void registerServerPackets() {
        NetworkUtils.registerPacket(C2SSendSyncingConfigPacket.TYPE, C2SSendSyncingConfigPacket.class, C2SSendSyncingConfigPacket.CODEC, C2SSendSyncingConfigPacket::handleServer);
    }

}
