package com.clefal.nirvana_lib.platform;

import com.clefal.nirvana_lib.platform.services.IPlatformCollector;
import io.vavr.collection.List;
import net.neoforged.fml.ModList;
import net.neoforged.neoforgespi.language.IModInfo;


public class NeoForgeCollector implements IPlatformCollector {


    @Override
    public List<String> gatherModIDList() {
        return List.ofAll(ModList.get().getMods()).map(IModInfo::getModId);
    }
}
