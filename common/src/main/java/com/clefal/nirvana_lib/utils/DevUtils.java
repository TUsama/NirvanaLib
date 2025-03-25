package com.clefal.nirvana_lib.utils;

import com.clefal.nirvana_lib.NirvanaLibConstants;
import com.clefal.nirvana_lib.platform.Services;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DevUtils {

    public void runWhenOnDev(Runnable runnable){
        if (Services.PLATFORM.isDevelopmentEnvironment()) {
            runnable.run();
        }
    }

    public void runWhenNotOnDev(Runnable runnable){
        if (!Services.PLATFORM.isDevelopmentEnvironment()) {
            runnable.run();
        }
    }

    public void runOnDifference(Runnable whenOn, Runnable whenOff){
        if (Services.PLATFORM.isDevelopmentEnvironment()) {
            whenOn.run();
        } else {
            whenOff.run();
        }
    }

    public void announceDevEnabled(){
        DevUtils.runWhenOnDev(() -> {
            NirvanaLibConstants.LOGGER.info("Dev tool enabled!");
        });
    }
}
