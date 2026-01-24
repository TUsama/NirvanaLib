package com.clefal.nirvana_lib.utils;

import lombok.experimental.UtilityClass;
import net.minecraft.resources.ResourceLocation;

@UtilityClass
public class ResourceLocationUtils {
    public ResourceLocation make(String modid, String path){
        //? legacy {
        /*return new ResourceLocation(modid, path);
        *///?} else {
        return ResourceLocation.fromNamespaceAndPath(modid, path);
        //?}
    }
}

