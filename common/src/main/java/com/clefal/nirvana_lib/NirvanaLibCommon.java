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
        NetworkUtils.registerServerMessage(C2SSendSyncingConfigPacket.class, C2SSendSyncingConfigPacket::new);
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(NirvanaLibConstants.MOD_ID, path);
    }
}
