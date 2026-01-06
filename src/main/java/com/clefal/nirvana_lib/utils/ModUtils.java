package com.clefal.nirvana_lib.utils;

import lombok.experimental.UtilityClass;



//? if forge {
/*import net.minecraftforge.fml.ModList;
*///?} else if (fabric) {
/*import net.fabricmc.loader.api.FabricLoader;
*///?} else if (neoforge) {
import net.neoforged.fml.ModList;
//?}

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class ModUtils {
    public List<String> getModList(){
        ArrayList<String> strings = new ArrayList<>();

        //? if forge {
        /*ModList.get().getMods().forEach(x -> strings.add(x.getModId()));
        *///?} else if (fabric) {
        /*FabricLoader.getInstance().getAllMods().forEach(x -> strings.add(x.getMetadata().getId()));
        *///?} else if (neoforge) {
        ModList.get().getMods().forEach(x -> strings.add(x.getModId()));
        //?}

        return strings;
    }


    public boolean isModLoaded(String modid){
        //? if forge {
        /*return ModList.get().isLoaded(modid);
        *///?} else if (fabric) {
        /*return FabricLoader.getInstance().isModLoaded(modid);
        *///?} else if (neoforge) {
        return ModList.get().isLoaded(modid);
        //?}
    }
}
