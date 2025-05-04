package com.clefal.nirvana_lib;

import com.clefal.nirvana_lib.networking.FabricNetworkHandler;
import com.clefal.nirvana_lib.networking.data.Side;
import com.clefal.nirvana_lib.utils.DevUtils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class NirvanaLib implements ModInitializer {
    @Override
    public void onInitialize() {
        DevUtils.announceDevEnabled();
        var env = FabricLoader.getInstance().getEnvironmentType().equals(EnvType.CLIENT) ? Side.CLIENT : Side.SERVER;
        new CommonNetworkMod(new FabricNetworkHandler(env));
        NirvanaLibCommon.packetInit();
    }
}
