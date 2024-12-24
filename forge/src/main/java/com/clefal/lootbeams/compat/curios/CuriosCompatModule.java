package com.clefal.nirvana_lib.compat.curios;

import com.clefal.nirvana_lib.LootBeamsConstants;
import com.clefal.nirvana_lib.modules.ILBCompatModule;
import com.clefal.nirvana_lib.events.RegisterConfigConditionEvent;
import net.minecraftforge.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import top.theillusivec4.curios.api.CuriosApi;

public class CuriosCompatModule implements ILBCompatModule {
    public final static CuriosCompatModule INSTANCE = new CuriosCompatModule();

    @Override
    public boolean shouldBeEnable() {
        return ModList.get().isLoaded(CuriosApi.MODID);
    }

    @Override
    public void tryEnable() {
        if (shouldBeEnable()) {
            LootBeamsConstants.LOGGER.info("Detected Curios, enable CuriosCompatModule!");
            LootBeamsConstants.EVENT_BUS.register(INSTANCE);
        }
    }

    @SubscribeEvent
    public void registerEquipmentCondition(RegisterConfigConditionEvent.RegisterEquipmentItemEvent event) {
        event.conditions.add(itemStack -> CuriosApi.getCurio(itemStack).isPresent());
    }
}
