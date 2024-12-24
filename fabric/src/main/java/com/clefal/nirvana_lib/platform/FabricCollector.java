package com.clefal.nirvana_lib.platform;

import com.clefal.nirvana_lib.platform.services.IPlatformCollector;
import io.vavr.collection.List;
import net.fabricmc.loader.api.FabricLoader;


public class FabricCollector implements IPlatformCollector {
    @Override
    public List<String> gatherModIDList() {
        return List.ofAll(FabricLoader.getInstance().getAllMods().stream()).map(x -> x.getMetadata().getId());
    }
}
