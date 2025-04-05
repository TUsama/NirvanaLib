package com.clefal.nirvana_lib.network.packets;

import com.clefal.nirvana_lib.config.*;
import com.clefal.nirvana_lib.network.C2SModPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;

import java.util.*;

public class C2SSendSyncingConfigPacket implements C2SModPacket {
    private final UUID player;
    private final Map<String, ConfigValue<?>> map;
    private List<Byte> tokens = new ArrayList<>();

    public C2SSendSyncingConfigPacket(UUID player, Map<String, ConfigValue<?>> configs) {
        this.player = player;
        this.map = configs;
    }

    public C2SSendSyncingConfigPacket(FriendlyByteBuf buf) {
        this.player = buf.readUUID();
        this.tokens = buf.readList(FriendlyByteBuf::readByte);
        Map<String, ConfigValue<?>> map = new LinkedHashMap<>();

        for (Byte token : tokens) {
            String key = buf.readUtf();
            ConfigValue<?> value = null;
            switch (token) {
                case 0 -> value = new BooleanValue(buf.readBoolean());
                case 1 -> value = new IntegerValue(((Byte) buf.readByte()).intValue());
                case 2 -> value = new StringListValue(buf.readCollection(ArrayList::new, FriendlyByteBuf::readUtf));
            }
            if (value == null) throw new RuntimeException("invalidated token: " + token);
            map.put(key, value);
        }
        this.map = map;
    }

    @Override
    public void handleServer(ServerPlayer player) {
        PersonalConfigData data = SyncingPersonalConfig.INSTANCE.getData(this.player, player.getServer().overworld());
        if (data != null){
            for (Map.Entry<String, ConfigValue<?>> e : map.entrySet()) {
                data.configMap.merge(e.getKey(), e.getValue(), (old, newOne) -> newOne);
            }
        } else {
            var newData = new PersonalConfigData();
            newData.configMap.putAll(this.map);
            SyncingPersonalConfig.INSTANCE.addData(this.player, newData);
        }
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeUUID(player);

        for (Map.Entry<String, ConfigValue<?>> e : map.entrySet()) {
            tokens.add(e.getValue().getToken());
        }

        buf.writeCollection(tokens, (buf1, aByte) -> buf1.writeByte(aByte));

        for (Map.Entry<String, ConfigValue<?>> e : map.entrySet()) {
            buf.writeUtf(e.getKey());
            e.getValue().write(buf);
        }
    }
}
