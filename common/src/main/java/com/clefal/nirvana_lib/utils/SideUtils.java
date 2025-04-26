package com.clefal.nirvana_lib.utils;

import com.clefal.nirvana_lib.platform.Services;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SideUtils {
    public boolean isClient(){
        return Services.PLATFORM.isClient();
    }
}
