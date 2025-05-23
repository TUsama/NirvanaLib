//? if forge {
package com.clefal.nirvana_lib.loaders.forge;

import com.mojang.logging.LogUtils;
import com.clefal.nirvana_lib.NirvanaLibCommon;
import com.clefal.nirvana_lib.NirvanaLibConstants;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(NirvanaLibConstants.MOD_ID)
public class ForgeEntrypoint {
    private static final Logger LOGGER = LogUtils.getLogger();

    public ForgeEntrypoint() {
        NirvanaLibCommon.init();

    }

}
//?}
