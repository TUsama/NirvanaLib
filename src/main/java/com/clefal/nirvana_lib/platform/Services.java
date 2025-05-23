package com.clefal.nirvana_lib.platform;

import com.clefal.nirvana_lib.platform.services.IPlatformHelper;
import com.clefal.nirvana_lib.utils.ModUtils;

@Deprecated(forRemoval = true)
public class Services {
    public static final IPlatformHelper PLATFORM = IPlatformHelper.INSTANCE;

    @Deprecated(forRemoval = true)
    public static boolean isModLoaded(String modid) {
        return ModUtils.isModLoaded(modid);
    }
}
