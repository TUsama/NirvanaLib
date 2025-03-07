package com.clefal.nirvana_lib.config;

import net.minecraft.network.FriendlyByteBuf;

public class BooleanValue extends ConfigValue<Boolean>{

    public static final byte token =  0;

    public BooleanValue(Boolean value) {
        super(value);
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeBoolean(value);
    }


    @Override
    public byte getToken() {
        return token;
    }
}
