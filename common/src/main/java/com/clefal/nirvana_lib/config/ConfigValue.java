package com.clefal.nirvana_lib.config;

import net.minecraft.network.FriendlyByteBuf;

import java.util.function.Consumer;

public abstract class ConfigValue<T> {
    public T value;

    public ConfigValue(T value) {
        this.value = value;
    }

    public abstract void write(FriendlyByteBuf buf);
    public abstract byte getToken();
    public abstract T getDefault();
}
