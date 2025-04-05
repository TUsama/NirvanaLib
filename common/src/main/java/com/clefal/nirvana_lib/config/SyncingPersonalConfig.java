package com.clefal.nirvana_lib.config;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SyncingPersonalConfig {
    public final static SyncingPersonalConfig INSTANCE = SyncingPersonalConfig.create();
    private final Map<UUID, PersonalConfigData> map = new HashMap<>();
    
    public static SyncingPersonalConfig create(){
        return new SyncingPersonalConfig();
    }

    @Nullable
    public PersonalConfigData getData(UUID player, ServerLevel level){
        PersonalConfigData personalConfigData = map.get(player);
        if (personalConfigData == null){
            Player playerByUUID = level.getPlayerByUUID(player);
            if (playerByUUID != null) playerByUUID.sendSystemMessage(Component.literal("Can't find your syncing config, please rejoin the world!"));
        }
        return personalConfigData;
    }

    public void addData(UUID player, PersonalConfigData data){
        map.put(player, data);
    }
}
