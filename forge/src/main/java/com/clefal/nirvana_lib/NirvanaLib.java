package com.clefal.nirvana_lib;

import com.clefal.nirvana_lib.utils.DevUtils;
import net.minecraftforge.fml.common.Mod;

@Mod(NirvanaLibConstants.MOD_ID)
public class NirvanaLib {

    public NirvanaLib() {
        DevUtils.announceDevEnabled();
        NirvanaLibCommon.packetInit();
    }


}
