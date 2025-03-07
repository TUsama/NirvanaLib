package com.clefal.nirvana_lib;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;

@Mod(NirvanaLibConstants.MOD_ID)
public class NirvanaLib {

    public NirvanaLib() {
        NirvanaLibCommon.packetInit();
    }


    public static ResourceLocation id(String path) {
        return new ResourceLocation(NirvanaLibConstants.MOD_ID, path);
    }
}
