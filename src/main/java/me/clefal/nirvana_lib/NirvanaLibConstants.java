package me.clefal.nirvana_lib;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NirvanaLibConstants {

    public static final String MOD_NAME = "NirvanaLib";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
    public static final String MOD_ID = "nirvana_lib";

    public static ResourceLocation id(String path) {
        ResourceLocation location;
        //? if =1.20.1 {
        
        location = new ResourceLocation(NirvanaLibConstants.MOD_ID, path);
         //?} else {
        /*location = ResourceLocation.fromNamespaceAndPath(NirvanaLibConstants.MOD_ID, path);
        *///?}
        return location;
    }
}
