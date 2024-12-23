package com.clefal.nirvana_lib.platform;

import com.clefal.nirvana_lib.platform.services.IPlatformCollector;
import io.vavr.collection.List;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.forgespi.language.IModInfo;

public class ForgeCollector implements IPlatformCollector {
    @Override
    public List<String> gatherModIDList() {
        return List.ofAll(ModList.get().getMods()).map(IModInfo::getModId);
    }
}
