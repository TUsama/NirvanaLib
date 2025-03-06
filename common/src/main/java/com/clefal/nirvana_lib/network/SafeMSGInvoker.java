package com.clefal.nirvana_lib.network;

import net.minecraft.network.FriendlyByteBuf;

import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
public interface SafeMSGInvoker<MSG> extends Supplier<Function<FriendlyByteBuf, MSG>> {

}
