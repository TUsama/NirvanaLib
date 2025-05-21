package com.clefal.nirvana_lib.utils;

import com.clefal.nirvana_lib.NirvanaLibConstants;
import lombok.experimental.UtilityClass;
//? if forge {
/*import net.minecraftforge.fml.loading.FMLLoader;
*///?} else if (fabric) {
/*import net.fabricmc.loader.api.FabricLoader;
*///?} else if (neoforge) {
import net.neoforged.fml.loading.FMLLoader;
//?}


@UtilityClass
public class DevUtils {

    public boolean isInDev(){
        //? if forge {
        /*return !FMLLoader.isProduction();
        *///?} else if (fabric) {
        /*return FabricLoader.getInstance().isDevelopmentEnvironment();
        *///?} else if (neoforge) {
        return !FMLLoader.isProduction();
        //?}
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
