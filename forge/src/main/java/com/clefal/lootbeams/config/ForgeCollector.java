package com.clefal.nirvana_lib.config;

import com.clefal.nirvana_lib.config.services.IServiceCollector;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.forgespi.language.IModInfo;

import java.util.List;

public class ForgeCollector implements IServiceCollector {


    @Override
    public List<String> gatherModIDList() {
        return ModList.get().getMods().stream().map(IModInfo::getModId).toList();
    }
}
