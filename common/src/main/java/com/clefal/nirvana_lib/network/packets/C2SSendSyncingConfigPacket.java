package com.clefal.nirvana_lib.network.packets;

import com.clefal.nirvana_lib.NirvanaLibConstants;
import com.clefal.nirvana_lib.config.*;
import com.clefal.nirvana_lib.network.ModPacket;
import com.clefal.nirvana_lib.networking.data.PacketContext;
import lombok.Getter;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

import java.util.*;

@Getter
public class C2SSendSyncingConfigPacket implements ModPacket<C2SSendSyncingConfigPacket> {
    public final static StreamCodec<FriendlyByteBuf, C2SSendSyncingConfigPacket> CODEC = StreamCodec.composite(
            UUIDUtil.STREAM_CODEC,
            C2SSendSyncingConfigPacket::getPlayer,
            new StreamCodec<>() {
                @Override
                public void encode(FriendlyByteBuf o, Map<String, ConfigValue<?>> stringConfigValueMap) {
                    var tokens = new ArrayList<Byte>();
                    for (Map.Entry<String, ConfigValue<?>> e : stringConfigValueMap.entrySet()) {
                        tokens.add(e.getValue().getToken());
                    }
                    o.writeCollection(tokens, (buf1, aByte) -> buf1.writeByte(aByte));

                    for (Map.Entry<String, ConfigValue<?>> e : stringConfigValueMap.entrySet()) {
                        o.writeUtf(e.getKey());
                        e.getValue().write(o);
                    }
                }

                @Override
                public Map<String, ConfigValue<?>> decode(FriendlyByteBuf byteBuf) {
                    List<Byte> bytes = byteBuf.readList(FriendlyByteBuf::readByte);

                    Map<String, ConfigValue<?>> map = new LinkedHashMap<>();

                    for (Byte token : bytes) {
                        String key = byteBuf.readUtf();
                        ConfigValue<?> value = null;
                        switch (token) {
                            case 0 -> value = new BooleanValue(byteBuf.readBoolean());
                            case 1 -> value = new IntegerValue(((Byte) byteBuf.readByte()).intValue());
                            case 2 ->
                                    value = new StringListValue(byteBuf.readCollection(ArrayList::new, FriendlyByteBuf::readUtf));
                        }
                        if (value == null) throw new RuntimeException("invalidated token: " + token);
                        map.put(key, value);
                    }

                    return map;
                }
            },
            C2SSendSyncingConfigPacket::getMap,
            C2SSendSyncingConfigPacket::new
    );
    public static final Type<C2SSendSyncingConfigPacket> TYPE = new Type<>(NirvanaLibConstants.id("send_syncing_config"));
    private UUID player;
    private Map<String, ConfigValue<?>> map;

    public C2SSendSyncingConfigPacket(UUID player, Map<String, ConfigValue<?>> configs) {
        this.player = player;
        this.map = configs;

    }

    public C2SSendSyncingConfigPacket() {
    }


    public static void handleServer(PacketContext<C2SSendSyncingConfigPacket> ctx) {
        C2SSendSyncingConfigPacket message = ctx.message();
        PersonalConfigData data = SyncingPersonalConfig.INSTANCE.getData(message.player);
        for (Map.Entry<String, ConfigValue<?>> e : message.map.entrySet()) {
            data.configMap.merge(e.getKey(), e.getValue(), (old, newOne) -> newOne);
        }
    }


    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    @Override
    public StreamCodec<FriendlyByteBuf, C2SSendSyncingConfigPacket> getCodeC() {
        return CODEC;
    }
}
