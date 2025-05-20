package me.clefal.nirvana_lib.config;

import net.minecraft.network.FriendlyByteBuf;

import java.util.List;

public class StringListValue extends ConfigValue<List<String>>{
    public StringListValue(List<String> value) {
        super(value);
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeCollection(value, FriendlyByteBuf::writeUtf);
    }

    @Override
    public byte getToken() {
        return ConfigTokens.STRINGLIST;
    }

    @Override
    public List<String> getDefault() {
        return List.of();
    }
}
