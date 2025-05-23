package com.clefal.nirvana_lib.platform.services;

import com.clefal.nirvana_lib.utils.DevUtils;
import com.clefal.nirvana_lib.utils.ModUtils;

public class Instance implements IPlatformHelper{
    @Override
    public String getPlatformName() {
        return "forge";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModUtils.isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return DevUtils.isInDev();
    }
}
