package com.clefal.nirvana_lib.config;

import net.minecraft.network.FriendlyByteBuf;

public class IntegerValue extends ConfigValue<Integer>{

    public IntegerValue(Integer value) {
        super(value);
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeInt(value);
    }


    @Override
    public byte getToken() {
        return ConfigTokens.INTEGER;
    }

    @Override
    public Integer getDefault() {
        return 0;
    }
}
