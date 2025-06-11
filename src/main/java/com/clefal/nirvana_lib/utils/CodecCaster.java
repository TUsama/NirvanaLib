//? >1.20.1 {
package com.clefal.nirvana_lib.utils;

import com.mojang.serialization.Codec;
import lombok.experimental.UtilityClass;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.codec.StreamDecoder;
import net.minecraft.network.codec.StreamEncoder;

@UtilityClass
public class CodecCaster {

    public static <T> StreamCodec<? extends FriendlyByteBuf, T> castToStreamCodeC(Codec<T> codec){
        return StreamCodec.of(new StreamEncoder<FriendlyByteBuf, T>() {
            @Override
            public void encode(FriendlyByteBuf o, T t) {
                o.writeJsonWithCodec(codec, t);
            }
        }, new StreamDecoder<FriendlyByteBuf, T>() {
            @Override
            public T decode(FriendlyByteBuf buf) {
                return buf.readJsonWithCodec(codec);
            }
        });
    }
}
//?}
