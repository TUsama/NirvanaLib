package com.clefal.nirvana_lib.events;


import net.neoforged.bus.BusBuilderImpl;
import net.neoforged.bus.EventBus;

public abstract class NLEventBus extends EventBus {

    public NLEventBus() {
        super(new BusBuilderImpl());
    }
}
