package me.clefal.nirvana_lib.config;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SyncingPersonalConfig {
    public final static SyncingPersonalConfig INSTANCE = SyncingPersonalConfig.create();
    private final Map<UUID, PersonalConfigData> map = new HashMap<>();

    public static SyncingPersonalConfig create() {
        return new SyncingPersonalConfig();
    }

    public PersonalConfigData getData(UUID player) {
        return map.computeIfAbsent(player, x -> new PersonalConfigData());
    }

    public void addData(UUID player, PersonalConfigData data) {
        map.put(player, data);
    }
}
