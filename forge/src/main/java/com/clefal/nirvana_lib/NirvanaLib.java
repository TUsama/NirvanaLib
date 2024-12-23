package com.clefal.nirvana_lib;

import com.clefal.nirvana_lib.config.configs.ConfigManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkConstants;

@Mod(NirvanaConstants.MODID)
public class NirvanaLib {

	public NirvanaLib() {

		getModLoadingContext().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));

		//FMLJavaModLoadingContext.get().getModEventBus().addListener(com.lootbeams.ClientSetup::init);

		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ConfigManager::init);
	}

	public static ModLoadingContext getModLoadingContext(){
		return ModLoadingContext.get();
	}

}
