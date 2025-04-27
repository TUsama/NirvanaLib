package com.clefal.nirvana_lib;

import com.clefal.nirvana_lib.networking.FabricNetworkHandler;
import com.clefal.nirvana_lib.networking.data.Side;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class CommonNetworkFabric implements ModInitializer
{

    public CommonNetworkFabric()
    {
    }

    @Override
    public void onInitialize()
    {
        var env = FabricLoader.getInstance().getEnvironmentType().equals(EnvType.CLIENT) ? Side.CLIENT : Side.SERVER;
        new CommonNetworkMod(new FabricNetworkHandler(env));
    }

}
