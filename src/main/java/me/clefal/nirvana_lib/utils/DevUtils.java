package me.clefal.nirvana_lib.utils;

import me.clefal.nirvana_lib.NirvanaLibConstants;
import me.clefal.nirvana_lib.platform.Services;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DevUtils {

    public boolean isInDev(){
        return Services.PLATFORM.isDevelopmentEnvironment();
    }

    public void runWhenOnDev(Runnable runnable){
        if (isInDev()) {
            runnable.run();
        }
    }

    public void runWhenNotOnDev(Runnable runnable){
        if (!isInDev()) {
            runnable.run();
        }
    }

    public void runOnDifference(Runnable whenOn, Runnable whenOff){
        if (isInDev()) {
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
