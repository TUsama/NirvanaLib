package com.clefal.nirvana_lib;

import com.clefal.nirvana_lib.utils.DevUtils;
import net.fabricmc.api.ModInitializer;

public class NirvanaLib implements ModInitializer {
    @Override
    public void onInitialize() {
        DevUtils.announceDevEnabled();
        NirvanaLibCommon.packetInit();
    }
}
