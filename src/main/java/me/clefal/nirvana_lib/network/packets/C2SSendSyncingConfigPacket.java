package me.clefal.nirvana_lib.network.packets;

import commonnetwork.networking.data.PacketContext;
import lombok.Getter;
import me.clefal.nirvana_lib.NirvanaLibConstants;
import me.clefal.nirvana_lib.config.*;
import me.clefal.nirvana_lib.network.ModPacket;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
//? if ~1.21 {
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
//?}
import java.util.*;

@Getter
public class C2SSendSyncingConfigPacket implements ModPacket<C2SSendSyncingConfigPacket> {
    public static ResourceLocation location = NirvanaLibConstants.id("send_syncing_config");
    //? if ~1.21 {
    public static final CustomPacketPayload.Type<C2SSendSyncingConfigPacket> TYPE = new CustomPacketPayload.Type<>(location);

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
    //?}
    private UUID player;
    private Map<String, ConfigValue<?>> map;


    public C2SSendSyncingConfigPacket(UUID player, Map<String, ConfigValue<?>> configs) {
        this.player = player;
        this.map = configs;

    }

    public C2SSendSyncingConfigPacket() {
    }


    public static void handleServer(PacketContext<C2SSendSyncingConfigPacket> ctx) {

    }
    //? if =1.20.1 {
    /*@Override
    public ResourceLocation getResourceLocation() {
        return location;
    }

    @Override
    public void handle(PacketContext<C2SSendSyncingConfigPacket> ctx) {
        C2SSendSyncingConfigPacket message = ctx.message();
        PersonalConfigData data = SyncingPersonalConfig.INSTANCE.getData(message.player);
        for (Map.Entry<String, ConfigValue<?>> e : message.map.entrySet()) {
            data.configMap.merge(e.getKey(), e.getValue(), (old, newOne) -> newOne);
        }
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeUUID(player);
        var tokens = new ArrayList<Byte>();
        for (Map.Entry<String, ConfigValue<?>> e : map.entrySet()) {
            tokens.add(e.getValue().getToken());
        }
        buf.writeCollection(tokens, (buf1, aByte) -> buf1.writeByte(aByte));

        for (Map.Entry<String, ConfigValue<?>> e : map.entrySet()) {
            buf.writeUtf(e.getKey());
            e.getValue().write(buf);
        }
    }

    @Override
    public void read(FriendlyByteBuf buf) {
        this.player = buf.readUUID();
        List<Byte> bytes = buf.readList(FriendlyByteBuf::readByte);

        Map<String, ConfigValue<?>> map = new LinkedHashMap<>();

        for (Byte token : bytes) {
            String key = buf.readUtf();
            ConfigValue<?> value = null;
            switch (token) {
                case 0 -> value = new BooleanValue(buf.readBoolean());
                case 1 -> value = new IntegerValue(((Byte) buf.readByte()).intValue());
                case 2 ->
                        value = new StringListValue(buf.readCollection(ArrayList::new, FriendlyByteBuf::readUtf));
            }
            if (value == null) throw new RuntimeException("invalidated token: " + token);
            map.put(key, value);
        }
        this.map = map;
    }
*///?}
    //? if ~1.21 {
    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    @Override
    public void handle(PacketContext<C2SSendSyncingConfigPacket> ctx) {
        handleServer(ctx);
    }
    //?}
}
