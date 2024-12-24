package com.clefal.nirvana_lib.platform.services;

import com.clefal.nirvana_lib.platform.Services;
import io.vavr.collection.List;


public interface IPlatformCollector {

    IPlatformCollector COLLECTOR = Services.load(IPlatformCollector.class);

    List<String> gatherModIDList();

}
