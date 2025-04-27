package com.clefal.nirvana_lib;



import com.clefal.nirvana_lib.networking.NeoForgeNetworkHandler;
import com.clefal.nirvana_lib.networking.PacketRegistrationHandler;
import com.clefal.nirvana_lib.networking.data.Side;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLLoader;


@Mod(Constants.MOD_ID)
public class CommonNetworkNeoForge
{
    private final PacketRegistrationHandler handler;

    public CommonNetworkNeoForge(IEventBus eventBus)
    {

        eventBus.addListener(this::commonSetupEvent);
        handler = new NeoForgeNetworkHandler(FMLLoader.getDist().isClient() ? Side.CLIENT : Side.SERVER);
        eventBus.register(handler);
    }

    public void commonSetupEvent(FMLCommonSetupEvent event)
    {
        new CommonNetworkMod(handler);
    }
}
