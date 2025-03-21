package com.clefal.nirvana_lib.network;

import net.minecraft.network.FriendlyByteBuf;

import java.util.function.Function;
import java.util.function.Supplier;

public abstract class SafeMSGInvoker<MSG> implements Supplier<Function<FriendlyByteBuf, MSG>> {

}
