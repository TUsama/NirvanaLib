package com.clefal.nirvana_lib.utils;

import lombok.experimental.UtilityClass;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class ComponentUtils {
    public List<Component> splitOnBreak(Component component) {
        String string = component.getString();
        List<Component> result = new ArrayList<>();
        if (string.contains("\n")) {
            for (String s : string.split("\n")) {
                result.add(Component.literal(s));
            }

        } else {
            result.add(component);
        }

        return result;
    }
}
