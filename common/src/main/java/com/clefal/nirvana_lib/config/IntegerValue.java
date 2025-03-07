package com.clefal.nirvana_lib.config;

import net.minecraft.network.FriendlyByteBuf;

public class IntegerValue extends ConfigValue<Integer>{

    public static final byte token = 1;

    public IntegerValue(Integer value) {
        super(value);
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeInt(value);
    }


    @Override
    public byte getToken() {
        return token;
    }
}
