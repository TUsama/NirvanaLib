package com.clefal.nirvana_lib.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkInstance;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestSimpleChannel extends SimpleChannel {
    public TestSimpleChannel(NetworkInstance instance) {
        super(instance);
    }

    public TestSimpleChannel(NetworkInstance instance, Consumer<NetworkEvent.ChannelRegistrationChangeEvent> registryChangeNotify) {
        super(instance, registryChangeNotify);
    }

}
