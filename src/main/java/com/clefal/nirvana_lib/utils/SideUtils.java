package com.clefal.nirvana_lib.utils;

import lombok.experimental.UtilityClass;



//? if forge {
/*import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLEnvironment;
*///?} else if (fabric) {
/*import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
*///?} else if (neoforge) {
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.api.distmarker.Dist;
//?}

@UtilityClass
public class SideUtils {
    public boolean isClient(){
        //? if forge {
        /*return FMLEnvironment.dist == Dist.CLIENT;
        *///?} else if (fabric) {
        /*return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
        *///?} else if (neoforge) {
        return FMLEnvironment.dist == Dist.CLIENT;
        //?}

    }
}
