package com.clefal.nirvana_lib.utils;

import lombok.experimental.UtilityClass;
import net.minecraft.resources.ResourceLocation;

@UtilityClass
public class ResourceLocationUtils{
    public ResourceLocation make(String modid, String path){
        //? 1.20.1
        /*return new ResourceLocation(modid, path);*/
        //? >1.20.1
        return ResourceLocation.fromNamespaceAndPath(modid, path);
    }
}

