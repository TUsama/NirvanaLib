package me.clefal.nirvana_lib.utils;

import me.clefal.nirvana_lib.platform.Services;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SideUtils {
    public boolean isClient(){
        return Services.PLATFORM.isClient();
    }
}
